package com.mukul.utility;

import java.util.Collection;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;

public interface HelperInt {

    interface Streams {

        static <T, E> Function<T, Stream<E>> asStream(Function<T, Collection<E>> getter) {
            return (t) -> Optional.ofNullable(getter.apply(t)).map(Collection::stream).orElseGet(Stream::empty);
        }

        static <T, E> Function<T, Stream<E>> streamOf(Function<T, Optional<E>> getter) {
            return (t) -> (getter.apply(t)).map(Stream::of).orElseGet(Stream::empty);
        }

    }

    interface Optionals {
        static <T> Optional<T> map (Optional<T> o1, Optional<T> o2, BinaryOperator<T> mapper){
            return o1.flatMap(v1 -> o2.map(v2 -> mapper.apply(v1,v2)));
        }

        static <T> Optional<Object> map (Optional<T> o1, Supplier<Optional<T>> o2, BinaryOperator<T> mapper){
            return o1.flatMap((v1) -> ((Optional)o2.get()).map((v2) -> mapper.apply(v1, (T) v2)));
        }
    }

    interface Maths{
        static int ceilDiv (int dividend , int divisor){
            return -Math.floorDiv(-dividend,divisor);
        }
    }
}















