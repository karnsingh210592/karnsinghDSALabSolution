package com.greatlearning.app;

import java.util.Stack;

public class BalancingExpression {
	public static void main(String[] s) {
		String expression = "{[}";
		boolean checkExp = checkEpression(expression);
		if(checkExp) {
			System.out.println("Expression is balanced");
		}else {
			System.out.println("Expression is not balanced");
		}
	}
	
	public static boolean checkEpression(String expression) {
		Stack<Character> expressionStack = new Stack<Character>();
		for(int i=0; i < expression.length(); i++) {
			char exp = expression.charAt(i);
			if(exp == '{' || exp == '[') {
				expressionStack.push(exp);
				continue;
			}
			if(expressionStack.isEmpty()) {
				return false;
			}
			if(exp == '}') {
				char expPop = expressionStack.pop();
				if(expPop != '{') {
					return false;
				}
			}
			if(exp == ']') {
				char expPop = expressionStack.pop();
				if(expPop != '[') {
					return false;
				}
			}
		}
		return expressionStack.isEmpty();
	}
}	
