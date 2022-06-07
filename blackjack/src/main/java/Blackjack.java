public class Blackjack {

    private static final int BLACKJACK = 21;
    private static final String STAND  = "S";
    private static final String SPLIT  = "P";
    private static final String HIT    = "H";
    private static final String WIN    = "W";

    public int parseCard(String card) {
        int cardScore = 
            card.equalsIgnoreCase("ace")   ?  11 :
            card.equalsIgnoreCase("two")   ?  2  :
            card.equalsIgnoreCase("three") ?  3  :
            card.equalsIgnoreCase("four")  ?  4  :
            card.equalsIgnoreCase("five")  ?  5  :
            card.equalsIgnoreCase("six")   ?  6  :
            card.equalsIgnoreCase("seven") ?  7  :
            card.equalsIgnoreCase("eight") ?  8  :
            card.equalsIgnoreCase("nine")  ?  9  :
            card.equalsIgnoreCase("ten")   ?  10 :
            card.equalsIgnoreCase("jack")  ?  10 :
            card.equalsIgnoreCase("queen") ?  10 :
            card.equalsIgnoreCase("king")  ?  10 : 0;
        return cardScore;                
    }

    public boolean isBlackjack(String card1, String card2) {
        return parseCard(card1) + parseCard(card2) == BLACKJACK;
    }

    public String largeHand(boolean isBlackjack, int dealerScore) {
        return !isBlackjack     ? SPLIT : 
               dealerScore < 10 ? WIN   : STAND;
    }

    public String smallHand(int handScore, int dealerScore) {
        return handScore >= 17  ? STAND : 
               handScore <= 11  ? HIT   :
               dealerScore >= 7 ? HIT   : STAND;
    }

    public String firstTurn(String card1, String card2, String dealerCard) {
        int handScore = parseCard(card1) + parseCard(card2);
        int dealerScore = parseCard(dealerCard);
        return (20 < handScore)  
               ? largeHand(isBlackjack(card1, card2), dealerScore) 
               : smallHand(handScore, dealerScore);
    }
}
