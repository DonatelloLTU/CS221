public class Freecell extends CardColumn{

    @Override public boolean rulesForAddingCard(Card card)
    {
        return size() == 0;
    }
}
