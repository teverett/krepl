/*
 * Copyright (C) khubla.com - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Tom Everett <tom@khubla.com>, 2018
 */
package com.khubla.krepl.command;

import java.util.HashMap;

import com.khubla.krepl.REPLConsole;
import com.khubla.krepl.REPLException;

public interface Command {
   String getCommand();

   String getHelp();

   String[] getShortcuts();

   boolean process(String[] commandArguments, REPLConsole replConsole, HashMap<String, Object> sesssionParameters) throws REPLException;
}
