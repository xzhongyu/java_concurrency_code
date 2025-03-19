package com.example.mycode;

public class Ned {

	// fn = （fn-1）+ (fn-2)
	private static int step(int n) {

		// n-1 , n-1 , ...
		if (n == 1 || n == 2){
			return n;
		}

		return step(n - 1) + step(n - 2);
	}

	public static void main(String[] args) {
		int step = step(10);
		System.out.println(step);
	}




}
