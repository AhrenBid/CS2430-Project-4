/**
* Group 2
* Zachary Butterfield, Andrew Clarkson, Ahren Bidlingmaier
* CS2430-002
* Project 4: Capstone
* @author Zachary Butterfield
*/
public class Space {
    private String name;
    private String color;
    private String type;
    private Player owner;
    private int visitCount;

    public Space(String name, String color, String type) {
        this.name = name;
        this.color = color;
        this.visitCount = 0; // Upon creation the visit count is at 0
        this.type = type;
    }

    public void incrementVisitCount() {
        visitCount++;
    }

    public void action(Player player) {

    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public Player getOwner() {
        return owner;
    }

    public String getType() {
        return type;
    }

    public int getVisitCount() {
        return visitCount;
    }
        
}
