import java.util.Scanner;

public class 블랙잭: 2798 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);  // 표준 입력 객체 생성

        int countNum = scan.nextInt();  // 카드(숫자) 개수 입력
        int maxNum = scan.nextInt();    // 넘지 말아야 할 최대 합 입력
        int max = 0;                    // 최대 합을 저장할 현수

        int[] arr = new int[countNum];  // 입력받은 숫자를 저장할 배열

        // 카드 숫자 입력
        for (int i = 0; i < countNum; i++) {
            arr[i] = scan.nextInt();
        }

        // 서로 다른 3개의 숫자를 선택하는 모든 경우 탐색
        for (int i = 0; i < countNum; i++) {
            for (int j = i + 1; j < countNum; j++) {
                for (int k = j + 1; k < countNum; k++) {
                    int sum = arr[i] + arr[j] + arr[k]; // 선택한 3개의 합 계산

                    // 최댓값을 넘지 않으면서 가장 큰 합 갱신
                    if (sum <= maxNum && sum > max) {
                        max = sum;
                    }
                }
            }
        }

        System.out.println(max);    // 조건을 만족하는 최대 합 출력
    }
}
