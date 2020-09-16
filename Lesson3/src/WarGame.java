import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * WarGame class is the main class to run the game and determine who wins.
 * @author Donatas Vasauskas
 * @version 2020-09-15.01
 */
public class WarGame
{


        public static void main(String[] args) throws InterruptedException, IOException {
            Deck deck = new Deck();
            Card[] playerOne = new Card[100];
            Card[] playerTwo = new Card[100];


            List<Card> warList = new ArrayList<>();
            List<Card> warList2 = new ArrayList<>();


                for (int i = 0; i < 26; i++) {
                    playerOne[i] = deck.returnDeck(i);
                    //System.out.println(playerOne[i]);
                }
                //System.out.println("Player two deck");
                for (int j = 0; j < 26; j++) {
                    playerTwo[j] = deck.returnDeck(j+26);
                   // System.out.println(playerTwo[j]);
                }
            /*
                Main loop for the game, if none of the arrays are 0, if not 0 then the game runs.
             */
            while (playerOne[0] != null || playerTwo[0] != null)
            {
               Card playerOneCard = playerOne[0]; //assigning first card of array to player card
               Card playerTwoCard = playerTwo[0]; //assigning first car of array to player card

               System.out.println("Player one card: " + playerOneCard); //prints out the player one card
               System.out.println("Player two card: " + playerTwoCard); //prints out the player two card

                LinkedList<Card> tempList = new LinkedList<>(Arrays.asList(playerOne)); //takes array and changes to LinkedList
                LinkedList<Card> tempList2 = new LinkedList<>(Arrays.asList(playerTwo)); //takes array and changes to LinkedList
               if(playerOneCard.getValue() > playerTwoCard.getValue()) //if player one card is higher, player one wins, adding his own first card and the card won to his array.
               {
                   System.out.println("Player one wins this round!");

                   tempList.add(playerOneCard);
                   tempList.removeFirst();
                   tempList.add(playerTwoCard);
                   tempList2.removeFirst();
                   tempList.removeAll(Collections.singletonList(null));
                   tempList2.removeAll(Collections.singletonList(null));
                   playerOne = tempList.toArray(playerOne);
                   playerTwo = tempList2.toArray(playerTwo);
                   TimeUnit.SECONDS.sleep(5);
                    System.out.println(" ");


               }
               else if (playerOneCard.getValue() < playerTwoCard.getValue()) //if player two card is higher, player one wins, adding his own first card and the card won to his array.
               {
                   System.out.println("Player two wins this round!");
                   tempList2.add(playerTwoCard);
                   tempList2.removeFirst();
                   tempList.add(playerOneCard);
                   tempList.removeFirst();
                   tempList.removeAll(Collections.singletonList(null));
                   tempList2.removeAll(Collections.singletonList(null));
                   playerOne = tempList.toArray(playerOne);
                   playerTwo = tempList2.toArray(playerTwo);
                   TimeUnit.SECONDS.sleep(5);
                   System.out.println(" ");

               }
               else //War part of the game
               {
                   System.out.println("War");
                   for (int b = 0; b < 5; b++)
                   {
                       if (tempList.isEmpty())
                       {
                           tempList.add(tempList2.getFirst());
                       }
                       else if (tempList2.isEmpty())
                       {
                           tempList2.add(tempList.getFirst());
                       }

                       warList.add(tempList.getFirst());
                       warList2.add(tempList2.getFirst());
                       tempList.removeFirst();
                       tempList2.removeFirst();

                   }
                   playerOneCard = tempList.getFirst();
                   playerTwoCard = tempList2.getFirst();

                   if (playerOneCard.getValue() > playerTwoCard.getValue())
                   {
                       tempList.addAll(warList);
                       tempList.addAll(warList2);
                       tempList.removeAll(Collections.singletonList(null));
                       tempList2.removeAll(Collections.singletonList(null));
                       playerOne = tempList.toArray(playerOne);
                       playerTwo = tempList2.toArray(playerTwo);
                       System.out.println("Player one card: " + playerOneCard);
                       System.out.println("Player two card: " + playerTwoCard);
                       System.out.println("Player one won the war!!!");
                       TimeUnit.SECONDS.sleep(5);
                       System.out.println(" ");
                   }
                   else if (playerOneCard.getValue() < playerTwoCard.getValue())
                   {

                       tempList2.addAll(warList);
                       tempList.remove(null);
                       tempList2.remove(null);
                       playerOne = tempList.toArray(playerOne);
                       playerTwo = tempList2.toArray(playerTwo);
                       System.out.println("Player one card: " + playerOneCard);
                       System.out.println("Player two card: " + playerTwoCard);
                       System.out.println("Player two won the war!!!");
                       TimeUnit.SECONDS.sleep(5);
                       System.out.println("  ");
                   }
                   else
                   {
                       System.out.println("War again!!!!");
                       break;
                   }

               }

            }
            if (playerOne[0] == null)
            {
                System.out.println("PLAYER 2 WINS THE GAME OF WAR!!!!");
            }
            else
            {
                System.out.println("PLAYER 1 WINS THE GAME OF WAR!!!!");
            }



        }
}
