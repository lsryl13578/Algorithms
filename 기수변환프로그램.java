// 입력받은 10진수를 2진수~36진수로 기수 변환하여 출력하는 프로그램

import java.util.Scanner;

public class 기수변환프로그램 {

    static int cardConv(int x, int r, char[] d) {
        // 정숫값 x를 r진수로 변환하여 배열 d에 아랫자리부터 넣어 두고 자릿수를 반환한다.
        int digits = 0;
        String dchar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        // r로 나눈 나머지를 저장한다.
        do {
            d[digits++] = dchar.charAt(x % r);
            x /= r;
        } while (x != 0);

        // 배열 d의 숫자 문자열을 역순으로 정렬한다.
        for (int i = 0; i < digits / 2; i++) {
            char t = d[i];
            d[i] = d[digits - i - 1];
            d[digits - i - 1] = t;
        }

        return digits;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in); 
        int no;                                 // 변환하는 정수
        int cd;                                 // 기수
        int dno;                                // 변환 후의 자릿수
        int retry;                              // 다시 한번 할지말지 입력하는 용도로 사용하는 정수형 인수
        char[] cno = new char[32];              // 변환 후 각 자리의 숫자를 넣어 두는 문자 배열

        System.out.println("10진수를 기수 변환합니다.");
        do {
            do {
                System.out.print("변환하는 음이 아닌 정수: ");
                no = stdIn.nextInt();
            } while (no < 0);

            do {
                System.out.print("어떤 진수로 변환할까요? (2~36): ");
                cd = stdIn.nextInt();
            } while (cd < 2 || cd > 36);

            dno = cardConv(no, cd, cno); // no를 cd진수로 변환한다.

            System.out.print(cd + "진수로 ");

            // 순서대로 출력한다.
            for (int i = 0; i < dno; i++) {
                System.out.print(cno[i]);
            }
            System.out.println("입니다.");

            System.out.print("한 번 더 할까요? (1..예/0..아니요): ");
            retry = stdIn.nextInt();
        } while (retry == 1);
    }
}
