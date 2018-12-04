/*
 * Copyright (C) khubla.com - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Tom Everett <tom@khubla.com>, 2018
 */
package com.khubla.krepl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class REPLConsole {
   /**
    * text colors
    */
   public static final String ANSI_RESET = "\u001B[0m";
   public static final String ANSI_BLACK = "\u001B[30m";
   public static final String ANSI_RED = "\u001B[31m";
   public static final String ANSI_GREEN = "\u001B[32m";
   public static final String ANSI_YELLOW = "\u001B[33m";
   public static final String ANSI_BLUE = "\u001B[34m";
   public static final String ANSI_PURPLE = "\u001B[35m";
   public static final String ANSI_CYAN = "\u001B[36m";
   public static final String ANSI_WHITE = "\u001B[37m";
   /**
    * background colors
    */
   public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
   public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
   public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
   public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
   public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
   public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
   public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
   public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
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

   public BufferedReader getInputReader() {
      return inputReader;
   }

   /**
    * readline
    */
   public String readLine() throws IOException {
      return inputReader.readLine();
   }

   public void write(String str) {
      outputWriter.print(str);
      outputWriter.flush();
   }

   public void writeln(Object... args) {
      outputWriter.printf(buildFormatString(args.length), args);
      outputWriter.flush();
   }

   public void writeln(String str) {
      outputWriter.println(str);
      outputWriter.flush();
   }
}
