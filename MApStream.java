import java.util.*;
import java.util.stream.*;

public class MApStream {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(5, 10, 15, 20, 25, 30);
        List<Integer> processedList = list.stream()
                .map(x -> (x % 2 == 0) ? x * 5 : null) 
                .filter(Objects::nonNull)              
                .collect(Collectors.toList());

        System.out.println(processedList);
    }
}
