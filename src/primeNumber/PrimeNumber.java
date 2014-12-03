package primeNumber;

public class PrimeNumber {
	
	public static void main(String[] args){
		searchPrime(1000);
		print();
	}
	
	static int[] prime;
	
	static void searchPrime(int N){
		search(1,N);
	}
	
	static int search(int k,int N){
		int x0 = k*k;
		int x1 = (k+1)*(k+1);
		int[] a = new int[x1-x0];
		
		if(prime==null){
			prime = new int[] {2};
			search(k,N);
		}else{
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
					setPrime(a[i]);
					if(prime.length>=N){
						return prime[prime.length-1];
					}
				}
			}
			search(k+1,N);
		}
		return 0;
	}
	
	static void setPrime(int x){
		int[] a = new int[prime.length+1];
		System.arraycopy(prime,0,a,0,prime.length);
		a[prime.length]=x;
		prime = a;
	}
	
	static void newtPrime(int x){
		int root = (int)Math.pow(x,0.5);
		if(prime==null){
			search(1,root);
		}
	}
	
	
	static void print(){
		for(int i=0;i<prime.length;i++){
			System.out.printf("%10d",prime[i]);
			if((i+1)%10==0){
				System.out.println();
			}
		}
	}

}
