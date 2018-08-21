public class RaindropConverter {

    public static String convert(int number) {

        String drops = "";

        drops += number % 3 == 0 ? "Pling" : "";
        drops += number % 5 == 0 ? "Plang" : ""; 
        drops += number % 7 == 0 ? "Plong" : "";  

        drops = drops.equals("") ? Integer.toString(number) : drops;
        
        return drops;
    }

}
