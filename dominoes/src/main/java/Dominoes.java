import java.util.ArrayList;
import java.util.List;

public class Dominoes {

    private final String NOT_FOUND = "No domino chain found.";

    public List<Domino> formChain(List<Domino> dominoes) throws ChainNotFoundException 
    {
        if (dominoes.isEmpty()) return new ArrayList<>();
        List<Domino> chain = new ArrayList<>();
        chain.add(dominoes.get(0));
        findChain(chain, new ArrayList<>(dominoes.subList(1, dominoes.size())));
        return chain;
    }

    private void findChain(List<Domino> chain, List<Domino> dominoes) throws ChainNotFoundException 
    {
        List<Domino> candidates = candidates(chain.get(chain.size() - 1)
                                                  .getRight(), dominoes);
        for (Domino candidate : candidates) {
            dominoes.remove(candidate);
            chain.add(candidate);
            try {
                findChain(chain, dominoes);
                break;
            } catch (Exception e) {
                chain.remove(chain.size() - 1);
                dominoes.add(candidate);
            }
        }
        if (chain.get(0).getLeft() != chain.get(chain.size() - 1).getRight()
            || !dominoes.isEmpty())
            throw new ChainNotFoundException(NOT_FOUND);            
    }
    private List<Domino> candidates(int target, List<Domino> dominoes) 
    {
        List<Domino> candidates = new ArrayList<>();
        for (Domino candidate : dominoes) {
            if (candidate.getLeft() == target) 
                candidates.add(candidate);
            else if (candidate.getRight() == target) {
                candidate = candidate.getReversed();
                candidates.add(candidate);
            }
            else 
                continue;
        }
        return candidates;
    }
}

