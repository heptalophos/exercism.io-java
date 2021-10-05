public class RnaTranscription {
    
    public String transcribe(String dnaStrand) {
        
        StringBuilder rna = new StringBuilder();

        for (char c : dnaStrand.toCharArray()) {
            switch (c) {
                case 'A': rna.append('U'); break;
                case 'G': rna.append('C'); break;
                case 'C': rna.append('G'); break;
                case 'T': rna.append('A'); break;
            }
        }
        return rna.toString();
    }
}