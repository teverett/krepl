/*
 * Copyright (C) khubla.com - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Tom Everett <tom@khubla.com>, 2018
 */
package com.khubla.krepl;

public interface Command {
   String getCommand();

   String getHelp();

   String getShortcut();

   boolean process(String[] parameters, REPLContext replContext) throws REPLException;
}
