import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;


// MouseInputAdapter enables the Compo class to receive mouse events. and to use a specified method such as mouseClicked in this context to handle the mouse action
public class Compo extends MouseInputAdapter {
    private JPanel pan; // Taking the pannel to manipulate 
    private JLabel lab; // the actual selected card 
    private JLabel[] labs; // The JLabel/object version of the its initial unchaged deck 
    private Cards[] card; // The unchanged deck of cards 
    private Cards[] ai; // Ai's deck
    private JPanel aiPan;
    private JLabel aiLab; // The backdrop of the Ai's cord on the panel positioned in the South
    private int indexNumber; // the index number of the selected card 
    private int aiIndex;
    // Static so that the values can be shared among the instances of this class
    private static int ai_score;
    private static int human_score;
    private static int round;
    private JPanel backC;
    private static List < Object[] > dataList;


    //--- have an attribute that takes the board and is updated after the cards are compared
    public Compo(JPanel pan, JLabel lab, Cards[] card, JLabel[] labs, JPanel aiPan, JLabel aiCard, Cards[] aiDeck, int aiInd, JPanel sc, JLabel closedCard) {
        this.pan = pan;
        this.lab = lab;
        this.card = card;
        this.labs = labs;
        //----------------ai 
        this.ai = aiDeck;
        this.aiPan = aiPan;
        this.aiLab = aiCard;
        this.aiIndex = aiInd; //Index of the card selected by the AI
        this.backC = sc;
        this.aiLab = closedCard;
        dataList = new ArrayList < > (); //Initializing dataList, so that it can be updated

    }

