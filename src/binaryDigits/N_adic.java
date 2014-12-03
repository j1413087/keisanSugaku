package binaryDigits;

public class N_adic {

	int n; //n進数(2~16進数)
	String si;//整数部分
	String sd;//小数部分
	double ary10;//10進数
	
	static char[] ch = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
	
	N_adic(){
	}
	
	N_adic(String Si,int N){ //n進数とその値を代入
		if(N>ch.length){
			System.out.println("この進数には対応してません");
			this.ary10=0;
			this.si="";
		}else{
			this.n=N;
			this.si=Si;
			this.sd="";
			this.ary10=convertInteTo10(this.si,this.n);
		}
	}
	
	N_adic(String Si,String Sd,int N){ //n進数が小数まである場合
		if(N>16){
			System.out.println("この進数には対応してません");
			this.ary10=0;
			this.si="";
			this.sd="";
		}else{
			this.n=N;
			this.si=Si;
			this.sd=Sd;
			this.ary10=convertInteTo10(this.si,this.n)+convertDecTo10(this.sd, this.n);
		}
	}
	
	N_adic(N_adic adic){ //コピーコンストラクタ
		this.n=adic.n;
		this.si=adic.si;
		this.sd=adic.sd;
		this.ary10=adic.ary10;
	}
	
	static int[] convertStringToInt(String str,int N){ //文字列から数字列へ変換
		int[] a = new int[str.length()];
		for(int i=0;i<a.length;i++){
			int j=0;
			for(j=0;j<ch.length;j++){
				if(str.charAt(i)==ch[j]){
					a[i]=j;
					if(j>=N){ //進数と文字が合わないとき
						System.out.println("正しい進数を入力して下さい");
						return null;
					}
					break;
				}
			}
			if(j==ch.length){ //文字が見つからないとき
				System.out.println("正しい進数を入力して下さい");
				return null;
			}
		}
		return a;
	}
	
	static String convertIntToString(int[] a){ //数字列から文字列に変換
		String str = "";
		for(int i=0;i<a.length;i++){
			if(a[i]>9){
				str += ch[a[i]];
			}else{
				str += a[i];
			}
		}
		return str;
	}
	
	 static int convertInteTo10(String str,int N){ //整数部分(N進数)を10進数へ変換
		int x = 0;
		int[] inte = convertStringToInt(str, N);
		if(inte!=null){
			for(int i=0;i<inte.length;i++){
				x=x*N+inte[i];
			}
		}
		return x;
	}
	
	static double convertDecTo10(String str,int N){ //小数部分(N進数)を10進数に変換
		double x=0;
		int[] dec = convertStringToInt(str, N);
		if(dec!=null){
			for(int i=dec.length-1;i>=0;i--){
				x=(double)(x/N)+dec[i];
			}
			x=(double)(x/N);
		}
		return x;
	}
	
	void print(){
		System.out.print("("+this.si);
		if(sd!=""){
			System.out.print("."+this.sd);
		}
		System.out.println(")_"+this.n);
	}
	
	static N_adic convert10toN(double X,int N){ //10進数XをN進数に変換
		
		int Inte = (int)X; //整数部分integer
		double Dec = X-Inte; //小数部分decimal

		String Si = "";
		String Sd = "";

		while(Inte!=0){
			Si = ch[Inte%N] + Si;
			Inte = Inte/N;

		}
		if(Dec==0){
			N_adic A = new N_adic(Si,N);
			return A;
		}else{
			Sd = "";
			int count = 0;
			while(Dec!=0){
				count++;
				if(count>8)break;
				Dec=Dec*N;
				Sd += ch[(int)Dec];
				Dec=Dec-(int)Dec;
			}
			N_adic A = new N_adic(Si,Sd,N);
			return A;
			}
		}
	
	N_adic convertTo(int N){ //N進数へ変換
		N_adic a = convert10toN(this.ary10,N);
		this.Set(a);
		return this;
	}
	
	void Set(N_adic a){
		this.n=a.n;
		this.si=a.si;
		this.sd=a.sd;
		this.ary10=a.ary10;
	}
	
	static N_adic add (N_adic a,N_adic b,int N){
		double ab= 0;
		ab=a.ary10+b.ary10;
		return convert10toN(ab,N);

	
	}
	/*
	N_adic sub (N_adic a,N_adic b){
		if(a.n==b.n){
			int[] ABd = {0};

			if(a.sd!=""||b.sd!=""){
				int[] Ad = convertStringToInt(a.sd, a.n);
				int[] Bd = convertStringToInt(b.sd, b.n);

				if(Ad==null){
					Ad = new int[] {0};
				}
				if(Bd==null){
					Bd = new int[] {0};
				}

				ABd = arrayAddDec(Ad,Bd,a.n);
			}
			int x = convertInteTo10(a.si, a.n)+convertInteTo10(b.si, b.n)+ABd[0];
			String Si = convert10toN(x, a.n).si;
			int[] abd = new int[ABd.length-1];
			for(int i=0;i<ABd.length;i++){
				abd[i] = ABd[i+1];
			}
			String Sd = convertIntToString(ABd);
			N_adic AB = new N_adic(Si,Sd,a.n);
			return AB;
		}else{
			return convert10toN((a.ary10+b.ary10), a.n);
		}
	}
	
	static int[] arrayAddDec(int[] a,int[] b,int N){

		int[] A = a;
		int[] B = b;

		if(A.length<B.length){ //Bのほうが大きい場合には入れ替え
			int[] c = a;
			A = B;
			B = c;
		}

		int[] C = new int[A.length];
		for(int i=0;i<C.length;i++){
			if(i<B.length){
				C[i]=B[i];
			}else{
				C[i]=0;
			}
		}

		int[] AB = new int[A.length+1];
		for(int i=0;i<A.length;i++){
			A = swap(A);
			C = swap(C);
			AB[i] += A[i]+C[i];
			if(AB[i]>=N){
				AB[i] -= N;
				AB[i+1]++;
			}
		}
		AB = swap(AB);
		return AB;

	}
	
	
	static int[] swap (int[] a){
		if(a.length==1){
			return a;
		}
		int i = 0;
		int j = a.length-1;
		while(i<j){
			int x = a[i];
			a[i]=a[j];
			a[j]=x;
		}
		return a;
	}
	
	*/

}

