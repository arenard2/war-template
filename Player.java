
/**
 * Write a description of class Player here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Player
{
    // instance variables - replace the example below with your own
    private Deck deck;
    private Deck warDeck;
    private Deck frontDeck;
    private String name;

    /**
     * Constructor for objects of class Player
     */
    public Player(String _name, Deck _deck)
    {
        this.deck = _deck;
        this.frontDeck = new Deck();
        this.warDeck = new Deck();
        this.name = _name;
    }
    
    public void dealToFrontDeck(){
        this.frontDeck.addCardToDeck(deck.dealCardFromDeck());
    }
    
    public void dealToWarDeck(){
        this.warDeck.addCardToDeck(deck.dealCardToWarDeck());
    }
    
    public void collect(Deck loserPile){
        for(int i = 0; i < frontDeck.getDeckSize(); i++){
            this.deck.addCardToDeck(frontDeck.getCardAt(i));
        }
        this.frontDeck.clearDeck();
        for(int i = 0; i < loserPile.getDeckSize(); i++){
            this.deck.addCardToDeck(loserPile.getCardAt(i));
        }
        
    }
    
    public void clearFrontDeck(){
        this.frontDeck.clearDeck();
    }
    
    public void clearWarDeck(){
        this.warDeck.clearDeck();
    }
    
    public Deck getFrontDeck(){
        return this.frontDeck;
    }
    
    public int getLastCardRankInFrontDeck(){
        return this.frontDeck.getLastCard().getRank();
    }
    
    public String getLastCardFaceInFrontDeck(){
        return this.frontDeck.getLastCard().getFace();
    }
    public String getLastCardSuitInFrontDeck(){
        return this.frontDeck.getLastCard().getSuit();
    }
    
    public int getAmountOfCards(){
        return this.deck.getDeckSize();
    }
    
    public void printWarDeck(){
        for(int i = 0; i < this.warDeck.getDeckSize(); i++){
            System.out.println(warDeck.getCardAt(i).getFace() + " of " + warDeck.getCardAt(i).getSuit());
        }
    }
}
