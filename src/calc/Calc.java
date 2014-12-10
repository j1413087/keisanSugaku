package calc;


public class Calc {

	public static void printVec(double[] x){ //ベクトルの出力
		for(int i=0;i<x.length;i++){
			System.out.println(x[i]);
		}
	}

	public static void printMat(double[][] A){ //行列の出力
		for(int i=0;i<A.length;i++){
			for(int j=0;j<A[0].length;j++){
				System.out.printf("%5.1f",A[i][j]);
			}
			System.out.println();
		}
	}

	public static double[] scalarMultiple (double c,double[] x){ //ベクトルのスカラーc倍
		for(int i=0;i<x.length;i++){
			x[i]=c*x[i];
		}
		return x;
	}

	/**
	 * 行列のディープコピー
	 * @param A コピー元
	 * @return A
	 */
	public static double[][] copyMat(double[][] A){

		double[][] X = new double[A.length][A[0].length];
		for(int i=0;i<A.length;i++){
			for(int j=0;j<A[i].length;j++){
				X[i][j] = A[i][j];
			}
		}
		return X;
	}

	/**
	 * ベクトルのディープコピー
	 * @param b コピー元
	 * @return b
	 */
	public static double[] copyVec(double[] b){

		double[] x = new double[b.length];
		for(int i=0;i<b.length;i++){
			x[i] = b[i];
		}
		return x;
	}

	public static double[] addVec (double[] x,double[] y){ //ベクトル同士の加算
		if(x.length!=y.length){
			System.out.println("計算できません");
			return null;
		}
		double[] a = new double [x.length];
		for(int i=0;i<x.length;i++){
			a[i]=x[i]+y[i];
		}
		return a;
	}

	public static double[] subVec (double[] x,double[] y){ //ベクトル同士の減算
		if(x.length!=y.length){
			System.out.println("計算できません");
			return null;
		}
		double[] a = new double [x.length];
		for(int i=0;i<x.length;i++){
			a[i]=x[i]-y[i];
		}
		return a;
	}

	public static double innProd(double[] x,double[] y){ //ベクトル同士の内積
		if(x.length!=y.length){
			System.out.println("計算できません");
			return 0;
		}
		double a=0;
		for(int i=0;i<x.length;i++){
			a+=x[i]*y[i];
		}
		return a;
	}

	public static double[] matVec (double[][] A,double[] x){ //行列Aとベクトルxの積
		double[] a = new double [A.length];
		if(A[0].length!=x.length){
			System.out.println("計算できません");
			return null;
		}
		for(int i=0;i<A.length;i++){
			for(int j=0;j<x.length;j++){
				a[i] += A[i][j]*x[j];
			}
		}
		return a;
	}

	/**
	 * 残差(Ax-b)の計算
	 * @param A 行列
	 * @param x ベクトル
	 * @param b ベクトル
	 * @return Ax-b
	 */
	public static double[] residual (double[][] A,double[] x,double[] b){ //Ax-b(残差)の計算
		return subVec(matVec(A,x),b);
	}

	public static double residualNorm2 (double[][] A,double[] x,double[] b){ //Ax-b(残差)のノルム
		return vecNorm2(residual(A, x, b));
	}
	/**
	 * 残差∞ノルム
	 * @param A
	 * @param x
	 * @param b
	 * @return ||Ax-b||_∞
	 */
	public static double residualNormInf(double[][] A,double[] x,double[] b){
		return vecNormInf(residual(A, x, b));
	}

	public static double[][] addMat (double[][] A,double[][] B){ //行列の加算
		if(A.length!=B.length
				||A[0].length!=B[0].length){
			System.out.println("計算できません");
			return null;
		}
		double[][]AB = new double[A.length][A[0].length];
		for(int i=0;i<A.length;i++){
			for(int j=0;j<A[0].length;j++){
				AB[i][j]=A[i][j]+B[i][j];
			}
		}
		return AB;
	}

