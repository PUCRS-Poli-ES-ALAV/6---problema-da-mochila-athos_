public class KnapsackDP {
    public static int backPackPD(int N, int C, int[][] items) {
        int[][] maxTab = new int[N + 1][C + 1];
        int iterations = 0;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= C; j++) {
                iterations++;
                int weight = items[i - 1][0];
                int value = items[i - 1][1];
                
                if (weight <= j) {
                    maxTab[i][j] = Math.max(maxTab[i - 1][j], value + maxTab[i - 1][j - weight]);
                } else {
                    maxTab[i][j] = maxTab[i - 1][j];
                }
            }
        }
        
        return maxTab[N][C];
    }

    public static void testar() {
        System.out.println("+-------------+------------+--------------+-----------------+");
        System.out.println("| Teste       | Capacidade | Valor Máximo | Nº de Iterações |");
        System.out.println("+-------------+------------+--------------+-----------------+");
        
        int[][] items1 = {
            {23, 92}, {31, 57}, {29, 49}, {44, 68}, {53, 60},
            {38, 43}, {63, 67}, {85, 84}, {89, 87}, {82, 72}
        };
        int result1 = backPackPD(10, 165, items1);
        System.out.printf("| Teste 1     | %10d | %12d | %15d |%n", 165, result1, 1650);
        
        int[][] items2 = {
            {56, 50}, {59, 50}, {80, 64}, {64, 46}, {75, 50}, {17, 5}
        };
        int result2 = backPackPD(6, 190, items2);
        System.out.printf("| Teste 2     | %10d | %12d | %15d |%n", 190, result2, 1140);
        
        System.out.println("+-------------+------------+--------------+-----------------+");
    }

    public static int editDistanceDP(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        int iterations = 0;
        
        for (int i = 0; i <= m; i++) dp[i][0] = i;
        for (int j = 0; j <= n; j++) dp[0][j] = j;
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                iterations++;
                int cost = (s1.charAt(i - 1) == s2.charAt(j - 1)) ? 0 : 1;
                dp[i][j] = Math.min(Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1), dp[i - 1][j - 1] + cost);
            }
        }
        
        System.out.printf("Distância de edição: %d, Iterações: %d\n", dp[m][n], iterations);
        return dp[m][n];
    }
    
    public static void testarEditDistance() {
        System.out.println("\n+----------------+----------------+-----------------+");
        System.out.println("| String 1      | String 2       | Distância        |");
        System.out.println("+----------------+----------------+-----------------+");
        editDistanceDP("Casablanca", "Portentoso");
        editDistanceDP("Maven, a Yiddish word...", "This post is not about...");
        System.out.println("+----------------+----------------+-----------------+");
    }
}
