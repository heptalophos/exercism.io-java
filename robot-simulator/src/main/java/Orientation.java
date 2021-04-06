enum Orientation {

    NORTH, EAST, SOUTH, WEST;

    Orientation clockwise() {
        switch (this) {
            case NORTH : return EAST;
            case EAST  : return SOUTH;
            case SOUTH : return WEST; 
            case WEST  : return NORTH;
        }
        return this;
    }

    Orientation counterClockwise() {
        switch (this) {
            case NORTH : return WEST;
            case WEST  : return SOUTH;
            case SOUTH : return EAST; 
            case EAST  : return NORTH;
        }
        return this;
    }
}
