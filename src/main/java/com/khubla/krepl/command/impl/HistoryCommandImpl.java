/*
 * Copyright (C) khubla.com - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Tom Everett <tom@khubla.com>, 2018
 */
package com.khubla.krepl.command.impl;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.khubla.krepl.REPLConsole;
import com.khubla.krepl.REPLException;
import com.khubla.krepl.command.AbstractCommandImpl;

public class HistoryCommandImpl extends AbstractCommandImpl {
   /**
    * logger
    */
   private static final Logger logger = LoggerFactory.getLogger(HistoryCommandImpl.class);

   @Override
   public String getCommand() {
      return "history";
   }

   @Override
   public String getHelp() {
      return "history";
   }

   @Override
   public String[] getShortcuts() {
      return null;
   }

   @Override
   public boolean process(String[] commandArguments, REPLConsole replConsole, HashMap<String, Object> sesssionParameters) throws REPLException {
      try {
         /*
          * we're done
          */
         return true;
      } catch (final Exception e) {
         e.printStackTrace();
         logger.error("Error processing command", e);
         return false;
      }
   }
}
