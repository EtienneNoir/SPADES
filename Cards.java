import java.util.Random;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
//import java.awt.image.BufferedImage;// to display images of cards
public class Cards {
    private final String suitName; //SUIT
    private final String cardSymbol; // RANK
    private final int cardValue; // OUR VALUE RANK
    private final BufferedImage imageOfCard; // IMAGE


    public Cards(String suit, String symbol, int value, BufferedImage imageCard) {
        /**the constructor initialize the instance */
        this.suitName = suit;
        this.cardSymbol = symbol;
        this.cardValue = value;
        this.imageOfCard = imageCard;
    } // CONSTRUCTOR

    public String printCards() {
        /**THE METHOD RETURNS THE CARD 'S VALUE RANK AND SUIT*/
        return cardSymbol + " " + "OF" + " " + suitName; // here a concatination of the CardSymbol and our suitName in order to give an appropriate card representation
    } // RANK AND SUIT
    public String Suits() {
        /**THE METHOD RETURNS THE CARD 'S VALUE RANK AND SUIT*/
        return suitName; // here a concatination of the CardSymbol and our suitName in order to give an appropriate card representation
    } //SUIT

    public int printValue() {
        //THE METHOD RETURNS THE CARD VALUE ACCORDING TO OUR RANKING  
        return cardValue;
    }
    public BufferedImage printImage() {
        /** THE METHODS RETURNS THE IMAGE OF OUR BEAUTIFUL CARD*/
        return imageOfCard; //To change body of generated methods, choose Tools | Templates.// to return card image
    }

    public static Cards[][] printPlayers(Cards[] x) { //Cards[][] in order to return an array within another array 
        Cards[] player1 = new Cards[13]; // so that it can hold like at least 13 cards 
        Cards[] player2 = new Cards[13];


        for (int i = 0; i < 13; i++) {
            player1[i] = x[i];
        }
        int startIndex = 13; // a start up index in order to tell it from which row in place we should extract the element and also because the player index value begins with a 13 value // therefore   for(int i = 0 ; i < 13 ; i++){
        /* player2[i] = x[startIndex];
        startIndex++;
     }*/
        for (int i = 0; i < 13; i++) {
            player2[i] = x[startIndex];
            startIndex++;
        }



        Cards[][] allPlayers = {
            player1,
            player2
        }; // so allPLayers has 4 elemenys within thus an array within an array


        return allPlayers;
    }



    private static Cards[] shuffle(Cards[] cards) {
        Random numbs = new Random();
        for (int i = 0; i < 52; i++) {
            int value = i + numbs.nextInt(52 - i); //  so that the randomly chosen index (value) is different from the current index (i).
            Cards temp = cards[i];
            cards[i] = cards[value];
            cards[value] = temp;
        }
        return cards;
    }

