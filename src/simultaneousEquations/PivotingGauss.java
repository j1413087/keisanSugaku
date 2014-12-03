package simultaneousEquations;

import calc.Calc;


public class PivotingGauss{
	
	double[][] A;
	double[] b;
	double[] x;
	
	PivotingGauss(){
	}
	
	PivotingGauss(double[][] A,double[] b){
		
		this.A = new double[A.length][A[0].length];
		for(int i=0;i<A.length;i++){
			for(int j=0;j<A[i].length;j++){
				this.A[i][j] = A[i][j];
			}
		}
		
		this.b = new double[b.length];
		for(int i=0;i<b.length;i++){
				this.b[i] = b[i];
		}
		
		this.x = new double[A.length];
		
	}

	public void pivoting() {
		
		for(int k=0;k<A[0].length-1;k++){
			int l=0; //行番号の保持
			double a_lk = 0; //最大成分を保持
			for(int i=k;i<A[0].length;i++){
				if( a_lk < Math.abs(A[i][k]) ){
					a_lk = Math.abs(A[i][k]);
					l=i;
				}
			}
			if(a_lk <1.0E-20){
				System.out.println("計算できません");
			}
			Calc.SwitchRow(A, k, l);
			Calc.Switch(b, k, l);
			
			for(int i=k+1;i<A.length;i++){
				double alpha = A[i][k]/A[k][k];
				for(int j=k+1;j<A[0].length;j++){
					A[i][j]=A[i][j]-alpha*A[k][j];
				}
				b[i]=b[i]-alpha*b[k];
			}
		}
		
		this.x = Calc.backSubst(this.A,this.b); //後退代入
	}
	

}
