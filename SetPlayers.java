import javax.swing.*;
/**
*this is the that need to be executed for the other classes to be used  
*All the methods in here are public static ,can be accessed in other program without instantiating an object 
*
*/
public class  SetPlayers{
    
  private static String name1; // Making all instances of this class share the same value


  public static void Play (){
  /**this method enters the name of the players, and stores the name in the static attribute */
  

    System.out.println("                                ");
    name1 = JOptionPane.showInputDialog(null,"PLEASE ENTER YOUR NAME:");
    if (name1 == null) { // If the user presses cancel which is equivalent to null then exit program
    System.exit(0);
    }

    else{ /* If userfield is left empty */
      String playerone= name1 ; // store name or empty string selected
      while(playerone.equals("")){ // IS the answer is an empty string keep on asking the user until an actual non-empty string is inserted
        name1 = JOptionPane.showInputDialog(null,"PLEASE ENTER YOUR NAME:");
        if (name1 == null) { // If the user presses cancel which is equivalent to null then exit program
          System.exit(0);
        }
        playerone= name1;
      }
    }


  }

 
  public static String names1(){  // This method is accessible to all classes because it is static, thus method can be invoked directly using class itself (name), without needing to create an instance of the class.
    return name1;
  }

}