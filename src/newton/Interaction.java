package newton;

//ニュートン法、セカント法、PC法の2つの誤差判定をメソッド化

//関数メソッドfとdfは抽象クラスのため、使用する際は、
//このクラスを継承したサブクラスのインスタンスを作り、Fとfをオーバーライドすること。

abstract public class Interaction {
	
	public double eps; //許容誤差
	public double x; //初期値
	public int N; //最大反復回数
	
	public abstract double f (double x);
	
	public abstract double df (double x);
	
	//残差判定によるニュートン法
	public void newtonResidual(double x0, double eps, int N){ //eps:許容誤差,x0:初期値,N:最大再帰回数
		
		double x = x0;
		int count = 0; //反復回数
		do{
			count++;
			//System.out.println(x);
			x = x-f(x)/df(x);
			if(count==N){
				break;
			}
		}while(Math.abs(f(x))>=eps); //残差判定
		
		System.out.println("x_0 = "+x);
		System.out.println("x="+x);
		System.out.println("反復回数"+count);
		
	}
	
	//相対誤差判定によるニュートン法
	public void newtonRE(double x0, double eps, int N){ //eps:許容誤差,x0:初期値,N:最大再帰回数
		double x_new = x0;
		double x_old = x0;
		int count=0; //反復回数
		do{
			count++;
			//System.out.println(x);
			x_old = x_new;
			x_new = x_old-f(x_old)/df(x_old);
			if(count==N){
				break;
			}
		}while(Math.abs(((x_new-x_old)/x_new))>=eps); //相対誤差判定
		
		System.out.println("x_0 = "+x);
		System.out.println("x="+x_new);
		System.out.println("反復回数"+count);

	}
	
	//残差判定によるセカント法
	public void secantResidual(double x_new, double x_old, double eps, int N){ //eps:許容誤差,x_old,x_new:初期値,N:最大再帰回数
		int count=0; //再帰回数のカウント
		do{
			count++;
			//System.out.println(x1);
			double xk = x_new;
			x_new = x_new-f(x_new)*((x_new-x_old)/(f(x_new)-f(x_old)));
			x_old = xk;
			if(count==N){
				break;
			}
		}while(Math.abs(f(x_new))>=eps); //残差判定
		
		System.out.println("x="+x_new);
		System.out.println("反復回数"+count);
		
	}
	
	//相対誤差判定によるセカント法(f(x0)>f(x1))
	public void secantRE(double x_new, double x_old, double eps, int N){ //eps:許容誤差,x_old,x_new:初期値,N:最大再帰回数;

		int count=0; //反復回数
		do{
			count++;
			//System.out.println(x1);
			double xk = x_new;
			x_new = x_new-f(x_new)*((x_new-x_old)/(f(x_new)-f(x_old)));
			x_old = xk;
			if(count==N){
				break;
			}
		}while(Math.abs((x_new-x_old)/x_new)>=eps); //相対誤差判定
		
		System.out.println("x="+x_new);
		System.out.println("再帰回数"+count);
		
	}
	
	//残差判定によるパラレルコード法
	public void ParallelChordRd(double x0, double eps, int N){ //eps:許容誤差,x0:初期値,N:最大再帰回数
		double x=x0;
		double df0 = df(x);
		int count=0; //反復回数のカウント
		do{
			count++;
			//System.out.println(x);
			x = x-f(x)/df0;
			if(count==N){
				break;
			}
		}while(Math.abs(f(x))>=eps); //残差判定
		
		System.out.println("x_0 = "+x0);
		System.out.println("x="+x);
		System.out.println("反復回数"+count);

	}
	
	//相対誤差判定によるパラレルコード法(初期値0でエラー)
	public void ParallelChordRE(double x0, double eps, int N){ //eps:許容誤差,x0:初期値,N:最大再帰回数
		double x_new = x0, x_old = x0;
		double df0 = df(x0);
		int count=0; //再帰回数のカウント
		do{
			count++;
			x_old = x_new;
			//System.out.println(x);
			x_new = x_new-f(x_new)/df0;
			if(count==N){
				break;
			}
		}while(Math.abs((x_new-x_old)/x_new)>=eps); //相対誤差判定
		
		System.out.println("x_0 = "+x0);
		System.out.println("x="+x_new);
		System.out.println("反復回数"+count);
		
	}
	
}