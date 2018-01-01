package test;

import algorithms.SuffixArray;

public class SuffixArrayTest {
	
	public static void main(String[] args) {
//		String text = "I am your father hi boy";
		String text = "I";
		SuffixArray suar = new SuffixArray(text);
		System.out.println(suar.length());
	}

}