	public static double[][] multipleMat (double[][] A,double[][] B){ //行列の積
		if(A[0].length!=B.length){
			System.out.println("計算できません");
			return null;
		}
		double[][] AB = new double[A.length][B[0].length];
		for(int i=0;i<A.length;i++){
			for(int j=0;j<A[0].length;j++){
				for(int k=0;k<A[0].length;k++){
					AB[i][j]+=A[i][k]*B[k][j];
				}
			}
		}
		return AB;
	}
	/**
	 * n×nの単位行列
	 * @param n n×n行列
	 * @return n×n単位行列
	 */
	public static double[][] identityMat(int n){
		double[][] E = new double[n][n];
		for(int i=0;i<E.length;i++){
			E[i][i]=1;
		}
		return E;
	}
	/**
	 * 転置行列
	 * @param A
	 * @return tA
	 */
	public static double[][] transMat(double[][] A){
		double[][] tA = new double[A[0].length][A.length];
		for(int i=0;i<A[0].length;i++){
			for(int j=0;j<A.length;j++){
				tA[i][j]=A[j][i];
			}
		}
		return tA;
	}

	public static double vecNorm1(double[] x){ //ベクトルの1ノルム
		double a=0;
		for(int i=0;i<x.length;i++){
			a+=Math.abs(x[i]);
		}
		return a;
	}

	public static double vecNorm2(double[] x){ //ベクトルの2ノルム
		double a=0;
		for(int i=0;i<x.length;i++){
			a+=x[i]*x[i];
		}
		return Math.sqrt(a);
	}

	public static double vecNormInf(double[] x){ //ベクトルの∞ノルム
		double a=0;
		for(int i=0;i<x.length;i++){
			if(Math.abs(x[i])>a){
				a=Math.abs(x[i]);
			}
		}
		return a;
	}
	
	public static double vecNormP(double[] x,int p){
		double a=0;
		for(int i=0;i<x.length;i++){
			a+=x[i]*x[i];
		}
		return Math.pow(a,(double)1/p);
	}

	public static double matNorm1(double[][] A){ //行列の1ノルム
		double a=0;
		double aj=0;
		double[][] tA= transMat(A);

		for(int i=0;i<tA.length;i++){
			aj=vecNorm1(tA[i]);
			if(aj>a){
				a=aj;
			}
		}
		return a;
	}

	public static double matNormInf(double[][] A){ //行列の∞ノルム
		double a=0;
		double ai=0;
		for(int i=0;i<A.length;i++){
			ai=vecNorm1(A[i]);
			if(ai>a){
				a=ai;
			}
		}
		return a;
	}
	
	/**
	 * フロベニウスノルム
	 * @param A 行列
	 * @return double
	 */
	public static double  frobeniusNorm(double[][] A){
		double norm = 0;
		for(int i=0;i<A.length;i++){
			for(int j=0;j<A[0].length;j++){
				norm += A[i][j]*A[i][j];
			}
		}
		norm = Math.sqrt(norm);
		return norm;
	}

	public static double[][] randMat(double[][] A){ //ランダム行列の生成
		for(int i=0;i<A.length;i++){
			for(int j=0;j<A[i].length;j++){
				A[i][j] = Math.random();
			}
		}
		return A;
	}

	public static double[] randVec(double[] b){ //ランダムベクトルの生成
		for(int i=0;i<b.length;i++){
			b[i] = Math.random();
		}
		return b;
	}

	/**
	 * 行列の行入れ替え
	 * @param A 行列
	 * @param k 入れ替える行
	 * @param l 入れ替える行
	 * @return 入れ替えた行列
	 */
	public static double[][] SwitchRow(double[][] A, int k, int l){
		for(int j=k;j<A[0].length;j++){ //第k行と第l行の入れ替え
			double c = 0;
			c=A[k][j];
			A[k][j]=A[l][j];
			A[l][j]=c;
		}
		return A;
	}

	/**
	 * 配列の成分の入れ替え
	 * @param b 配列(ベクトル)
	 * @param k 入れ替える番号
	 * @param l 入れ替える番号
	 * @return 入れ替えた配列(ベクトル)
	 */
	public static double[] Switch(double[] b, int k, int l){
		double a=b[k];
		b[k]=b[l];
		b[l]=a;

		return b;
	}

	/**
	 * 前進消去法
	 * @param A 行列
	 * @param b ベクトル
	 */
	public static void ForElim(double[][] A,double[] b) {

		for(int k=0;k<A.length;k++){
			for(int i=k+1;i<A.length;i++){
				double alpha = A[i][k]/A[k][k];
				for(int j=k+1;j<A[0].length;j++){
					A[i][j]=A[i][j]-alpha*A[k][j];
				}
				b[i]=b[i]-alpha*b[k];
			}
		}
	}

