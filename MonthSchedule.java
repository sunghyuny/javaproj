package week4;
import java.util.Scanner;

public class MonthSchedule {
    private Day[] days; // Day 타입의 객체 배열

    public MonthSchedule(int numOfDays) {
        days = new Day[numOfDays]; // numOfDays만큼 Day 객체 배열 생성
        for (int i = 0; i < numOfDays; i++) {
            days[i] = new Day(); // Day 객체 초기화
        }
    }

    public void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("날짜(1~" + days.length + ")? ");
        int day = scanner.nextInt();
        System.out.print("할 일(빈칸 없이 입력)? ");
        String schedule = scanner.next();

        if (day < 1 || day > days.length) {
            System.out.println("잘못된 입력입니다.");
            return;
        }

        days[day - 1].setSchedule(schedule); // 해당 일자의 Day 객체에 스케줄 저장
    }

    public void view() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("날짜(1~" + days.length + ")? ");
        int day = scanner.nextInt();

        if (day < 1 || day > days.length) {
            System.out.println("잘못된 입력입니다.");
            return;
        }

        System.out.println((day) + "일의 할 일은 " + days[day - 1].getSchedule() + "입니다.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("days 입력: ");
        int numOfDays = scanner.nextInt();

        MonthSchedule schedule = new MonthSchedule(numOfDays); // MonthSchedule 객체 생성

        int choice = 0;
        while (true) {
            System.out.print("할 일(입력:1, 보기:2, 끝내기:3) >> ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    schedule.input();
                    break;
                case 2:
                    schedule.view();
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

class Day {
    private String schedule;

    public Day() {
        schedule = "";
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getSchedule() {
        return schedule;
    }



	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
