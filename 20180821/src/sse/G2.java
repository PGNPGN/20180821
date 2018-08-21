package sse;

import java.util.Scanner;

public class G2 {
	Scanner scan = new Scanner(System.in);
	int distance;
	int num;
	int[] station_Dist;
	int[] station_Time;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		G2 obj = new G2();
		obj.getInput();
		obj.process(0,0,0);
	}
	public void process(int dist, int time, int index) {
		System.out.println("dist = "+dist+" time + "+time+" index = "+index);

		if(dist>140) {
			return;
		}
		if(index>num) {
			System.out.println(time);

		}

		for(int i=index; i<num; i++) {
			process(dist+station_Dist[i], time, i+1);
			process(0, time+station_Time[i], i+1);
		}
		

	}
	public void getInput() {
		distance = scan.nextInt();
		num = scan.nextInt();
		station_Dist = new int[num+1];
		station_Time = new int[num+1];

		for(int i=0; i<num+1; i++) {
			station_Dist[i] = scan.nextInt();
		}

		for(int i=1; i<num; i++) {
			station_Time[i] = scan.nextInt();
		}
	}
}
