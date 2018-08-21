package sse;

import java.util.Scanner;

public class F8 {
	Scanner scan = new Scanner(System.in);
	int num_Pendulum, num_bead;
	int[] pendulum, bead;
	int[] weight;
	int idx;
	char[] answer;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		F8 obj = new F8();
		obj.getInput();
		obj.combination(0, 0, 0);
		obj.check();
		for(int i=0; i<obj.answer.length; i++) {
			System.out.print(obj.answer[i]+" ");
		}
	}
	
	public void check() {
		for(int i=0; i<bead.length; i++) {
			for(int j=0; j<weight.length; j++) {
				if(bead[i] == weight[j]) {
					answer[i] = 'Y';
					break;
				}else {
					answer[i] = 'N';
				}
			}
		}
	}
	
	
	public void combination(int n, int plate1, int plate2) {
//		System.out.println(n);
		if(n==num_Pendulum) {
			weight[idx++] = Math.abs(plate1-plate2);
//			System.out.println(idx);
//			System.out.println(plate1+" "+plate2);
			return;
		}
		
		
		combination(n+1, plate1+pendulum[n], plate2);
		combination(n+1, plate1, plate2+pendulum[n]);
		combination(n+1, plate1, plate2);
	}
	public void getInput() {
		num_Pendulum = scan.nextInt();
		pendulum = new int[num_Pendulum];
		for(int i=0; i<num_Pendulum; i++) {
			pendulum[i] = scan.nextInt();
		}
		
		num_bead = scan.nextInt();
		bead = new int[num_bead];
		answer = new char[num_bead];
		for(int i=0; i<num_bead; i++) {
			bead[i] = scan.nextInt();
		}
		
		weight = new int[(int)Math.pow(3, num_Pendulum)];
	}
}
