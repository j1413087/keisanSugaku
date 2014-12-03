package simultaneousEquations;

import calc.Calc;



public class GaussExample {
	
	public static void main(String[] args) {
		
		double[][] A = {
						{1,2,1,2,1},
						{2,3,2,3,2},
						{1,2,3,4,5},
						{4,3,8,1,2},
						{8,2,4,1,9}
						};
		
		double[] b = {7,7,7,7,7};
		
		GaussElimination g = new GaussElimination(A,b);
		g.gaussElim();
		System.out.println("A'=");
		Calc.printMat(g.A);
		System.out.println("b'=");
		Calc.printVec(g.b);
	}
	
	
}