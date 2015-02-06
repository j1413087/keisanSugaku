package practice;

public class Work4 { //演習課題4

	public static void main(String[] args) {
		double x0 = -10; //初期値
		double eps = 1.0E-13;
		int N = 100; //最大反復回数
		double a = -3.0 ; //真の解
		int countMax = 0;
		
		countMax = newton(x0,eps,N);
		newtonCount(x0, a, eps, countMax, N);
		
		x0 = 10;
		
		countMax = newton(x0,eps,N);
		newtonCount(x0, a, eps, countMax, N);
		
	}
	
	static int newton(double x0, double eps, int N) {
		int count = 0; //反復回数のカウント
		double x = x0;
		do{
			count++;
			x = x-f(x)/df(x);
			if(count==N){
				break;
			}
		}while(Math.abs(f(x))>=eps); //残差判定
		
		return count;
	}
	
	static void newtonCount(double x0, double xTrue, double eps,int countMax, int N){
		
		System.out.println("初期値x0="+x0);
		
		int count = 0;
		double x = x0;
		do{
			count++;
			if(count>(countMax-5)){
				System.out.println("(e_"+count+")="+Math.abs(x-xTrue));
			}
			x = x-f(x)/df(x);
			if(count==N){
				break;
			}
		}while(Math.abs(f(x))>=eps); //残差判定
		
		System.out.println("x="+x);
	}
	
	
	static double f (double x){ //f(x)=x^3+x^2-5x+3
		return x*x*x+x*x-5*x+3;
	}
	
	static double df (double x){ //df(x)=3x^2+2x-5
		return 3*x*x+2*x-5;
	}

}

