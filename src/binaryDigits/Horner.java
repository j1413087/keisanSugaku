package binaryDigits;

public class Horner { //ホーナー法
	
	public static void main(String[] args) {
		
		int[] inte = {1,1,0,1}; //整数部分
		int[] dec = {0,0,1}; //小数部分
		
		int n = 2; //n進数
		
		String str = "";
		for(int i=0;i<inte.length;i++){
			str+=inte[i];
		}
		str+=".";
		for(int i=0;i<dec.length;i++){
			str+=dec[i];
		}
		System.out.println("("+str+")_"+n);
		
		
		int y=0;
		for(int i=0;i<inte.length;i++){
			y=y*2+inte[i];
		}
		
		double z=0;
		for(int i=dec.length-1;i>0;i--){
			z=(double)z/n+dec[i];
		}
		z=(double)z/n;
		
		double sum = y+z;
		
		System.out.println("("+sum+")_10");
	
	}

}
