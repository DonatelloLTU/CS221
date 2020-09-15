import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class WarGame
{


        public static void main(String[] args) throws InterruptedException {
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

            while (playerOne[0] != null || playerTwo[0] != null)
            {
               Card playerOneCard = playerOne[0];
               Card playerTwoCard = playerTwo[0];

               System.out.println("Player one card: " + playerOneCard);
               System.out.println("Player two card: " + playerTwoCard);

                LinkedList<Card> tempList = new LinkedList<>(Arrays.asList(playerOne));
                LinkedList<Card> tempList2 = new LinkedList<>(Arrays.asList(playerTwo));
               if(playerOneCard.getValue() > playerTwoCard.getValue())
               {
                   System.out.println("Player one wins this round!");

                   tempList.add(playerOneCard);
                   tempList.removeFirst();
                   tempList.add(playerTwoCard);
                   tempList2.removeFirst();
                   playerOne = tempList.toArray(playerOne);
                   playerTwo = tempList2.toArray(playerTwo);
                   TimeUnit.SECONDS.sleep(5);
               }
               else if (playerOneCard.getValue() < playerTwoCard.getValue())
               {
                   System.out.println("Player two wins this round!");
                   tempList2.add(playerTwoCard);
                   tempList2.removeFirst();
                   tempList.add(playerOneCard);
                   tempList.removeFirst();
                   playerOne = tempList.toArray(playerOne);
                   playerTwo = tempList2.toArray(playerTwo);
                   TimeUnit.SECONDS.sleep(5);
               }
               else
               {
                   System.out.println("War");
                   for (int b = 0; b < 5; b++)
                   {

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
                       playerOne = tempList.toArray(playerOne);
                       playerTwo = tempList2.toArray(playerTwo);
                       System.out.println("Player one won the war!!!");
                       TimeUnit.SECONDS.sleep(5);
                   }
                   else if (playerOneCard.getValue() < playerTwoCard.getValue())
                   {
                       tempList2.addAll(warList);
                       playerOne = tempList.toArray(playerOne);
                       playerTwo = tempList2.toArray(playerTwo);
                       System.out.println("Player two won the war!!!");
                       TimeUnit.SECONDS.sleep(5);
                   }
                   else
                   {
                       System.out.println("War again!!!!");
                   }

               }

            }



        }
}
