/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Ahren
 */
public class Player
{
    private String piece;
    private int location;
    private int cash; // not implemented
    private int jailCount;
    private int jailBreak;
    private boolean strat; // false = A, true = B
    private Dice dice;
    private int turnCount;
    
    public Player(String piece, int location, int cash, int jailCount, int jailBreak, boolean strat)
    {
        this.piece      = piece;
        this.location   = location;
        this.cash       = cash;
        this.jailCount  = jailCount;
        this.jailBreak  = jailBreak;
        this.strat      = strat;
        dice = new Dice();
    }
    
    /**
     * Roll dice, update internal location, increment turn count
     * @return int[] {dice total, isDouble 1 or 0}   
     */
    public int[] roll()
    {
        dice.roll();
        if (location + dice.getTotal() < 40)
            location += dice.getTotal();
        
        else
            location = dice.getTotal() - (39 - location); 
        
        turnCount++;
        
        return new int[] {dice.getTotal(), dice.isDouble() ? 1 : 0};
    }
    
    /**
     * get board location
     * @return boardLocation 
     */
    public int getLocation()
    {
        return location;
    }
    
    /**
     * 
     * set location to @param newLocation 
     * will throw an IllegalArgumentException if newLocation < 0 || newLocation > 39
     */
    public void setLocation(int newLocation) throws IllegalArgumentException
    {   
        if (location < 0 || location > 39)
            throw new IllegalArgumentException("Illegal location value " + newLocation);
        
        location = newLocation;
    }
    
    /**
     * add payment to cash total
     * @param payment 
     */
    public void addCash(int payment)
    {
        cash += payment;
    }
    
    /**
     * remove payment from cash total
     * if balance would go negative throws an exception
     * @param payment 
     */
    public void subtractCash(int payment) throws IllegalArgumentException
    {
        if( cash - payment < 0)
            throw new IllegalArgumentException("too broke");
        
        cash -= payment;
    }
    
    /**
     * returns this players balance
     * @return balance
     */
    public int getCash()
    {
        return cash;
    }
    
    /**
     * 
     * @return piece 
     */
    public String getPiece()
    {
        return piece;
    }
    
    /**
     * get the double count for this player
     * @return 
     */
    public int getJailCount()
    {
        return jailCount;
    }
    
    /**
     * set the double count for this player
     * @param newCount 
     */
    public void setJailCount(int newCount)
    {
        jailCount = newCount;
    }
    
    /**
     * get the count of get out of jail free cards
     * @return jailBreak
     */
    public int getJailBreak()
    {
        return jailBreak;
    }
    
    /**
     * "give" the player another get out of that free card
     */
    public void addJailBreak()
    {
        jailBreak++;
    }
    
    /**
     * send the player to jail (space 9)
     */
    public void sendToJail()
    {
        location = 9;
    }
    
    /**
     * send the player to go (space 0)
     */
    public void sendToGo()
    {
        location = 0;
    }
    
    /**
     * play jail according to the strat this player is initialised with.
     * strat = true means the player will ALWAYS roll for doubles
     * strat = false means the player will ALWAYS either pay to leave jail or use a get out of jail free card if available
     * @return numTurns     return the number of turns spent in jail, DOES NOT do the roll after leaving jail to determine where to move to.
     */
    public int playJail()
    {
        int numTurns = 0;
        
        if(strat) // if true play for doubles
        {
            int i = 0;
            //dice.roll();
            while (numTurns < 3)
            {
                dice.roll();
                i++;
                
                System.out.println("Player.playJail: new roll numTurns = " + numTurns);
                    
                
                if(dice.isDouble())
                {
                    numTurns++;
                    System.out.println("Player.playJail: returning numTurns = " + numTurns);
                    turnCount += numTurns;
                    return numTurns;
                }
                if (i%3 == 0)
                {
                    numTurns++;
                    i = 0;
                }
                
            }
            turnCount += numTurns;
            System.out.println("Player.playJail: returning numTurns = " + numTurns);      
            return numTurns;
        }
        
        else // if not true don't
        {
            if(jailBreak > 0)
                jailBreak--;
            
            numTurns = 1;
            
            turnCount += numTurns;
            System.out.println("Player.playJail: returning numTurns = " + numTurns);
            return numTurns;
        }
        
       
        
    }
    
    /**
     * 
     * example output
     * | Piece | Location | Last Roll | Jail Break |\n"
     * |  car  |    30    |  1    3   |     2      |"
     * 
     */
    @Override
    public String toString()
    {
        return String.format("| Piece | Location | Last Roll | Jail Break |\n"
                +            "| %5s | %8d | %4d %4d | %10d |", piece, location, dice.getDice1(), dice.getDice2(), jailBreak);
    } 
    
    public int getTurnCount()
    {
        return turnCount;
    }
    
    public void resetTurnCount()
    {
        turnCount = 0;
    }
}
