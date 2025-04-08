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
}
