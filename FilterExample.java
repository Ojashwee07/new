import java. util.*;
import java. util.stream.*;

public class FilterExample{
    public static void main(String[] args) {
        List<Integer> list =Arrays.asList(5,10,15,20,25,30 );
        List<Integer> evenList = list.stream()
        .filter(x -> x %2==0)
        .collect(Collectors.toList());
        System.out.println(evenList);
    }
}