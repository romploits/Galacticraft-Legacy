package micdoodle8.mods.galacticraft.api.util.stream;

import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

import micdoodle8.mods.galacticraft.api.galaxies.CelestialObject;
import micdoodle8.mods.galacticraft.core.util.list.CelestialList;
import micdoodle8.mods.galacticraft.core.util.list.ImmutableCelestialList;

import lombok.experimental.UtilityClass;

import static java.util.stream.Collector.Characteristics.CONCURRENT;
import static java.util.stream.Collector.Characteristics.IDENTITY_FINISH;
import static java.util.stream.Collector.Characteristics.UNORDERED;

@UtilityClass
public final class Accumulators
{
    static final Set<Accumulator.Characteristics> CH_CONCURRENT_ID   = from(CONCURRENT, UNORDERED, IDENTITY_FINISH);
    static final Set<Accumulator.Characteristics> CH_CONCURRENT_NOID = from(CONCURRENT, UNORDERED);
    static final Set<Accumulator.Characteristics> CH_ID              = from(IDENTITY_FINISH);
    static final Set<Accumulator.Characteristics> CH_UNORDERED_ID    = from(UNORDERED, IDENTITY_FINISH);
    static final Set<Accumulator.Characteristics> CH_NOID            = Collections.emptySet();

    static final Set<Collector.Characteristics> from(Collector.Characteristics... arr)
    {
        return Collections.unmodifiableSet(EnumSet.of(arr[0], Arrays.copyOfRange(arr, 1, arr.length)));
    }

    @SuppressWarnings("unchecked")
    private static <I, R> Function<I, R> castingIdentity()
    {
        return i -> (R) i;
    }

    //@noformat
    static class AccumulatorImpl<T, A, R> implements Accumulator<T, A, R> {
        private final Supplier<A> supplier;
        private final BiConsumer<A, T> accumulator;
        private final BinaryOperator<A> combiner;
        private final Function<A, R> finisher;
        private final Set<Characteristics> characteristics;

        AccumulatorImpl(Supplier<A> supplier,
                      BiConsumer<A, T> accumulator,
                      BinaryOperator<A> combiner,
                      Function<A,R> finisher,
                      Set<Characteristics> characteristics) {
            this.supplier = supplier;
            this.accumulator = accumulator;
            this.combiner = combiner;
            this.finisher = finisher;
            this.characteristics = characteristics;
        }

        AccumulatorImpl(Supplier<A> supplier,
                      BiConsumer<A, T> accumulator,
                      BinaryOperator<A> combiner,
                      Set<Characteristics> characteristics) {
            this(supplier, accumulator, combiner, castingIdentity(), characteristics);
        }

        @Override
        public BiConsumer<A, T> accumulator() {
            return accumulator;
        }

        @Override
        public Supplier<A> supplier() {
            return supplier;
        }

        @Override
        public BinaryOperator<A> combiner() {
            return combiner;
        }

        @Override
        public Function<A, R> finisher() {
            return finisher;
        }

        @Override
        public Set<Characteristics> characteristics() {
            return characteristics;
        }
    }
    
    public static <T extends CelestialObject>
    Accumulator<T, ?, CelestialList<T>> celestialList() {
        return new AccumulatorImpl<>((Supplier<CelestialList<T>>) CelestialList::new, CelestialList::add, (left, right) -> { left.addAll(right); return left; }, CH_ID);
    }
    
    public static <T extends CelestialObject>
    Accumulator<T, ?, ImmutableCelestialList<T>> toImmutableCelestialList() {
        return new AccumulatorImpl<>((Supplier<ImmutableCelestialList<T>>) ImmutableCelestialList::new, ImmutableCelestialList::add, (left, right) -> { left.addAll(right); return left; }, CH_ID);
    }
}
