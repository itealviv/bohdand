import java.util.Comparator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class StreamsHome {

    public static void main(String[] args) {
        System.out.println("First");
        IntStream.concat(
                IntStream.range(2, 6),
                IntStream.rangeClosed(-1, 2))
                .forEach(x -> System.out.format("%d, ", x));
        System.out.println("\nSecond");
        IntStream.range(5, 30)
                .limit(12)
                .skip(3)
                .limit(6)
                .skip(2)
                .forEach(x -> System.out.format("%d, ", x));
        System.out.println("\nThird");
        IntStream.range(0, 10)
                .skip(2)
                .dropWhile(x -> x < 5)
                .limit(3)
                .forEach(x -> System.out.format("%d, ", x));
        System.out.println("\nFourth");
        IntStream.range(0, 10)
                .skip(3)
                .takeWhile(x -> x < 5)
                .limit(3)
                .forEach(x -> System.out.format("%d, ", x));
        System.out.println("\nFifth");
        IntStream.range(1, 5)
                .flatMap(i->IntStream.generate(()->i).limit(i))
                .forEach(x -> System.out.format("%d, ", x));
        System.out.println("\nSixth");
        int x = IntStream.range(-2, 2)
                .map(i -> i*5)
                .reduce(10, Integer::sum);
        System.out.print("x: "+x);
        System.out.println("\nSeventh");
        IntStream.range(0, 10)
                .boxed()
                .collect(Collectors.partitioningBy(i -> i % 2 == 0))
                .entrySet().forEach(System.out::println);
        System.out.println("\nEighth");
        IntStream.range(-5, 0)
                .flatMap(i->IntStream.of(i,i+6))
                .sorted()
                .forEach(z -> System.out.format("%d, ", z));
        System.out.println("\nNinth");
        IntStream.range(-5, 0)
                .flatMap(i->IntStream.of(i,i+6))
                .boxed()
                .sorted(Comparator.comparing(Math::abs))
                .forEach(y -> System.out.format("%d, ", y));
        System.out.println("\nTenth");
        IntStream.range(1, 5)
                .flatMap(i->IntStream.generate(()->i).limit(i))
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet().forEach(System.out::println);
    }
}
