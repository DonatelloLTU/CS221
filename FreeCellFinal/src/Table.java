
import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.*;
import javax.swing.event.*;


class Table extends JComponent implements
        MouseListener,
        MouseMotionListener,
        ChangeListener {

    private static final int NUMBER_OF_PILES = 8;
    private static final int GAP = 20;
    private static final int FOUNDATION_TOP = GAP;
    private static final int FOUNDATION_BOTTOM = FOUNDATION_TOP + Card.CARD_HEIGHT;

    private static final int FREE_CELL_TOP = GAP ;
    private static final int FREE_CELL_BOTTOM = FREE_CELL_TOP + Card.CARD_HEIGHT;

    private static final int TABLEAU_TOP = 2 * GAP +
            Math.max(FOUNDATION_BOTTOM, FREE_CELL_BOTTOM);
    private static final int TABLEAU_INCR_Y  = 15;
    private static final int TABLEAU_START_X = GAP;
    private static final int TABLEAU_INCR_X  = Card.CARD_WIDTH + GAP;


    private static final Color BACKGROUND_COLOR = new Color(0, 100, 0);

    //=================================================================== fields

    /** Position in image of mouse press to make dragging look better. */
    private int _dragFromX = 0;  // Displacement inside image of mouse press
    private int _dragFromY = 0;

    //... Selected card and its column for dragging purposes.
    private Card     dragCard = null;  // Current draggable card
    private CardColumn _draggedFromPile = null;  // Which column it came from

    //... Remember where each column is located.
    private IdentityHashMap<CardColumn, Rectangle> _whereIs =
            new IdentityHashMap<CardColumn, Rectangle>();

    //private boolean _autoComplete = false;

    private Game game;
    //============================================================== constructor
    /** Constructor sets size, colors, and adds mouse listeners.*/
    Table(Game model)
    {
        //... Save the model.
        game = model;

        //... Initialize graphics
        setPreferredSize(new Dimension(1080, 720));


        //... Add mouse listeners.
        this.addMouseListener(this);
        this.addMouseMotionListener(this);

        //... Set location of all columns in model
        int x = TABLEAU_START_X;   // Initial x position.
        for (int columnNumber = 0; columnNumber < 8; columnNumber++)
        {
            CardColumn p;
            if (columnNumber < 4)
            {
                p = game.getFreeCell(columnNumber);
                _whereIs.put(p, new Rectangle(x, FREE_CELL_TOP, Card.CARD_WIDTH,
                        Card.CARD_HEIGHT));
            } else {
                p = game.getFoundation(columnNumber - 4);
                _whereIs.put(p, new Rectangle(x, FOUNDATION_TOP, Card.CARD_WIDTH,
                        Card.CARD_HEIGHT));
            }

            p = game.getTableau(columnNumber);
            _whereIs.put(p, new Rectangle(x, TABLEAU_TOP, Card.CARD_WIDTH,
                    3 * Card.CARD_HEIGHT));

            x += TABLEAU_INCR_X;
        }

        //... Make sure model calls us whenever something changes
        game.addChangeListener(this);
    }
    //=========================================================== paintComponent
    /** Draw the cards. */
    @Override public void paintComponent(Graphics g)
    {
        //... Paint background.
        int width  = getWidth();
        int height = getHeight();
        g.setColor(BACKGROUND_COLOR);	// in order not to see visual artifacts
        g.fillRect(0, 0, width, height);//, because of the override


        //... Display each column.
        for (CardColumn column : game.getFreeCells())
        {
            g.setColor(Color.BLACK);
            createColumns(g, column, true);
        }
        for (CardColumn column : game.getFoundations())
        {
            g.setColor(Color.BLACK);
            createColumns(g, column, true);
        }
        for (CardColumn column : game.getTableaus())
        {
            g.setColor(new Color(0,100,0));
            createColumns(g, column, false);
        }

        //... Draw the dragged card, if any
        if (dragCard != null)
        {
            dragCard.draw(g);
        }
    }
    //================================================================ createColumns
    private void createColumns(Graphics g, CardColumn column, boolean topOnly)
    {
        Rectangle loc = _whereIs.get(column);
        g.drawRect(loc.x, loc.y, loc.width, loc.height);
        int y = loc.y;
        if (column.size() > 0)
        {
            if (topOnly)
            {
                Card card = column.peekTop();
                if (card != dragCard)
                {
                    //... Draw only non-dragged card.
                    card.setPosition(loc.x, y);
                    card.draw(g);
                }
            } else {
                //... Draw all cards.
                for (Card card : column)
                {
                    if (card != dragCard)
                    {
                        //... Draw only non-dragged card.
                        card.setPosition(loc.x, y);
                        card.draw(g);
                        y += TABLEAU_INCR_Y;
                    }
                }
            }
        }
    }
    //============================================================= mousePressed
    public void mousePressed(MouseEvent e)
    {
        int x = e.getX();   // Save the x coord of the click
        int y = e.getY();   // Save the y coord of the click

        //... Find card image this is in.  Check top of every column.
        dragCard = null;  // Assume not in any image.
        for (CardColumn column : game)
        {
            if (column.isRemovable() && column.size() > 0)
            {
                Card testCard = column.peekTop();
                if (testCard.isInside(x, y))
                {
                    _dragFromX = x - testCard.getRow();  // how far from left
                    _dragFromY = y - testCard.getColumn();  // how far from top
                    dragCard = testCard;  // Remember what we're dragging.
                    _draggedFromPile = column;
                    break;   // Stop when we find the first match.
                }
            }
        }
    }
    //============================================================= stateChanged
    // Implementing ChangeListener means we had to define this.
    // Because we added ourselves as a change listener in the model,
    // This method will be called whenever anything changes in the model.
    // All we have to do is repaint.
    public void stateChanged(ChangeEvent e)
    {
        _clearDrag();     // Perhaps not needed, but just making sure.
        this.repaint();
    }

    //============================================================= mouseDragged
    /** Set x,y to mouse position and repaint. */
    public void mouseDragged(MouseEvent e)
    {
        if (dragCard == null)
        {
            return;  // Non-null if pressed inside card image.
        }
        int newX;
        int newY;

        newX = e.getX() - _dragFromX;
        newY = e.getY() - _dragFromY;

        //... Don't move the image off the screen sides
        newX = Math.max(newX, 0);
        newX = Math.min(newX, getWidth() - Card.CARD_WIDTH);

        //... Don't move the image off top or bottom
        newY = Math.max(newY, 0);
        newY = Math.min(newY, getHeight() - Card.CARD_HEIGHT);

        dragCard.setPosition(newX, newY);

        this.repaint();  // Repaint because position changed.
    }
    //============================================================ mouseReleased
    public void mouseReleased(MouseEvent e)
    {
        //... Check to see if something was being dragged.
        if (_draggedFromPile != null)
        {
            int x = e.getX();
            int y = e.getY();
            CardColumn targetPile = _findPileAt(x, y);
            if (targetPile != null)
            {
                //... Move card.  This may not move if illegal.
                game.columnToColumn(_draggedFromPile, targetPile);
            }
            _clearDrag();
            this.repaint();
        }
    }
    //=============================================================== _clearDrag
    // After mouse button is released, clear the drag info, otherwise
    // paintComponent will still try to display a dragged card.
    private void _clearDrag()
    {
        dragCard = null;
        _draggedFromPile = null;
    }
    //============================================================== _findPileAt
    private CardColumn _findPileAt(int x, int y)
    {
        for (CardColumn column : game)
        {
            Rectangle loc = _whereIs.get(column);
            if (loc.contains(x, y))
            {
                return column;
            }
        }

        return null;   // Not found.
    }
    //=============================================== Ignore other mouse events.
    public void mouseMoved  (MouseEvent e) {}   // ignore these events
    public void mouseEntered(MouseEvent e) {}   // ignore these events
    public void mouseClicked(MouseEvent e) {}   // ignore these events
    public void mouseExited(MouseEvent e) { ; }
}