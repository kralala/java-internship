package base;

import java.util.UUID;

public interface Item {

    public UUID getId();

    public String getName();

    public long getPrice();

    public void setName(String name);

    public void setPrice(long price);

}
