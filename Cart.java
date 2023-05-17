package proj3;
import java.util.ArrayList;
import java.util.List;

public class Cart {
    private String owner;
    private List<Item> items;

    public Cart(String owner) {
        this.owner = owner;
        this.items = new ArrayList<>();
    }

    public String getOwner() {
        return owner;
    }

    public List<Item> getItems() {
        return items;
    }

    public void addItem(Item item) {
        boolean itemExists = false;

        for (Item cartItem : items) {
            if (cartItem.getName().equals(item.getName())) {
                // 아이템이 이미 장바구니에 존재하는 경우
                int newQuantity = cartItem.getQuantity() + item.getQuantity();
                cartItem.setQuantity(newQuantity);
                itemExists = true;
                break;
            }
        }

        if (!itemExists) {
            // 아이템이 장바구니에 존재하지 않는 경우
            items.add(item);
        }
    }


    public void removeItem(Item item) {
        items.remove(item);
    }

    public void updateItemQuantity(Item item, int newQuantity) {
        item.setQuantity(newQuantity);
    }

    public void emptyCart() {
        items.clear();
    }

    public void printItems() {
        System.out.println("=== 장바구니 아이템 ===");
        for (Item item : items) {
            System.out.println("제품명: " + item.getName());
            System.out.println("수량: " + item.getQuantity());
            System.out.println("가격: " + item.getPrice());
            System.out.println("======================");
        }
    }
}
