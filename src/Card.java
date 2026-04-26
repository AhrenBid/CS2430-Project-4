package src;

/**
 * Card class to establish a card object
 * @author Andrew
 */
public class Card {
	private String power;
	private int movement;
	private int cashNet;
	private boolean goToJail;
	private boolean goToGo;
	private boolean leaveJail;
    private int location;
	
    /**
     * Constructor for Card object
     * @param power
     * @param location
     * @param cashNet
     * @param goToJail
     * @param goToGo
     * @param leaveJail
     */
	public Card(String power, int movement, int cashNet, boolean goToJail, boolean goToGo, boolean leaveJail) {
		this.power = power;
		this.movement = movement;
		this.cashNet = cashNet;
		this.goToJail = goToJail;
		this.goToGo = goToGo;
		this.leaveJail = leaveJail;
	}
	/**
	 * 
	 * @return power
	 */
	public String getPower() {
		return power;
	}
	/**
	 * 
	 * @return movement
	 */
	public int getMovement() {
		return movement;
	}
	/**
	 * 
	 * @return cashNet
	 */
	public int getCashNet() {
		return cashNet;
	}
	/**
	 * 
	 * @return goToJail
	 */
	public boolean getGoToJail() {
		return goToJail;
	}
	/**
	 * 
	 * @return goToJail
	 */
	public boolean goToGo() {
		return goToGo;
	}
	/**
	 * 
	 * @return location
	 */
    public int getLocation() {
        return location;
    }
    /**
     * 
     * @return leaveJail
     */
    public boolean getLeaveJail() {
        return leaveJail;
    }
}
