public class 분수찾기프로그램 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int x = Integer.parseInt(br.readLine());

        int count = 1; // 대각선 분수 개수
        int hap = 0; // 이전 대각선까지의 분수 개수 총합

        // x번째 분수가 몇 번째 대각선에 있는지 찾기 위해 계속 대각선을 하나씩 늘려가는 과정
        while(true) {
            if (x <= count + hap) { // x번째 분수가 현재 대각선 안에 있는지에 대해 검사
                if (count % 2 == 1) { // 대각선 번호가 홀수인 경우
                    System.out.println(count - (x - hap - 1) + "/" + (x - hap)); // 분수가 위 -> 아래 방향으로 증가
                    break;
                } else { // 대각선 번호가 짝수인 경우
                    System.out.println((x - hap) + "/" + (count - (x - hap - 1))); // 분수가 아래 -> 위 방향으로 증가
                    break;
                }
            } else { // 아직 해당 대각선이 아닐 때의 조건문
                hap += count; // 이전 분수 개수 누적
                count++; // 다음 대각선으로 이
            }
        }
    }
}
