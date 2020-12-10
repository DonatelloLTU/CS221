import java.awt.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Game class where the magic happens. Game engine within this class
 * @author dvasauskas
 * @version 2020-12-01.01
 */
public class Game implements Iterable<CardColumn>
{
    CardColumn[] freecell, tableau, foundation;
    private ArrayList<CardColumn> columns;
    private ArrayList<ChangeListener> cl; //https://docs.oracle.com/javase/7/docs/api/javax/swing/event/ChangeListener.html
    private ArrayDeque<CardColumn> undo = new ArrayDeque<CardColumn>(); //https://www.baeldung.com/java-array-deque#:~:text=An%20ArrayDeque%20(also%20known%20as,In%2DFirst%2DOut).

    /**
     * Constructor for the Game class
     */
    public Game()
    {
        foundation = new CardColumn[4];
        freecell  = new CardColumn[4];
        tableau    = new CardColumn[8];
        columns = new ArrayList<CardColumn>();

        // columns for foundation
        for (int i = 0; i < foundation.length; i++)
        {
            foundation[i] = new Foundation();
            columns.add(foundation[i]);
        }

        //columns for freecell
        for (int i = 0; i < freecell.length; i++)
        {
            freecell[i] = new Freecell();
            columns.add(freecell[i]);
        }

        //collumns for tableau and adding cards and arranging
        for (int i = 0; i < tableau.length; i++)
        {
            tableau[i] = new CardColumn();
            columns.add(tableau[i]);
        }

        cl = new ArrayList<ChangeListener>();

        reset();

    }
    /*
    * method to get rules of the game
     */
    public static boolean openWebpage(URI uri)
    {
        Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
        if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
            try {
                desktop.browse(uri);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static boolean openWebpage(URL url) {
        try {
            return openWebpage(url.toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return false;
    }
    /**
     * Method to reset the game
     */
    public void reset()
    {
        Deck deck = new Deck();
        deck.shuffle();

        //for each loop to clear
        for (CardColumn cc: columns)
        {
            cc.clear();
        }
        int inTheRow = 0;
        //for each loop to push new cards
        for (Card card : deck)
        {
            tableau[inTheRow].pushIgnore(card);
            inTheRow = (inTheRow + 1) % tableau.length;
        }
        
        changes();
    }

    /**
     * Method to give changes to the listener
     * https://docs.oracle.com/javase/7/docs/api/javax/swing/event/ChangeListener.html
     */
    private void changes()
    {
        for (ChangeListener listener : cl)
        {
            listener.stateChanged(new ChangeEvent("Reset the game"));
        }
    }

    /**
     * Method to addChangeListener
     * https://docs.oracle.com/javase/7/docs/api/javax/swing/event/ChangeListener.html
     * @param listener Change listener for changes
     */
    public void addChangeListener(ChangeListener listener)
    {
        cl.add(listener);
    }

    /**
     * Method to go over columns of the cards
     * @return found column card
     */
    public Iterator<CardColumn> iterator()
    {
        return columns.iterator();
    }

    /**
     * Method to get tableau with specific index
     * @param i int to index secific tableau
     * @return tableau with that index
     */
    public CardColumn getTableau(int i)
    {
        return tableau[i];
    }

    /**
     * Method to get all tableaus
     * @return tableaus
     */
    public CardColumn[] getTableaus()
    {
        return tableau;
    }

    /**
     * method to get specific freecell
     * @param i integer to specify index
     * @return specific freecell
     */
    public CardColumn getFreeCell(int i)
    {
        return freecell[i];
    }
    /**
     * Method to get all the freecells
     * @return
     */
    public CardColumn[] getFreeCells()
    {
        return freecell;
    }

    /**
     * Method to get foundation with specific index
     * @param i index to specify specific foundation
     * @return specific foundation
     */
    public CardColumn getFoundation(int i)
    {
        return foundation[i];
    }

    /**
     * Method to get all the foundations
     * @return foundations
     */
    public CardColumn[] getFoundations()
    {
        return foundation;
    }

    /**
     * Method to move cards from column to column
     * @param originalPos is original position of the card
     * @param finalPos is final position of thee card
     * @return result after moving
     */
    public boolean columnToColumn(CardColumn originalPos, CardColumn finalPos)
    {
        boolean result = false;
        if (originalPos.size() > 0)
        {
            Card card = originalPos.peek();
            if (finalPos.addingThisCard(card))
            {
                finalPos.push(card);
                originalPos.pop();
                changes();
                undo.push(originalPos);
                undo.push(finalPos);
                result = true;
            }
        }
        return result;
    }


}