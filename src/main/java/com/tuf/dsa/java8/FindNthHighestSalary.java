package com.tuf.dsa.java8;


import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class FindNthHighestSalary {

    public static void main(String[] args) {

       // Map<String,Integer> map = new HashMap<>();
        //getInput1(map);
        //getInput2(map);
       // Map.Entry<String, Integer> nthSalary = findNthHighestSalary(2, map);
        //System.out.println(nthSalary);
        //Entry<Integer, List<String>> employeesWithnthHigestsalary =  findNthHighestSalaryDynamic(2,map);
        //System.out.println(employeesWithnthHigestsalary);
    
    	System.out.println("**************");
    	
    	//findNthLargestSalary();
    	//nthSalary();
    	nthSalaryEmployee();
    }
    
    private static void nthSalaryEmployee() {
		// TODO Auto-generated method stub
		List<Employee> employees = getEmployees();
		
		Entry<Double, List<Employee>> emp = employees.stream()
			.collect(Collectors.groupingBy(Employee::getSalary))
			.entrySet()
			.stream()
			.sorted(Collections.reverseOrder(Entry.comparingByKey()))
			.collect(Collectors.toList())
			.get(1)
			;
		System.out.println(emp);
		
	}

	public static void nthSalary() {
    	Map<String,Integer> map = new HashMap<>();
        getInput2(map);
        
        Entry<Integer, List<String>> map1 =  map.entrySet()
        	.stream()
        	.collect(Collectors.groupingBy(entry-> entry.getValue(),Collectors.mapping(Entry::getKey, Collectors.toList())))
        	.entrySet()
        	.stream()
        	.sorted(Collections.reverseOrder(Entry.comparingByKey()))
        	.collect(Collectors.toList())
        	.get(1)
        	;
        System.out.println(map1+"map1");
       Entry<String, Integer> sortedMap =  map.entrySet()
        	.stream()
        	.sorted(Collections.reverseOrder(Entry.comparingByValue()))
        	.collect(Collectors.toList())
        	.get(2)
        	;
        System.out.println(sortedMap);
    }
    
    public static List<Employee> getEmployees(){
    	
    	
    	return Arrays.asList(
    			new Employee(1,"hemant",1000,"HR"),
    			new Employee(2,"ravi",1200,"IT"),
    			new Employee(3,"Adam",1400,"dev"),
    			new Employee(4,"john",1400,"HR"),
    			new Employee(5,"neeraj",1200,"IT"),
    			new Employee(6,"lee",1500,"IT"),
    			new Employee(6,"jeff",1700,"DEV"),
    			new Employee(7,"kolin",1600,"HR"),
    			new Employee(8,"ajay",1700,"HR")
    			);
    	
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
	private static void findNthLargestSalary() {
		// TODO Auto-generated method stub
		
		List<Employee> employeese  = 
				Arrays.asList(
						new Employee(1,"hemant",1000,"HR"),
						new Employee(2,"ravi",1200,"IT"),
						new Employee(3,"Adam",1400,"dev"),
						new Employee(4,"john",1400,"HR"),
						new Employee(5,"neeraj",1200,"IT"),
						new Employee(6,"lee",1500,"IT"),
						new Employee(6,"jeff",1700,"DEV"),
						new Employee(7,"kolin",1600,"HR"),
						new Employee(8,"ajay",1700,"HR")
						);
		
		Comparator<Employee> comparator = Comparator.comparing(Employee::getSalary)
													.thenComparing(Employee::getName);
		int position = 2;
		Employee employeese2 = employeese.stream()
		.sorted(Collections.reverseOrder(comparator))
		.collect(Collectors.toList())
		.get(position-1);
				
	}
































	private static void getInput1(Map<String, Integer> map) {
		map.put("hemant",1000);
        map.put("tom",1200);
        map.put("adm",1300);
        map.put("john",1700); // output
        map.put("deepak",1400);
        map.put("ravi",1100);
        map.put("santosh",1800);
	}
	private static void getInput2(Map<String, Integer> map) {
		map.put("hemant",1000);
        map.put("tom",1200);
        map.put("adm",1300);
        map.put("john",1700);
        map.put("Amar",1700);
        map.put("deepak",1400);
        map.put("michal",1400);
        map.put("ravi",1100);
        map.put("santosh",1800);
        map.put("Ankit",1800);
        map.put("pavan",1400);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private static Map.Entry<String, Integer> findNthHighestSalary(int num,Map<String, Integer> map) {
		Map.Entry<String, Integer> nthSalary = map.entrySet()
                .stream().
                sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors.toList())
                .get(num-1);
		return nthSalary;
	}
	private static Entry<Integer, List<String>> findNthHighestSalaryDynamic(int num,Map<String, Integer> map) {
		System.out.println(map.entrySet()
                .stream()
                .collect(
                		Collectors.groupingBy(Map.Entry::getValue,
                		//Collectors.mapping(Map.Entry::getKey, Collectors.toList())
                		Collectors.counting())
                		)
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByKey()))
                .collect(Collectors.toList())
                .get(num-1));
		return map.entrySet()
                .stream()
                .collect(
                		Collectors.groupingBy(Map.Entry::getValue,
                		Collectors.mapping(Map.Entry::getKey, Collectors.toList())
                		)
                		)
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByKey()))
                .collect(Collectors.toList())
                .get(num-1);
                
	}
}
