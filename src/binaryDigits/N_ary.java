package binaryDigits;

public class N_ary {

	//10進数のn進数変換(2~16進数)

	public static void main(String[] args) {

		double X = 270.375;
		
		int n = 16; //n進数
		int inte = (int)X; //整数部分integer
		double dec = X-inte; //小数部分decimal
		
		
		String aryN = "";

		char[] c = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};

		int x=inte;
		while(x!=0){
			aryN = c[x%n] + aryN;
			x = x/n;

		}

		aryN += ".";

		double y=dec;
		int count = 0;
		while(y!=0){
			count++;
			if(count>4)break;
			y=y*n;
			aryN += c[(int)y];
			y=y-(int)y;
		}

		System.out.println("("+X+")_10");
		System.out.println("↓");
		System.out.println("("+aryN+")_"+n);

	}

}
