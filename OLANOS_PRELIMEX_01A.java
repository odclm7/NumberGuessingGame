import java.util.Random;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class OLANOS_PRELIMEX_01A {

   Scanner scanner = new Scanner(System.in);
      
   public static void main(String[] args) {
      OLANOS_PRELIMEX_01A app = new OLANOS_PRELIMEX_01A();
      app.guessingGame();
   }
   
   private void guessingGame(){
      JFrame guessingGameFrame = new JFrame();

      JLabel nameLabel = new JLabel("Input user’s name:");
      JTextField nameInput = new JTextField();

      guessingGameFrame.add(nameLabel);
      guessingGameFrame.add(nameInput);

      guessingGameFrame.setSize(500, 300);
      guessingGameFrame.setVisible(true);
      guessingGameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }

   private String askNameInput(){
      System.out.println("Input user’s name:");
      String name = scanner.nextLine();
      return name;
   }

   private int generateRandomInteger(){
      Random random = new Random();
      int randomInt = random.nextInt(100);
      return randomInt;
   }

   private void acceptIntegerInput(){
      System.out.println("Enter a number:");
      int number = scanner.nextInt();
   }
}