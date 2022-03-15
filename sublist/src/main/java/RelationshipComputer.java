import java.util.List;
import java.util.Collections;

class RelationshipComputer<T> {

    public Relationship computeRelationship(List<T> a, List<T> b) {
        if (a.size() == b.size())
            if (Collections.indexOfSubList(a, b) == 0) 
                return Relationship.EQUAL;
        if (a.size() > b.size())
            if (Collections.indexOfSubList(a, b) >= 0) 
                return Relationship.SUPERLIST;
        if (a.size() < b.size())
            if (Collections.indexOfSubList(b, a) >= 0) 
                return Relationship.SUBLIST;
        return Relationship.UNEQUAL;
    }
}
