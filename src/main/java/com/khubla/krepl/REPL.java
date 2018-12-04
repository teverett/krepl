/*
 * Copyright (C) khubla.com - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Tom Everett <tom@khubla.com>, 2018
 */
package com.khubla.krepl;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.khubla.krepl.impl.HelpCommandImpl;

public class REPL {
   /**
    * logger
    */
   private static final Logger logger = LoggerFactory.getLogger(REPL.class);
   /**
    * prompt
    */
   private String prompt = ">";
   /**
    * console
    */
   private final REPLConsole replConsole = new REPLConsole();
   /**
    * command factory
    */
   private final CommandFactory commandFactory = new CommandFactory();
   /**
    * session parameters
    */
   private final HashMap<String, Object> sessionParameters = new HashMap<String, Object>();

   /**
    * default CTOR
    */
   public REPL() {
   }

   /**
    * dispatch
    */
   private boolean dispatchCommand(String[] parts) {
      try {
         final Command command = commandFactory.getCommand(parts[0]);
         if (null != command) {
            if (command instanceof HelpCommandImpl) {
               commandFactory.showHelp(replConsole);
               return true;
            } else {
               return command.process(parts, replConsole, sessionParameters);
            }
         } else {
            replConsole.writeln("Unknown: '" + parts[0] + "'");
            return true;
         }
      } catch (final Exception e) {
         e.printStackTrace();
         logger.error("Error in dispatchCommand", e);
         return false;
      }
   }

   public boolean executeCommmandString(String commandString) {
      final String[] parts = commandString.split(" ");
      if (parts.length > 0) {
         return dispatchCommand(parts);
      }
      return false;
   }

   public String getPrompt() {
      return prompt;
   }

   public REPLConsole getReplConsole() {
      return replConsole;
   }

   public HashMap<String, Object> getSessionParameters() {
      return sessionParameters;
   }

   public void repl() {
      try {
         boolean go = true;
         while (true == go) {
            replConsole.write(prompt);
            final String commandString = replConsole.readLine();
            go = executeCommmandString(commandString);
         }
      } catch (final Exception e) {
         e.printStackTrace();
      }
   }

   public void setPrompt(String prompt) {
      this.prompt = prompt;
   }
}
