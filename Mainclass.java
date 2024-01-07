import javax.swing.*;

public class Mainclass {
  public static void main(String[] args) throws Exception {
    int ans = JOptionPane.showConfirmDialog(null, "PLAY SPADES GAME NOW!");
    if (ans == JOptionPane.YES_OPTION) {

      SetPlayers.Play(); //storing the player's name in the setPlayers, ask the user to enter their name then play the game  
      Spades.Play();

    } 
    else System.exit(2);



  }
}