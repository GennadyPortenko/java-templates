package gpk.tailrec;

public class TailrecUtils<T> {
    public static <T> Tailrec<T> done(T result) {
        return new Tailrec<T>() {
            @Override
            public boolean isComplete() {
                return true;
            }

            @Override
            public T result() {
                return result;
            }

            @Override
            public Tailrec<T> nextCall() {
                throw new Error("not implemented");
            }
        };
    }
}
