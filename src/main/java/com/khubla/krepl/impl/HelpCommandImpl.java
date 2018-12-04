/*
 * Copyright (C) khubla.com - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Tom Everett <tom@khubla.com>, 2018
 */
package com.khubla.krepl.impl;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.khubla.krepl.AbstractCommandImpl;
import com.khubla.krepl.REPLConsole;
import com.khubla.krepl.REPLException;

public class HelpCommandImpl extends AbstractCommandImpl {
   /**
    * logger
    */
   private static final Logger logger = LoggerFactory.getLogger(HelpCommandImpl.class);

   @Override
   public String getCommand() {
      return "help";
   }

   @Override
   public String getHelp() {
      return "help";
   }

   @Override
   public String[] getShortcuts() {
      return new String[] { "?" };
   }

   @Override
   public boolean process(String[] commandParameters, REPLConsole replConsole, HashMap<String, Object> sesssionParameters) throws REPLException {
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
