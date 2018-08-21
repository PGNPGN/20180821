package sse;

import java.util.Scanner;

public class F5 {
	Scanner scan = new Scanner(System.in);
	int size;
	int[] array;
	int[] check;
	int anotherSum;
	int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		F5 obj = new F5();
		obj.getInput();
		obj.dfs(0, 0, 0);
		System.out.println(obj.min);
	}
	
	public void dfs(int n, int sum, int cnt) {
		
//		for(int i=0; i<size; i++) {
//			System.out.print(check[i]+" ");
//
//		}
//		System.out.print(sum);
//		System.out.println();
//		
		if(cnt == size/2) {
			anotherSum = 0;
			for(int i=0; i<size; i++) {
				if(check[i] ==0) {
					anotherSum += array[i];
				}
			}
			
//			System.out.println(anotherSum);
			
			if(Math.abs(sum-anotherSum)<min) {
				min = Math.abs(sum-anotherSum);
			}
			return;
		}
		
		if(n == size) {
			return;
		}
		
		
		check[n] = 1;
		dfs(n+1, sum+array[n], cnt+1);
		check[n] = 0;
		dfs(n+1, sum, cnt);
	}
	
	public void getInput() {
		size = scan.nextInt();
		array = new int[size];
		check = new int[size];
		
		for(int i=0; i<size; i++) {
			array[i] = scan.nextInt();
		}
	}
}
