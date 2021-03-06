/*
 * Copyright (C) khubla.com - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Tom Everett <tom@khubla.com>, 2018
 */
package com.khubla.krepl.command.impl;

import java.util.HashMap;

import com.khubla.krepl.REPLConsole;
import com.khubla.krepl.REPLException;
import com.khubla.krepl.command.AbstractCommandImpl;

public class QuitCommandImpl extends AbstractCommandImpl {
   @Override
   public String getCommand() {
      return "quit";
   }

   @Override
   public String getHelp() {
      return "quit";
   }

   @Override
   public String[] getShortcuts() {
      return new String[] { "q" };
   }

   @Override
   public boolean process(String[] commandArguments, REPLConsole replConsole, HashMap<String, Object> sesssionParameters) throws REPLException {
      /*
       * we're done
       */
      return false;
   }
}
