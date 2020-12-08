import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class CardColumn implements Iterable<Card>{

    ArrayList<Card> cards = new ArrayList<Card>();

    public Card peek()
    {
        return cards.get(cards.size() - 1);
    }

    public Card pop()
    {
        int last = size() - 1;
        Card temporary = cards.get(last);
        cards.remove(last);
        return temporary;
    }

    public void push(Card card)
    {
        cards.add(card);
    }

    public int size()
    {
        return cards.size();
    }

    public void shuffle()
    {
        Collections.shuffle(cards);
    }


    public void clear()
    {
        cards.clear();
    }

    public boolean rulesForAddingCard(Card card)
    {
        return true;
    }
    public boolean rulesAllowAddingThisCard(Card card)
    {
        return true;
    }
    public boolean isRemovable()
    {
        return true;
    }
    @Override
    public Iterator<Card> iterator()
    {
        return cards.iterator();
    }

    public String toString()
    {
        return cards.toString() + "\n";
    }

    public void pushIgnoreRules(Card card)
    {
        cards.add(card);
    }
    public Card popIgnoreRules()
    {
        int lastIndex = size()-1;
        Card card = cards.get(lastIndex);
        cards.remove(lastIndex);
        return card;
    }
    public Card peekTop()
    {
        return cards.get(cards.size() - 1);
    }
}