package GA;

import GA.shapes.Paper;
import GA.shapes.Rock;
import GA.shapes.Scissors;
import GA.shapes.Shape;

import java.util.Random;

public class ComputerPlayer extends Player {
    public ComputerPlayer() {
        super();
    }

    public static Shape selectFigure(String input) {
        Random rnd = new Random();
        int random = rnd.nextInt(3);
        System.out.println(random);
        if (random == 0) {
            return new Rock();
        } else if (random == 1) {
            return new Paper();
        } else if (random == 2) {
            return new Scissors();
        } else {
            throw new IllegalStateException("Unexpected value: " + input);
        }
    }
}
