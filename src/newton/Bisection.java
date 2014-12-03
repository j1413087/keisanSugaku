package newton;

public class Bisection {

	public static void main(String[] args) {
		double a=0;
		double b=1.5; //a,b初期点
		double eps=1.0E-12;
		
		double c = 0;
		int count=0;
		while((Math.abs(b-a)/2.0)>=eps){
			count++;
			c = (a+b)/2.0;
			if((f(a)*f(c))>0){
				a=c;
			}else if((f(a)*f(c))<0){
				b=c;
			}else{
				break;
			}
			if(count>=100) break;
		}
		
		System.out.println("反復回数"+count);
		System.out.println("x="+c);
		System.out.println("|f(x)|="+Math.abs(f(c)));
		/*
		System.out.println(Math.log10(3));
		System.out.println(Math.log10(2));
		System.out.println((12+Math.log10(3))/Math.log10(2)-2.0);
		*/
	}
	
	
	static double f(double x){
		return x*x*x-2*x*x-x+2;
	}

}
