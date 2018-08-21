package sse;

import java.util.Scanner;

public class F1 {
	Scanner scan = new Scanner(System.in);
	int ship_num;
	Ship[] ships;
	int mis_num;
	int[] check;
	Missile missile;
	int cnt, min=16;

	public class Ship{
		int x, y, energy;

		public Ship(int x, int y, int energy) {
			this.x = x;
			this.y = y;
			this.energy = energy;
		}
	}
	
	public class Missile{
		int power, range;
		
		public Missile(int power, int range) {
			this.power = power;
			this.range = range;
		}
	}
	public static void main(String[] args) {
		F1 obj = new F1();
		obj.getInput();
		obj.dfs(0);
		System.out.println(obj.min);
	}
	
	public void dfs(int n) {
		if(n==mis_num) {
			calculate();
			return;
		}
		
		for(int i=0; i<ship_num; i++) {
			attack(ships[i]);
			dfs(n+1);
			back(ships[i]);
			
		}
	}
	
	private void calculate() {
		cnt = 0;
		for(Ship newship : ships) {
			if(newship.energy>0) {
				cnt++;
			}
		}
		if(cnt<min) {
			min = cnt;
		}
		
	}

	private void back(Ship ship) {
//		ship.energy += missile.power;
		for(Ship newship: ships) {
			if(Math.abs(newship.x-ship.x)+Math.abs(newship.y-ship.y)<=missile.range) {
				newship.energy +=missile.power;

			}
		}
		
	}

	private void attack(Ship ship) {
//		ship.energy -= missile.power; 중복되나?
		for(Ship newship: ships) {
			if(Math.abs(newship.x-ship.x)+Math.abs(newship.y-ship.y)<=missile.range) {
				newship.energy -=missile.power;

			}
		}
	}

	public void getInput() {
		ship_num = scan.nextInt();
		ships = new Ship[ship_num];
		check = new int[ship_num];

		for(int i=0; i<ship_num; i++) {
			ships[i] = new Ship(scan.nextInt(), scan.nextInt(), scan.nextInt());
		}
		
		mis_num = scan.nextInt();
		missile = new Missile(scan.nextInt(), scan.nextInt());
	}
}
