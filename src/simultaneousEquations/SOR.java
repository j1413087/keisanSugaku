package simultaneousEquations;

import calc.Calc;

public class SOR {

	public static void main(String[] args) {

		double[][] A = {{6,1,1,1,0},
						{1,7,1,1,1},
						{0,1,8,1,1},
						{0,0,1,9,1},
						{0,0,0,1,10}
						};
		double[] b = {9,11,11,11,11};
		double[] x = new double [A[0].length];
		double eps = 1.0E-10; //許容誤差
		int N = 100; //最大反復回数
		double omega = 1.5; //加速パラメータ

		x = Calc.SOR(6,A, x, b, eps, N,omega);
		System.out.println("x=");
		Calc.printVec(x);
	}

}


