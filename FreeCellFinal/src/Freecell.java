/**
 * Class Freecell extends CarColumn and uses adding card method , loose coupling
 * @author dvasauskas
 * @version 2020-12-01.01
 */
public class Freecell extends CardColumn{

    @Override public boolean addingCard(Card card)
    {
        return size() < 1;
    }
}
