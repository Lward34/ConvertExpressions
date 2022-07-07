/*
 * File:SyntaxError.java
 * Lilian Ward
 * CMSC 350
 * March 26, 2021
 * Purpose: The class main method creates a GUI panel frame and content necessary to generate conversion performance.
 */

//This class check exception inherited from class Exception
// Calls parent construct 



package project1;


class SyntaxError extends Exception {

      private static final long serialVersionUID = 1L;
      public SyntaxError() { super(); }
      public SyntaxError(String message){ super(message); }
    } 
 
        