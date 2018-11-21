package main;

public class Problem92 {

	public static void main(String[] args) {
		int tot=0;
		for(int i=1;i<10000000;i++) {
			if(chain89(i)) {
				tot++;
			}
			if(i%100000==0)
				System.out.println(i);
		}
		System.out.println(tot);

	}
	public static boolean chain89(int a) {
		while(true) {
			if(a==1) {
				return false;
			}
			else if(a==89) {
				return true;
			}
			a=sqrDigits(a);
		}
	}
	public static int sqrDigits(int a) {
		int ans=0;
		for(char c:(a+"").toCharArray()) {
			int dig = c-'0';
			ans+=dig*dig;
		}
		return ans;
	}

}
