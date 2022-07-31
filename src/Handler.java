import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

class Handler extends DefaultHandler {

    private final List<Currency> currencies =  new ArrayList<>();


    @Override
    public void startElement(String uri,
                             String localName, String qName, Attributes attributes) {
        if (qName.equalsIgnoreCase("Cube")) {
            try {
                currencies.add(new Currency(attributes.getValue("currency"),
                        Double.parseDouble(attributes.getValue("rate"))));
            } catch (NullPointerException ignored){}
        }
    }

    List<Currency> getCurrencies() {
        return currencies;
    }
}
