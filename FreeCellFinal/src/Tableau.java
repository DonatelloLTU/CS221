public class Tableau extends CardColumn
{
    @Override
    public boolean rulesAllowAddingThisCard(Card card)
    {
        if ((this.size() == 0) ||
                (this.peekTop().getValue().ordinal() - 1 == card.getValue().ordinal() && this.peekTop().getSuit().getColor() != card.getSuit().getColor())) {
            return true;
        }
        return false;
    }
}
