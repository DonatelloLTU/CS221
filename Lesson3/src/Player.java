/**
 * Player class responsible for creating player
 * @author Donatas Vasauskas
 * @version 2020-09-15.01
 */
public class Player
{
    String name;

    /**
     * Constructor to create player with a name
     * @param name players name as defined by string
     */
    public Player(String name)
    {
        this.name = name;
    }

    /**
     * Get name method to get players name
     * @return name, returns string for player name.
     */
    public String getName() {
        return name;
    }
}
