package com.algod.test;

import java.util.Arrays;

public class IdGenerator {

	public static void main(String[] args) {

		char [] avail = {
		        '0' , '1' , '2' , '3' , '4' , '5' ,
		        '6' , '7' , '8' , '9' , 'a' , 'b' ,
		        'c' , 'd' , 'e' , 'f' , 'g' , 'h' ,
		        'i' , 'j' , 'k' , 'l' , 'm' , 'n' ,
		        'o' , 'p' , 'q' , 'r' , 's' , 't' ,
		        'u' , 'v' , 'w' , 'x' , 'y' , 'z'
		    };
		
		long seq = 234234345345l;
		final int radix = avail.length;
		
		char [] id = new char[10];
		int i = id.length-1;
		while (seq > 0) {
			id[i--] = avail[(int) (seq % radix)];
			seq = seq / radix;
		}
		
		System.out.println(Arrays.toString(id));
	}

}

//252 -> 50 -> 10 -> 2