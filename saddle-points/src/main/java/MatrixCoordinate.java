class MatrixCoordinate {
    private final int row;
    private final int col;
    
    MatrixCoordinate(final int row, final int col) {
        this.row = row;
        this.col = col;
    }

    public int row() {
        return this.row;
    }

    public int col() {
        return this.col;
    }

    // Generated equals and hashcode.
  
    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final MatrixCoordinate that = (MatrixCoordinate) o;
        return this.row == that.row && this.col == that.col;
    }

    @Override
    public int hashCode() {
        int result = row;
        result = 31 * result + col;
        return result;
    }
}
