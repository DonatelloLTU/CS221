/**
 * Tableau extends CardColumn to create 4 tableaus, loose coupling
 * @author dvasauskas
 * @version 2020-12-01.01
 */
public class Tableau extends CardColumn
{
    @Override
    public boolean addingThisCard(Card card)
    {
        if ((this.size() == 0) ||
                (this.peek().getValue().ordinal() - 1 == card.getValue().ordinal() && this.peek().getSuit().getColor() != card.getSuit().getColor())) {
            return true;
        }
        return false;
    }
}
