import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;
import java.nio.file.Paths;
import java.io.File;
import java.util.Collections;
/**
 * Write a description of class Deck here.
 *
 * @author Donatas Vasauskas
 * @version 2020.09.06-01
 */
public class Deck {
    public ArrayList<Card> cards;
    Card card;
    int deckSize;
    int card1;
    int card2;
    Random gen = new Random();
    private ArrayList<Card> drawCard;

    /**
     * Constructor for objects of class Deck
     */
    public Deck() {
        cards = new ArrayList<Card>();
        drawCard = new ArrayList<Card>();
        //int i;
        //int j;
        int k;
        //for (i = 0; i <= 3; i++)
        //{
        //  for (j = 0; j <= 12; j++)
        //  {
        //      cards.add(new Card(i, j, new File(Paths.get(".\\jpg\\ace_of_spades.jpg").toString())));
        //  }
        //}
        cards.add(new Card(0, 0, new File(Paths.get(".\\jpg\\2_of_hearts.jpg").toString())));
        cards.add(new Card(0, 1, new File(Paths.get(".\\jpg\\3_of_hearts.jpg").toString())));
        cards.add(new Card(0, 2, new File(Paths.get(".\\jpg\\4_of_hearts.jpg").toString())));
        cards.add(new Card(0, 3, new File(Paths.get(".\\jpg\\5_of_hearts.jpg").toString())));
        cards.add(new Card(0, 4, new File(Paths.get(".\\jpg\\6_of_hearts.jpg").toString())));
        cards.add(new Card(0, 5, new File(Paths.get(".\\jpg\\7_of_hearts.jpg").toString())));
        cards.add(new Card(0, 6, new File(Paths.get(".\\jpg\\8_of_hearts.jpg").toString())));
        cards.add(new Card(0, 7, new File(Paths.get(".\\jpg\\9_of_hearts.jpg").toString())));
        cards.add(new Card(0, 8, new File(Paths.get(".\\jpg\\10_of_hearts.jpg").toString())));
        cards.add(new Card(0, 9, new File(Paths.get(".\\jpg\\jack_of_hearts.jpg").toString())));
        cards.add(new Card(0, 10, new File(Paths.get(".\\jpg\\queen_of_hearts.jpg").toString())));
        cards.add(new Card(0, 11, new File(Paths.get(".\\jpg\\king_of_hearts.jpg").toString())));
        cards.add(new Card(0, 12, new File(Paths.get(".\\jpg\\ace_of_hearts.jpg").toString())));

        cards.add(new Card(1, 0, new File(Paths.get(".\\jpg\\2_of_clubs.jpg").toString())));
        cards.add(new Card(1, 1, new File(Paths.get(".\\jpg\\3_of_clubs.jpg").toString())));
        cards.add(new Card(1, 2, new File(Paths.get(".\\jpg\\4_of_clubs.jpg").toString())));
        cards.add(new Card(1, 3, new File(Paths.get(".\\jpg\\5_of_clubs.jpg").toString())));
        cards.add(new Card(1, 4, new File(Paths.get(".\\jpg\\6_of_clubs.jpg").toString())));
        cards.add(new Card(1, 5, new File(Paths.get(".\\jpg\\7_of_clubs.jpg").toString())));
        cards.add(new Card(1, 6, new File(Paths.get(".\\jpg\\8_of_clubs.jpg").toString())));
        cards.add(new Card(1, 7, new File(Paths.get(".\\jpg\\9_of_clubs.jpg").toString())));
        cards.add(new Card(1, 8, new File(Paths.get(".\\jpg\\10_of_clubs.jpg").toString())));
        cards.add(new Card(1, 9, new File(Paths.get(".\\jpg\\jack_of_clubs.jpg").toString())));
        cards.add(new Card(1, 10, new File(Paths.get(".\\jpg\\queen_of_clubs.jpg").toString())));
        cards.add(new Card(1, 11, new File(Paths.get(".\\jpg\\king_of_clubs.jpg").toString())));
        cards.add(new Card(1, 12, new File(Paths.get(".\\jpg\\ace_of_clubs.jpg").toString())));

        cards.add(new Card(2, 0, new File(Paths.get(".\\jpg\\2_of_spades.jpg").toString())));
        cards.add(new Card(2, 1, new File(Paths.get(".\\jpg\\3_of_spades.jpg").toString())));
        cards.add(new Card(2, 2, new File(Paths.get(".\\jpg\\4_of_spades.jpg").toString())));
        cards.add(new Card(2, 3, new File(Paths.get(".\\jpg\\5_of_spades.jpg").toString())));
        cards.add(new Card(2, 4, new File(Paths.get(".\\jpg\\6_of_spades.jpg").toString())));
        cards.add(new Card(2, 5, new File(Paths.get(".\\jpg\\7_of_spades.jpg").toString())));
        cards.add(new Card(2, 6, new File(Paths.get(".\\jpg\\8_of_spades.jpg").toString())));
        cards.add(new Card(2, 7, new File(Paths.get(".\\jpg\\9_of_spades.jpg").toString())));
        cards.add(new Card(2, 8, new File(Paths.get(".\\jpg\\10_of_spades.jpg").toString())));
        cards.add(new Card(2, 9, new File(Paths.get(".\\jpg\\jack_of_spades.jpg").toString())));
        cards.add(new Card(2, 10, new File(Paths.get(".\\jpg\\queen_of_spades.jpg").toString())));
        cards.add(new Card(2, 11, new File(Paths.get(".\\jpg\\king_of_spades.jpg").toString())));
        cards.add(new Card(2, 12, new File(Paths.get(".\\jpg\\ace_of_spades.jpg").toString())));

        cards.add(new Card(3, 0, new File(Paths.get(".\\jpg\\2_of_Diamonds.jpg").toString())));
        cards.add(new Card(3, 1, new File(Paths.get(".\\jpg\\3_of_Diamonds.jpg").toString())));
        cards.add(new Card(3, 2, new File(Paths.get(".\\jpg\\4_of_Diamonds.jpg").toString())));
        cards.add(new Card(3, 3, new File(Paths.get(".\\jpg\\5_of_Diamonds.jpg").toString())));
        cards.add(new Card(3, 4, new File(Paths.get(".\\jpg\\6_of_Diamonds.jpg").toString())));
        cards.add(new Card(3, 5, new File(Paths.get(".\\jpg\\7_of_Diamonds.jpg").toString())));
        cards.add(new Card(3, 6, new File(Paths.get(".\\jpg\\8_of_Diamonds.jpg").toString())));
        cards.add(new Card(3, 7, new File(Paths.get(".\\jpg\\9_of_Diamonds.jpg").toString())));
        cards.add(new Card(3, 8, new File(Paths.get(".\\jpg\\10_of_Diamonds.jpg").toString())));
        cards.add(new Card(3, 9, new File(Paths.get(".\\jpg\\jack_of_Diamonds.jpg").toString())));
        cards.add(new Card(3, 10, new File(Paths.get(".\\jpg\\queen_of_Diamonds.jpg").toString())));
        cards.add(new Card(3, 11, new File(Paths.get(".\\jpg\\king_of_Diamonds.jpg").toString())));
        cards.add(new Card(3, 12, new File(Paths.get(".\\jpg\\ace_of_Diamonds.jpg").toString())));
        for (k = 0; k < 100; k++) {
            card1 = gen.nextInt(cards.size() - 1);
            card2 = gen.nextInt(cards.size() - 1);

            card = cards.get(card2);
            cards.set(card2, cards.get(card1));
            cards.set(card1, card);
        }

    }
    public Card draw()
    {
        Collections.shuffle(cards);
        return cards.remove(cards.size()-1);
        //had to do 2 because it constantly was giving same card
    }

    public int getCards()
    {
        return cards.size();
    }
    public void getArrayList()
    {
        for(int i =0; i<cards.size(); i++)
        {
            System.out.println(cards.get(i));
        }
    }
    public void shuffle()
    {
        Collections.shuffle(cards);
        System.out.println("Cards has been shuffled");
    }

}