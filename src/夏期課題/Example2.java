package 夏期課題;

import newton.Interaction;

class Concrete2 extends Interaction{

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

	}

}
