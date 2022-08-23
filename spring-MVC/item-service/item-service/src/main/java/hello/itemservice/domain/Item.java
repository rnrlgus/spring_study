package hello.itemservice.domain;


import lombok.Data;

@Data // getter, setter
public class Item {

    private Long id;
    private String itemName;
    private Integer price;
    private Integer qunatity;

    public Item() {
    }

    public Item(String itemName, Integer price, Integer qunatity) {
        this.itemName = itemName;
        this.price = price;
        this.qunatity = qunatity;
    }
}
