public class FiboRec {
    public static long fiboRec(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fiboRec(n - 1) + fiboRec(n - 2);
        }
    }

    public static void testar() {
        int[] valores = {4, 8, 16, 32};
        System.out.println("Testando FIBO-REC:");
        
        for (int n : valores) {
            long inicio = System.nanoTime();
            long resultado = fiboRec(n);
            long fim = System.nanoTime();
            double tempo = (fim - inicio) / 1_000_000.0;
            
            System.out.printf("fib(%d) = %d (tempo: %.3f ms)%n", n, resultado, tempo);
        }
        System.out.println();
    }
}