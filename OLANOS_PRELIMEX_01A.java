import java.util.Random;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OLANOS_PRELIMEX_01A {

   Scanner scanner = new Scanner(System.in);
   private int randomInt;
   private int [] attempts = {0};
   private int maxAttempts = 3;
      
   public static void main(String[] args) {
      OLANOS_PRELIMEX_01A app = new OLANOS_PRELIMEX_01A();
      app.enterName();
   }
   
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

               enterNameFrame.dispose();

               JFrame guessingGameFrame = new JFrame("Number Guessing Game");
               
               guessingGameFrame.setLayout(null);

               JLabel guessLabel = new JLabel("Enter a number: ");
               guessLabel.setFont(new Font("Arial", Font.BOLD, 20));
               guessLabel.setBounds(150, 50, 200, 50);
               
               JTextField guessInput = new JTextField();
               guessInput.setFont(new Font("Arial", 15, 15));
               guessInput.setBounds(130, 100, 230, 30);

               JButton submitIntButton = new JButton("Submit Guess");
               submitIntButton.setBounds(170, 150, 150, 30);

               JLabel feedbackLabel = new JLabel("");
               feedbackLabel.setFont(new Font("Arial", 15, 15));
               feedbackLabel.setBounds(220, 100, 230, 30);

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

                     try {
                        // Parse the guess to an integer
                        int guess = Integer.parseInt(guessText);
                        attempts[0]++; // Increment attempts counter

                        // Check if the guess is correct
                        if (guess < 0 || guess > 99) {
                           feedbackLabel.setText("Please enter a number between 0 and 99.");
                        } else if (guess < randomInt) {
                           feedbackLabel.setText("Too low! Try again.");
                        } else if (guess > randomInt) {
                           feedbackLabel.setText("Too high! Try again.");
                        } else {
                           feedbackLabel.setText("Congratulations, " + name + "! You guessed it in " + attempts + " attempts.");
                           // Disable the guess input and button after winning
                           guessInput.setEnabled(false);
                           submitIntButton.setEnabled(false);
                        }
                     } catch (NumberFormatException ex) {
                     feedbackLabel.setText("Invalid input! Please enter a valid number.");
                     } //end of try-catch
                  }//end of actionPerformed 
               });//end of submitIntButton
            }//end of if-else
         }//end of actionPerformed   
      });//end of submitNameButton
   }//end of enterName

   public void guessingGameFrame(){
      
   }

   private int generateRandomInteger(){
      Random random = new Random();
      randomInt = random.nextInt(100);
      return randomInt;
   } //end of generateRandomInteger
} //end of class