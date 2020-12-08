public class Foundation extends CardColumn{

    @Override
    public boolean rulesForAddingCard(Card card)
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
