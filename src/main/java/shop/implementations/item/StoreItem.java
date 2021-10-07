package shop.implementations.item;

import shop.base.Item;

import java.util.Objects;
import java.util.UUID;

abstract public class StoreItem implements Item {

    protected UUID id;
    protected ItemParameters parameters;

    public StoreItem(ItemParameters parameters) {
        this.id = UUID.randomUUID();
        this.parameters = parameters;
    }

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public ItemParameters getParameters() { return parameters; }

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
        StoreItem item = (StoreItem) o;
        return id == item.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, parameters);
    }

    @Override
    public String toString() {
        return String.valueOf(new StringBuilder()
                .append(this.getParameters().getName() + " ")
                .append(this.getParameters().getPrice() + ". "));
    }

}
