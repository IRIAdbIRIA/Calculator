import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CalculatorTests {
    @Test
    public void incorrectNameTest() throws IOException {

        String data = "gdfgdfgdf\n";
        InputStream testInput = new ByteArrayInputStream( data.getBytes() );
        System.setIn( testInput );

        CalculatorForTests calculator = new CalculatorForTests();
        double result = CalculatorForTests.main(null);

        Assert.assertEquals(1,result,0);
    }

    @Test
    public void negativeAmountTest() throws IOException {

        String data = "USD\n" + "-100";
        InputStream testInput = new ByteArrayInputStream( data.getBytes() );
        System.setIn( testInput );

        CalculatorForTests calculator = new CalculatorForTests();
        double result = CalculatorForTests.main(null);

        Assert.assertEquals(2,result,0);
    }

    @Test
    public void cantCastAmountToDoubleTest() throws IOException {

        String data = "USD\n" + "gsdfgdfsgdfs";
        InputStream testInput = new ByteArrayInputStream( data.getBytes() );
        System.setIn( testInput );

        CalculatorForTests calculator = new CalculatorForTests();
        double result = CalculatorForTests.main(null);

        Assert.assertEquals(3,result,0);
    }

    @Test
    public void USDTest() throws IOException {

        String data = "USD\n" + "100";
        InputStream testInput = new ByteArrayInputStream( data.getBytes() );
        System.setIn( testInput );

        CalculatorForTests calculator = new CalculatorForTests();
        double result = CalculatorForTests.main(null);

        Assert.assertEquals(101.98,result,0);
    }

    @Test
    public void parseTestDoesItWorkOk1(){
        Parser parser = new Parser(new File("eurofxref-daily.xml"));
        List<Currency> currencies = parser.parse();
        Assert.assertEquals("USD",currencies.get(0).getName());
    }

    @Test
    public void parseTestDoesItWorkOk2(){
        Parser parser = new Parser(new File("eurofxref-daily.xml"));
        List<Currency> currencies = parser.parse();
        Assert.assertEquals(1.0198,currencies.get(0).getThisToEur(),0);
    }

    @Test
    public void parseTest2(){
        Parser parser = new Parser(new File("eurofxref-daily.xml"));
        List<Currency> currencies = parser.parse();
        Assert.assertEquals(currencies.size(),31);
    }

    @Test
    public void parseTest3(){
        Parser parser = new Parser(new File("eurofxref-daily.xml"));
        List<Currency> currencies = parser.parse();
        List<Currency> currencies1 = new ArrayList<>();
        currencies1.add(currencies.get(0));
        boolean result = true;
        for (int i = 1;i < currencies.size();i++){
            if (!currencies1.contains(currencies.get(i))){
                currencies1.add(currencies.get(i));
            }
        }
        Assert.assertEquals(31,currencies1.size());
    }
}
