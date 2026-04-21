import java.util.ArrayList;

public class Board {

    ArrayList<Space> board;

    public void initializeBoard() {
    board = new ArrayList<Space>();
    board.add(new Space("Go", null, "GO"));
    board.add(new Space("Mediterranean Avenue", "Brown", "PROPERTY"));
    board.add(new Space("Community Chest", null, "COMMUNITY_CHEST"));
    board.add(new Space("Baltic Avenue", "Brown", "PROPERTY"));
    board.add(new Space("Income Tax", null, "TAX"));
    board.add(new Space("Reading Railroad", null, "RAILROAD"));
    board.add(new Space("Oriental Avenue", "Light Blue", "PROPERTY"));
    board.add(new Space("Chance", null, "CHANCE"));
    board.add(new Space("Vermont Avenue", "Light Blue", "PROPERTY"));
    board.add(new Space("Connecticut Avenue", "Light Blue", "PROPERTY"));
    board.add(new Space("Jail", null, "JAIL"));
    board.add(new Space("St. Charles Place", "Pink", "PROPERTY"));
    board.add(new Space("Electric Company", null, "UTILITY"));
    board.add(new Space("States Avenue", "Pink", "PROPERTY"));
    board.add(new Space("Virginia Avenue", "Pink", "PROPERTY"));
    board.add(new Space("Pennsylvania Railroad", null, "RAILROAD"));
    board.add(new Space("St. James Place", "Orange", "PROPERTY"));
    board.add(new Space("Community Chest", null, "COMMUNITY_CHEST"));
    board.add(new Space("Tennessee Avenue", "Orange", "PROPERTY"));
    board.add(new Space("New York Avenue", "Orange", "PROPERTY"));
    board.add(new Space("Free Parking", null, "FREE_PARKING"));
    board.add(new Space("Kentucky Avenue", "Red", "PROPERTY"));
    board.add(new Space("Chance", null, "CHANCE"));
    board.add(new Space("Indiana Avenue", "Red", "PROPERTY"));
    board.add(new Space("Illinois Avenue", "Red", "PROPERTY"));
    board.add(new Space("B&O Railroad", null, "RAILROAD"));
    board.add(new Space("Atlantic Avenue", "Yellow", "PROPERTY"));
    board.add(new Space("Ventnor Avenue", "Yellow", "PROPERTY"));
    board.add(new Space("Water Works", null, "UTILITY"));
    board.add(new Space("Marvin Gardens", "Yellow", "PROPERTY"));
    board.add(new Space("Go To Jail", null, "GO_TO_JAIL"));
    board.add(new Space("Pacific Avenue", "Green", "PROPERTY"));
    board.add(new Space("North Carolina Avenue", "Green", "PROPERTY"));
    board.add(new Space("Community Chest", null, "COMMUNITY_CHEST"));
    board.add(new Space("Pennsylvania Avenue", "Green", "PROPERTY"));
    board.add(new Space("Short Line Railroad", null, "RAILROAD"));
    board.add(new Space("Chance", null, "CHANCE"));
    board.add(new Space("Park Place", "Dark Blue", "PROPERTY"));
    board.add(new Space("Luxury Tax", null, "TAX"));
    board.add(new Space("Boardwalk", "Dark Blue", "PROPERTY"));

    }
}
