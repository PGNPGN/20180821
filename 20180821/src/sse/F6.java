package sse;

import java.util.Scanner;

public class F6 {
	Scanner scan = new Scanner(System.in);
	int size;
	int[] array;
	int remainder;
	int max;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		F6 obj = new F6();
		obj.getInput();
		obj.addCow(0, 0, 0);
		System.out.println(obj.max);
	}

	public void addCow(int n, int sum, int cnt) {
		System.out.println("n = "+n+" "+" sum = "+sum+" cnt = "+cnt);
		if(n == size) {
			System.out.println("n is full size");
			if(cnt>max) {
				max = cnt;
			}
			return;
		}

		System.out.println(sum_Digit(sum)+" "+sum_Digit(array[n])+" "+sum_Digit(sum+array[n]));

		if(sum_Digit(sum)+sum_Digit(array[n]) == sum_Digit(sum+array[n])) {
			addCow(n+1, sum+array[n], cnt+1);
		}
		addCow(n+1, sum, cnt);
		return;
	}

	public int sum_Digit(int a) {
		remainder = 0;
		while(a>0) {
			remainder += a%10;
			a /= 10;
		}
		return remainder;
	}

	public void getInput() {
		size = scan.nextInt();
		array = new int[size];

		for(int i=0; i<size; i++) {
			array[i] = scan.nextInt();
		}
	}
}
