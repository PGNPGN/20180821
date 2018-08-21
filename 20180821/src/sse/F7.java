package sse;

import java.util.Scanner;

public class F7 {
	Scanner scan = new Scanner(System.in);
	int size, goal;
	int[] array;
	int[] sum_array;
	int idx;
	int temp;
	int cnt=1, cnt2;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		F7 obj = new F7();
		obj.getInput();
		obj.findResult(0,0);
		obj.print();
		obj.sort();
		obj.print();
		obj.findOrder();
		System.out.println(obj.cnt-obj.cnt2);
	}

	public void findOrder() {
		for(int i=0; i<idx; i++) {
			if(sum_array[i]>goal) {
				cnt++;
			}
			try {
				if(sum_array[i] == sum_array[i-1] && sum_array[i]>goal) {
					cnt2++;
				}
			}catch(ArrayIndexOutOfBoundsException e) {
				
			}
		}
	}

	public void sort() {
		for(int i=0; i<idx; i++) {
			for(int j=i+1; j<idx; j++) {
				if(sum_array[i]<sum_array[j]) {
					temp = sum_array[i];
					sum_array[i] = sum_array[j];
					sum_array[j] = temp;
				}
			}
		}
	}

	public void print() {
		for(int i=0; i<idx; i++) {
			System.out.print(sum_array[i]+" ");
		}
		System.out.println();
	}

	public void findResult(int n, int sum) {

		//		System.out.println(sum);
		if(n == size) {
			sum_array[idx++] = sum;
			return;
		}


		findResult(n+1, sum+array[n]);
		findResult(n+1, sum);
	}


	public void getInput() {
		size = scan.nextInt();
		goal = scan.nextInt();
		array = new int[size];
		sum_array = new int[(int)Math.pow(2, size)];

		for(int i=0; i<size; i++) {
			array[i] = scan.nextInt();
		}
	}
}
