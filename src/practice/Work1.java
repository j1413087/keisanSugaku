package practice;

import calc.Calc;

public class Work1 {//演習課題1
	
	public static void main(String[] args) {
		
		/*問１******************/
		
		System.out.println("問1");
		
		double a = Math.pow(5,9);
		double b = Math.pow(8,7);
		double root = Math.sqrt(a/b);
		
		System.out.println("(1)="+root);
		
		double sin = Math.sin(3*Math.PI/4.0);
		double Abs = sin-Math.E*Math.E*Math.sqrt(Math.log(3));
		Abs = Math.abs(Abs);
		
		System.out.println("(2)"+Abs);
		
		/*問２********************/
		
		System.out.println("問2");
		
		long Fn_old = 0;
		long Fn = 1;
		long Fn_new = 0;
		
		for(int i=1;i<50;i++){
			Fn_new = Fn + Fn_old;
			Fn_old = Fn;
			Fn = Fn_new;
		}
		System.out.println("F_50="+Fn_new);
		
		
		/*問３********************/
		
		System.out.println("問3");
		
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
		
		System.out.println("n="+n);
		System.out.println("S="+sum);
		
		
		/*問4********************/
		
		System.out.println("問4");
		
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
