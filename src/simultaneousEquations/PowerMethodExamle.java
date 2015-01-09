package simultaneousEquations;

import calc.Calc;

public class PowerMethodExamle {

	public static void main(String[] args) {
		
		/*
		int n = 3;
		double[][] A = new double[n][n];
		for(int i=0;i<A.length;i++){
			A[i][i] = i+1;
		}
		*/
		
		/*
		double[][] A = {{4,2,0},
						{2,4,1},
						{0,1,4}
						};
		*/
		double[][] A = new double[10][10];
		
		for(int i=0;i<A.length;i++){
			for(int j=0;j<A[0].length;j++){
				A[i][j] = Math.pow((double)(j+1), i)/Math.pow(10, 10);
				//A[i][j] = (double)1/(i+j+1);
			}
		}
		
		double[] x = Calc.randVec(A.length);
		
		double eps = 1.0E-20;
		
		int N = 1000;
		
		//Calc.printMat(A);
		PowerMethodExamle.powerMethod(A, x, eps, N);
		
	}
	
	public static double powerMethod(double[][] A, double[] x_0, double eps, int N){

		double lambda_old = 1;
		double lambda_new = 1;

		double[] x_old = new double[x_0.length];

		//x_old←x_0
		System.arraycopy(x_0, 0, x_old, 0, x_0.length);

		double[] x_new = new double[x_old.length];

		int count = 0;
		for(int i=0;i<N;i++){
			count++;
			
			//正規化
			Calc.normalize(x_old);
			
			x_new = Calc.matVec(A, x_old);
			lambda_new = Calc.vecNormInf(x_new)/Calc.vecNormInf(x_old);

			if(Math.abs((lambda_new-lambda_old)/lambda_new)<eps){
				System.out.println("反復回数"+count+"回");
				System.out.print("絶対値最大固有値");
				System.out.println(lambda_new);
				System.out.println("固有ベクトル");
				Calc.printVec(x_new);
				return lambda_new;
			}
			
			//x_old←x_newに値を更新
			System.arraycopy(x_new, 0, x_old, 0, x_new.length);
			
			//λの更新
			lambda_old = lambda_new;
		}
		System.out.println("収束しない");
		return 0;
	}

}
