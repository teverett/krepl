/*
 * Copyright (C) khubla.com - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Tom Everett <tom@khubla.com>, 2018
 */
package com.khubla.krepl.command;

import java.io.IOException;
import java.util.TreeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.khubla.krepl.REPLConsole;
import com.khubla.krepl.command.impl.HelpCommandImpl;
import com.khubla.krepl.command.impl.HistoryCommandImpl;
import com.khubla.krepl.command.impl.QuitCommandImpl;

public class CommandFactory {
   /**
    * logger
    */
   private static final Logger logger = LoggerFactory.getLogger(CommandFactory.class);
   /**
    * commands
    */
   private final TreeMap<String, Command> commands = new TreeMap<String, Command>();
   /**
    * shortcuts
    */
   private final TreeMap<String, Command> shortcuts = new TreeMap<String, Command>();

   public CommandFactory() {
      addCommand(new HelpCommandImpl());
      addCommand(new HistoryCommandImpl());
      addCommand(new QuitCommandImpl());
   }

   public void addCommand(Command command) {
      if (null != command) {
         logger.info("added REPL command: " + command.getCommand());
         if (null != command.getCommand()) {
            commands.put(command.getCommand(), command);
            if (null != command.getShortcuts()) {
               for (final String sc : command.getShortcuts()) {
                  shortcuts.put(sc, command);
               }
            }
         }
      }
   }

   public Command getCommand(String name) {
      Command command = commands.get(name.trim().toLowerCase());
      if (null == command) {
         command = shortcuts.get(name.trim().toLowerCase());
      }
      return command;
   }

   public void showHelp(REPLConsole replConsole) throws IOException {
      for (final Command command : commands.values()) {
         String sc = "<none>";
         if ((null != command.getShortcuts()) && (null != command.getShortcuts()[0])) {
            sc = command.getShortcuts()[0];
         }
         replConsole.writeln(sc, command.getCommand(), command.getHelp());
      }
   }
}
