/*
 * Copyright (C) khubla.com - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Tom Everett <tom@khubla.com>, 2018
 */
package com.khubla.krepl;

import java.util.HashMap;

public interface Command {
   String getCommand();

   String getHelp();

   String[] getShortcuts();

   boolean process(String[] commandParameters, REPLConsole replConsole, HashMap<String, Object> sesssionParameters) throws REPLException;
}
