/*
 * Copyright (C) khubla.com - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Tom Everett <tom@khubla.com>, 2018
 */
package com.khubla.krepl.command;

import java.io.IOException;
import java.lang.reflect.Modifier;
import java.util.Set;
import java.util.TreeMap;

import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.scanners.TypeAnnotationsScanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.khubla.krepl.REPLConsole;

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
      try {
         final Reflections reflections = new Reflections(null, new SubTypesScanner(true), new TypeAnnotationsScanner());
         final Set<Class<? extends Command>> classes = reflections.getSubTypesOf(Command.class);
         for (final Class<? extends Command> clazz : classes) {
            if ((false == clazz.isInterface()) && (false == Modifier.isAbstract(clazz.getModifiers()))) {
               addCommand(clazz.newInstance());
            }
         }
      } catch (final Exception e) {
         e.printStackTrace();
      }
   }

   private void addCommand(Command command) {
      logger.info("added REPL command: " + command.getCommand());
      commands.put(command.getCommand(), command);
      for (final String sc : command.getShortcuts()) {
         shortcuts.put(sc, command);
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
         replConsole.writeln(command.getShortcuts()[0], command.getCommand(), command.getHelp());
      }
   }
}
