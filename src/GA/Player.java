package GA;

import java.util.ArrayList;
import java.util.List;

public abstract class Player {
    private int points;
    private List<String> moves;
    private String name;


    public Player() {
        this.name = "player";
        this.points = 0;
        this.moves = new ArrayList<String>();
    }

    // Setters and getters


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public List<String> getMoves() {
        return moves;
    }

    public void setMoves(String move) {
        this.moves.add(move);
    }
}
