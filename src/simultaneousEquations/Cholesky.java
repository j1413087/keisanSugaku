package simultaneousEquations;

import calc.Calc;

public class Cholesky {

	public static void main(String[] args) {
		
		double[][] A = {{4,-1,1},
						{-1,4.25,2.75},
						{1,2.75,3.5}
						};
		
		double[] x = new double[A[0].length];
		for(int i=0;i<x.length;i++){
			x[i]=1;
		}
		double[] b = Calc.matVec(A, x);
		
		double[][] L = Calc.choleskyDecomp(A);
		Calc.printMat(L);
		x = Calc.cholesky(A, b);
		Calc.printVec(x);

	}

}