	/**
	 * 後退代入法
	 * @param A 行列
	 * @param b ベクトル
	 * @return 解xベクトル
	 */
	public static double[] backSubst(double[][]A,double[]b){
		double[] x = new double[b.length];

		for(int k=A.length-1;k>=0;k--){
			x[k] = b[k];
			for(int j=k+1;j<A[0].length;j++){
				x[k] = x[k] - A[k][j]*x[j];
			}
			x[k] = x[k]/A[k][k];
		}
		return x;
	}

	/**
	 * ピボット選択あり前進消去法
	 * @param A 行列
	 * @param b ベクトル
	 */
	public static void pivoting(double[][] A,double[] b) {

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

	}

	/**
	 * LU分解(A=LU)
	 * @param A 行列
	 * @return LU
	 */
	public static double[][] LUdecomposition(double[][] A){

		double[][] LU = new double [A.length][A[0].length];
		LU = copyMat(A);

		for(int k=0;k<LU.length;k++){
			for(int i=k+1;i<LU.length;i++){
				double alpha = LU[i][k]/LU[k][k];
				LU[i][k] = alpha;
				for(int j=k+1;j<LU[0].length;j++){
					LU[i][j]=LU[i][j]-alpha*LU[k][j];
				}
			}
		}
		return LU;
	}
	/**
	 * LU分解を用いてAx=bを解く
	 * @param A 行列
	 * @param b ベクトル
	 * @return x
	 */
	public static double[] LUsolve(double[][] A,double[] b){
		double[][] LU = LUdecomposition(A);
		double[] y = forSubst(LU, b);
		return backSubst(LU, y);
	}

	/**
	 * 前進代入(Ly=b)
	 * @param LU
	 * @param b
	 * @return y
	 */
	public static double[] forSubst(double[][] LU,double[] b){
		double[] y = new double[b.length];

		for(int k=0;k<LU.length;k++){
			y[k] = b[k];
			for(int j=k-1;j>=0;j--){
				y[k] = y[k] - LU[k][j]*y[j];
			}
			y[k] = y[k]/LU[k][k];
		}
		return y;
	}
	/**
	 * A=LUとしてA逆行列を求める
	 * @param LU
	 * @return inverseA
	 */
	public static double[][] LUinverse(double[][] LU){

		double[][] E = identityMat(LU.length);
		double[][] Y = new double[LU.length][LU.length];

		for(int i=0;i<Y.length;i++){
			Y[i] = forSubst(LU, E[i]);
		}

		double[][] X = new double[LU.length][LU.length];
		for(int i=0;i<X.length;i++){
			X[i] = backSubst(LU, Y[i]);
		}
		X = transMat(X);

		return X;
	}
	/**
	 * 逆行列を求める
	 * @param A 行列
	 * @return 逆行列A^(-1)
	 */
	public static double[][] inverse(double[][] A){
		double[][] LU = new double[A.length][A[0].length];
		LU = Calc.LUdecomposition(A);
		double[][] invA = Calc.LUinverse(LU);
		return invA;
	}

	/**
	 * Hilbert行列
	 * @param A 行列
	 * @return Hilbert行列
	 */
	public static double[][] hilbert(double[][] A){
		for(int i=0;i<A.length;i++){
			for(int j=0;j<A[0].length;j++){
				A[i][j] = (double)1/((i+1)+(j+1)-1);
			}
		}
		return A;
	}

	/**
	 * Jacobi法
	 * @param n 判定法の選択
	 * (1:相対誤差1ノルム,2:相対誤差2ノルム,3:相対誤差∞ノルム,
	 * 	4:残差1ノルム,5:残差2ノルム,6:残差∞ノルム)
	 * @param A 行列
	 * @param b ベクトル
	 * @param x_k1 初期値
	 * @param eps 許容誤差
	 * @param N 最大反復回数
	 * @return x (Ax=b)
	 */
	public static double[] jacobi(double [][] A,double[] x_old, double[] b, double eps, int N){
		double[] x_new = new double[x_old.length];
		int count = 0; //反復回数

		for(int m=0;m<N;m++){
			count++;

			for(int i=0;i<x_new.length;i++){
				x_new[i] = b[i];
				for(int j=0;j<A[0].length;j++){
					if(i!=j){
						x_new[i] = x_new[i] - A[i][j]*x_old[j];
					}
				}
				x_new[i] = x_new[i]/A[i][i];

			}

			if(residualNormInf(A, x_new, b, eps)){ //収束判定
				System.out.println("反復回数"+count+"回");
				return x_new;
			}
			
			for(int l=0;l<x_old.length;l++){ //解の更新
				x_old[l] = x_new[l];
			}
		}
		System.out.println("収束しない");
		return x_new;
	}

