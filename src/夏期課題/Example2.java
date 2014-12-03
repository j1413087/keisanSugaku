package 夏期課題;

import newton.Interaction;

class Concrete2 extends Interaction{

	Concrete2(){
	}

	Concrete2(double E,double X,int n){
		eps = E;
		x = X;
		N = n;
	}

	public double f(double x){
		return x-11+10/x;
	}

	public double df(double x){
		return 1-10/(x*x);
	}
}

public class Example2 {

	public static void main(String[] args) {

		//Concrete2 c2 = new Concrete2(1.0E-10,15,50);
		//c2.newtonResidualPrint(10.0);

		Concrete2 c4 = new Concrete2(1.0E-10,0.1,50);
		c4.newtonResidualPrint(1.0);

	}

}
