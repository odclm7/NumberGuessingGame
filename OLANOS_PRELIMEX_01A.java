import java.util.Random;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
Author: Cheni Lei Olanos
Date: 1/17/2025

323 Prelim Exercise 1a
Filename: LASTNAME_PRELIMEX_01A.java
Objective:
• Illustrate the concept of random variables. The concept of random variables will be essential in the simulation and modeling subject.

Create a program for the following requirements:

Guessing Game
Input user’s name:
Enter a number:
(Provide a remark on whether the inputted number is correct or not)
Another guess (Yes or No):
A user is given 3 chances to guess otherwise, the game is ended.
 */
public class OLANOS_PRELIMEX_01A {

   Scanner scanner = new Scanner(System.in);
   private int randomInt;
   private int attempts;
   private int maxAttempts = 3;
      
   public static void main(String[] args) {
      OLANOS_PRELIMEX_01A app = new OLANOS_PRELIMEX_01A();
      app.enterName();
   }
   
   /**
   entername() method:
   - Prompts the user to enter their name
   - Displays the guessing game frame
    */
   private void enterName(){

      randomInt = generateRandomInteger();

      JFrame enterNameFrame = new JFrame("Number Guessing Game");
      enterNameFrame.setLayout(null);

      JLabel nameLabel = new JLabel("Input user’s name:");
      nameLabel.setFont(new Font("Arial", Font.BOLD, 20));
      nameLabel.setBounds(150, 50, 200, 50);
      JTextField nameInput = new JTextField();
      nameInput.setFont(new Font("Arial", 15, 15));
      nameInput.setBounds(130, 100, 230, 30);
      JButton submitNameButton = new JButton("Submit Name");
      submitNameButton.setBounds(170, 150, 150, 30);

      enterNameFrame.add(nameLabel);
      enterNameFrame.add(nameInput);
      enterNameFrame.add(submitNameButton);

      enterNameFrame.setSize(500, 300);
      enterNameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      enterNameFrame.setLocationRelativeTo(null);
      enterNameFrame.setVisible(true);

      submitNameButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            String name = nameInput.getText();
            if(name == null || name.trim().isEmpty()){
               JOptionPane.showMessageDialog(null, "Please, enter your name.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
               //closes the enter name frame for the transition for the new frame
               enterNameFrame.dispose();

               //create a new frame for guessing demo
               JFrame guessingGameFrame = new JFrame("Number Guessing Game");
               
               guessingGameFrame.setLayout(null);

               JLabel guessLabel = new JLabel("Enter a number (1-10): ");
               guessLabel.setFont(new Font("Arial", Font.BOLD, 20));
               guessLabel.setBounds(130, 30, 300, 50);
               
               JTextField guessInput = new JTextField();
               guessInput.setFont(new Font("Arial", 15, 15));
               guessInput.setBounds(130, 80, 230, 30);

               JButton submitIntButton = new JButton("Submit Guess");
               submitIntButton.setBounds(170, 180, 150, 30);

               JLabel feedbackLabel = new JLabel("You have 3 attempts to make.");
               feedbackLabel.setFont(new Font("Arial", 15, 15));
               feedbackLabel.setBounds(130, 110, 500, 30);

               guessingGameFrame.add(guessLabel);
               guessingGameFrame.add(guessInput);
               guessingGameFrame.add(submitIntButton);
               guessingGameFrame.add(feedbackLabel);

               guessingGameFrame.setSize(500, 300);
               guessingGameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               guessingGameFrame.setLocationRelativeTo(null);
               guessingGameFrame.setVisible(true);

               submitIntButton.addActionListener(new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                     String guessText = guessInput.getText();

                     // handles the cases whether the user's entered integer matches with the random integer generated
                     try {
                        int guess = Integer.parseInt(guessText);

                        if (guess < 0 || guess > 10) {
                           feedbackLabel.setText("Please enter a number between 0 and 10.");
                        } else {
                           attempts++;
                           guessInput.setText("");
                           if (guess == randomInt) {
                              feedbackLabel.setText("Congratulations, " + name + "! You guessed it right.");
                              guessInput.setEnabled(false);
                              submitIntButton.setEnabled(false);
                           } else {
                              if (attempts < maxAttempts) {
                                 feedbackLabel.setText("Incorrect! " + (maxAttempts - attempts) + " attempts remaining.");
                              } else {
                                 feedbackLabel.setText("Game over! The correct number was " + randomInt + ".");
                                 guessInput.setEnabled(false);
                                 submitIntButton.setEnabled(false);
                              }
                           }
                        }
                     } catch (NumberFormatException ex) {
                        feedbackLabel.setText("Invalid input! Please enter a valid number.");
                     }
                  }//end of actionPerformed 
               });//end of submitIntButton
            }//end of if-else
         }//end of actionPerformed   
      });//end of submitNameButton
   }//end of enterName

   /**
    * generateRandomInteger() method
    * Handles the generation of a random integer
    * @return
    */
   private int generateRandomInteger(){
      Random random = new Random();
      randomInt = random.nextInt(10);
      return randomInt;
   } //end of generateRandomInteger
} //end of class