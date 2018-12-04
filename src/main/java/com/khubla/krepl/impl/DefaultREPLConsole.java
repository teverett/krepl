/*
 * Copyright (C) khubla.com - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Tom Everett <tom@khubla.com>, 2018
 */
package com.khubla.krepl.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

import com.khubla.krepl.REPLConsole;

public class DefaultREPLConsole implements REPLConsole {
   /**
    * input
    */
   private final BufferedReader bufferedReader;
   /**
    * output
    */
   private final PrintStream outputStream;

   /**
    * ctor
    */
   public DefaultREPLConsole() {
      bufferedReader = new BufferedReader(new InputStreamReader(System.in));
      outputStream = System.out;
   }

   /**
    * ctor
    */
   public DefaultREPLConsole(InputStream inputStream, PrintStream outputStream) {
      bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
      this.outputStream = outputStream;
   }

   private String buildFormatString(int args) {
      String str = "%-25s";
      if (args > 1) {
         for (int i = 2; i <= args; i++) {
            str += " %-25s";
         }
      }
      str += "\n";
      return str;
   }

   @Override
   public String readln() throws IOException {
      return bufferedReader.readLine();
   }

   @Override
   public void write(String str) {
      outputStream.print(str);
      outputStream.flush();
   }

   @Override
   public void writeln(Object... args) {
      outputStream.printf(buildFormatString(args.length), args);
      outputStream.flush();
   }

   @Override
   public void writeln(String str) {
      outputStream.println(str);
      outputStream.flush();
   }
}
