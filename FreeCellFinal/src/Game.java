import java.util.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class Game implements Iterable<CardColumn>
{
    CardColumn[] freecell, tableau, foundation;
    private ArrayList<CardColumn> columns;
    private ArrayList<ChangeListener> cl; //https://docs.oracle.com/javase/8/javafx/api/javafx/collections/ListChangeListener.html
    private ArrayDeque<CardColumn> undo = new ArrayDeque<CardColumn>(); //https://www.baeldung.com/java-array-deque#:~:text=An%20ArrayDeque%20(also%20known%20as,In%2DFirst%2DOut).
    
    
    public Game()
    {
        columns = new ArrayList<CardColumn>();
        foundation = new CardColumn[4];
        freecell  = new CardColumn[4];
        tableau    = new Tableau[8];
        
        
        for (int column = 0; column < foundation.length; column++)
        {
            foundation[column] = new Foundation();
            columns.add(foundation[column]);
        }
        for (int column = 0; column < freecell.length; column++)
        {
            freecell[column] = new Freecell();
            columns.add(freecell[column]);
        }
        for (int column = 0; column < tableau.length; column++)
        {
            tableau[column] = new Tableau();
            columns.add(tableau[column]);
        }

        cl = new ArrayList<ChangeListener>();

        reset();
    }
    
    public void reset()
    {
        Deck deck = new Deck();
        deck.shuffle();

        
        for (CardColumn cc: columns)
        {
            cc.clear();
        }
        int inTheRow = 0;
        for (Card card : deck)
        {
            tableau[inTheRow].pushIgnoreRules(card);
            inTheRow = (inTheRow + 1) % tableau.length;
        }
        
        notifyEveryoneOfChanges();
    }

   
    public Iterator<CardColumn> iterator()
    {
        return columns.iterator();
    }
    
    public CardColumn getTableau(int i)
    {
        return tableau[i];
    }
    public CardColumn[] getTableaus()
    {
        return tableau;
    }
   
    public CardColumn[] getFreeCells()
    {
        return freecell;
    }
    
    public CardColumn getFreeCell(int cellNum)
    {
        return freecell[cellNum];
    }
    
    public CardColumn[] getFoundations()
    {
        return foundation;
    }

    public CardColumn getFoundation(int cellNum)
    {
        return foundation[cellNum];
    }

    public boolean columnToColumn(CardColumn source, CardColumn target)
    {
        boolean result = false;
        if (source.size() > 0)
        {
            Card card = source.peekTop();
            if (target.rulesAllowAddingThisCard(card))
            {
                target.push(card);
                source.pop();
                notifyEveryoneOfChanges();
                undo.push(source);
                undo.push(target);
                result = true;
            }
        }
        return result;
    }
    public void addChangeListener(ChangeListener listener)
    {
        cl.add(listener);
    }
    private void notifyEveryoneOfChanges()
    {
        for (ChangeListener listener : cl)
        {
            listener.stateChanged(new ChangeEvent("Changed"));
        }
    }
}