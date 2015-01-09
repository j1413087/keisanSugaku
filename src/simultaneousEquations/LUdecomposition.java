package simultaneousEquations;

import calc.Calc;

public class LUdecomposition {
	
	double[][] A;
	double[] b;
	double[] x;
	
	LUdecomposition(double[][] A,double[] b){
		this.A = Calc.copyMat(A);
		this.b = Calc.copyVec(b);
	}
	public void LUdecompo(){
		this.x = Calc.LUsolve(this.A, this.b);
	}
	
	public static void main(String[] args) {

		double[][] A = {
				{1,2,1,2,1},
				{2,3,2,3,2},
				{1,2,3,4,5},
				{4,3,8,1,2},
				{8,2,4,1,9}
		};

		double[] b = {7,7,7,7,7};
		
		GaussElimination g = new GaussElimination(A, b);
		g.gaussElim();
		PivotingGauss p = new PivotingGauss(A, b);
		p.pivoting();
		LUdecomposition lu = new LUdecomposition(A, b);
		lu.LUdecompo();
		
		System.out.println("Gauss");
		Calc.printVec(g.x);
		System.out.println("Pvoting");
		Calc.printVec(p.x);
		System.out.println("LU");
		Calc.printVec(lu.x);
	}
}
