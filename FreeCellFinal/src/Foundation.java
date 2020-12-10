/**
 * Class foundation extends card column
 * @author dvasauskas
 * @version 2020-12-01.01
 */
public class Foundation extends CardColumn{

    /**
     * Overide mehtod from CardColumn loose coupling.
     * @param card move card to foundation starting ace and up
     * @return
     */
    @Override
    public boolean addingThisCard(Card card)
    {
        if((this.size() == 0) && (card.getValue() == Value.ACE))
        {
            return true;
        }

        if(size() > 0)
        {
            Card top = peek();
            if ((top.getSuit() == card.getSuit() && (top.getValue().ordinal() + 1 == card.getValue().ordinal())))
            {
                return true;
            }
        }
        return false;
    }
    /*
    Can't remove the card from Foundation
     */
    @Override
    public boolean isRemovable()
    {
        return false;
    }
}
