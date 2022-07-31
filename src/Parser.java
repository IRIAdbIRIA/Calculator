import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.util.List;

class Parser {

    File fileToParse;

    Parser(File fileToParse){

        this.fileToParse = fileToParse;
    }

    List<Currency> parse(){

        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            Handler handler = new Handler();
            saxParser.parse(fileToParse, handler);
            return handler.getCurrencies();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
