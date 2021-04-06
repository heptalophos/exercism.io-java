class GridPosition {

    final int x;

    final int y;

    GridPosition(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    GridPosition change(Orientation orientation) {
        int x = this.x;
        int y = this.y;
        switch (orientation) {
            case NORTH : y += 1; break;
            case EAST :  x += 1; break;
            case SOUTH : y -= 1; break;
            case WEST :  x -= 1; break;
        }
        return new GridPosition(x, y);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + x;
        result = prime * result + y;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            return false;
        } else if (x != ((GridPosition) obj).x || y != ((GridPosition) obj).y) {
            return false;
        } else {
            return true;
        }
    }
}
