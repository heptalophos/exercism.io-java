public class MatrixCoordinate implements Comparable<MatrixCoordinate> {

    private final int row;
    private final int col;

    MatrixCoordinate(final int row, final int col) {
        this.row = row - 1;
        this.col = col - 1;
    }

    // Modified MatrixCoordinate, 
    // define public getters for row and col
    
    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    @Override
    public String toString() {
        return "Row: " + getRow() + ", Column: " + getCol();
    }

    // Generated equals and hashcode.

    @Override
    public boolean equals(final Object o) {
        if (this == o) 
            return true;
        
            if (o == null || getClass() != o.getClass()) 
            return false;

        final MatrixCoordinate that = 
            (MatrixCoordinate) o;

        return getRow() == that.getRow() 
            && getCol() == that.getCol();
    }

    @Override
    public int hashCode() {
        int result = getRow();
        result = 31 * result + getCol();
        return result;
    }

    @Override
    public int compareTo(MatrixCoordinate o) {
        int rowComparison = 
            Integer.compare(getRow(), o.getRow());
        return (rowComparison == 0) ? 
               Integer.compare(getCol(), o.getCol()) : 
               rowComparison;
    }
}
