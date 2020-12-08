import java.awt.*;

enum Value
{
    ACE, DEUCE, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT,
    NINE, TEN, JACK, QUEEN, KING;
}

enum Suit
{
    SPADES(Color.BLACK), HEARTS(Color.RED), CLUBS(Color.BLACK), DIAMONDS(Color.RED);
    private final Color colorCard;
    Suit(Color color)
    {
        colorCard = color;
    }
    public Color getColor()
    {
        return colorCard;
    }
}