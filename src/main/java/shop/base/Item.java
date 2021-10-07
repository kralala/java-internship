package shop.base;

import shop.implementations.item.ItemParameters;

import java.util.UUID;

public interface Item {

    UUID getId();

    ItemParameters getParameters();

}
