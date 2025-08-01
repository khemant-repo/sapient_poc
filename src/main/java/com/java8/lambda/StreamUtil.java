package com.java8.lambda;

import com.preprations.systemdesign.parkinglot.Person;
import com.tuf.dsa.java8.Employee;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamUtil {


    public static int findFactorial(int n) {

        if (n < 0) {
            throw new IllegalArgumentException("number can't be negative.");
        }

        int result = IntStream.rangeClosed(1, n)
                .reduce(1, (a, b) -> a * b);

        return result;
    }

    public static List<Integer> filterItems() {
        return IntStream.rangeClosed(1, 10).filter(n -> n > 5).
                boxed().collect(Collectors.toList());
    }

    public static Set<String> mapExample() {
        List<String> list = Arrays.asList("apple", "banana", "mango", "apple");


        return list.stream()
                .map(item -> item.toUpperCase())
                .collect(Collectors.toSet());
    }

    public static void forExample() {
        List<String> list = Arrays.asList("apple", "banana", "mango", "apple");

        list.stream()
                .map(item -> item.toUpperCase())
                .collect(Collectors.toSet()).forEach(fruit -> System.out.println(fruit));
    }

    public static OptionalInt reduceExample() {
        return IntStream.rangeClosed(1, 5)
                .reduce((a, b) -> a * b);
    }

    public static void maxExample() {
        List<Integer> list = Arrays.asList(1, 2, 4, 5, 7, 9);

        Optional<Integer> maxItem = list.stream()
                .max(Integer::compareTo);

        System.out.println("map item: " + maxItem);

    }

    public static void groupbyExmaple() {

        List<Employee> list = Arrays.asList(
                new Employee(1, "hemant", 1000, "HR"),
                new Employee(2, "ravi", 1200, "IT"),
                new Employee(3, "Adam", 1400, "dev"),
                new Employee(4, "john", 1400, "HR"),
                new Employee(5, "neeraj", 1200, "IT"),
                new Employee(6, "lee", 1500, "IT"),
                new Employee(6, "jeff", 1700, "DEV"),
                new Employee(7, "kolin", 1600, "HR"),
                new Employee(8, "ajay", 1700, "HR")
        );

        Map<String, List<Employee>> collect = list.stream().collect(Collectors.groupingBy(employee -> employee.getDept()));
        System.out.println(collect);
    }

    public static void practiceFilter() {
        Predicate<String> pred = name -> name.length() > 4;
        Stream.of("alex", "bob", "maria", "shawn", "ama")
                .filter(pred).forEach(name -> System.out.println("Filter example: " + name));
    }

    public static void exploreCreateStream() {

        // type 1
        int[] arr = {1, 2, 3, 4, 5};
        long count = Arrays.stream(arr).count();
        System.out.println("Arrays.stream(take arr[] ) count is:: " + count);

        // type 2
        long countAsList = Arrays.asList(1, 2, 3, 4, 5)
                .stream()
                .count();

        System.out.println("countAsList : " + countAsList);


        //type 3
        Map<String, Integer> map = new HashMap<>();
        map.put("hemant", 6);
        map.put("muskan", 6);

        long countAsMap = map.entrySet()
                .stream()
                .count();
        System.out.println("countAsMap:: " + countAsMap);

        //type 4

        long countAsStream = Stream.of(1, 2, 3, 4, 5)
                .count();

        System.out.println("countAsStream:: " + countAsStream);
    }


    /**
     * reduction terminal operation
     */
    public static void minMaxComparator() {

        Optional<String> min = Stream.of("deer", "hourse", "pig")
                //        .filter(s-> s.length()>10)
                .min((s1, s2) -> s1.length() - s2.length());

        // will throw below exception if value not present
        //Exception in thread "main" java.util.NoSuchElementException: No value present
        // try with filter case on
        // System.out.println("Animal with minimum char "+ min.get());

        System.out.println("Animal with minimum char ");
        min.ifPresent(System.out::println); // correct way to use optional


        Optional<Integer> max = Stream.of(1, 4, 2, 3, 11, 6, 44)
                .max((n1, n2) -> n1 - n2);
        max.ifPresent(System.out::println);
    }

    public static void toMapExample() {
        Map<Integer, String> map = Stream.of("cake", "biscuit", "apple")
                .collect(Collectors.toMap(s -> s.length(), s -> s));

        System.out.println(map);
    }

    public static void reverseEachWord() {
        String input = "java 8 stream API is powerful";

        String result = Arrays.stream(input.split(" "))
                .map(s -> {
                    StringBuilder builder = new StringBuilder(s);
                    builder = builder.reverse();
                    return builder.toString();

                }).collect(Collectors.joining(" "));
        System.out.println(result);
    }

    /**
     * collect - Collectors.toMap();
     */
    public static void practiceCollect() {

        collect1();
        collectWithPredefinedAPIsWithCollectors();

        testCollectectors_joining();
        testCollectors_averageInt();

        test_toMap();
        test_partitioningBy();
    }

    private static void test_partitioningBy() {
        partitioningBYListView();
        partitioningBySetView();
    }

    private static void partitioningBySetView() {
        var result = Arrays.asList("Thomas", "Terresa", "mike", "alan", "Tony", "Hemant","alan")
                .stream()
                .collect(Collectors.partitioningBy(s -> s.startsWith("T"),Collectors.toSet()));

        System.out.println("partioning by result set view: " + result);
        var namesWithT = result.get(true);
        System.out.println("namesWithT: " + namesWithT);
        var namesWithoutT = result.get(false);
        System.out.println("namesWithoutT: " + namesWithoutT);
    }

    private static void partitioningBYListView() {
        var result = Arrays.asList("Thomas", "Terresa", "mike", "alan", "Tony", "Hemant","alan")
                .stream()
                .collect(Collectors.partitioningBy(s -> s.startsWith("T")));

        System.out.println("partioning by result: " + result);
        var namesWithT = result.get(true);
        System.out.println("namesWithT: " + namesWithT);
        var namesWithoutT = result.get(false);
        System.out.println("namesWithoutT: " + namesWithoutT);
    }

    private static void collectWithPredefinedAPIsWithCollectors() {

    }

    private static void collect1() {
        Stream<String> strStream = Stream.of("ad", "ju", "di", "cate");
        var result = strStream.collect(StringBuilder::new,
                (sb, str) -> sb.append(str),
                (sb1, sb2) -> sb1.append(sb2));

        System.out.println("collect 1 result: " + result);
    }


    private static void test_toMap() {
        convertKeyAsStringValueAsLength();

        collectWithDuplicateKeys();
        collectWithDuplicateKeysInSortedOrder();
        collectWithGroupingBy();
    }

    /**
     * groupBy tells collect to group all the element into map
     * groupBy takes function which determine the keys in the Map
     * Each value is a list of all entries matched by keys.
     * The list is default, can be changed.
     */
    private static void collectWithGroupingBy() {

        Map<Integer, List<String>> map = Arrays.asList("joe", "tom", "tom", "alan", "walker")
                .stream()
                .collect(Collectors.groupingBy(String::length));
        System.out.println("group by example with list" + map);

        // provided downstream collectors which work with the value
        // it will convert list of string to set of stream and remove duplicates

        Map<Integer, Set<String>> setResult = Arrays.asList("joe", "tom", "tom", "alan", "walker")
                .stream()
                .collect(Collectors.groupingBy(s -> s.length(), Collectors.toSet()));
        System.out.println("setResult :" + setResult);

        TreeMap<Integer, List<String>> treeMapResult = Arrays.asList("joe", "tom", "tom", "alan", "walker")
                .stream()
                .collect(Collectors.groupingBy(String::length,
                        TreeMap::new, // return result with sorted keys as tree map view
                        Collectors.toList()));

        System.out.println("treeMapResult: " + treeMapResult);
    }

    private static void collectWithDuplicateKeys() {
        Map<Integer, String> map = Stream.of("banana", "apple", "mango")
                .collect(Collectors.toMap(
                        s -> s.length(), // key
                        s -> s, // value
                        (s1, s2) -> s1 + ", " + s2) // merge function defined to perform operation if key is equals

                );

        System.out.println("collect with duplicate keys: " + map);
    }

    private static void collectWithDuplicateKeysInSortedOrder() {
        TreeMap<String, Integer> map = Stream.of("apple", "banana", "mango", "pineapple")
                .collect(Collectors.toMap(
                        s -> s, // key
                        s -> s.length(), // value
                        (s1, s2) -> s1 + s2,
                        () -> new TreeMap<>())); // merge function defined to perform operation if key is equals


        System.out.println("collect with duplicate keys in sorted order: " + map);
    }

    /**
     * convertKeyAsStringValueAsLength
     */
    private static void convertKeyAsStringValueAsLength() {
        Map<String, Integer> map = Stream.of("apple", "banana", "mango")
                .collect(Collectors.toMap(s -> s, // Function for key
                        s1 -> s1.length())); // Function for value

        System.out.println("map: " + map);
    }

    private static void testCollectors_averageInt() {
        Double avg = Stream.of("apple", "banana", "mango")
                .collect(Collectors.averagingInt(s -> s.length()));

        System.out.println("avg of length: " + avg);
    }

    private static void testCollectectors_joining() {
        String s = Stream.of("apple", "banana", "mango")
                .collect(Collectors.joining(", "));
        System.out.println("After joining: " + s);

        String joingingwithreduce = Stream.of("apple", "banana", "mango")
                .reduce("", (s1,s2)-> s1+", "+s2);

        System.out.println("joingingwithreduce : "+joingingwithreduce);
    }

    public static void practiceGroupingBy() {
        groupBy_defaultListImpl();

        groupBy_withourDuplicate();
    }

    private static void groupBy_withourDuplicate() {
        Map<Integer, Set<String>> collect = Stream.of("jow", "andy", "rose", "peter", "andy", "spider", "man")
                .collect(Collectors.groupingBy(s -> s.length(),
                        Collectors.toSet()));

        System.out.println("grouping by example 2: " + collect);
    }

    /**
     * contains duplicate
     */
    private static void groupBy_defaultListImpl() {
        Map<Integer, List<String>> collect = Stream.of("jow", "andy", "rose", "peter", "andy", "spider", "man")
                .collect(Collectors.groupingBy(s -> s.length()));

        System.out.println("grouping by example 1: " + collect);
    }

    public static void practiceTerminalOperations() {

//        minMaxComparator();
//        findFirstFindAny();
//        anyMatchAllMatchNoneMatch();
//        streamForEachExample();
//        reduceMethodExample();
        practiceCollect();
    }

    private static void reduceMethodExample() {
        reduceWithIdentity();
        reduceWithoutIdentity();

    }

    /**
     * return optional:
     * 3 result are expected
     * 1. empty stream
     * 2. one element
     * 3. multi element
     */
    private static void reduceWithoutIdentity() {

        BinaryOperator<Integer> op = (a, b) -> a * b;
        Stream<Integer> emptyStream = Stream.empty();
        emptyStream.reduce((a, b) -> a * b).ifPresent(s -> System.out.println("empty stream result " + s));

        Stream<Integer> singleEleStream = Stream.of(6);
        singleEleStream.reduce((a, b) -> a * b).ifPresent(s -> System.out.println("single stream result " + s));

        Stream<Integer> multiEleStream = Stream.of(2, 3, 4);
        multiEleStream.reduce(op).ifPresent(s -> System.out.println("multiEleStream stream result " + s));
    }

    /**
     * does return some value if nothing found : intial value.
     */
    private static void reduceWithIdentity() {
        System.out.println("Reduce method example with initial val...");
        String name = Stream.of("h", "e", "m", "a", "n", "t")
                .reduce("", (initialValue, str) -> initialValue + str);

        System.out.println("name: " + name);


        var result = Stream.of(2, 3, 4)
                .reduce(1, (initialVal, ele) -> initialVal * ele);

        System.out.println("result of int stream :" + result);
    }

    private static void streamForEachExample() {
        System.out.println("foreach  take consumer and does not return any value, not a reduction.");
        Stream.of("Hemant", "Muskan", "Vaidik", "Vedasnh").forEach(System.out::println);
    }

    private static void anyMatchAllMatchNoneMatch() {
        List<String> names = Arrays.asList("Hemant", "Muskan", "Vaidik", "Vedasnh");
        Predicate<String> pred = name -> name.startsWith("T");

        boolean result = names.stream()
                .anyMatch(pred);

        System.out.println("is Any match exist: " + result);
        boolean isAllMatch = names.stream()
                .allMatch(pred);

        System.out.println("is All names matched with pred? " + isAllMatch);

        boolean isNoneMatched = names.stream().noneMatch(pred);

        System.out.println("is no element matched? " + isNoneMatched);
    }

    private static void findFirstFindAny() {
        Optional<String> any = Stream.of("jow", "andy", "rose", "peter", "andy", "spider", "man")
                .findAny(); // useually return first element
        any.ifPresent(s -> System.out.println("find any result: " + s));

        Optional<String> result = Stream.of("jow", "andy", "rose", "peter", "andy", "spider", "man")
                .findFirst(); // always return first element

        result.ifPresent(s -> System.out.println("find first example: " + s));
    }

    public static void practiceIntermediateOPerations() {

        practiceFilter();
        practiceDistinct();
        practiceLimit();
        practiceMap();
        practiceFlatMap();
        practiceSorted();
        practiceSkip();
    }

    private static void practiceSkip() {
        System.out.println("practice skip...");
        Predicate<Integer> pred = n -> n> 10;
        Stream.of(1,3,4,2,5,7,99,4,22,12,87,90)
                .filter(pred)
                .sorted()
                .skip(1)
                .limit(2)
                .forEach(System.out::println);
    }

    private static void practiceSorted() {

        defaultSortingNaturalOrder();

        System.out.println("sorting with comparator...");
        sortWithComparator();
    }

    private static void sortWithComparator() {
        List<Employee> empList =   Arrays.asList(
                  new Employee(1,"hemant",1000,"HR"),
                  new Employee(6,"lee",1500,"IT"),
                  new Employee(6,"jeff",1700,"DEV"),
                  new Employee(7,"kolin",1600,"HR")
          );

        //sort in accsending
        var result = empList.stream().sorted(Comparator.comparing(emp-> emp.getSalary()))
                .collect(Collectors.toList());

        /**
         * would give compile time error, when reversed applied java consider lambda and Object instread of employee obj
         * so, unable to figure the type
         */
        //var result = empList.stream().sorted(Comparator.comparing(emp-> emp.getSalary()).reversed())
          //      .collect(Collectors.toList());

        /**
         * with method ref java knows the type Employee and Integer for comparable
         */
        //var descResult = empList.stream().sorted(Comparator.comparing(Employee::getSalary).reversed())
          //      .collect(Collectors.toList());


        result.stream().forEach(s-> System.out.println(s.getName()+", "+s.getSalary()));
    }

    private static void defaultSortingNaturalOrder() {
        System.out.println("Sorting example ...");
        Stream.of("jow", "john", "rose", "peter", "andy", "spider", "man")
                .peek(s-> System.out.println("input: "+s))
                .filter(s-> s.length()==4)
                .peek(s-> System.out.println("after filter: "+s))
                .sorted()
                .peek(s-> System.out.println("after sorting: "+s))
                .limit(2)

                .forEach(s-> System.out.println("final result "+ s));
    }

    private static void practiceFlatMap() {
        System.out.println("flatmap example...");
        List<String> batch1 = Arrays.asList("hemant","muskan");
        List<String> batch2 = Arrays.asList("Ajay","Brayan");

        Stream<List<String>> streamOfList = Stream.of(batch1,batch2);

        streamOfList.flatMap(list-> list.stream())
                .forEach(name-> System.out.print(name+", "));
    }

    private static void practiceMap() {
        System.out.println("map example..");
        Stream.of("alex", "bob", "alex", "Alex")
                .map(s-> s.length())
                .forEach(s-> System.out.print(s+", "));
    }

    private static void practiceLimit() {
        System.out.println("Example limit operation...");
        IntStream.of(
                11,22,33,44,55,66,77,88,99
        ).peek(n-> System.out.println("peek: "+n))
                .filter(n-> n > 40)
                .limit(2)
                .forEach(n-> System.out.println("after filter and limit the result: "+ n));
    }

    private static void practiceDistinct() {
        System.out.println("Distinct practice...");
        Stream.of("alex", "bob", "alex", "Alex")
                .peek(s-> System.out.println("peek: "+s))
                .distinct()
                .forEach(s-> System.out.println("foreach: "+s));
    }

    public static void practicePrimitiveStream() {
        practiceIntStream();
    }


    private static void practiceIntStream() {
        IntSummaryStatistics stats = IntStream.of(5,10,15,20)
                .summaryStatistics();

        int min = stats.getMin();
        int max = stats.getMax();
        double avg = stats.getAverage();
        long count = stats.getCount();
        long sum = stats.getSum();
        System.out.println("min :"+min +"\nmax : "+max +"\nAVG : "+avg +"\nSUM: "+sum +"\nCount: "+count);
    }

    public static void practiceOptional() {
        commonOptionalMethods();
        practiceOptionalWithNull();

    }

    private static void practiceOptionalWithNull() {

        Optional<String> optRes = howToDealWithNull("hemant");
        System.out.println("optional response with value: ");
        optRes.ifPresent(System.out::println);

        System.out.println("optional with null response");
        Optional<String> optNullRes = howToDealWithNull(null);
        System.out.println( optNullRes.orElseGet(()-> "empty optional"));
    }

    private static Optional<String> howToDealWithNull(String arg) {
        //Optional optionalReturn  = arg == null ? Optional.empty() : Optional.of(arg);

        Optional optionalReturn = Optional.ofNullable(arg);// same as previous line

        return optionalReturn;

    }

    private static void commonOptionalMethods() {
        //Optional<Double> avg = calAverage(Arrays.asList(10,20,30));
        Optional<Double> avg = calAverage(new ArrayList<>());
        /**
         * if you do get on empty optional you will get  NoSuchElementException: No value present exception
         */
        //Optional<Double> avg = calAverage(new ArrayList<>());
        // double result = avg.get();

       /* if(avg.isPresent()){
            System.out.println("result :" + avg.get());
        }*/

        avg.ifPresent(System.out::println);

        System.out.println(avg.orElse(Double.NaN));

        System.out.println(avg.orElseGet(()-> Math.random()*10));
    }

    private static Optional<Double> calAverage(List<Integer> list) {

        int sum = 0;
        if (list.isEmpty()) return Optional.empty();

        for(int n : list){
            sum +=n;
        }

        return Optional.of((double) sum/list.size());
    }

    public static void practiceParallelStream() {

        System.out.println("be mindful while using PS, the sequence may vary while using PS because different thread work parallely ");
        System.out.println("output with sequential stream");
        Stream.of("a","b","c","d","e","f","g")
                .forEach(System.out::print);

        System.out.println("\noutput with parallel stream unordered..");
        Stream.of("a","b","c","d","e","f","g")
                .parallel()
                .forEach(System.out::print);

        System.out.println("\noutput with parallel stream ordered..");
       Arrays.asList("a","b","c","d","e","f","g")
               .parallelStream()
                .forEachOrdered(System.out::print);
    }
}
