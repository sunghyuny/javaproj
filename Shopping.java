package proj3;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Shopping {
    private List<Cart> carts;

    public Shopping() {
        this.carts = new ArrayList<>();
    }

    public void shoppingMenu() {
        System.out.println("=== 쇼핑 관련 메뉴 ===");
        System.out.println("1. 카트 임대");
        System.out.println("2. 카트 반납");
        System.out.println("3. 쇼핑 종료");
    }

    public void cartMenu(Cart cart) {
        System.out.println("=== 카트 관련 메뉴 ===");
        System.out.println("1. 카트에 상품 추가");
        System.out.println("2. 카트에 상품 수량 추가");
        System.out.println("3. 카트 상품 제거");
        System.out.println("4. 카트 상품 출력");
        System.out.println("5. 카트 관련 동작 종료");

        cartAction(cart);
    }

    public void cartAction(Cart cart) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("동작을 선택하세요: ");
            String userInput = scanner.nextLine();

            switch (userInput) {
                case "1":
                    System.out.print("추가할 상품명을 입력하세요: ");
                    String itemName = scanner.nextLine();
                    System.out.print("수량을 입력하세요: ");
                    int quantity = Integer.parseInt(scanner.nextLine());
                    System.out.print("가격을 입력하세요: ");
                    int price = Integer.parseInt(scanner.nextLine());
                    Item item = new Item(itemName, quantity, price);
                    cart.addItem(item);
                    break;
                case "2":
                    System.out.print("추가할 상품명을 입력하세요: ");
                    String existingItemName = scanner.nextLine();
                    System.out.print("추가할 수량을 입력하세요: ");
                    int additionalQuantity = Integer.parseInt(scanner.nextLine());
                    for (Item existingItem : cart.getItems()) {
                        if (existingItem.getName().equals(existingItemName)) {
                            int newQuantity = existingItem.getQuantity() + additionalQuantity;
                            existingItem.setQuantity(newQuantity);
                            System.out.println("상품 수량이 업데이트되었습니다.");
                            break;
                        }
                    }
                    break;
                case "3":
                    System.out.print("제거할 상품명을 입력하세요: ");
                    String itemToRemove = scanner.nextLine();
                    for (Item cartItem : cart.getItems()) {
                        if (cartItem.getName().equals(itemToRemove)) {
                            cart.removeItem(cartItem);
                            System.out.println("상품이 제거되었습니다.");
                            break;
                        }
                    }
                    break;
                case "4":
                    cart.printItems();
                    break;
                case "5":
                    return;  // 동작 종료
                default:
                    System.out.println("올바른 동작을 선택하세요.");
                    break;
            }

            // 카트 메뉴로 이동
            cartMenu(cart);
        }
    }

    public void rentCart() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("(임대)사용자 이름 입력: ");
        String owner = scanner.nextLine();
        Cart cart = new Cart(owner);
        carts.add(cart);
        System.out.println("카트가 임대되었습니다.");
        cartMenu(cart);
    }

    public void returnCart() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("반납할 카트 소유자 이름을 입력하세요: ");
        String owner = scanner.nextLine();

        Cart cartToRemove = null;
        for (Cart cart : carts) {
            if (cart.getOwner().equals(owner)) {
                cartToRemove = cart;
                break;
            }
        }

        if (cartToRemove != null) {
            carts.remove(cartToRemove);
            System.out.println("카트가 반납되었습니다.");
        } else {
            System.out.println("해당 소유자의 카트를 찾을 수 없습니다.");
        }
    }

    public void stopShopping() {
    	System.exit(0);
    }
    public void shoppingProgram() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            shoppingMenu();
            System.out.print("메뉴를 선택하세요: ");
            String userInput = scanner.nextLine();

            switch (userInput) {
                case "1":
                    rentCart();
                    break;
                case "2":
                    returnCart();
                    break;
                case "3":
                	stopShopping();
                default:
                	System.out.println("올바른 메뉴를 선택해주세요");
                	break;
            }
        }
    }

    public static void main(String[] args) {
        Shopping shopping = new Shopping();
        shopping.shoppingProgram();
    }
}
