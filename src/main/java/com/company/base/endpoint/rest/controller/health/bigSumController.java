import java.math.BigInteger;
import java.util.Map;

public class bigSumController {

    @GetMapping("/big-sum")

    public static String getBigSum(Map<String, String> queryParams) {
        try {
            String numbera = queryParams.get("a");
            String numberb = queryParams.get("b");

            if (numbera == null || numberb == null) {
                return "Les paramètres 'a' et 'b' sont requis.";
            }

            BigInteger a = new BigInteger(numbera);
            BigInteger b = new BigInteger(numberb);

            BigInteger result = a.add(b);

            return result.toString();
        } catch (NumberFormatException e) {
            return "Erreur: 'a' ou 'b' non valides.";
        }
    }
    public static void main(String[] args) {
        Map<String, String> queryParams = Map.of("a", "1000000000000000000000", "b", "2");
        String result = getBigSum(queryParams);
        System.out.println(result);
    }
}
