
/**
 * Write a description of class Player here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Player
{
    // instance variables - replace the example below with your own
    public Deck deck;
    public Deck winPile;
    public Deck frontDeck;
    public String name;

    /**
     * Constructor for objects of class Player
     */
    public Player(String _name, Deck _deck)
    {
        deck = _deck;
        winPile = new Deck();
        frontDeck = new Deck();
        name = _name;
    }
}
