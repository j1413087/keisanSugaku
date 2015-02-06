package primeNumber;

public class PrimeNumber{ //素数を探すクラス
	
	public static void main(String[] args){
		
		searchTo(1000); //1000までの素数を探す
		//search(100); //素数を100個探す
		
		printPrime(); //作られた素数をすべて表示
	}
	
	static int[] prime; //素数を保持する配列
	
	static int[] primeTo(int N){ //Nまでの素数を探す
		int n = countPrimeTo(N);
		int[] primeToN = new int[n];
		System.arraycopy(prime, 0, primeToN, 0, n);
		return primeToN;
	}
	
	static int[] searchTo(int N){ //Nまでの素数を探す
		buildPrime(1,N);
		
		int n = countPrimeTo(N);
		int[] a = new int[n];
		System.arraycopy(prime, 0, a, 0, n);
		return a;
	}
	
	static int[] search(int N){ //N個の素数を探す
		
		buildPrime2(1,N);
		
		int[] a = new int[N];
		System.arraycopy(prime, 0, a, 0, N);
		return a;
		
	}
	
	static void buildPrime(int k,int N){ //Nまでの素数を作る再帰メソッド
		
		int x0 = k*k;
		int x1 = (k+1)*(k+1);
		int[] a = new int[x1-x0];
		
		if(prime==null) setPrime(2); //最初は2をセット
		
		if(prime[prime.length-1]>=N) //既にNより大きい素数がセットされてる場合
			return;
		
		//Nより大きい素数がセットされてない場合
		for(int i=0;i<a.length;i++){
			a[i] = x0+i+1;
			
			for(int j=0;j<prime.length;j++){
				if(a[i]%prime[j]==0){
					if(a[i]!=prime[j]){
						a[i]=0;
						break;
					}
				}
			}
			if(a[i]!=0){
				if(a[i]<=N){
					setPrime(a[i]);
				}else return;
			}
		}
		buildPrime(k+1,N);
		return;
	}
	
	static void buildPrime2(int k,int N){ //Nまでの素数を作る再帰メソッド

		int x0 = k*k;
		int x1 = (k+1)*(k+1);
		int[] a = new int[x1-x0];

		if(prime==null) setPrime(2); //最初は2をセット

		if(prime.length>=N) //既にN個おり多い素数がセットされてる場合
			return;

		//N個より多く素数がセットされてない場合
		for(int i=0;i<a.length;i++){
			a[i] = x0+i+1;

			for(int j=0;j<prime.length;j++){
				if(a[i]%prime[j]==0){
					if(a[i]!=prime[j]){
						a[i]=0;
						break;
					}
				}
			}
			if(a[i]!=0){
				if(a[i]>prime[prime.length-1]){
					setPrime(a[i]);
				}
				if(prime.length==N){
					return;
				}
			}
		}
		buildPrime2(k+1,N);
		return;
	}
	
	static void setPrime(int x){
		if(prime==null){ //primeが空のときは2をセット
			prime = new int[] {2};
			return;
		}
		//primeの最後がx以上の場合、xはすでにセット済みのため何もしない
		if(x<=prime[prime.length-1]){
			return;
		}
		int[] a = new int[prime.length+1];
		System.arraycopy(prime,0,a,0,prime.length);
		a[prime.length]=x;
		prime = a;
	}
	
	static int countPrimeTo(int N){
		
		if(prime == null) setPrime(2);
		
		if(prime[prime.length-1]<N){ //Nまでの素数が作れてない場合
			buildPrime(1,N);
		}
		
		int count = 0;
		for(int i=0;i<prime.length;i++){
			count++;
			if(prime[i]>N){
				count--;
				break;
			}
		}
		return count;
	}
	
	static int[] primeBetween(int x,int y){ //xとyの間の素数を探す
		
		if(x>y){ //必ずx<=yとする
			int a = x;
			x = y;
			y = a;
		}
		
		int numberX = countPrimeTo(x);
		int numberY = countPrimeTo(y);
		
		int[] betweenXY;
		
		if(numberX==numberY){
			betweenXY = new int[] {0};
			return betweenXY;
		}
		
		betweenXY = new int[numberY-numberX];
		System.arraycopy(prime, numberX-1, betweenXY, 0, numberY-numberX);
		return betweenXY;
	}
	
	static void printPrime(){ //素数の表示
		print(prime);
	}
	
	static void print(int[] x){ //配列の表示
		for(int i=0;i<x.length;i++){
			System.out.printf("%10d",x[i]);
			if((i+1)%10==0){
				System.out.println();
			}
		}
		System.out.println();
	}

}
