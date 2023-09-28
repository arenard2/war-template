
/**
 * War game class
 *
 * @author Mr. Jaffe
 * @version 2022-10-19
 */
public class War
{
    private Player a;
    private Player b;
    /**
     * Constructor for the game
     * Include your initialization here -- card decks, shuffling, etc
     * Run the event loop after you've done the initializations
     */
    public War()
    {
        // Initializations here...
        Deck deck = new Deck();
        deck.initializeNewDeck();
        deck.shuffle();
        Deck[] halves = deck.dealDeck();
        
        a = new Player("a", halves[0]);
        b = new Player("b", halves[1]);
        
        // ...then run the event loop
        this.runEventLoop();
    }
    
    /**
     * This is the game's event loop. The code in here should come
     * from the War flowchart you created for this game
     */
    public void runEventLoop() {
        for(int i = 0; i < 300; i++){
            this.a.dealToFrontDeck();
            this.b.dealToFrontDeck();
            
            if(this.a.getLastCardRankInFrontDeck() > this.b.getLastCardRankInFrontDeck()){
                
            } else if(this.a.getLastCardRankInFrontDeck() < this.b.getLastCardRankInFrontDeck()){
                
            } else {
                String tied = tie();
                if(tied == "a"){
                    System.out.println("Player b won!");
                    break;
                }else if(tied == "a"){
                    System.out.println("Player a won!");
                    break;
                } else if(tied == "ab"){
                    System.out.println("Tie!.");
                    break;
                }
            }
        }
    }
    
    //returns a if a lost, b if b lost, ab if both lost, n to continue
    public String tie(){
        if(!(this.a.getAmountOfCards() > 3) && !(this.b.getAmountOfCards() > 3)){
            return "ab";
        } else if(!(this.a.getAmountOfCards() > 3)){
            return "a";
        } else if(!(this.a.getAmountOfCards() > 3)){
            return "b";
        }
        
        for(int j = 0; j < 3; j++){
            this.a.dealToFrontDeck();
            this.b.dealToFrontDeck();
        }
            
        if(this.a.getLastCardRankInFrontDeck() > this.b.getLastCardRankInFrontDeck()){
                
        } else if(this.a.getLastCardRankInFrontDeck() < this.b.getLastCardRankInFrontDeck()){
                
        } else {
            return tie();
        }
        return "n";
    }
    
    /**
     * The main method is called when Java starts your program
     */
    public static void main(String[] args) {
        War war = new War();
    }

}
