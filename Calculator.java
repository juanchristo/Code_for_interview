package com.juan.Calculator;

import java.util.*;

public class Calculator {
	
	boolean parse_string(String expr){
		Stack<Integer> st= new Stack <Integer>();
		int invalid=0;
		for(int i=0;i<expr.length();i++){
			switch(expr.charAt(i)){
				case '(': st.push(1);
						  break;
				case ')': st.pop();
						  break;
				case '+': 
				case '-':
				case '*':
				case '/':
					if((expr.charAt(i+1)=='+')||(expr.charAt(i+1)=='-')||(expr.charAt(i+1)=='*')||(expr.charAt(i+1)=='/'))
						invalid=1;
					break;							
			}
		}
		if (!st.isEmpty())
			invalid=1;
		if (invalid==1)
			return false;
		else
			return true;
	}
	
	
	int eval_string(String expr){
		//String num1;		
		for(int i=0;i<expr.length();i++){
// to be completed
			}
		return 0;
		}
}