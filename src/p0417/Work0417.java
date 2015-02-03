package p0417;

import calc.Calc;

public class Work0417 {
	
	//演習課題1の解答のためのコード
	
	public static void main(String[] args) {
		
		/*問１******************/
		
		double a = Math.pow(5,9);
		double b = Math.pow(8,7);
		double root = 0;
		
		root = Math.pow((a/b), 0.5);
		
		System.out.println(root);
		
		double sin = Math.sin(3*Math.PI/4.0);
		double Abs = sin-Math.E*Math.E*Math.pow(Math.log(3),0.5);
		Abs = Math.abs(Abs);
		
		System.out.println(Abs);
		
		/*問２********************/
		
		long Fn2 = 0;
		long Fn1 = 1;
		long Fn = 0;
		for(int i=0;i<49;i++){
			Fn2 = Fn1+Fn;
			Fn = Fn1;
			Fn1 = Fn2;
		}
		System.out.println(Fn2);
		System.out.println(Fn1);
		System.out.println(Fn);
		
		/*問３********************/
		
		double ai = 0;
		double sum = 0;
		int k=1;
		int n=0;
		do{
			n++;
			double ii = 1;
			for(int j=1;j<=k;j++){
				ii = ii*j;
			}
			ai = 1/ii;
			sum += ai;
			k++;
		}while(ai>=1.0E-8);
		
		System.out.println(sum);
		System.out.println("n="+n);
		
		/*問4********************/
		
		double[][] A = new double[3][3];
		double[][] B = new double[3][3];
		
		for(int i=0;i<A.length;i++){
			for(int j=0;j<A[i].length;j++){
				A[i][j] = (double)1/(i+j+2);
			}
		}
		
		for(int i=0;i<A.length;i++){
			for(int j=0;j<A[i].length;j++){
				B[i][j] = Math.sqrt((i+1)*(j+1));
			}
		}
		
		double[][] AB = Calc.multipleMat(A, B);
		
		for(int i=0;i<AB.length;i++){
			for(int j=0;j<AB[i].length;j++){
				System.out.print(AB[i][j] + " ");
			}
			System.out.println();
		}
	}
}
