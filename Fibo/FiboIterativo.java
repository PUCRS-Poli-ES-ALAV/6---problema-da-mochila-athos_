public class FiboIterativo {
    public static long fibo(int n) {
        if (n <= 1) {
            return n;
        }
        
        long[] f = new long[n + 1];
        f[0] = 0;
        f[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        
        return f[n];
    }

    public static void testar() {
        int[] valores = {4, 8, 16, 32, 128, 1000, 10000};
        System.out.println("Testando FIBO:");
        
        for (int n : valores) {
            long inicio = System.nanoTime();
            long resultado = fibo(n);
            long fim = System.nanoTime();
            double tempo = (fim - inicio) / 1_000_000.0;
            
            System.out.printf("fib(%d) = %d (tempo: %.3f ms)%n", n, resultado, tempo);
        }
        System.out.println();
    }
}