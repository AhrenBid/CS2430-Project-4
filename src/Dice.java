/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.Random;
/**
 *
 * @author Ahren
 */
public class Dice
{
    
    private int dice1;
    private int dice2;
    private boolean isDouble;
    private Random rand;
    
    public Dice()
    {
        dice1 = 0;
        dice2 = 0;
        rand = new Random();
    }
    
    public void roll()
    {
        dice1 = rand.nextInt(5) + 1;
        dice2 = rand.nextInt(5) + 1;
        isDouble = dice1 == dice2;
    }
    
    public int getDice1()
    {
        return dice1;
    }
    
    public int getDice2()
    {
        return dice2;
    }
    
    public int getTotal()
    {
        return dice1 + dice2;
    }
    
    public boolean isDouble()
    {
        return isDouble;
    }
        
    
    
}
