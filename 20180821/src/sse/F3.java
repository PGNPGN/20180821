

package sse;

import java.util.Scanner;

public class F3 {
	Scanner scan = new Scanner(System.in);
	int testCase;
	int number, goal;
	int[] integers;
	boolean flag = false;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		F3 obj = new F3();
		obj.getInput();
	}
	
	public void getInput() {
		testCase = scan.nextInt();
		for(int i=0; i<testCase; i++) {
			flag = false;
			number = scan.nextInt();
			goal = scan.nextInt();
			integers = new int[number];
			for(int j=0; j<number; j++) {
				integers[j] = scan.nextInt();
			}
			dfs(0,0);
			if(flag == true) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
		}
	}
	
	private void dfs(int n, int sum) {
		if(sum>goal)
			return;
		if(sum==goal) {
			flag = true;
			return;
		}
		if(n==number) {
			if(sum == goal)
				flag = true;
			return;
		}
				dfs(n+1, sum + integers[n]);
				dfs(n+1, sum);
	}
}
