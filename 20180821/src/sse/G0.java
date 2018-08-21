package sse;

import java.util.Scanner;

public class G0 {
	Scanner scan = new Scanner(System.in);
	int num;
	int _case;
	int[] dice = {1,2,3,4,5,6};
	int[] array;
	int[] check;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		G0 obj = new G0();
		obj.getInput();
		
		switch (obj._case) {
		case 1:
			obj.process1(0);
			break;
		case 2:
			obj.process2(0, 0);
			break;
		case 3:
			obj.process3(0);
			break;
		}

	}
	
	public void process3(int n) {
//		System.out.println("process3");
		if(n==num) {
			for(int i=0; i<num; i++) {
				System.out.print(array[i]+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=0; i<6; i++) {
			if(check[i] == 1) continue;
			
			array[n] = dice[i];
			check[i]=1;
			process3(n+1);
			check[i]=0;
		}
		
		
		
	}
	
	
	public void process2(int n, int index) {
//		System.out.println("process2");
		if(n==num) {
			for(int i=0; i<num; i++) {
				System.out.print(array[i]+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=index; i<6; i++) {
			array[n] = dice[i];
			process2(n+1, i);
		}
		

		
	}
	
	public void process1(int n) {
//		System.out.println("process1");
		if(n==num) {
			for(int i=0; i<num; i++) {
				System.out.print(array[i]+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=0; i<6; i++) {
			array[n] = dice[i];
			process1(n+1);
		}
		
	}
	
	public void getInput() {
		num = scan.nextInt();
		_case = scan.nextInt();
		array = new int[num];
		check = new int[6];
	}
}
