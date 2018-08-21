package sse;

public class F2 {
	int[] a = {1,2,3};
	int[] b = new int[3];
	int num = 3;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		F2 obj = new F2();
		obj.dfs(0);
	}
	
	public void dfs(int n) {
		if(n==3) {
			for(int i=0; i<3; i++) {
				System.out.print(b[i]+" ");
			}
			System.out.println();
			return;
		}
				b[n] = a[n];
				dfs(n+1);
				b[n] = 0;
				dfs(n+1);
				return;
		}
}
