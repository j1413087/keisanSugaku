package 冬期課題;

import simultaneousEquations.GaussElimination;
import simultaneousEquations.PivotingGauss;
import calc.Calc;
public class Example {

	public static void main(String[] args) {
		
		
		double[][] A2 = new double[2][2];
		
		for(int i=0;i<A2.length;i++){
			for(int j=0;j<A2[0].length;j++){
				A2[i][j] = Math.pow((j+1), i);
			}
		}
		
		double[][] invA2 = Calc.inverse(A2);
		double kapInfA2 = Calc.matNormInf(A2)*Calc.matNormInf(invA2);
		System.out.println("(1)Κ∞(2)="+kapInfA2);
		
		
		double[][] A5 = new double[5][5];
		
		for(int i=0;i<A5.length;i++){
			for(int j=0;j<A5[0].length;j++){
				A5[i][j] = Math.pow((j+1), i);
			}
		}
		
		double[][] invA5 = Calc.inverse(A5);
		double kapInfA5 = Calc.matNormInf(A5)*Calc.matNormInf(invA5);
		System.out.println("(2)Κ∞(5)="+kapInfA5);
		
		
		double[][] A10 = new double[10][10];
		
		for(int i=0;i<A10.length;i++){
			for(int j=0;j<A10[0].length;j++){
				A10[i][j] = Math.pow((j+1), i);
			}
		}
		
		double[][] invA10 = Calc.inverse(A10);
		double kapInfA10 = Calc.matNormInf(A10)*Calc.matNormInf(invA10);
		System.out.println("(3)Κ∞(10)="+kapInfA10);
		
		
		double[][] A50 = new double[50][50];
		
		for(int i=0;i<A50.length;i++){
			for(int j=0;j<A50[0].length;j++){
				A50[i][j] = Math.pow((j+1), i);
			}
		}
		
		double[][] invA50 = Calc.inverse(A50);
		double kapInfA50 = Calc.matNormInf(A50)*Calc.matNormInf(invA50);
		System.out.println("(4)Κ∞(50)="+kapInfA50);
		
		
		double[][] A100 = new double[100][100];
		
		for(int i=0;i<A100.length;i++){
			for(int j=0;j<A100[0].length;j++){
				A100[i][j] = Math.pow((j+1), i);
			}
		}
		
		double[][] invA100 = Calc.inverse(A100);
		double kapInfA100 = Calc.matNormInf(A100)*Calc.matNormInf(invA100);
		System.out.println("(5)Κ∞(100)="+kapInfA100);
		
		
		double[][] A01 = new double[10][10];
		
		for(int i=0;i<A01.length;i++){
			for(int j=0;j<A01[0].length;j++){
				A01[i][j] = 1/Math.pow((j+1), i);
			}
		}
		
		double[][] invA01 = Calc.inverse(A01);
		double kapInfA01 = Calc.matNormInf(A01)*Calc.matNormInf(invA01);
		System.out.println("(6)Κ∞(01)="+kapInfA01);
		
		
		double[] x = new double[A10[0].length];
		for(int i=0;i<x.length;i++){
			x[i] = 1;
		}
		double[] b = Calc.matVec(A10, x);
		GaussElimination g = new GaussElimination(A10, b);
		g.gaussElim();
		Calc.printVec(g.x);
		System.out.println("(g)||b-Ax||_∞="+Calc.residualNormInf(A10, g.x, b));
		
		PivotingGauss p = new PivotingGauss(A10, b);
		p.pivoting();
		System.out.println("(p)||b-Ax||_∞="+Calc.residualNormInf(A10, p.x, b));
		
		double[] LUx = Calc.LUsolve(A10, b);
		System.out.println("(L)||b-Ax||_∞="+Calc.residualNormInf(A10, LUx, b));
		
		double[] chx = Calc.cholesky(A10, b);
		System.out.println("(c)||b-Ax||_∞="+Calc.residualNormInf(A10, chx, b));
		
		double[] db = new double[b.length];
		System.arraycopy(b, 0, db, 0, b.length);
		db[0] += 0.001*b[0];
		
		
		GaussElimination g2 = new GaussElimination(A10, db);
		g2.gaussElim();
		Calc.printVec(g2.x);
		System.out.println("(g2)||b-Ax||_∞="+Calc.residualNormInf(A10, g2.x, db));
		
		PivotingGauss p2 = new PivotingGauss(A10, db);
		p.pivoting();
		System.out.println("(p2)||b-Ax||_∞="+Calc.residualNormInf(A10, p2.x, db));
		
		double[] LUx2 = Calc.LUsolve(A10, db);
		System.out.println("(L2)||b-Ax||_∞="+Calc.residualNormInf(A10, LUx2, db));
		
		double[] chx2 = Calc.cholesky(A10, db);
		System.out.println("(c2)||b-Ax||_∞="+Calc.residualNormInf(A10, chx2, db));
	}
	
	static double[][]  Vandermonde (int n){
		double[][] V = new double[n][n];
		for(int i=0;i<V.length;i++){
			for(int j=0;j<V[0].length;j++){
				V[i][j] = Math.pow((j+1), i);
			}
		}
		return V;
	}

}

