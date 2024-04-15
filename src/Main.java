import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int n = scanner.nextInt();

    int[] stairs = new int[n+1];
    for (int i = 1; i <= n; i++) {
      stairs[i] = scanner.nextInt();
    }

    // DP를 위한 배열 초기화
    int[] dp = new int[n+1];

    dp[1] = stairs[1];
    if (n > 1) {
      dp[2] = stairs[1] + stairs[2];
    }

    // DP 실행
    for (int i = 3; i <= n; i++) {
      // 이전 계단을 밟지 않고 현재 계단에 도달한 경우와
      // 이전 계단을 밟고 현재 계단에 도달한 경우를 비교
      dp[i] = Math.max(dp[i-2] + stairs[i], dp[i-3] + stairs[i-1] + stairs[i]);
    }

    // 최대 점수 출력
    System.out.println(dp[n]);

    scanner.close();
  }
}
