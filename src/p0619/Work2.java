package p0619;

//import newton.Cvg;
public class Work2 {

	//反復法と収束の速さ
	public static void main(String[] args) {
		
		double x = -5;
		double x0 = x;
		double x1 = x0+1.0;
		double eps = 1.0E-10;
		int count = 0;
		int N = 50;
		
		//f(x)=sinx/(x-1)
		//g(x)=(x-4)^4
		
		double xx = 0;
		int countMax = 0;
		while(Math.abs(((xx-x0)/x0))>=eps){ //相対誤差
			count++;
			//System.out.println(x);
			xx = x0;
			x0 = x0-f(x0)/df(x0);
			if(count==N){
				break;
			}
		}
		System.out.println("x="+x0);
		countMax = count;
		System.out.println("再帰回数"+count);
		
		count = 0;
		double a = 0;
		x0 = x;
		while(Math.abs(((x1-x0)/x0))>=eps){ //相対誤差
			count++;
			//System.out.println(x1);
			a = x1;
			x1 = x1-f(x1)*((x1-x0)/(f(x1)-f(x0)));
			x0 = a;
			if(count==N){
				break;
			}
		}
		
		System.out.println("x="+x1);
		System.out.println("再帰回数"+count);
		
		count = 0;
		x0 = x;
		xx = 0;
		double df0 = df(x0);
		while(Math.abs(((xx-x0)/x0))>=eps){ //相対誤差
			count++;
				//System.out.println(x);
				xx = x0;
				x0 = x0-f(x0)/df0;
				if(count==N){
					break;
				}
		}
		System.out.println("x="+x0);
		System.out.println("再帰回数"+count);
		
		count = 0;
		x0 = x;
		xx = 0;
		a = 2*Math.PI;
		while(Math.abs(((xx-x0)/x0))>=eps){ //相対誤差
			count++;
			xx = x0;
			x0 = x0-f(x0)/df(x0);
			if(count>(countMax-5)){
				System.out.println("(e_"+count+")="+Math.abs(x0-a));
			}
			if(count==N){
				break;
			}

		}
		
		count = 0;
		x0 = x;
		xx = 0;
		eps = 1.0E-8;
		double dg0 = dg(x0);
		while(Math.abs(((xx-x0)/x0))>=eps){ //相対誤差
			count++;
				//System.out.println(x);
				xx = x0;
				x0 = x0-g(x0)/dg0;
				if(count>=200){
					break;
				}
		}
		System.out.println("x="+x0);
		System.out.println("再帰回数"+count);
		
		/*
		x0 = x;
		x1 = x+1.0;
		Cvg.newtonRE(eps, x0, N);
		Cvg.newtonResidual(eps, x0, N);
		Cvg.ParallelChordRd(eps, x0, N);
		Cvg.ParallelChordRE(eps, x0, N);
		Cvg.secantResidual(eps, x0, x1, N);
		Cvg.secantRE(eps, x1, x0, N);
		*/
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
