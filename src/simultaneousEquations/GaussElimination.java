package simultaneousEquations;

import calc.Calc;


public class GaussElimination {
	
	double[][] A;
	double[] b;
	double[] x;
	
	GaussElimination(){
	}
	
	GaussElimination(double[][] A,double[] b){
		
		this.A = Calc.copyMat(A);
		this.b = Calc.copyVec(b);
		
	}
	
	public void gaussElim(){
		Calc.ForElim(this.A,this.b);
		this.x = Calc.backSubst(this.A,this.b);
	}

}
