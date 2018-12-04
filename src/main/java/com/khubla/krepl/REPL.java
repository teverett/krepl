/*
 * Copyright (C) khubla.com - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Tom Everett <tom@khubla.com>, 2018
 */
package com.khubla.krepl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.khubla.krepl.command.Command;
import com.khubla.krepl.command.CommandFactory;
import com.khubla.krepl.command.impl.HelpCommandImpl;
import com.khubla.krepl.command.impl.HistoryCommandImpl;
import com.khubla.krepl.impl.DefaultREPLConsole;

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
   private final REPLConsole replConsole = new DefaultREPLConsole();
   /**
    * command factory
    */
   private final CommandFactory commandFactory = new CommandFactory();
   /**
    * session parameters
    */
   private final HashMap<String, Object> sessionParameters = new HashMap<String, Object>();
   /**
    * command history
    */
   private List<String> commandHistory = new ArrayList<String>();

   /**
    * default CTOR
    */
   public REPL() {
   }

   /**
    * dispatch
    */
   private boolean dispatchCommand(String[] arguments) {
      try {
         final Command command = commandFactory.getCommand(arguments[0]);
         if (null != command) {
            if (command instanceof HelpCommandImpl) {
               commandFactory.showHelp(replConsole);
               return true;
            } else if (command instanceof HistoryCommandImpl) {
               showCommandHistory();
               return true;
            } else {
               return command.process(arguments, replConsole, sessionParameters);
            }
         } else {
            replConsole.writeln(REPLConsole.ConsoleColors.RED + "Unknown: '" + arguments[0] + "'" + REPLConsole.ConsoleColors.RESET);
            return true;
         }
      } catch (final Exception e) {
         e.printStackTrace();
         logger.error("Error in dispatchCommand", e);
         return false;
      }
   }

   public boolean executeCommmandString(String commandString) {
      final String[] arguments = commandString.split(" ");
      if (arguments.length > 0) {
         return dispatchCommand(arguments);
      }
      return false;
   }

   public List<String> getCommandHistory() {
      return commandHistory;
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
            /*
             * write prompt
             */
            replConsole.write(REPLConsole.ConsoleColors.WHITE_BRIGHT + prompt);
            /*
             * get input
             */
            final String commandString = replConsole.readLine();
            /*
             * save command to history
             */
            commandHistory.add(commandString);
            /*
             * execute command
             */
            go = executeCommmandString(commandString);
            /*
             * reset colors
             */
            replConsole.write(REPLConsole.ConsoleColors.RESET);
         }
      } catch (final Exception e) {
         e.printStackTrace();
      }
   }

   public void setCommandHistory(List<String> commandHistory) {
      this.commandHistory = commandHistory;
   }

   public void setPrompt(String prompt) {
      this.prompt = prompt;
   }

   private void showCommandHistory() {
      for (final String command : commandHistory) {
         replConsole.writeln(command);
      }
   }
}
