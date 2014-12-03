package simultaneousEquations;

import calc.Calc;

public class LUinverse {

	public static void main(String[] args) {

		double[][] A = {{2,-1,2},{-4,4,-5},{6,-7,10}};
		double[][] LU = Calc.LUdecomposition(A);
		double[][] invA = Calc.LUinverse(LU);

		//Calc.printMat(invA);
		
		for(int i=0;i<invA.length;i++){
			for(int j=0;j<invA[0].length;j++){
				System.out.print(invA[i][j]+" ");
			}
			System.out.println();
		}
		
		System.out.println("******************");
		
		Calc.printMat(LU);
	}

}

