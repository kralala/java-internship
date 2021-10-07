package shop.implementations.item;

import shop.base.Item;

import java.time.LocalDate;
import java.util.UUID;

public class Berry extends StoreItem {

    private UUID id;
    private ItemParameters parameters;
    private LocalDate harvested;

    public Berry(BerryParameters parameters) {
        super(parameters);
        this.harvested = parameters.getHarvested();
    }

    public LocalDate getHarvested() {
        return harvested;
    }

    @Override
    public String toString() {
        return String.valueOf(super.toString()
                + "Harvested on: " + harvested.toString() + ".\n");
    }
}
