package com.tuf.dsa.java11;

import java.util.ArrayList;
import java.util.List;

public class LVTI {

	/**
	 
1. Where they can be used?​

AS the nature is local so they can be used inside block of code.​

Ex: method,constructor,init block etc.​

2. Where they can't be used?​

Constructor/method parameters, static or class variables.​

Caveat: can only be used with lambdas where the parameter type can be inferred!.

3.A variable is always initialized on the same line where it is declared.​
Ex. var x =8;

4.The value of the var can be changed but the type can't.
ex.
var x = 8;
var x = 9; //posible
var x =8.9; // not possible it became double now.

5. Var can’t be simply initialzed to null, cast the null to a type first.
	Ex. var j = null; // is j a string, a double or int compiler doesn’t know.​
	Instead, var j = (String) null; // now, complier know j is null;

6.Var not allow multi variable decalaration.​
	Ex. Var a=5, b=6; // not allowed
	
7. Var is a reserved name but not a reserved keyword.
 	Ex. Var var = 8;  //ok​
-  identifiers can be called var but not the types names.exmaples ,  Classess, enums, interfaces.​
	
	 */

	
	{
		//init block
		var y = "abc"; // string
		//var j; not allowed , intialization must be in same line as well.
		//j = 9;
	}
	public LVTI() {
		// TODO Auto-generated constructor stub
		var x = 2; // int
	//	var j = null; // 5. will create issue.
		var j = (String) null; // will work that way
		//var a=5, b=6;	// 6. not allowed multi variable declaration.
		
		var var = 6; // allowed..
	}
	//class var{}// point 7: not allowed
	//enum var{}// point 7: not allowed
	
	public static void main(String[] args) {
		// here it is ok but remember to initialize them
		var x = 2; // int
		var y = "abc"; // string
		var z = 2.3; // double
		lambdaEx();
	}
	private static void lambdaEx() {
		// TODO Auto-generated method stub
		List<String> ls = new ArrayList<String>();
		ls.add("a");
		ls.add("a");
		ls.add("b");
		ls.removeIf((var s) -> s.equals("a")); // here complier already know that the list is of type string.
		System.out.println(ls);
	}
	
}
