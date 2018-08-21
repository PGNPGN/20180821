package sse;

import java.util.Scanner;

public class F9 {
	Scanner scan = new Scanner(System.in);
	int testcase;
	int[] array;
	int array_Num;
	int max;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		F9 obj = new F9();
		obj.getInput();
		
	}
	
	public void getInput() {
		testcase = scan.nextInt();
		
		for(int i=0; i<testcase; i++) {
			max = 0;
			array_Num = scan.nextInt();
			array = new int[array_Num];
			
			for(int j=0; j<array_Num; j++) {
				array[j] = scan.nextInt();
			}
			
			process(1001, 0, 0, 0, 0);
			System.out.println(max);
		}

		
	}

	private void process(int A, int A_Sum, int B, int B_Sum, int n) {
		
		if(n==array_Num) {
			if(A_Sum+B_Sum>max) {
				max = A_Sum+B_Sum;
			}
			
			return;
		}
		
		
		if(array[n]<A)
			process(array[n], A_Sum+array[n], B, B_Sum, n+1);
		if(array[n]>B)
			process(A, A_Sum, array[n], B_Sum+array[n], n+1);
		process(A, A_Sum, B, B_Sum, n+1);
		
	}
}
