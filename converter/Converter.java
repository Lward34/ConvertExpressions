/*
 * File:Converter.java
 * Lilian Ward
 * CMSC 350
 * March 26, 2021
 * Purpose: The class main method creates a GUI panel frame and content necessary to generate conversion performance.
 */

// This class defines a stack implemented with an array. It throws an
// exception if a push is attempted on a full stack or a pop is attempted on
// an empty stack.


package project1;

  import java.io.IOException;
  import java.io.StreamTokenizer;
  import java.io.StringReader;
  import java.util.ArrayList;
  import java.util.Collections;
  import java.util.EmptyStackException;
  import java.util.List;
  import java.util.Stack;


public class Converter {


    /**
     * Converts from Postfix to Prefix Expression
     * @param expression
     * @return
     * @throws IOException
     * @throws SyntaxError
     */
public static String PostfixToPrefix(String expression) throws IOException, SyntaxError {
     if (!expression.equals("")){
      //tokenize the string and create stack  
      Stack<String> S = new Stack<>();
      List<String> expressionToArray = tokenizeExpression(expression);
      //loop through the expression and check for operands
    for(String token:expressionToArray) {
      // checks if symbol is operator
      if (!isOperator(token)){
        stack.push(token + " ");
       }else {
         try {
        // pop two operands from stack
        String op2 = S.pop();
        String op1 = S.pop();
      
        // concat the operands and operator   
        String innerExpression = token + " " + op1+ op2;
        // Push String back to stack
        S.push(innerExpression);
     
    //a try/catch throws the custom exception
    }catch (EmptyStackException ex){
       throw new SyntaxError("Trying to call pop on an empty stack!");
        }
      }
    }
    String result = S.pop();
    //Check if the stack is Empty.Syntax error message will appear for the user in case stack is empty.
    if (S.empty()){
        return result;
    }else { // else throws new exception 
        throw new SyntaxError("Stack is not Empty!"); 
        }
    } else { //else throws another exception 
        throw new SyntaxError("Please enter something!");
      }
    }

    /**
     * Converts from Prefix to Postfix
     * @param expression
     * @return
     * @throws SyntaxError
     * @throws IOException
     */
 public static String PrefixToPostfix(String expression) throws SyntaxError, IOException {
    if(!expression.equals("")){
     Stack<String> opStack = new Stack<>();
      List<String> expToArray = tokenizeExpression(expression);
      //reversal of the list
      Collections.reverse(expToArray);
      //loop through the expression array 
      for (String token:expToArray) {
      // checks if symbol is operator
       if (!isOperator(token)){ 
          opStack.push(token + " ");
        }else {
          try {
            // pop two operands from stack
            String s1 = opStack.pop();
            String s2 = opStack.pop();
          
            // concat the operands and operator
            String innerExpression = s1 + s2 + token + " ";
           // Push String 
            opStack.push(innerExpression);
        //try/catch throws the custom exception
        }catch (EmptyStackException ex){
            throw new SyntaxError("Trying to call pop on an empty stack!");
          }
       }
    }
    String result = opStack.pop();
   //check if stack is empty. If it is, return result
   if (opStack.empty()){
        return result;
        }else { // else throw new exception 
        throw new SyntaxError("Stack is not empty!");
      }
    }else { //else throw new exception 
        throw new SyntaxError("Please enter something!");
      }
    }   
    private static List<String> tokenizeExpression(String expression) throws IOException {
        StreamTokenizer tokenizeExp = new StreamTokenizer(new StringReader(expression));
        //treat the following as normal chars
        tokenizeExp.ordinaryChar('-');
        tokenizeExp.ordinaryChar('/');
        List<String> tokenList = new ArrayList<>();// can also store as objects and cast
    // match tokens until end of stream
    while (tokenizeExp.nextToken() != StreamTokenizer.TT_EOF){
           //number
            switch (tokenizeExp.ttype) {
                case StreamTokenizer.TT_NUMBER:
                    tokenList.add(String.valueOf((int)tokenizeExp.nval));
                    //if for some reason there are words
                    break;
                case StreamTokenizer.TT_WORD:
                    tokenList.add(tokenizeExp.sval);
                    break;
                default:
                    //operator
                    tokenList.add(String.valueOf((char) tokenizeExp.ttype));
                    break;
            }
    }
    return tokenList;
    }
    //Check if value is operator or number
  private static boolean isOperator(String term){
    switch (term.charAt(0)){ //also looks at the first operand in inner expressions
        case '+':
        case '-':
        case '/':
        case '*':
        case '^':
        return true;
        } return false;
     }

  } 
 
        
    
  


