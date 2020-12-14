package gpk.tailrec;

import java.util.stream.Stream;

@FunctionalInterface
public interface Tailrec<T> {
    Tailrec<T> nextCall();

    default boolean isComplete() {
        return false;
    }

    default T result() {
        throw new Error("not implemented");
    }

    default T execute() {
        return Stream.iterate(this, Tailrec::nextCall)
                .filter(Tailrec::isComplete)
                .findFirst()
                .get()
                .result();
    }
}