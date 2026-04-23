
public class Card {
	private String power;
	private int movement;
	private int cashNet;
	private boolean goToJail;
	
	public Card(String power, int location, int cashNet, boolean goToJail, boolean goToGo, boolean leaveJail) {
		this.power = power;
		this.movement = movement;
		this.cashNet = cashNet;
		this.goToJail = goToJail;
	}
	public String getPower() {
		return power;
	}
	public int getMovement() {
		return movement;
	}
	public int getCashNet() {
		return cashNet;
	}
	public boolean getGoToJail() {
		return goToJail;
	}
	public boolean goToGo() {
		return goToJail;
	}
}