    public void mouseClicked(MouseEvent event) { // overriding mouseListerner
        this.pan.remove(this.lab); // dynamically removing the graphical component/Card from the GUI/Jpanel 
        // To reflect the changes and update the Panel 
        this.pan.validate();
        this.pan.repaint();

        //------------------------ comparing----------------------------
        /* 
         * trying to find the index number of the selected card in the original deck card 
         * The cards in the labs/JLabel/Object version of the card deck have the same index number as the cards in the Card deck (The unchanged given deck of cards given to the player )
         * The following instruction attempts to find the index number of the selected card in the JLabel verion of the given set of cards
         * Thus if the selected card is equivalent to the a card in the JLabel array - retrieve its index number in the JLabel array 
         * This index number is equivalent to the index number of the same card in the cards of deck - the original deck
         * This allows for the actual card to be retrieved from the card of deck and manipulated
         */
        for (int i = 0; i < this.labs.length; i++) {
            if (this.labs[i] == this.lab) {
                this.indexNumber = i; /** To get rid of the actual card once selected  */
            }
        }


        //----------------------------------------Cards[] to print the strong representation-----------------------//
        JOptionPane.showMessageDialog(null, "You have selected" + " " + card[this.indexNumber].printCards());
        JOptionPane.showMessageDialog(null, "AI selected " + " " + ai[this.aiIndex].printCards());
        backC.remove(aiLab); // removing a closed card from the ai's section to make it seem like the ai played a card
        backC.validate();
        backC.repaint(); // repainting the panel so that the changes can be updated and seen. 

        //----------------Comparing Ai card to Human card to determine winner

        //Adding and removing a card in the middle that the Ai plays with a new one

        JLabel aiC = new JLabel(new ImageIcon(ai[this.aiIndex].printImage()));
        Border border = BorderFactory.createLineBorder(Color.white, 3);
        aiPan.setLayout(new GridBagLayout()); // Set a layout manager for aiPan
        aiPan.removeAll(); // Remove the existing aiLab or card in the middle of the canvas
        aiC.setBorder(border); // adding borders around it
        aiPan.add(aiC); // Adding the new Card played by the Ai 
        aiPan.validate();
        aiPan.repaint(); // Ensuring that the changes are reflected on the panel

        round++;

        if ((ai[this.aiIndex].printValue()) > (card[this.indexNumber].printValue())) {
            ai_score++;
            dataList.add(new Object[] {
                "                    " + round, "                    " + "", "                    " + "+ 1"
            });


        } else if ((ai[this.aiIndex].printValue()) < (card[this.indexNumber].printValue())) {
            human_score++;
            dataList.add(new Object[] {
                "                    " + round, "                    " + "+ 1", "                    " + ""
            });

        } else { // Just in case it is a draw
            dataList.add(new Object[] {
                "                    " + round, "                    " + " 0 ", "                    " + " 0 "
            });

        }

        // The following is for debugging purposes
        System.err.println("----------------------------------" + Integer.toString(round) + "--------------------------------");
        System.err.println("AI Score: " + (ai[this.aiIndex].printCards()));
        System.err.println("Human Score: " + (card[this.indexNumber].printCards()));


        // If all the cards have been played then empty canvas
        if (round == 13) {
            aiPan.setLayout(new GridBagLayout()); // Set a layout manager for aiPan
            aiPan.removeAll(); // Remove the existing aiLab or card in the middle of the canvas


            dataList.add(new Object[] {
                "                " + "SCORE", "                    " + human_score, "                    " + ai_score
            });
            Object[][] data = new Object[dataList.size()][];
            dataList.toArray(data);

            // Create column names
            String[] columnNames = {
                "Round",
                SetPlayers.names1().toUpperCase(),
                "AI"
            };

            //Creating a custom table with unmodifiable cells
            DefaultTableModel newTab = new DefaultTableModel(data, columnNames) {
                //overriding its cellEditable method to false 
                public boolean isCellEditable(int row, int column) {
                    return false;
                }


            };


            // JTable with data and column names
            JTable table = new JTable(newTab);


            // JScrollPane to hold the table
            JScrollPane scrollPane = new JScrollPane(table);
            scrollPane.setPreferredSize(new Dimension(400, 248));
            String winner = "";
            if (ai_score > human_score) winner = "./AIWins.png";
            else winner = "./Won.png";

            ImageIcon iconY = new ImageIcon(winner); // ICon that will be displayed based on the Winner
            JLabel winnerLabel = new JLabel(iconY);
            winnerLabel.setBackground(Color.GREEN);

            JPanel panel = new JPanel((new FlowLayout(FlowLayout.CENTER)));
            panel.setBackground(Color.green.darker().darker());
            panel.add(winnerLabel, BorderLayout.NORTH);

            //Displaying frame once 

            JButton button = new JButton("VIEW SCORE");
            Spades.addButtons.add(button);

            //Displyaing Frame whenever the View Score is selected: 
            button.addActionListener(new ActionListener() {
                //Override
                public void actionPerformed(ActionEvent e) {
                    // Open the scoreboard frame when the button is clicked
                    JFrame score = new JFrame("Score");
                    JPanel scorePan = new JPanel();
                    //Dimension minSize = new Dimension(200, 200);

                    score.setResizable(false); // disabling the maximise option 
                    int size = 50;
                    score.setSize(size, size);

                    scorePan.add(scrollPane, BorderLayout.CENTER);

                    ImageIcon customIcon = new ImageIcon("./icon.png");
                    score.setIconImage(customIcon.getImage());

                    score.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

                    // Handle the closing of the new window manually
                    score.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosing(WindowEvent e) {
                            // Handle any cleanup or specific actions when the new window is closed
                            // For example, you may want to hide the window instead of disposing it
                            score.setVisible(false);
                        }
                    });

                    //score.setSize(410,250); 


                    //newWindow.add(cardPanel,BorderLayout.CENTER);
                    //newWindow.add(addButtons,BorderLayout.NORTH);
                    score.add(scorePan); // Adding the pan with the score to the new Frame
                    score.pack(); //Using the pack function to make the Frame size fit its content
                    score.setVisible(true);

                }
            });


            Spades.window.setVisible(true);

            aiPan.add(panel);

            aiPan.validate();
            aiPan.repaint(); // Ensuring that the changes are reflected on the panel
            round = 0; // Starting again.
            human_score = 0; // re-initializing it just incase the user restarts the game so that the human score of this class that will be shared among all its instances restart as well
            ai_score = 0;


        }

    }


    // create a picture in canva that says you won or AI won and add fireworks images on the right and on the left

    public int aiScore() {
        return ai_score;
    }

    public int humanScore() {
        return human_score;
    }
    // A get method, to return Ai's card , calculated here
    public JLabel aiCard() {
        return new JLabel(new ImageIcon(ai[this.aiIndex].printImage()));
    }

    //=------------------------------------------------------------------------






}