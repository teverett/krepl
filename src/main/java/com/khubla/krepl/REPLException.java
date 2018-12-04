/*
 * Copyright (C) khubla.com - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Tom Everett <tom@khubla.com>, 2017
 */
package com.khubla.krepl;

/**
 * @author Tom Everett
 */
public class REPLException extends Exception {
   private static final long serialVersionUID = 1L;

   public REPLException(Exception e) {
      super(e);
   }

   public REPLException(String e) {
      super(e);
   }

   public REPLException(String s, Exception e) {
      super(s, e);
   }
}