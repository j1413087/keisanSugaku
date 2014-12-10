package simultaneousEquations;

import calc.Calc;

public class Hilbert {

	public static void main(String[] args) {
		
		int n = 12;
		System.out.println("n="+n);
		
		double[][] A = new double[n][n];
		A = Calc.hilbert(A);
		
		double[][] invA = Calc.inverse(A);
		
		//(1)
		double kapInfA = Calc.matNormInf(A)*Calc.matNormInf(invA);
		System.out.println("(1)Κ∞="+kapInfA);
		
		//(2)
		double[] x = new double[A.length]; //xの全成分に1を入れる
		for(int i=0;i<x.length;i++){
			x[i]=1;
		}
		double[] b = Calc.matVec(A, x);
		/*
		System.out.println("b=");
		Calc.printVec(b);
		*/
		
		PivotingGauss g1 = new PivotingGauss(A,b);//ピボット選択付きガウスの消去法
		g1.pivoting();
		/*
		System.out.println("x1=");
		Calc.printVec(g1.x);
		*/

		System.out.println("(2)||b-Ax_1||_∞="+Calc.residualNormInf(A, g1.x, b));
		System.out.println("   ||x^*-x1||_∞="+Calc.vecNormInf(Calc.subVec(x, g1.x)));
		
		//(3)
		/*
		double[] db = new double[b.length];
		db[0] = 0.001*b[0];
		
		double sup = kapInfA*Calc.vecNormInf(db)/Calc.vecNormInf(b);
		System.out.println("(3)sup="+sup);
		*/
		//(4)
		PivotingGauss g2 = new PivotingGauss(A,b/*(Calc.addVec(b, db))*/);
		g2.pivoting();
		System.out.println("(4)||x^*-x2||_∞="+Calc.vecNormInf(Calc.subVec(x, g2.x)));
		System.out.println("(4)相対残差∞="+Calc.vecNormInf(Calc.residual(A, g2.x,b))/Calc.vecNormInf(b));
		System.out.println("(4)||x^*-x2||_∞/||x^*||_∞="+Calc.vecNormInf(Calc.subVec(x, g2.x))/Calc.vecNormInf(x));
	}

}
