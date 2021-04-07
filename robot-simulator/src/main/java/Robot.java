public class Robot {

    private GridPosition position;
    private Orientation direction;

    Robot(GridPosition position, Orientation orientation) {
        this.position = position;
        this.direction = orientation;
    }

    public Orientation getOrientation() {
        return this.direction;
    }

    public GridPosition getGridPosition() {
        return this.position;
    }

    public void turnRight() {
        direction = direction.minusHalfPi();
    }

    public void turnLeft() {
        direction = direction.plusHalfPi();
    }

    public void advance() {
        position = position.change(direction, 1); 
    }

    public void simulate(String commands) {
        for (char command: commands.toCharArray()) {
            switch (command) {
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
