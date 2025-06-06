import java.util.*;
import java.util.stream.*;

public class MapExample {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(5, 10, 15, 20, 25, 30);
        List<Integer> evenList = list.stream()
                .map(x -> (x % 2 == 0) ? x : null) 
                .filter(Objects::nonNull) 
                .collect(Collectors.toList());

        System.out.println(evenList);
    }
}

