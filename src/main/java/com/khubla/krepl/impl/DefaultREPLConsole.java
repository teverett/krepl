/*
 * Copyright (C) khubla.com - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Tom Everett <tom@khubla.com>, 2018
 */
package com.khubla.krepl.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import com.khubla.krepl.REPLConsole;

public class DefaultREPLConsole implements REPLConsole {
   /**
    * in from console
    */
   private final BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
   /**
    * out to console
    */
   private final PrintWriter outputWriter = new PrintWriter(new OutputStreamWriter(System.out));

   private String buildFormatString(int args) {
      String str = "%-25s";
      if (args > 1) {
         for (int i = 2; i <= args; i++) {
            str += " %-25s";
         }
      }
      str += "\n";
      // System.out.println(str);
      return str;
   }

   @Override
   public BufferedReader getInputReader() {
      return inputReader;
   }

   /**
    * readline
    */
   @Override
   public String readLine() throws IOException {
      return inputReader.readLine();
   }

   @Override
   public void write(String str) {
      outputWriter.print(str);
      outputWriter.flush();
   }

   @Override
   public void writeln(Object... args) {
      outputWriter.printf(buildFormatString(args.length), args);
      outputWriter.flush();
   }

   @Override
   public void writeln(String str) {
      outputWriter.println(str);
      outputWriter.flush();
   }
}
