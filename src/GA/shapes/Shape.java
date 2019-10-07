package GA.shapes;
import GA.Player;

public abstract class Shape {
    public String compare(Shape shape, Player player1, Player player2) {
        String[] logic = new String[3];

        if (this.toString() == "Rock") {
            logic[0] = "Rock";
            logic[1] = "Scissors";
            logic[2] = "Paper";
        } else if (this.toString() == "Scissors") {
            logic[0] = "Scissors";
            logic[1] = "Paper";
            logic[2] = "Rock";
        } else {
            logic[0] = "Paper";
            logic[1] = "Rock";
            logic[2] = "Scissors";
        }

        if (shape.toString() == logic[0]) {
            player1.setMoves("Draw with " + this.toString());
            return "draw";
        } else if (shape.toString() == logic[1]) {
            player1.setPoints(player1.getPoints() + 1);
            player2.setPoints(player2.getPoints() - 1);
            player1.setMoves("Win with " + this.toString());
            player2.setMoves("lost with " + this.toString());
            return player1.getName() + " won, " + player2.getName() + " lost";
        } else if (shape.toString() == logic[2]) {
            player1.setPoints(player1.getPoints() - 1);
            player2.setPoints(player2.getPoints() + 1);
            player2.setMoves("Win with " + this.toString());
            player1.setMoves("lost with " + this.toString());
            return player1.getName() + " lost, congratulation " + player2.getName();
        }
        return "Something went wrong";
    }
}
