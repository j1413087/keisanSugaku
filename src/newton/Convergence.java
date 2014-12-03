package newton;

public class Convergence {

	public static void main(String[] args) { //ニュートン法の収束の速さ
		double x = -10;
		double x0 = x;
		//double x1 = 4.0;
		double eps = 1.0E-13;
		int N = 100; //最大反復回数
		double a = -3.0 ; //真の解
		int count = 0;
		int countMax = 0;
		
		while(Math.abs(F(x))>=eps){ //残差判定
			count++;
			x = x-F(x)/f(x);
			if(count==N){
				break;
			}
		}
		countMax = count;
		count = 0;
		
		x = x0;
		while(Math.abs(F(x))>=eps){ //残差判定
			count++;
			if(count>(countMax-5)){
				System.out.println("(e_"+count+")="+Math.abs(x-a));
			}
			x = x-F(x)/f(x);
			if(count==N){
				break;
			}
		}
		System.out.println("再帰回数"+count);
	
	}
	
	static double F (double x){
		return x*x*x+x*x-5*x+3;
	}
	
	static double f (double x){
		return 3*x*x+2*x-5;
	}

}
