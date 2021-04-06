public class Robot {

    private GridPosition position;
    private Orientation orientation;

    public Robot(GridPosition position, Orientation orientation) {
        this.position = position;
        this.orientation = orientation;
    }

    public Orientation getOrientation() {
        return this.orientation;
    }

    public GridPosition getGridPosition() {
        return this.position;
    }

    public void turnRight() {
        orientation = orientation.minusHalfPi();
    }

    public void turnLeft() {
        orientation = orientation.plusHalfPi();
    }

    public void advance() {
        position = position.change(orientation); 
    }

    public void simulate(String commands) {
        for (char c: commands.toCharArray()) {
            switch (c) {
                case 'R' : 
                    turnRight();
                    break;
                case 'L' :
                    turnLeft();
                    break;
                case 'A' : 
                    advance();
                    break;
                default : throw 
                    new IllegalArgumentException(
                        "unknown command"
                    );
            }
        }
    }
} 
