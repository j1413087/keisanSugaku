package 夏期課題;

import newton.Interaction;

class Concrete1 extends Interaction{
	
	Concrete1(){
	}
	
	Concrete1(double E,double X,int n){
		eps = E;
		x = X;
		N = n;
	}
	
	public double f(double x){
		return x*x-11*x+10;
	}
	
	public double df(double x){
		return 2*x-11;
	}
}

public class Example1 {
	public static void main(String[] args) {
		
		//Concrete1 c1 = new Concrete1(1.0E-10,15,50);
		//c1.newtonResidualPrint(10.0);
		
		Concrete1 c3 = new Concrete1(1.0E-10,0.1,50);
		c3.newtonResidualPrint(1.0);

	}

}
