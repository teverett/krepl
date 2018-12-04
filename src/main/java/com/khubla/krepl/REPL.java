/*
 * Copyright (C) khubla.com - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Tom Everett <tom@khubla.com>, 2018
 */
package com.khubla.krepl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class REPL {
   /**
    * logger
    */
   private static final Logger logger = LoggerFactory.getLogger(REPL.class);
   /**
    * command factory
    */
   private final CommandFactory commandFactory = new CommandFactory();
   /**
    * context
    */
   private final REPLContext replContext;

   /**
    * default CTOR
    */
   public REPL() {
      this.replContext = new REPLContext();
   }

   /**
    * custom context
    */
   public REPL(REPLContext replContext) {
      this.replContext = replContext;
   }

   /**
    * dispatch
    */
   private boolean dispatchCommand(String[] parts) {
      try {
         final Command command = commandFactory.getCommand(parts[0]);
         if (null != command) {
            return command.process(parts, replContext);
         } else {
            replContext.getReplConsole().writeln("Unknown: '" + parts[0] + "'");
            return true;
         }
      } catch (final Exception e) {
         e.printStackTrace();
         logger.error("Error in dispatchCommand", e);
         return false;
      }
   }

   public void executeCommmandString(String commandString) {
      if ((null != commandString) && (commandString.length() > 0)) {
         final String[] parts = commandString.split(";");
         for (final String part : parts) {
            executeSingleCommand(part);
         }
      }
   }

   private void executeSingleCommand(String commandString) {
      final String[] parts = commandString.split(" ");
      if (parts.length > 0) {
         replContext.setGo(dispatchCommand(parts));
      }
   }

   public void repl() {
      try {
         while (replContext.isGo()) {
            replContext.getReplConsole().write(">");
            final String commandString = replContext.getReplConsole().readLine();
            executeCommmandString(commandString);
         }
      } catch (final Exception e) {
         e.printStackTrace();
      }
   }
}
