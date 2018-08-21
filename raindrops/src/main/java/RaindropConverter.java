public class RaindropConverter {

    public static String convert(int number) {
        StringBuilder drops = new StringBuilder() ;
        drops.append(number % 3 == 0 ? "Pling" : "");
        drops.append(number % 5 == 0 ? "Plang" : "");
        drops.append(number % 7 == 0 ? "Plong" : "");
        drops = drops.length() == 0 ? drops.append(number) : drops;
        return drops.toString();
    }

}
