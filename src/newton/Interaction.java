package newton;

abstract public class Interaction {
	
	public double eps; //許容誤差
	public double x; //初期値
	public int N; //最大反復回数
	
	public abstract double f (double x);
	
	public abstract double df (double x);
	
	//残差判定によるニュートン法
	public int newtonResidual(){ //eps:許容誤差,x:初期値,N:最大再帰回数
		double xk = x;
		int c=0; //再帰回数のカウント
		while(Math.abs(f(xk))>=eps){ //残差判定
			c++;
			//System.out.println(x);
			xk = xk-f(xk)/df(xk);
			if(c>=N){
				break;
			}
		}
		System.out.println("x_0 = "+x);
		System.out.println("x="+xk);
		System.out.println("再帰回数"+c);
		return c;
	}
	
	public int newtonResidualPrint(double a){ //収束の過程を表示
		double xk = x;
		int c=0; //再帰回数のカウント
		while(Math.abs(f(xk))>=eps){ //残差判定
			c++;
			//System.out.println(x);
			xk = xk-f(xk)/df(xk);
			System.out.println("e_"+c+"="+Math.abs(xk-a));
			if(c>=N){
				break;
			}
		}
		System.out.println("x_0 = "+x);
		System.out.println("x="+xk);
		System.out.println("再帰回数"+c);
		return c;
	}
	
	//相対誤差判定によるニュートン法(初期値0だとエラー)
	public int newtonRE(){ //eps:許容誤差,x:初期値,N:最大再帰回数
		double xk=x;
		double xk0 = 0;
		int c=0; //再帰回数のカウント
		while(Math.abs(((xk-xk0)/xk))>=eps){ //相対誤差判定
			c++;
			//System.out.println(x);
			xk0=xk;
			xk = xk-f(xk)/df(xk);
			if(c>=N){
				break;
			}
		}
		System.out.println("x_0 = "+x);
		System.out.println("x="+xk);
		System.out.println("再帰回数"+c);
		return c;
	}
	
	//残差判定によるセカント法(f(x0)>f(x1))
	public int secantResidual(double x0,double x1){ //eps:許容誤差,x0,x1:初期値,N:最大再帰回数
		double xo = x0;
		double xl = x1;
		int c=0; //再帰回数のカウント
		while(Math.abs(f(xl))>=eps){ //残差判定
			c++;
			//System.out.println(x1);
			double a = xl;
			xl = xl-f(xl)*((xl-xo)/(f(xl)-f(xo)));
			xo = a;
			if(c>=N){
				break;
			}
		}
		
		System.out.println("x_0="+x0);
		System.out.println("x_1="+x1);
		System.out.println("x="+xl);
		System.out.println("再帰回数"+c);
		return c;
	}
	
	//相対誤差判定によるセカント法(f(x0)>f(x1))
	public int secantRE(double x0,double x1){ //eps:許容誤差,x0,x1:初期値,N:最大再帰回数
		double xo = x0;
		double xl = x1;
		int c=0; //再帰回数のカウント
		while(Math.abs((xl-xo)/xl)>=eps){ //残差判定
			c++;
			//System.out.println(x1);
			double a = xl;
			xl = xl-f(xl)*((xl-xo)/(f(xl)-f(xo)));
			xo = a;
			if(c>=N){
				break;
			}
		}
		
		System.out.println("x_0="+x0);
		System.out.println("x_1="+x1);
		System.out.println("x="+xl);
		System.out.println("再帰回数"+c);
		return c;
	}
	
	//残差判定によるパラレルコード法
	public int ParallelChordRd(){ //eps:許容誤差,x:初期値,N:最大再帰回数
		double xk=x;
		double df0 = df(x);
		int c=0; //再帰回数のカウント
		while(Math.abs(f(xk))>=eps){ //残差判定
			c++;
			//System.out.println(x);
			xk = xk-f(xk)/df0;
			if(c>=N){
				break;
			}
		}
		System.out.println("x_0 = "+x);
		System.out.println("x="+xk);
		System.out.println("再帰回数"+c);
		return c;
	}
	
	//相対誤差判定によるパラレルコード法(初期値0でエラー)
	public int ParallelChordRE(){ //eps:許容誤差,x:初期値,N:最大再帰回数
		double xk=x;
		double xk0=0;
		double df0 = df(x);
		int c=0; //再帰回数のカウント
		while(Math.abs((xk-xk0)/xk)>=eps){ //残差判定
			c++;
			//System.out.println(x);
			xk = xk-f(xk)/df0;
			if(c>=N){
				break;
			}
		}
		System.out.println("x_0 = "+x);
		System.out.println("x="+xk);
		System.out.println("再帰回数"+c);
		return c;
	}
	
}