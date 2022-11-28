import java.util.Objects;

class Domino {
    private int left;
    private int right;
    
    Domino(int left, int right) {
        this.left = left;
        this.right = right;
    }
    
    int getLeft() {
    	return this.left;
    }
    
    int getRight() {
    	return this.right;
    }

    Domino reversed() {
        return new Domino(right, left);
    }
    
    @Override
    public boolean equals(Object o) {
        Domino that = (Domino) o;
        return ( this.getLeft() == that.getLeft() && 
                 this.getRight() == that.getRight() ) ||
               ( this.getLeft() == that.getRight() && 
                 this.getRight() == that.getLeft() );
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }

    @Override
	public String toString() {
        return "[" + this.getLeft() + "|" + this.getRight() + "]";
	}
}
