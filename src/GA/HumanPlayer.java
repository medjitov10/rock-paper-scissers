package GA;

import GA.shapes.Paper;
import GA.shapes.Rock;
import GA.shapes.Scissors;
import GA.shapes.Shape;

public class HumanPlayer extends Player {
    private final String name;

    public HumanPlayer(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public static Shape selectFigure(String input) {
        if (input.compareToIgnoreCase("ROCK") == 0) {
            return new Rock();
        } else if (input.compareToIgnoreCase("Paper") == 0) {
            return new Paper();
        } else if (input.compareToIgnoreCase("Scissors") == 0) {
            return new Scissors();
        } else {
            throw new IllegalStateException("Unexpected value: " + input);
        }
    }
}
