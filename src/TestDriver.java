public class TestDriver {
    static int doublesCounter = 0;
    static int currentSpace;
    static int turnCounter = 0;
    static int currentturnsWastedinJail;
    static int getOutOfJailFreeCards = 0;
    static int[] currentDiceRoll;
    static Board board = new Board();
    static Deck deck = new Deck();

    public static void spaceMovementAndAction(Player player1) {
        currentSpace = player1.getLocation();
        System.out.println("Player 1 is now on space " + board.getSpace(currentSpace).getName());
        board.getSpace(currentSpace).incrementVisitCount();

        // Community Chest Card logic
        if (board.getSpace(currentSpace).getType().equals("COMMUNITY_CHEST")) {
            Card drawnCommunityCard = deck.drawCommunityCard();
            System.out.println("Player 1 drew a Community Chest Card. " + "Its a " + drawnCommunityCard.getPower());

            if (drawnCommunityCard.goToGo() == true) {
                System.out.println("Player 1 has been sent to Go.");
                player1.setLocation(0);
                spaceMovementAndAction(player1);

            } else if (drawnCommunityCard.getGoToJail() == true) {
                System.out.println("Player 1 has been sent to Jail.");
                player1.sendToJail();
                currentturnsWastedinJail = player1.playJail();
                turnCounter = currentturnsWastedinJail + turnCounter;
                System.out.print("Player 1 is now out of jail after " + currentturnsWastedinJail + " turns. They get to roll again.");
                rollDice(player1);

            } else if (drawnCommunityCard.getLeaveJail() == true) {
                System.out.println("Player 1 has drawn a Get Out of Jail Free Card.");
                player1.addJailBreak();
            }
        // Chance Card logic
        } else if (board.getSpace(currentSpace).getType().equals("CHANCE")) {
            Card drawnChanceCard = deck.drawChanceCard();
            System.out.println("Player 1 drew a Chance Card. " + "Its a " + drawnChanceCard.getPower());
            
            if (drawnChanceCard.goToGo() == true) {
                System.out.println("Player 1 has been sent to Go.");
                player1.setLocation(0);
                spaceMovementAndAction(player1);

            } else if (drawnChanceCard.getGoToJail() == true) {
                System.out.println("Player 1 has been sent to Jail.");
                player1.sendToJail();
                currentturnsWastedinJail = player1.playJail();
                turnCounter = currentturnsWastedinJail + turnCounter;
                System.out.print("Player 1 is now out of jail after " + currentturnsWastedinJail + " turns. They get to roll again.");
                rollDice(player1);

            } else if (drawnChanceCard.getLeaveJail() == true) {
                System.out.println("Player 1 has drawn a Get Out of Jail Free Card.");
                player1.addJailBreak();

            } else if (drawnChanceCard.getLocation() == -3) {
                player1.setLocation(player1.getLocation() - 3);
                System.out.println("Player 1 has been sent to " + board.getSpace(player1.getLocation()).getName() + ".");
                spaceMovementAndAction(player1);
            
            } else if (drawnChanceCard.getLocation() > 0) {
                System.out.println("Player 1 has been sent to " + board.getSpace(drawnChanceCard.getLocation()).getName() + ".");
                player1.setLocation(drawnChanceCard.getLocation());
                spaceMovementAndAction(player1);

            } else if (drawnChanceCard.getPower().equals("Advance to Nearest Railroad")) {
                if (player1.getLocation() < 5) {
                    player1.setLocation(5);
                } else if (player1.getLocation() < 15) {
                    player1.setLocation(15);
                } else if (player1.getLocation() < 25) {
                    player1.setLocation(25);
                } else if (player1.getLocation() < 35) {
                    player1.setLocation(35);
                } else {
                    player1.setLocation(5);
                }
                System.out.println("Player 1 has been sent to " + board.getSpace(player1.getLocation()).getName() + ".");
                spaceMovementAndAction(player1);

            } else if (drawnChanceCard.getPower().equals("Advance to Nearest Utility")) {
                if (player1.getLocation() < 12) {
                    player1.setLocation(12);
                } else if (player1.getLocation() < 28) {
                    player1.setLocation(28);
                } else {
                    player1.setLocation(12);
                }
                System.out.println("Player 1 has been sent to " + board.getSpace(player1.getLocation()).getName() + ".");
                spaceMovementAndAction(player1);
            }

        } else if (board.getSpace(currentSpace).getType().equals("GO_TO_JAIL")) {
            System.out.println("Player 1 has been sent to Jail.");
            player1.sendToJail();
            currentturnsWastedinJail = player1.playJail();
            turnCounter = currentturnsWastedinJail + turnCounter;
            System.out.println("Player 1 is now out of jail after " + currentturnsWastedinJail + " turns. They get to roll again.");
            rollDice(player1);
        }
    }

    public static void rollDice(Player player1) {
        // Roll the dice
        currentDiceRoll = player1.roll();
        System.out.println("Player 1 rolled a " + currentDiceRoll[0] + ".");
        if (currentDiceRoll[1] == 0) {
            spaceMovementAndAction(player1);
            return;
        } else {
            spaceMovementAndAction(player1);
        }

        // Keeps rolling if doubles until jail or continue. 
        do {
            if (currentDiceRoll[1] == 1) {
                doublesCounter++;
                if (doublesCounter == 3) {
                    System.out.println("Player 1 rolled doubles three times in a row and went to Jail.");
                    doublesCounter = 0;
                    player1.sendToJail();
                    currentturnsWastedinJail = player1.playJail();
                    turnCounter = currentturnsWastedinJail + turnCounter;
                    System.out.println("Player 1 is now out of jail after " + currentturnsWastedinJail + " turns. They get to roll again.");
                    currentDiceRoll = player1.roll();
                    System.out.println("Player 1 rolled a " + currentDiceRoll[0] + ".");
                    spaceMovementAndAction(player1);
                    continue;
                } else {
                    System.out.println("Player 1 rolled doubles! Roll again.");
                    currentDiceRoll = player1.roll();
                    System.out.println("Player 1 rolled a " + currentDiceRoll[0] + ".");
                    spaceMovementAndAction(player1);

                }
            }
        } while (currentDiceRoll[1] == 1);
    }

    public static void main(String[] args) {

    // Create Player
        Player player1 = new Player("Player 1", 0, 0, 0, 0, true);
    
    // Simulate x turns for player 1
        while (turnCounter < 10) {
        doublesCounter = 0;
        rollDice(player1);
    
        // Print end of rond counter
        System.out.println();
        turnCounter++;
        System.out.println("Round " + turnCounter + " is now over.");
        System.out.println();
        System.out.println();
        }

        int totalVisits = 0;
        for (int i = 0; i < 40; i++) {
            System.out.println(board.getSpace(i).getName() + " was landed on " + board.getSpace(i).getVisitCount() + " times.");
            totalVisits += board.getSpace(i).getVisitCount();
        }
        System.out.println();
        System.out.println("Total visits: " + totalVisits);
    
    }
    
}