    private static Cards[] creatingDeck() throws IOException { //MADE IT PRIVATE 

        Cards[] deck1 = new Cards[52]; // created a object array in order to store the objects
        Cards theCardAceOfSpades = new Cards("Spades", "Ace", 27, ImageIO.read(new File("Ace_Of_Spades.png"))); // creating individual objects with specif and unique charateristics 
        Cards theCardThreeOfSpades = new Cards("Spades", "Three", 16, ImageIO.read(new File("Three_Of_Spades.png"))); // it is done this way in order to access the other characteristics 
        Cards theCardTwoOfSpades = new Cards("Spades", "Two", 15, ImageIO.read(new File("Two_Of_Spades.png"))); // spades have  higher card value  
        Cards theCardFourOfSpades = new Cards("Spades", "Four", 17, ImageIO.read(new File("four_Of_Spades.png")));
        Cards theCardsFiveOfSpades = new Cards("Spades", "Five", 18, ImageIO.read(new File("five_Of_Spades.png")));
        Cards theCardsSixOfSpades = new Cards("Spades", "Six", 19, ImageIO.read(new File("Six_Of_Spades.png")));
        Cards theCardsSevenOfSpades = new Cards("Spades", "Seven", 20, ImageIO.read(new File("Seven_Of_Spades.png")));
        Cards theCardsEightOfSpades = new Cards("Spades", "Eight", 21, ImageIO.read(new File("Eight_Of_Spades.png")));
        Cards theCardsNineOfSpades = new Cards("Spades", "Nine", 22, ImageIO.read(new File("Nine_Of_Spades.png")));
        Cards theCardsSTenOfSpades = new Cards("Spades", "Ten", 23, ImageIO.read(new File("Ten_Of_Spades.png")));
        Cards theCardsJackOfSpades = new Cards("Spades", "Jack", 24, ImageIO.read(new File("Jack_Of_Spades.png")));
        Cards theCardsQueenOfSpades = new Cards("Spades", "Queen", 25, ImageIO.read(new File("Queen_Of_Spades.png")));
        Cards theCardsKingOfSpades = new Cards("Spades", "King", 26, ImageIO.read(new File("King_Of_Spades.png")));
        Cards theCardAceOfDiamond = new Cards("Diamonds", "Ace", 14, ImageIO.read(new File("Ace_Of_Diamonds.png")));
        Cards theCardTwoOfDiamond = new Cards("Diamonds", "Two", 2, ImageIO.read(new File("Two_Of_Diamonds.png")));
        Cards theCardThreeOfDiamond = new Cards("Diamonds", "Three", 3, ImageIO.read(new File("Three_Of_Diamonds.png")));
        Cards theCardFourOfDiamond = new Cards("Diamonds", "Four", 4, ImageIO.read(new File("four_Of_Diamonds.png")));
        Cards theCardsFiveOfDiamond = new Cards("Diamonds", "Five", 5, ImageIO.read(new File("five_Of_Diamonds.png")));
        Cards theCardsSixOfDiamond = new Cards("Diamonds", "Six", 6, ImageIO.read(new File("Six_Of_Diamonds.png")));
        Cards theCardsSevenOfDiamond = new Cards("Diamonds", "Seven", 7, ImageIO.read(new File("Seven_Of_Diamonds.png")));
        Cards theCardsEightOfDiamond = new Cards("Diamonds", "Eight", 8, ImageIO.read(new File("Eight_Of_Diamonds.png")));
        Cards theCardsNineOfDiamond = new Cards("Diamonds", "Nine", 9, ImageIO.read(new File("Nine_Of_Diamonds.png")));
        Cards theCardsSTenOfDiamond = new Cards("Diamonds", "Ten", 10, ImageIO.read(new File("Ten_Of_Diamonds.png")));
        Cards theCardsJackOfDiamond = new Cards("Diamonds", "Jack", 11, ImageIO.read(new File("Jack_Of_Diamonds.png")));
        Cards theCardsQueenOfDiamond = new Cards("Diamonds", "Queen", 12, ImageIO.read(new File("Queen_Of_Diamonds.png")));
        Cards theCardsKingOfDiamond = new Cards("Diamonds", "King", 13, ImageIO.read(new File("King_Of_Diamonds.png")));
        Cards theCardAceOfClubs = new Cards("Clubs", "Ace", 14, ImageIO.read(new File("Ace_Of_Clubs.png")));
        Cards theCardTwoOfClubs = new Cards("Clubs", "Two", 2, ImageIO.read(new File("Two_Of_Clubs.png")));
        Cards theCardThreeOfClubs = new Cards("Clubs", "Three", 3, ImageIO.read(new File("Three_Of_Clubs.png")));
        Cards theCardFourOfClubs = new Cards("Clubs", "Four", 4, ImageIO.read(new File("four_Of_Clubs.png")));
        Cards theCardsFiveOfClubs = new Cards("Clubs", "Five", 5, ImageIO.read(new File("five_Of_Clubs.png")));
        Cards theCardsSixOfClubs = new Cards("Clubs", "Six", 6, ImageIO.read(new File("Six_Of_Clubs.png")));
        Cards theCardsSevenOfClubs = new Cards("Clubs", "Seven", 7, ImageIO.read(new File("Seven_Of_Clubs.png")));
        Cards theCardsEightOfClubs = new Cards("Clubs", "Eight", 8, ImageIO.read(new File("Eight_Of_Clubs.png")));
        Cards theCardsNineOfClubs = new Cards("Clubs", "Nine", 9, ImageIO.read(new File("Nine_Of_Clubs.png")));
        Cards theCardsSTenOfClubs = new Cards("Clubs", "Ten", 10, ImageIO.read(new File("Ten_Of_Clubs.png")));
        Cards theCardsJackOfClubs = new Cards("Clubs", "Jack", 11, ImageIO.read(new File("Jack_Of_Clubs.png")));
        Cards theCardsQueenOfClubs = new Cards("Clubs", "Queen", 12, ImageIO.read(new File("Queen_Of_Clubs.png")));
        Cards theCardsKingOfClubs = new Cards("Clubs", "King", 13, ImageIO.read(new File("King_Of_Clubs.png")));
        Cards theCardAceOfHearts = new Cards("Hearts", "Ace", 14, ImageIO.read(new File("Ace_Of_Hearts.png")));
        Cards theCardTwoOfHearts = new Cards("Hearts", "Two", 2, ImageIO.read(new File("Two_Of_Hearts.png")));
        Cards theCardThreeOfHearts = new Cards("Hearts", "Three", 3, ImageIO.read(new File("Three_Of_Hearts.png")));
        Cards theCardFourOfHearts = new Cards("Hearts", "Four", 4, ImageIO.read(new File("four_Of_Hearts.png")));
        Cards theCardsFiveOfHearts = new Cards("Hearts", "Five", 5, ImageIO.read(new File("five_Of_Hearts.png")));
        Cards theCardsSixOfHearts = new Cards("Hearts", "Six", 6, ImageIO.read(new File("Six_Of_Hearts.png")));
        Cards theCardsSevenOfHearts = new Cards("Hearts", "Seven", 7, ImageIO.read(new File("Seven_Of_Hearts.png")));
        Cards theCardsEightOfHearts = new Cards("Hearts", "Eight", 8, ImageIO.read(new File("Eight_Of_Hearts.png")));
        Cards theCardsNineOfHearts = new Cards("Hearts", "Nine", 9, ImageIO.read(new File("Nine_Of_Hearts.png")));
        Cards theCardsSTenOfHearts = new Cards("Hearts", "Ten", 10, ImageIO.read(new File("Ten_Of_Hearts.png")));
        Cards theCardsJackOfHearts = new Cards("Hearts", "Jack", 11, ImageIO.read(new File("Jack_Of_Hearts.png")));
        Cards theCardsQueenOfHearts = new Cards("Hearts", "Queen", 12, ImageIO.read(new File("Queen_Of_Hearts.png")));
        Cards theCardsKingOfHearts = new Cards("Hearts", "King", 13, ImageIO.read(new File("King_Of_Hearts.png")));
        deck1[0] = theCardAceOfSpades; // so here we are storing each individual object in deck1 
        deck1[1] = theCardThreeOfSpades;
        deck1[2] = theCardFourOfSpades;
        deck1[3] = theCardsFiveOfSpades;
        deck1[4] = theCardsSixOfSpades;
        deck1[5] = theCardsSevenOfSpades;
        deck1[6] = theCardsEightOfSpades;
        deck1[7] = theCardsNineOfSpades;
        deck1[8] = theCardsSTenOfSpades;
        deck1[9] = theCardsJackOfSpades;
        deck1[10] = theCardsQueenOfSpades;
        deck1[11] = theCardsKingOfSpades;
        deck1[12] = theCardAceOfDiamond;
        deck1[13] = theCardThreeOfDiamond;
        deck1[14] = theCardFourOfDiamond;
        deck1[15] = theCardsFiveOfDiamond;
        deck1[16] = theCardsSixOfDiamond;
        deck1[17] = theCardsSevenOfDiamond;
        deck1[18] = theCardsEightOfDiamond;
        deck1[19] = theCardsNineOfDiamond;
        deck1[20] = theCardsSTenOfDiamond;
        deck1[21] = theCardsJackOfDiamond;
        deck1[22] = theCardsQueenOfDiamond;
        deck1[23] = theCardsKingOfDiamond;
        deck1[24] = theCardAceOfClubs;
        deck1[25] = theCardThreeOfClubs;
        deck1[26] = theCardFourOfClubs;
        deck1[27] = theCardsFiveOfClubs;
        deck1[28] = theCardsSixOfClubs;
        deck1[29] = theCardsSevenOfClubs;
        deck1[30] = theCardsEightOfClubs;
        deck1[31] = theCardsNineOfClubs;
        deck1[32] = theCardsSTenOfClubs;
        deck1[33] = theCardsJackOfClubs;
        deck1[34] = theCardsQueenOfClubs;
        deck1[35] = theCardsKingOfClubs;
        deck1[36] = theCardAceOfHearts;
        deck1[37] = theCardThreeOfHearts;
        deck1[38] = theCardFourOfHearts;
        deck1[39] = theCardsFiveOfHearts;
        deck1[40] = theCardsSixOfHearts;
        deck1[41] = theCardsSevenOfHearts;
        deck1[42] = theCardsEightOfHearts;
        deck1[43] = theCardsNineOfHearts;
        deck1[44] = theCardsSTenOfHearts;
        deck1[45] = theCardsJackOfHearts;
        deck1[46] = theCardsQueenOfHearts;
        deck1[47] = theCardsKingOfHearts;
        deck1[48] = theCardTwoOfSpades;
        deck1[49] = theCardTwoOfHearts;
        deck1[50] = theCardTwoOfClubs;
        deck1[51] = theCardTwoOfDiamond;
        return deck1;
    }
    public static Cards[][] Players() throws IOException {
        Cards[] createdDeck = creatingDeck();
        Cards[] deck = shuffle(createdDeck); // assigning our return value from the shuffle method to deck obeject thus it will hold a shuffle version of deck1
        //  System.out.println(deck[0].printValue() > deck[1].printValue());// example of how we can use it 
        Cards[][] players = printPlayers(deck);



        return players;
    }


}