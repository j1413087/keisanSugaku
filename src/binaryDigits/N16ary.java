package binaryDigits;

public class N16ary {

	//10進数の16進数変換
	
	public static void main(String[] args) {

		double X = 270.375;

		int inte = (int)X; //整数部分integer
		double dec = X-inte; //小数部分decimal

		String ary16 = "";
		
		char[] c = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
		
		int x=inte;
		while(x!=0){
			ary16 = c[x%16] + ary16;
			x = x/16;

		}

		System.out.println(ary16);
		
		ary16 += ".";

		double y=dec;
		int count = 0;
		while(y!=0){
			count++;
			if(count>4)break;
			y=y*16;
			ary16 += c[(int)y];
			y=y-(int)y;
		}

		System.out.println(ary16);
	}

}
