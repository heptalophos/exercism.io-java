import static java.lang.String.format;

public class BeerSong {

    private String premise(int bottles) {
        
        switch (bottles) {
            case 0:
                return "No more bottles of beer on the wall,"+
                       " no more bottles of beer.";
            case 1:
                return "1 bottle of beer on the wall,"+
                       " 1 bottle of beer.";
            default:
                return format(
                            "%1$d bottles of beer on the wall,"+
                            " %1$d bottles of beer.", 
                            bottles
                        );
        }
    }

    private String conclusion(int bottles) {
        
        switch (bottles) {
            case 0:
                return "Go to the store and buy some more,"+
                       " 99 bottles of beer on the wall.";
            case 1:
                return "Take it down and pass it around,"+
                       " no more bottles of beer on the wall.";
            default:
                return format(
                         "Take one down and pass it around,"+
                         " %1$d bottle%2$s of beer on the wall.", 
                         bottles - 1, bottles != 2 ? "s" : ""
                       );
        }
    }

    private String verse(int bottles) {
        
        return premise(bottles) + "\n" + 
               conclusion(bottles) + "\n\n";   
    }
    
    public String sing(int bottles, int howManyDown) {
        
        StringBuilder verses = new StringBuilder();
        
        for (int i = bottles; i > bottles - howManyDown; i--) {
            verses.append(verse(i));
        }
        
        return verses.toString();
    }

    public String singSong() {
        
        return sing(99, 100);
    }
}