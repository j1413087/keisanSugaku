package practice;

public class Work3 { //演習課題3

	public static void main(String[] args) {

		double x0 = 4; //初期値
		double x_old ; //反復解の保存
		double x_new ;
		double eps = 1.0E-10; //許容誤差
		int N = 50; //最大反復回数

		Judge error = new Judge(){ //相対誤差判定の実装
			@Override
			public boolean judge(double x_new, double x_old, double eps){
				return Math.abs((x_new-x_old)/x_new)>=eps;
			}
			public void print(){
				System.out.println("---収束判定として相対誤差を用いる---");
			}
		};

		x_old = x_new = x0;
		comparison(error, x0, x_old, x_new, eps, N);

		Judge residual = new Judge(){ //残差判定の実装
			@Override
			public boolean judge(double x_new, double x_old, double eps){
				return Math.abs(f(x_new))>=eps;
			}
			public void print(){
				System.out.println("---収束判定として残差を用いる---");
			}
		};

		x_old = x_new = x0;
		comparison(residual, x0, x_old, x_new, eps, N);

	}

	static int comparison(Judge j,double x0,double x_old, double x_new, double eps, int N){

		j.print();

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
		}while(j.judge(x_new, x_old, eps));

		System.out.println((count<N)?("反復回数"+count):("収束しない"));

		int countNewton = count; //ニュートン法の反復回数の保持


		/**************************/

		System.out.println("セカント法");

		count = 0;
		x_old = x0;
		x_new = x_old-1.0;

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
		}while(j.judge(x_new, x_old, eps));

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
		}while(j.judge(x_new, x_old, eps));

		System.out.println((count<N)?("反復回数"+count):("収束しない"));

		return countNewton;
	}

	static double f (double x){
		return x*x-5;
	}

	static double df (double x){
		return 2.0*x;
	}

}

abstract interface Judge{
	boolean judge(double x_new, double x_old, double eps);
	void print();
}