	/**
	 * 誤差ノルムの判定
	 * ||x1-x2||_1<ε
	 * @param x1
	 * @param x2
	 * @param eps 許容誤差
	 * @return boolean
	 */
	public static boolean errorNorm1(double[] x1,double[] x2,double eps){
		return vecNorm1(subVec(x1, x2)) < eps ;
	}
	/**
	 * 誤差ノルム2の判定
	 * ||x1-x2||_2<ε
	 * @param x1
	 * @param x2
	 * @param eps 許容誤差
	 * @return boolean
	 */
	public static boolean errorNorm2(double[] x1,double[] x2,double eps){
		return vecNorm2(subVec(x1, x2)) < eps ;
	}
	/**
	 * 誤差ノルム∞の判定
	 * ||x1-x2||_∞<ε
	 * @param x1
	 * @param x2
	 * @param eps 許容誤差
	 * @return boolean
	 */
	public static boolean errorNormInf(double[] x1,double[] x2,double eps){
		return vecNormInf(subVec(x1, x2)) < eps ;
	}

	/**
	 * 残差ノルム1の判定
	 * ||Ax-b||_1<ε
	 * @param A 行列
	 * @param x 解ベクトル
	 * @param b ベクトル
	 * @param eps 許容誤差
	 * @return boolean
	 */
	public static boolean residualNorm1(double[][] A,double[] x,double[] b,double eps){
		return vecNorm1(residual(A, x, b)) < eps ;
	}

	/**
	 * 残差ノルム2の判定
	 * ||Ax-b||_2<ε
	 * @param A 行列
	 * @param x 解ベクトル
	 * @param b ベクトル
	 * @param eps 許容誤差
	 * @return boolean
	 */
	public static boolean residualNorm2(double[][] A,double[] x,double[] b,double eps){
		return vecNorm2(residual(A, x, b)) < eps ;
	}

	/**
	 * 残差ノルム∞の判定
	 * ||Ax-b||_∞<ε
	 * @param A 行列
	 * @param x 解ベクトル
	 * @param b ベクトル
	 * @param eps 許容誤差
	 * @return boolean
	 */
	public static boolean residualNormInf(double[][] A,double[] x,double[] b,double eps){
		return vecNormInf(residual(A, x, b)) < eps ;
	}
	
	/**
	 * 相対誤差ノルム1の判定
	 * @param x_new
	 * @param x_old
	 * @param eps 許容誤差
	 * @return boolean
	 */
	public static boolean relativeErrorNorm1(double[] x_new, double[] x_old, double eps){
		return vecNorm1(subVec(x_new, x_old))/vecNorm1(x_new) < eps ;
	}
	
	/**
	 * 相対誤差ノルム2の判定
	 * @param x_new
	 * @param x_old
	 * @param eps 許容誤差
	 * @return boolean
	 */
	public static boolean relativeErrorNorm2(double[] x_new, double[] x_old, double eps){
		return vecNorm2(subVec(x_new, x_old))/vecNorm2(x_new) < eps ;
	}
	
	/**
	 * 相対誤差ノルム2の判定
	 * @param x_new
	 * @param x_old
	 * @param eps 許容誤差
	 * @return boolean
	 */
	public static boolean relativeErrorNormInf(double[] x_new, double[] x_old, double eps){
		return vecNormInf(subVec(x_new, x_old))/vecNormInf(x_new) < eps ;
	}
	
