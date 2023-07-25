import java.util.ArrayDeque;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ReverseString {

    private static String reverseStringNaive(String str) {
        for (int i = 0; i < (str.length() / 2); i++) {
            var elemLeft = str.substring(i, i + 1);
            var elemRight = str.substring(str.length() - 1 - i, str.length() - i);
            str = str.substring(0, i)
                    + elemRight
                    + str.substring(i + 1, str.length() - i - 1)
                    + elemLeft
                    + str.substring(str.length() - i);
        }
        return str;
    }

    private static String reverseStringChars(String str) {
        var chars = str.toCharArray();
        for (var i = 0; i < chars.length / 2; i++) {
            var buf = chars[i];
            chars[i] = chars[str.length() - i - 1];
            chars[str.length() - i - 1] = buf;
        }
        return new String(chars);
    }

    private static String reverseStringStream(String str) {
        AtomicReference<String> result = new AtomicReference<>("");
        str.chars()
                .mapToObj(Character::toString)
                .collect(Collectors.toCollection(ArrayDeque::new))
                .descendingIterator()
                .forEachRemaining(i -> result.accumulateAndGet(i, (a, b) -> a + b));
        return result.get();
    }

    public static void main(String[] args) {
        var str = IntStream.range(0, 100000)
                .mapToObj(Character::toString)
                .collect(Collectors.joining());
        var time = System.currentTimeMillis();
        System.out.println(reverseStringNaive(str));
        System.out.printf("reverseStringNaive: %d%n", System.currentTimeMillis() - time);
        time = System.currentTimeMillis();
        System.out.println(reverseStringChars(str));
        System.out.printf("reverseStringChars: %d%n", System.currentTimeMillis() - time);
        time = System.currentTimeMillis();
        System.out.println(reverseStringStream(str));
        System.out.printf("reverseStringStream: %d%n", System.currentTimeMillis() - time);
    }
}
