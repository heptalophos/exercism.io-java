public class MatrixCoordinate implements Comparable<MatrixCoordinate> {
    private final int row;
    private final int col;

    MatrixCoordinate(final int row, final int col) {
        this.row = row - 1;
        this.col = col - 1;
    }
  
    public int row() {
        return this.row;
    }
  
    public int col() {
        return this.col;
    }

    @Override
    public String toString() {
        return "Row: " + row() + ", Column: " + col();
    }
  
  // Generated equals and hashcode.
    @Override
        public boolean equals(final Object o) {
            if (this == o) 
                return true;
            if (o == null || this.getClass() != o.getClass()) 
                return false;
            final MatrixCoordinate that = (MatrixCoordinate) o;
            return this.row() == that.row() && this.col() == that.col();
  }
  
    @Override
    public int hashCode() {
        int result = row();
        result = 31 * result + col();
        return result;
    }

    @Override
        public int compareTo(MatrixCoordinate that) {
            int rowComparison = Integer.compare(this.row(), that.row());
            return  (rowComparison == 0) 
                    ? Integer.compare(this.col(), that.col()) 
                    : rowComparison;
    }
}
