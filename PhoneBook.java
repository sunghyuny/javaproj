package week4;
import java.util.Scanner;

public class PhoneBook {
    private Phone[] phones; // Phone 타입의 객체 배열

    public PhoneBook(int numOfPhones) {
        phones = new Phone[numOfPhones]; // numOfPhones만큼 Phone 객체 배열 생성
        for (int i = 0; i < numOfPhones; i++) {
            phones[i] = new Phone(); // Phone 객체 초기화
        }
    }

    public void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("이름: ");
        String name = scanner.next();
        System.out.print("전화번호: ");
        String number = scanner.next();

        for (int i = 0; i < phones.length; i++) {
            if (phones[i].getName().equals("")) { // 빈 객체를 찾아 이름과 전화번호 저장
                phones[i].setName(name);
                phones[i].setNumber(number);
                System.out.println("저장되었습니다.");
                return;
            }
        }

        System.out.println("저장할 수 있는 공간이 없습니다.");
    }

    public void view() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("검색할 이름: ");
        String name = scanner.next();

        for (int i = 0; i < phones.length; i++) {
            if (phones[i].getName().equals(name)) { // 이름이 일치하는 객체를 찾아 전화번호 출력
                System.out.println(phones[i].getName() + "의 전화번호는 " + phones[i].getNumber() + "입니다.");
                return;
            }
        }

        System.out.println("찾을 수 없습니다.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("사용자 수 입력: ");
        int numOfPhones = scanner.nextInt();

        PhoneBook phoneBook = new PhoneBook(numOfPhones); // PhoneBook 객체 생성

        int choice = 0;
        while (true) {
            System.out.print("검색(입력:1, 검색:2, 끝내기:3) >> ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    phoneBook.input();
                    break;
                case 2:
                    phoneBook.view();
                    break;
                case 3:
                    System.out.println("프로그램을 종료합니다.");
                    scanner.close();
                    return;
                default:
                    System.out.println("잘못된 입력입니다.");
                    break;
            }
        }
    }
}

class Phone {
    private String name;
    private String number;

    public Phone() {
        name = "";
        number = "";
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }
}
