/* 
 * A seperate panel that will hold the different scores for both the ai and the human , that will be dynamically be updated after every round 
 * A winner should be declared once the human player has exuasted all it cards, this can be done by creating a static variable that will be added everytime a card is selected, once the variable is 13 the winner can be declared using the static scores variable of the ai and the human 
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


import javax.swing.event.*;



public class Spades extends MouseInputAdapter {
    static private Cards[] playerA;
    static public JPanel addButtons;
    static private Cards[] playerB;
    static public JFrame window; //attribute can be accessed from outside the class because of the public keyword, it is thus made visible to other classes.
    /* 
      * This static keyword indicates that the window attribute belongs to the class itself, 
      * In other words each instance of this class will not have their own unique value for this attribute 
      * All instances will share the same value of the attribute
      * There is only one copy of this attribute shared among all instances of the class.
      * This attribute can thus be accessed by calling the name of its class instead of creating an object to access it

    */

    public static void Play() throws IOException { // The public keyword indicates that other classes can access this class. 

        Cards[] backDeck = new Cards[13];
        Cards theCardAceOfSpades = new Cards("?", "?", 0, ImageIO.read(new File("backOfCard.png"))); // creating individual objects with specif and unique charateristics 
        for (int i = 0; i < 13; i++) {
            backDeck[i] = theCardAceOfSpades;
        }
        Cards[][] players = Cards.Players(); //Retrieving the cards distributed among the two players
        //Distributing cards
        playerA = players[0];
        playerB = players[1];
        window = new JFrame("Spades");



        // Frame
        ImageIcon customIcon = new ImageIcon("./icon.png");
        window.setIconImage(customIcon.getImage());

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setExtendedState(JFrame.MAXIMIZED_BOTH);
        window.setSize(500, 300);



        final CardLayout storingPanels = new CardLayout();
        final JPanel cardPanel = new JPanel(storingPanels);

        JLabel[] index = new JLabel[13];
        JPanel cardPanelOne = new JPanel(new BorderLayout()); // Use BorderLayout
        JPanel ai = new JPanel(new BorderLayout()); // Use BorderLayout

        //-------AI Section---
        JPanel aiPanel = new JPanel(new FlowLayout()); //  a left-to-right flow

        JPanel scores = new JPanel(new FlowLayout());

        JPanel topPanel = new JPanel(new FlowLayout());

        JLabel[] deckJLabel = new JLabel[13]; // This is a JLabel version of a deck, it has the cards in the same order as the playerA deck but just a different type

        // Setting the reversed cards on the panel positioned south for the Ai

        for (int i = 0; i < index.length; i++) {

            JLabel labelingOne = new JLabel(new ImageIcon(playerA[i].printImage()));
            deckJLabel[i] = labelingOne = new JLabel(new ImageIcon(playerA[i].printImage())); // All JLabel cards are placed the new JLabel deck 
            JLabel aiPlayed = new JLabel(new ImageIcon(playerB[i].printImage()));

            //-------------AiPan--------------------------------------------

            JLabel backCard = new JLabel(new ImageIcon(backDeck[i].printImage()));
            Border border2 = BorderFactory.createLineBorder(Color.BLACK, 2);
            backCard.setBorder(border2);

            Compo co = new Compo(topPanel, labelingOne, playerA, deckJLabel, ai, aiPlayed, playerB, i, aiPanel, backCard); // Giving an Individual card a compo characteristic, like the mouseClicked event
            Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
            labelingOne.setBorder(border);
            /* 
             * Each card / label is converted into an instance of the compo class 
             * The compo takes in the actual top panel that will have all the cards 
             * Compo all takes the actual card - labelingOne that will be clicked
             * Compo also takes its original deck that was distributed to the player. The deck is unchanged. 
             * Compo also takes the Jlabel version of the playerA deck 
             */

            /* Each card is given the ability to respond to a mouse action 
             *  So when a card is clicked it will call it compo instance that will deal with the mouse listern using the defined method
             * The labelingOne object is set as a mouse event listener using the Compo class,
             * The Compo class extends MouseInputAdapter. Thus the Compo class will handle mouse events for the JLabel.
             */
            labelingOne.addMouseListener(co); // turning the labelingOne object as a listener for mouse events. Thus, it will respond to mouse actions
            labelingOne.addMouseMotionListener(co);
            topPanel.add(labelingOne); // Adding the individual card to the topPanel
            aiPanel.add(backCard); // Adding the reversed section of the card   

        }


        Dimension preferredSize = new Dimension(20, 150);
        Dimension preferredSize2 = new Dimension(200, 130);
        ai.setBorder(null);
        aiPanel.setPreferredSize(preferredSize2);
        scores.setPreferredSize(preferredSize);

        //--------------------AI----------------------------------------------------------
        aiPanel.setBackground(Color.green.darker().darker());
        topPanel.setBackground(Color.green.darker().darker());
        ai.setBackground(Color.green.darker().darker());
        cardPanelOne.add(topPanel, BorderLayout.NORTH); // This represent the card that the user will play
        cardPanelOne.add(aiPanel, BorderLayout.SOUTH);
        cardPanelOne.add(ai, BorderLayout.CENTER);
        cardPanelOne.add(scores, BorderLayout.WEST);
        cardPanelOne.setBackground(Color.green.darker().darker());

        /** here we are adding the the different panels in the main panel and the strings names are used to differentiate the added panels */
        cardPanel.add(cardPanelOne, "First");
        cardPanel.add(scores, "Second");


        // create two buttons on the two different pannels 
        addButtons = new JPanel();


        JButton button5 = new JButton("HELP!");
        JButton button3 = new JButton("RESTART");
        addButtons.add(button5);
        addButtons.add(button3);








        //Help Section 
        button5.addActionListener(new ActionListener() {
            //Override
            public void actionPerformed(ActionEvent e) {
                // Open the scoreboard frame when the button is clicked
                JFrame help = new JFrame("Help");

                ImageIcon image = new ImageIcon("./Help.png"); //Retrieving the the help image to be displayed
                Image helpImage = image.getImage().getScaledInstance(810, 600, Image.SCALE_SMOOTH);

                ImageIcon scaledIcon = new ImageIcon(helpImage);

                JLabel label = new JLabel(scaledIcon);

                LineBorder border = new LineBorder(Color.BLACK, 1);

                label.setBorder(border);

                help.add(label);

                help.pack();

                help.setResizable(false); // disabling the maximise option 



                ImageIcon customIcon = new ImageIcon("./icon.png");
                help.setIconImage(customIcon.getImage());

                help.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

                // Handle the closing of the new window manually
                help.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        // Handle any cleanup or specific actions when the new window is closed
                        // For example, you may want to hide the window instead of disposing it
                        help.setVisible(false);
                    }
                });

                help.setVisible(true);

            }
        });

        //Restart Game: 
        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Close the JFrame
                window.dispose(); // Using the Dispose method to close the Jframe - window and release all resources associated with the Jframe
                try { // Used to ensure that the type of exception that the main method in the MainClass might thrown is the same type that will cought in the part of the code 
                    Mainclass.main(new String[0]); // calling the entry point / starting point of the program, where execution begins 
                } catch (Exception err) {
                    // If an Error occured , or an exception is encountered then do the following
                    JOptionPane.showMessageDialog(null, "The following Error was detected: " + err.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }

            }
        });

        // add card & button panels to the main window
        window.add(cardPanel, BorderLayout.CENTER);
        window.add(addButtons, BorderLayout.NORTH);
        window.setVisible(true);

    }


    public static Cards[] play1() {
        return playerA;
    }

    public static Cards[] play2() {
        return playerB;
    }

}
