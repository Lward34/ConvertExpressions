/*
 * File:Main.java
 * Lilian Ward
 * CMSC 350
 * March 26, 2021
 * Purpose: The class main method creates a GUI panel frame and content necessary to generate conversion performance.
 */


// This class contains the main method that creates the window GUI for a program
// program allows the user to input an expression either prefix or postix 
// evaluates respectively expressions


package project1;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

//main class which extends GUI form to show convertor display
public class Main extends JFrame implements ActionListener{

    private static final long serialVersionUID = 1L;
    // Class used by the JFrame label constructor
    private final JLabel ExpressLabel = new JLabel("Enter Expression");
    private final JTextField userInput = new JTextField(20);
    private final JButton PrefixToPostfix = new JButton("Prefix to Postfix");
    private final JButton PostfixToPrefix = new JButton("Postfix to Prefix");   
    private final JLabel textExpressResult = new JLabel("Result");
    private final JTextField outputField = new JTextField(20);
    
    //Main method GUI
    public static void main(String[] args) {
       Main frame = new Main();
       frame.setVisible(true); 
       
    }
    // Class constructor GUI
    // Title, Exit when close, border size, etc
    public Main() {
    super("Expresson Converter"); 
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    setBounds(100, 100, 450, 150);
    setResizable(false);
    JPanel JP = new JPanel();
    JP.setBorder(new EmptyBorder(5, 5, 5, 5));
    JP.setLayout(new BorderLayout());
    JP.add(topPanel(), BorderLayout.NORTH);
    JP.add(middlePanel(), BorderLayout.CENTER);
    JP.add(bottomPanel(), BorderLayout.SOUTH);
    setContentPane(JP);
}
    //Set up the three main panels:
    //Displays the Top panel and input box to user enter an expression
    private Component topPanel() {
    JPanel topPanel = new JPanel();
    topPanel.add(ExpressLabel);
    topPanel.add(userInput);
    return topPanel;
        
    }
    //Displays Middle panel 
    private Component middlePanel() {
    JPanel middlePanel = new JPanel();
    middlePanel.add(PrefixToPostfix);
    middlePanel.add(PostfixToPrefix);
    PrefixToPostfix.addActionListener(this);
    PostfixToPrefix.addActionListener(this);
    return middlePanel;
    }
    //Displays Bottom panel and the output of the conversion
    private Component bottomPanel() {
    JPanel bottomPanel = new JPanel();
    bottomPanel.add(textExpressResult);
    bottomPanel.add(outputField) ;
    outputField.setEditable(false);
    return bottomPanel;
    }

    //Class implemented actionPerformed 
    //when user click prefix to postfix or postfix to prefix 
    @Override
    public void actionPerformed(ActionEvent e) {
    try {
          String expressionString = userInput.getText(); //Input from user 
          //userInput.setText("");// blank user input
          System.out.println(expressionString);// prints output
          if(e.getSource() == PrefixToPostfix){
            // Call the method PrefixToPostfix from instance converter class
            String converted = Converter.PrefixToPostfix(expressionString);  
            outputField.setText(converted);
          } else if (e.getSource() == PostfixToPrefix) {
            // Calls the methods PostfixToPrefix from instance converter class
            String converted = Converter.PostfixToPrefix(expressionString);
            outputField.setText(converted);
          }
         } catch (NullPointerException | IOException | SyntaxError ex){
           JOptionPane.showMessageDialog(null, ex.getMessage());
        }   
      }

    }
    
    
   