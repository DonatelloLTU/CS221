/**
 * Class foundation extends card column
 * @author dvasauskas
 * @version 2020-12-01.01
 */
public class Foundation extends CardColumn{

    /**
     * Overide mehtod from CardColumn loose coupling.
     * @param card
     * @return
     */
    @Override
    public boolean addingCard(Card card)
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
    @Override public boolean isRemovable()
    {
        return false;
    }
}
