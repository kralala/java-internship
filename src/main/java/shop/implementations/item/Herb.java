package shop.implementations.item;

import java.util.UUID;

public class Herb extends StoreItem {

    private UUID id;
    private ItemParameters parameters;
    private String importedFrom;

    public Herb(HerbParameters parameters) {
        super(parameters);
        this.importedFrom = parameters.getImportedFrom();
    }

    @Override
    public String toString() {
        return String.valueOf(super.toString()
                + "Imported from: " + importedFrom + ".\n");
    }
}
