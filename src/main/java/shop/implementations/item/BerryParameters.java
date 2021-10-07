package shop.implementations.item;

import shop.base.Item;

import java.time.LocalDate;
import java.util.UUID;

public enum BerryParameters implements ItemParameters {

    CLOUDBERRY("Cloudberry", 290,
            LocalDate.of(2020, 8, 12)),
    COWBERRY("Cowberry",170,
            LocalDate.of(2020,9,15)),
    CRANBERRY("Cranberry",135,
            LocalDate.of(2020,9,23)),
    SEA_BUCKTHORN("Sea Buckthorn",190,
            LocalDate.of(2020,8,7));

    private String name;
    private int price;
    private LocalDate harvested;

    BerryParameters(String name, int price, LocalDate harvested) {
        this.name = name;
        this.price = price;
        this.harvested = harvested;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getPrice() {
        return price;
    }

    public LocalDate getHarvested() {
        return harvested;
    }
}
