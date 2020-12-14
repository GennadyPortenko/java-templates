package gpk;

import gpk.tailrec.Tailrec;

import static gpk.tailrec.TailrecUtils.done;

public class App {
    public static void main(String... args) {
        System.out.println(factorial(1, 3).execute());
    }

    static Tailrec<Integer> factorial(int accum, int n) {
        if (n == 0) {
            return done(accum);
        }
        return () -> factorial(accum * n, n - 1);
    }
}

