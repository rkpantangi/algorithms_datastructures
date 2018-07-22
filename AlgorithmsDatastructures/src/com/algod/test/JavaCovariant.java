package com.algod.test;

public class JavaCovariant {

	private static class A{  
		A get(){return this;}  
		}  
		  
	private static class B1 extends A{  
		B1 get(){return this;}  
		public void message(){System.out.println("welcome to covariant return type");}  
		  
		}
	
		public static void main(String args[]){
			new B1().get().message();  
		}  

}
