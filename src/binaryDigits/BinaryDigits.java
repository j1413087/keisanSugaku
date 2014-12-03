package binaryDigits;

public class BinaryDigits {
	
		//10進数の2進数変換
	
	public static void main(String[] args) {
		
		double X = 270.375;
		
		int inte = (int)X; //整数部分integer
		double dec = X-inte; //小数部分decimal
		
		String BD = "";
		
		int x=inte;
		while(x!=0){
			BD = x%2 + BD;
			x = x/2;
		
		}
		
		System.out.println(BD);
		
		BD += ".";
		
		double y=dec;
		int count = 0;
		while(y!=0){
			count++;
			if(count>4)break;
			y=y*2;
			BD += (int)y;
			y=y-(int)y;
		}
		
		System.out.println(BD);
	}

}
