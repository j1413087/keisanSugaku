package binaryDigits;

public class Example {

	public static void main(String[] args) {
		
		
		N_adic a = new N_adic("0","15", 10);
		a.convertTo(16);
		a.print();
		/*
		System.out.println(a.ary10);
		N_adic A = new N_adic("0","0001", 2);
		System.out.println(A.ary10);
		N_adic b = new N_adic("123","25", 10);
		N_adic c = new N_adic("0","6", 8);
		N_adic.add(b,c,8).print();
		*/
		
		
		/*
		double an = 1.0;
		//double an1 = 0.0;
		double sum=0.0;
		double sum2=0.0;
		int N = 0;
		for(double i=1;i<=50000;i++){
			//an1 = an;
			an = an/(i*i*i);
			sum += an;
			if(sum==sum2){
				N = (int)i-1;
				break;
			}
			sum2=sum;
		}
		System.out.println("N="+N);
		System.out.println(an);
		*/
	}
}
