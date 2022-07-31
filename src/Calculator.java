import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;


public class Calculator {

    public static void main(String[] args) throws IOException {

        Parser parser = new Parser(new File("eurofxref-daily.xml"));
        List<Currency> currencies = parser.parse();
        System.out.println("Print ESC eny time to exit");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true){

            System.out.println("Print currency name");
            String name = reader.readLine();
            if (name.equals("ESC")){
                break;
            }
            if (!checkName(name,currencies)){
                System.out.println("Incorrect currency name");
                continue;
            }

            System.out.println("Print EUR amount");
            String currencyAmount = reader.readLine();
            if (currencyAmount.equals("ESC")){
                break;
            }
            double amount;
            try {
                amount = Double.parseDouble(currencyAmount);
                if(amount < 0){
                    System.out.println("Incorrect currency amount");
                    continue;
                }
            }catch (NumberFormatException e){
                System.out.println("Incorrect currency amount");
                continue;
            }

            for (Currency currency : currencies) {
                if (name.equals(currency.getName())) {
                    System.out.println(amount * currency.getThisToEur());
                }
            }
        }
    }

    private static boolean checkName(String name, List<Currency> currencies){

        for (Currency currency : currencies) {
            if (name.equals(currency.getName())) {
                return true;
            }
        }
        return false;
    }
}
