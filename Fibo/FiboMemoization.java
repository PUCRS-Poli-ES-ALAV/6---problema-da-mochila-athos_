public class FiboMemoization {
    private static long lookupFibo(long[] f, int n) {
        if (f[n] != -1) {
            return f[n];
        }
        if (n == 0) {
            f[0] = 0;
            return 0;
        }
        if (n == 1) {
            f[1] = 1;
            return 1;
        }
        f[n] = lookupFibo(f, n - 1) + lookupFibo(f, n - 2);
        return f[n];
    }

    public static long memoizedFibo(int n) {
        if (n <= 1) {
            return n;
        }
        long[] f = new long[n + 1];
        for (int i = 0; i <= n; i++) {
            f[i] = -1;
        }
        f[0] = 0;
        f[1] = 1;
        return lookupFibo(f, n);
    }

    public static void testar() {
        int[] valores = {4, 8, 16, 32, 128, 1000, 10000};
        System.out.println("Testando MEMOIZED:");
        for (int n : valores) {
            try {
                long inicio = System.nanoTime();
                long resultado = memoizedFibo(n);
                long fim = System.nanoTime();
                double tempo = (fim - inicio) / 1_000_000.0;
                System.out.printf("fib(%d) = %d (tempo: %.3f ms)%n", n, resultado, tempo);
            } catch (StackOverflowError e) {
                System.out.printf("fib(%d) = StackOverflowError (recursão muito profunda)%n", n);
            } catch (OutOfMemoryError e) {
                System.out.printf("fib(%d) = OutOfMemoryError (array muito grande)%n", n);
            }
        }
        System.out.println();
    }
}