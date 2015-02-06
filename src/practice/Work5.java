package practice;

public class Work5 { //演習課題5

	//反復法と収束の速さ
	public static void main(String[] args) {
		
		double x0; //初期値
		double x_old ; //反復解の保存
		double x_new ;
		double eps = 1.0E-10; //許容誤差
		int N = 50; //最大反復回数
		
		//f(x)=sinx/(x-1)
		//g(x)=(x-4)^4
		
		System.out.println("問1");
		
		x0 = 5; //初期値5
		x_old = x_new = x0;
		
		//処理と同時にニュートン法の反復回数の保持
		int countNewton = comparison(x0, x_old, x_new, eps, N);
		
		x0 = -5; //初期値-5
		x_old = x_new = x0;
		comparison(x0, x_old, x_new, eps, N);
		
		/************************/
		
		System.out.println("問2");
		
		x0 = 5;
		x_old = x_new = x0;
		double a = 2*Math.PI; //真の解
		int count = 0; //反復回数の保持
		
		do{
			count++;
			x_old = x_new;
			x_new = x_old-f(x_old)/df(x_old);
			if(count>(countNewton-5)){
				System.out.println("(e_"+count+")="+Math.abs(x_new-a));//誤差の表示
			}
			if(count==N){
				break;
			}

		}while(Math.abs(((x_new-x_old)/x_new))>=eps);//相対誤差
		
		
		/************************/
		
		System.out.println("問3");
		
		x0 = 5;
		x_old = x_new = x0;
		eps = 1.0E-8;
		N = 200;
		double dg0 = dg(x_old);
		count = 0;
		
		do{
			count++;
				//System.out.println(x);
				x_old = x_new;
				x_new = x_old-g(x_old)/dg0;
				if(count>=200){
					break;
				}
		}while(Math.abs(((x_new-x_old)/x_new))>=eps); //相対誤差
		
		System.out.println((count<N)?("反復回数"+count):("収束しない"));

	}
	/**
	 * 3つの反復法を行う
	 * @param x0 初期値
	 * @param x_old 古い解(最初はx0)
	 * @param x_new 新しい解
	 * @param eps 許容誤差
	 * @param N 最大反復回数
	 * @return ニュートン法の反復回数
	 */
	static int comparison(double x0,double x_old, double x_new, double eps, int N){
		
		System.out.println("初期値x0="+x0);
		System.out.println("ニュートン法");
		
		int count = 0;
		
		do {
			count++;
			//System.out.println(x);
			x_old = x_new; //解の更新
			x_new = x_old-f(x_old)/df(x_old);
			
			if(count==N){
				break;
			}
		}while(Math.abs((x_new-x_old)/x_new)>=eps);
		
		System.out.println("x="+x_new);
		System.out.println((count<N)?("反復回数"+count):("収束しない"));
		
		int countNewton = count; //ニュートン法の反復回数の保持
		
		
		/**************************/
		
		System.out.println("セカント法");
		
		count = 0;
		x_old = x0;
		x_new = x_old+1.0;
		
		do {
			count++;
			//System.out.println(x1);
			double xk = 0; //解の更新
			xk = x_new;
			x_new = x_new-f(x_new)*((x_new-x_old)/(f(x_new)-f(x_old)));
			x_old = xk;
			if(count==N){
				break;
			}
		}while(Math.abs(((x_new-x_old)/x_new))>=eps); //相対誤差
		
		System.out.println("x="+x_new);
		System.out.println((count<N)?("反復回数"+count):("収束しない"));
		
		/*************************/
		
		System.out.println("パラレルコード法");
		
		count = 0;
		x_old = x_new = x0;
		double df0 = df(x0); //df(x0)の保存
		
		do {
			count++;
				//System.out.println(x);
				x_old = x_new; //解の更新
				x_new = x_old-f(x_old)/df0;
				if(count==N){
					break;
				}
		}while(Math.abs(((x_new-x_old)/x_new))>=eps); //相対誤差
		
		System.out.println("x="+x_new);
		System.out.println((count<N)?("反復回数"+count):("収束しない"));
		
		return countNewton;
	}
	static double f (double x){
		return Math.sin(x)/(x-1);
	}
	
	static double df (double x){
		return ((Math.cos(x)*(x-1)-Math.sin(x))/((x-1)*(x-1)));
	}
	
	static double g (double x){
		return Math.pow((x-1),4);
	}
	
	static double dg (double x){
		return 4*Math.pow((x-1),3);
	}
	
}
