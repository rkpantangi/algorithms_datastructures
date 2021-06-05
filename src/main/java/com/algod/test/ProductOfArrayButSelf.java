package com.algod.test;

import java.util.Arrays;

public class ProductOfArrayButSelf {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(product2(new int [] {1, 2, 3, 4})));
		
		System.out.println(21 & 1);
		System.out.println(20 & 1);
		System.out.println(2 & 1);
		System.out.println(1 & 1);
	}

	public static int [] product(int [] arr) {
	    int [] prodArr = new int[arr.length];
	    int product = 1;
	    for(int i=0; i<arr.length; i++){
	        prodArr[i] = product;
	        product *= arr[i];
	    }

	    product = 1;
	    for(int i=arr.length-1; i>=0; i--){
	        prodArr[i] *= product;
	        product *= arr[i];
	    }
	    
	    for (int i=0;i<prodArr.length;i++) {
	    	prodArr[i] = ((prodArr[i] & 1));
	    }

	    return prodArr;
	}
	
	public static int [] product2(int [] arr) {
	    int [] prodArr = new int[arr.length];
	    int product = 1;
	    prodArr[1]=1;
	    for(int i=1; i<arr.length; i++){
	        prodArr[i] = product;
	        product *= arr[i];
	    }

	    product = 1;
	    for(int i=arr.length-1; i>=0; i--){
	        prodArr[i] *= product;
	        product *= arr[i];
	    }
	    
	    for (int i=0;i<prodArr.length;i++) {
	    	prodArr[i] = ((prodArr[i] & 1));
	    }

	    return prodArr;
	}

	public static int [] product1(int [] arr) {
	    int [] temp = new int[arr.length];
	    int product = 1;
	    for(int i=0; i<arr.length; i++){
	        temp[i] = product;
	        product *= arr[i];
	    }

	    product = 1;
	    for(int i=arr.length-1; i>=0; i--){
	        temp[i] *= product;
	        product *= arr[i];
	    }

	    return temp;
	}

}
