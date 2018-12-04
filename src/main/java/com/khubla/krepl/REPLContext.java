/*
 * Copyright (C) khubla.com - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Tom Everett <tom@khubla.com>, 2018
 */
package com.khubla.krepl;

public class REPLContext {
   /**
    * console
    */
   private final REPLConsole replConsole = new REPLConsole();
   /**
    * continue?
    */
   private boolean go = true;

   public REPLConsole getReplConsole() {
      return replConsole;
   }

   public boolean isGo() {
      return go;
   }

   public void setGo(boolean go) {
      this.go = go;
   }
}
