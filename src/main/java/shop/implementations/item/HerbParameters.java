package shop.implementations.item;

import shop.base.Item;

import java.util.UUID;

public enum HerbParameters implements ItemParameters {

    LINDEN("Linden",95,"Siberia, Russia"),
    PEPPERMINT_AUS("Peppermint",105,"Gold Coast, Australia"),
    PEPPERMINT_MRC("Peppermint",90,"Marrakesh, Morocco"),
    CHAMOMILE("Chamomile",70,"Krakow, Poland"),
    CINNAMON("Cinnamon",140,"Rain Forest, Sri Lanka");

    private String name;
    private int price;
    private String importedFrom;

    HerbParameters(String name, int price, String importedFrom) {
        this.name = name;
        this.price = price;
        this.importedFrom = importedFrom;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getPrice() {
        return price;
    }

    public String getImportedFrom() {
        return importedFrom;
    }
}
