
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
    public Deck frontDeck;
    public String name;

    /**
     * Constructor for objects of class Player
     */
    public Player(String _name, Deck _deck)
    {
        deck = _deck;
        frontDeck = new Deck();
        name = _name;
    }
    
    public void dealToFrontDeck(){
        frontDeck.addCardToDeck(deck.dealCardFromDeck());
    }
    
    public void collect(Deck loserPile){
        for(int i = 0; i < frontDeck.getDeckSize(); i++){
            deck.addCardToDeck(frontDeck.getCardAt(i));
        }
        frontDeck.clearDeck();
        for(int i = 0; i < loserPile.getDeckSize(); i++){
            deck.addCardToDeck(loserPile.getCardAt(i));
        }
        
    }
}
