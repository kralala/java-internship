package entity;

import base.Item;

import java.util.Objects;
import java.util.UUID;

public class ItemImpl implements Item {

    private UUID id;
    private String name;
    private long price;

    public ItemImpl(String name, long price) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.price = price;
    }

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public long getPrice() {
        return price;
    }

    @Override
    public void setPrice(long price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null){
            return false;
        }
        if (this.getClass() != o.getClass()) {
            return false;
        }
        Item item = (Item) o;
        return id == item.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price);
    }

    @Override
    public String toString() {
        return String.valueOf(new StringBuilder()
        .append("Item ")
        .append(this.name + " ")
        .append(this.price + ". "));
    }
}
