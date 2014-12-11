package simultaneousEquations;

import calc.Calc;

public class PivotingExample {

	public static void main(String[] args) {

		PivotingGauss[] p = new PivotingGauss[100];
		GaussElimination[] g = new GaussElimination[100];
		double[] NormP = new double[100];
		double[] NormG = new double[100];

		for(int i=0;i<100;i++){
			double[][] A = Calc.randMat(100,100);
			double[]b = new double[A.length];
			b = Calc.randVec(b);

			p[i] = new PivotingGauss(A,b);
			g[i] = new GaussElimination(A,b);

			p[i].pivoting();
			g[i].gaussElim();
			
			NormP[i] = Calc.vecNorm2(Calc.residual(A, p[i].x, b));
			NormG[i] = Calc.vecNorm2(Calc.residual(A, g[i].x, b));
			
		}
		
		System.out.println("***************Pivot選択なし***************");
		Calc.printVec(NormG);
		System.out.println("***************Pivot選択あり***************");
		Calc.printVec(NormP);
	}
}
