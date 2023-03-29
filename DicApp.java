package week4;

import java.util.Scanner;

class Dictionary {
    private String[] korWords; // 한글 단어 배열
    private String[] engWords; // 영어 단어 배열

    public Dictionary(int size) {
        korWords = new String[size];
        engWords = new String[size];
    }

    public void addWord(int index, String korWord, String engWord) {
        korWords[index] = korWord;
        engWords[index] = engWord;
    }

    public String findWord(String korWord) {
        for (int i = 0; i < korWords.length; i++) {
            if (korWords[i].equals(korWord)) { // 입력한 한글 단어와 일치하는 인덱스의 영어 단어를 반환
                return engWords[i];
            }
        }

        return "찾을 수 없습니다.";
    }
}

class DicApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Dictionary dictionary = new Dictionary(5); // 5개의 단어 쌍을 저장하는 Dictionary 객체 생성

        // 한글 단어와 영어 단어 쌍을 추가
        dictionary.addWord(0, "사과", "apple");
        dictionary.addWord(1, "바나나", "banana");
        dictionary.addWord(2, "포도", "grape");
        dictionary.addWord(3, "딸기", "strawberry");
        dictionary.addWord(4, "오렌지", "orange");

        while (true) {
            System.out.print("한글 단어 입력 >> ");
            String korWord = scanner.next();

            if (korWord.equals("그만")) { // "그만"을 입력하면 프로그램 종료
                break;
            }

            String engWord = dictionary.findWord(korWord); // 한글 단어에 대응하는 영어 단어 검색
            System.out.println(korWord + "은(는) " + engWord + "입니다.");
        }

        scanner.close();
        System.out.println("프로그램 종료");
    }
}
