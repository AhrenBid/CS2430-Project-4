
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Provides functionality for community and chance decks
 * @author Andrew
 **/
public class Deck {
	Random rand = new Random();
	 ArrayList<Card> community;
	 ArrayList<Card> chance;
	 private Player player;
	 
	 /**
	  * Deck constructor
	  * @param player
	  */
	 public Deck() {
		 	this.player = player;

	        community = new ArrayList<>();

	        chance = new ArrayList<>();

	        initializeCommunityDeck();

	        initializeChanceDeck();
	        

	    }
	 /**
	  * Initializes AND SHUFFLES the community deck
	  * @author Andrew
	  */
	 //(String power, int location, int cashNet, boolean goToJail, boolean goToGo, boolean leaveJail)
	 public void initializeCommunityDeck() {
		 Card goToGo = new Card("Advance to Go", 0, 200, false, true, false);
		 Card bankErrorGood = new Card("Bank Error Positive", 0, 200, false, false, false);
		 Card doctorFee = new Card("Doctor Fee", 0, -50, false, false, false);
		 Card sellStock = new Card("Sell Stock", 0, 50, false, false, false);
		 Card getOutOfJail = new Card("Get Out Of Jail Free", 0, 0, false, false, true);
		 Card goToJail = new Card("Go To Jail", 0, 0, true, false, false);
		 Card grandOpera = new Card("Collect $50 from each", 0, 0, false, false, false);
		 Card holiday = new Card("Collect $100", 0, 100, false, false, false);
		 Card taxRefund = new Card("Collect $20", 0, 0, false, false, false);
		 Card birthday = new Card("Collect $10 from each player", 0, 0, false, false, false);
		 Card lifeInsurance = new Card("Collect $100", 0, 0, false, false, false);
		 Card hospitalFee = new Card("Pay $50", 0, 50, false, false, false);
		 Card schoolFee = new Card("Pay $50", 0, 0, false, false, false);
		 Card consultancyProfit = new Card("Collect $25", 0, 0, false, false, false);
		 Card repair = new Card("Pay $40 per house and $115 per hotel", 0, 0, false, false, false);
		 Card beautyContest = new Card("Collect $10", 0, 0, false, false, false);
		 Card inherit = new Card("Collect $100", 0, 0, false, false, false);
		
		 community.add(holiday);
		 community.add(taxRefund);
		 community.add(birthday);
		 community.add(lifeInsurance);
		 community.add(hospitalFee);
		 community.add(schoolFee);
		 community.add(consultancyProfit);
		 community.add(repair);
		 community.add(beautyContest);
		 community.add(inherit);
		 
		 Collections.shuffle(community);
	
	 }
	 /**
	  * Initializes AND SHUFFLES the chance deck
	  * @author Andrew
	  */
	// (String power, int location, int cashNet, boolean goToJail, boolean goToGo, boolean leaveJail)
	 public void initializeChanceDeck() {

	     Card advanceToGo = new Card("Advance to Go", 0, 200, false, true, false);
	     Card advanceToIllinois = new Card("Advance to Illinois Ave", 24, 0, false, false, false);
	     Card advanceToStCharles = new Card("Advance to St. Charles Place", 11, 0, false, false, false);
	     Card nearestUtility = new Card("Advance to Nearest Utility", 0, 0, false, false, false);
	     Card nearestRailroad = new Card("Advance to Nearest Railroad", 0, 0, false, false, false);
	     Card dividend = new Card("Bank pays you dividend of $50", 0, 50, false, false, false);
	     Card getOutOfJail = new Card("Get Out Of Jail Free", 0, 0, false, false, true);
	     Card goBackThree = new Card("Go Back 3 Spaces", -3, 0, false, false, false);
	     Card goToJail = new Card("Go To Jail", 0, 0, true, false, false);
	     Card repairs = new Card("Make general repairs on all your property", 0, 0, false, false, false);
	     Card poorTax = new Card("Pay Poor Tax of $15", 0, -15, false, false, false);
	     Card readingRailroad = new Card("Take a trip to Reading Railroad", 5, 0, false, false, false);
	     Card boardwalk = new Card("Take a walk on Boardwalk", 39, 0, false, false, false);
	     Card chairman = new Card("You have been elected chairman, pay each player $50", 0, -50, false, false, false);
	     Card buildingLoan = new Card("Your building loan matures, collect $150", 0, 150, false, false, false);
	     Card crossword = new Card("You have won a crossword competition, collect $100", 0, 100, false, false, false);
	     
	     chance.add(advanceToGo);
	     chance.add(advanceToIllinois);
	     chance.add(advanceToStCharles);
	     chance.add(nearestUtility);
	     chance.add(nearestRailroad);
	     chance.add(dividend);
	     chance.add(getOutOfJail);
	     chance.add(goBackThree);
	     chance.add(goToJail);
	     chance.add(repairs);
	     chance.add(poorTax);
	     chance.add(readingRailroad);
	     chance.add(boardwalk);
	     chance.add(chairman);
	     chance.add(buildingLoan);
	     chance.add(crossword);
	     
	     Collections.shuffle(chance);
	     

	 }
	 
	 /**
	  * Draws from community and shuffles if empty
	  * @return choice (card drawn)
	  */
	 public Card drawCommunityCard() {
		 if (!community.isEmpty()) {
			 Card choice = community.remove(0);
			 return choice; 
		 } 
		 else {
			 initializeCommunityDeck();
			 Card choice = community.remove(0);
			 return choice;
		 }
	 }
	 /**
	  * Draws from chance and shuffles if empty
	  * @return choice (card drawn)
	  */
	 public Card drawChanceCard() {
		 if (!chance.isEmpty()) {
			 Card choice = chance.remove(0);
			 return choice; 
		 } 
		 else {
			 initializeChanceDeck();
			 Card choice = chance.remove(0);
			 return choice;
		 }
	 }
	 
	 /**
	  * 
	  * @return community
	  */
	 
	 public ArrayList<Card> returnCommunity() {
		 return community;
		 }
	 /**
	  * 
	  * @return chance
	  */
	 public ArrayList<Card> returnChance() {
		 return chance;
	 }
}
