/*
 * Copyright (C) khubla.com - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Tom Everett <tom@khubla.com>, 2018
 */
package com.khubla.krepl.impl;

import com.khubla.krepl.AbstractCommandImpl;
import com.khubla.krepl.REPLContext;
import com.khubla.krepl.REPLException;

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
   public String getShortcut() {
      return "q";
   }

   @Override
   public boolean process(String[] parameters, REPLContext replContext) throws REPLException {
      /*
       * we're done
       */
      return false;
   }
}
