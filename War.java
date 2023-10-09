
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
        int i = 0;
        while(i < 300){
            this.a.dealToFrontDeck();
            this.b.dealToFrontDeck();
            
            System.out.println("Player A: " + this.a.getLastCardFaceInFrontDeck() + " of " + this.a.getLastCardSuitInFrontDeck());
            System.out.println("Player B: " + this.b.getLastCardFaceInFrontDeck() + " of " + this.b.getLastCardSuitInFrontDeck());
            
            if(this.a.getLastCardRankInFrontDeck() > this.b.getLastCardRankInFrontDeck()){
                this.a.collect(this.b.getFrontDeck());
                this.b.clearFrontDeck();
                System.out.println("Player A gets Cards.");
            } else if(this.a.getLastCardRankInFrontDeck() < this.b.getLastCardRankInFrontDeck()){
                this.b.collect(this.a.getFrontDeck());
                this.a.clearFrontDeck();
                System.out.println("Player B gets Cards.");
            } else {
                System.out.println("");
                String tied = tie();
                if(tied == "a"){
                    System.out.println("Player B won!");
                    break;
                }else if(tied == "b"){
                    System.out.println("Player A won!");
                    break;
                } else if(tied == "ab"){
                    System.out.println("Tie!");
                    break;
                }
            }
            
            if(this.a.getAmountOfCards() == 0){
                System.out.println("Player B wins!");
                break;
            } else if(this.b.getAmountOfCards() == 0){
                System.out.println("Player A wins!");
                break;
            }
            i++;
            System.out.println("");
        }
        if(i == 300){
            System.out.println("Tie, reached 300 iterations.");
        }
    }
    
    //returns a if a lost, b if b lost, ab if both lost, n to continue
    public String tie(){
        System.out.println("War:");
        if(this.a.getAmountOfCards() < 3 && this.b.getAmountOfCards() < 3){
            return "ab";
        } else if(this.a.getAmountOfCards() < 3){
            return "a";
        } else if(this.b.getAmountOfCards() < 3){
            return "b";
        }
        
        for(int j = 0; j < 3; j++){
            this.a.dealToWarDeck();
            this.b.dealToWarDeck();
            this.a.dealToFrontDeck();
            this.b.dealToFrontDeck();
        }
        
        System.out.println("Player A: " + this.a.getLastCardFaceInFrontDeck() + " of " + this.a.getLastCardSuitInFrontDeck());
        System.out.println("Player B: " + this.b.getLastCardFaceInFrontDeck() + " of " + this.b.getLastCardSuitInFrontDeck());
        
        if(this.a.getLastCardRankInFrontDeck() > this.b.getLastCardRankInFrontDeck()){
            this.a.collect(this.b.getFrontDeck());
            this.b.clearFrontDeck();
            System.out.println("Player A gets Cards:");
            this.a.printWarDeck();
            this.b.printWarDeck();
            System.out.println("");
            this.a.clearWarDeck();
            this.b.clearWarDeck();
        } else if(this.a.getLastCardRankInFrontDeck() < this.b.getLastCardRankInFrontDeck()){
            this.b.collect(this.a.getFrontDeck());
            this.a.clearFrontDeck();
            System.out.println("Player B gets Cards:");
            this.b.printWarDeck();
            this.a.printWarDeck();
            System.out.println("");
            this.a.clearWarDeck();
            this.b.clearWarDeck();
        } else {
            System.out.println("");
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