	/**
	 * 判定法の選択
	 * @param n 判定法の選択
	 * (1:誤差1ノルム,2:誤差2ノルム,3:誤差∞ノルム,
	 * 	4:残差1ノルム,5:残差2ノルム,6:残差∞ノルム)
	 * @param A 行列
	 * @param x_new 
	 * @param x_old 
	 * @param b ベクトル
	 * @param eps 許容誤差
	 * @return boolean
	 */
	public static boolean judge (int n,double[][] A,double[] x_new,double[] x_old,double[] b,double eps){
		switch(n){
			case 1:
				return errorNorm1(x_new,x_old,eps);
			case 2:
				return errorNorm2(x_new,x_old,eps);
			case 3:
				return errorNormInf(x_new,x_old,eps);
			case 4:
				return residualNorm1(A,x_new,b,eps);
			case 5:
				return residualNorm2(A,x_new,b,eps);
			case 6:
				return residualNormInf(A,x_new,b,eps);
		}
		System.out.println("判定方法がありません");
		return false;
	}
	
	/**
	 * Gauss-Seidel法
	 * @param n 判定法の選択
	 * @param A 行列
	 * @param b ベクトル
	 * @param x 初期値
	 * @param eps 許容誤差
	 * @param N 最大反復回数
	 * @return x (Ax=b)
	 */
	public static double[] gaussSeidel(int n,double [][] A,double[] x_old, double[] b, double eps, int N){
		int count = 0; //反復回数
		double[] x_new = new double[x_old.length];
		
		for(int l=0;l<x_old.length;l++){
			x_new[l] = x_old[l];
		}
		
		for(int m=0;m<N;m++){
			count++;

			for(int i=0;i<x_new.length;i++){
				x_old[i] = x_new[i]; //解の保存
				x_new[i] = b[i];
				for(int j=0;j<A[0].length;j++){
					if(i!=j){
						x_new[i] = x_new[i] - A[i][j]*x_new[j];
					}
				}
				x_new[i] = x_new[i]/A[i][i];

			}

			if(residualNormInf(A, x_new, b, eps)){
				System.out.println("反復回数"+count+"回");
				return x_new;
			}
		}
		System.out.println("収束しない");
		return x_new;
	}
	
	/**
	 * SOR法
	 * @param A 行列
	 * @param b ベクトル
	 * @param x_old 初期値
	 * @param eps 許容誤差
	 * @param N 最大反復回数
	 * @param omega 加速パラメータω(0<ω<2)
	 * @return x (Ax=b)
	 */
	public static double[] SOR(double [][] A, double[] x_old, double[] b, double eps, int N,double omega){
		int count = 0; //反復回数
		double[] x_new = new double[x_old.length];
		
		for(int l=0;l<x_old.length;l++){
			x_new[l] = x_old[l];
		}

		for(int m=0;m<N;m++){
			count++;
			
			for(int i=0;i<x_new.length;i++){
				x_old[i] = x_new[i]; //古い解の保存
				x_new[i] = b[i];
				for(int j=0;j<A[0].length;j++){
					if(i!=j){
						x_new[i] = x_new[i] - A[i][j]*x_new[j];
					}
				}
				x_new[i] = x_new[i]/A[i][i];
				x_new[i] = (1.0-omega)*x_old[i]+omega*x_new[i];
			}

			if(residualNormInf(A, x_new, b, eps)){
				System.out.println("反復回数"+count+"回");
				return x_new;
			}
		}
		
		System.out.println("収束しない");
		return x_new;
	}
	
	/**
	 * コレスキー分解
	 * @param A 行列
	 * @param b ベクトル
	 * @return L (A=LL^T)
	 */
	public static double[][] choleskyDecomp(double[][] A){
		
		double[][] L = new double[A.length][A[0].length];
		
		for(int i=0;i<L.length;i++){
			for(int j=0;j<=i;j++){
				L[i][j] = A[i][j];
				if(i==j){
				for(int k=0;k<=j-1;k++){
					L[i][i] = L[i][i] - L[i][k]*L[i][k];
				}
					L[i][i] = Math.sqrt(L[i][i]);
				}else{
					for(int k=0;k<=j-1;k++){
						L[i][j] = L[i][j] - L[i][k]*L[j][k];
					}
					L[i][j] = L[i][j]/L[j][j];
				}
			}
		}
		
		return L;
	}
	
	/**
	 * コレスキー法
	 * @param A 行列
	 * @param b ベクトル
	 * @return x 解
	 */
	public static double[] cholesky(double[][] A, double[] b){
		double[] x = new double[A[0].length];
		double[][] L = choleskyDecomp(A);
		double[][] tL = transMat(L);
		
		double[] y = new double[x.length];
		y = forSubst(L, b);
		x = backSubst(tL, y);
		
		return x;
	}

}
