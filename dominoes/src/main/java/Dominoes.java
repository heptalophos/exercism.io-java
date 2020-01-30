import java.util.ArrayList;
import java.util.List;


public class Dominoes {

    public List<Domino> formChain(List<Domino> dominoes) 
                        throws ChainNotFoundException {
        if (dominoes.isEmpty()) 
            return new ArrayList<>();
        List<Domino> chain = new ArrayList<>();
        chain.add(dominoes.get(0));
        findChain(chain, 
                  new ArrayList<>(dominoes.subList(1, dominoes.size())));
        return chain;
    }

    private void findChain(List<Domino> chain, List<Domino> dominoes) 
                 throws ChainNotFoundException {
        List<Domino> candidates = 
            candidates(chain.get(chain.size() - 1).getRight(), dominoes);
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
            throw new ChainNotFoundException("No domino chain found.");            
    }

    private List<Domino> candidates(int target, List<Domino> dominoes) {
        List<Domino> candidates = new ArrayList<>();
        for (Domino candidate : dominoes) {
            if (candidate.getLeft() == target) 
                candidates.add(candidate);
            else if (candidate.getRight() == target) 
                candidates.add(candidate.reversed());
            else 
                continue;
        }
        return candidates;
    }
}