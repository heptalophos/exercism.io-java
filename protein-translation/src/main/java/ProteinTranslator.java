import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ProteinTranslator {
    private static HashMap<String, String> proteins = new HashMap<>();

    static {
        Arrays.asList(new String[] {"AUG"})
              .forEach(codon -> proteins.put(codon, "Methionine"));
        Arrays.asList(new String[] {"UGG"})
              .forEach(codon -> proteins.put(codon, "Tryptophan"));
        Arrays.asList(new String[] {"UUU", "UUC"})
              .forEach(codon -> proteins.put(codon, "Phenylalanine"));
        Arrays.asList(new String[] {"UUA", "UUG"})
              .forEach(codon -> proteins.put(codon, "Leucine"));
        Arrays.asList(new String[] {"UCU", "UCC", "UCG", "UCA"})
              .forEach(codon -> proteins.put(codon, "Serine"));
        Arrays.asList(new String[] {"UAU", "UAC"})
              .forEach(codon -> proteins.put(codon, "Tyrosine"));
        Arrays.asList(new String[] {"UGU", "UGC"})
              .forEach(codon -> proteins.put(codon, "Cysteine"));
        Arrays.asList(new String[] {"UAA", "UAG", "UGA"})
              .forEach(codon -> proteins.put(codon, "STOP"));
    }

    public List<String> translate(final String rna) {
        if (rna.isEmpty())
            return List.of();
        final List<String> proteinList = new ArrayList<>();
        for (int i = 0; i < rna.length(); i += 3) {
            String thisCodon = rna.substring(i, i + 3);
            if (rna.length() % 3 != 0 && !(rna.contains("UAA") || 
                rna.contains("UAG") ||rna.contains("UGA"))) {
                throw new IllegalArgumentException("Invalid codon");
            }
            if (proteins.containsKey(thisCodon)) {
                if (proteins.get(rna.substring(i, i + 3)).equals("STOP"))
                    return proteinList;
                proteinList.add(proteins.get(rna.substring(i, i + 3)));
            } 
            else {
                throw new IllegalArgumentException("Invalid codon");
            }
            if (proteinList.contains(null))
                throw new IllegalArgumentException("Invalid codon");
        }
        return proteinList;
    }
}