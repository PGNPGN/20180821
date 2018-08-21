package sse;

import java.util.Scanner;

public class F4 {
	Scanner scan = new Scanner(System.in);
	int num;
	Pukit[] pukit;
	int gap, min=Integer.MAX_VALUE;
	
	public class Pukit{
		int s, b;
		
		public Pukit(int s, int b){
			this.s = s;
			this.b = b;
		}
	}
	public static void main(String[] args) {
		F4 obj = new F4();
		obj.getInput();
		obj.calculate(0, 1, 0);
		System.out.println(obj.min);
	}
	public void calculate(int cnt, int s, int b) {

		if( b!=0) {
			gap = Math.abs(s-b);
			if(gap<min) {
				min = gap;
			}
		}
//		System.out.println("cnt = "+cnt+" s = "+s+" b = "+b+" gap = "+gap);
		
		if(cnt == num) {
			return;
		}
		
			
		

		
		
		
		calculate(cnt+1, s*pukit[cnt].s, b+pukit[cnt].b);
		calculate(cnt+1, s, b);
	}
	public void getInput() {
		num = scan.nextInt();
		pukit = new Pukit[num];
		
		for(int i=0; i<num; i++) {
			pukit[i] = new Pukit(scan.nextInt(), scan.nextInt());
		}
	}
}
