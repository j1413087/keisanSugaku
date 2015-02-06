package practice;

public class Work2 { //演習課題2

	public static void main(String[] args) {
		
		System.out.println("問題1");
		
		float a = 0.1f;
		float b = 0.3f;
		float c = 0.4f;
		
		/*
		System.out.printf("a="+"%.16f\n",a);
		System.out.printf("b="+"%.16f\n",b);
		System.out.printf("c="+"%.16f\n",c);
		*/
		System.out.printf("(左辺)="+"%.16f\n",(a+b)+c);
		System.out.printf("(右辺)="+"%.16f\n",a+(b+c));
		
		
		/*******************/
		
		System.out.println("問題2");
		
		double x = 1.0E-7;
		double fx = 0.0;
		
		fx = (Math.sin(x)*Math.sin(x))/x*x*(1+Math.cos(x));
		
		System.out.println("sin(x)^2/x^2(1+x^2*cos(x))");
		System.out.println("="+fx);
		
		fx = ((1-Math.cos(x))/(x*x));
		
		System.out.println("(1-cos(x))/x^2");
		System.out.println("="+fx);
		
		
		/**********************/
		
		System.out.println("問題3");
		
		S(500);
		S(5000);
		S(50000);
		
		/**********************/
		
		System.out.println("問題4");
		
		float sum_old = 0.0f; //k=n
		float sum_new = 0.0f; //k=n+1
		
		int N;
		
		float k=1.0f;
		
		do{
			sum_old = sum_new;
			sum_new += 1/(k*k);
			N = (int)k-1;
			k++;
		}while(sum_new>sum_old);
		
		System.out.println("N="+N);
		System.out.println(sum_new);
	}
	
	static void S(int n){
		
		System.out.println("n="+n);
		
		float sum = 0.0f;
		
		for(float k=1.0f;k<=n;k++){
			sum += 1/(k*k);
		}
		System.out.println("k:1→n");
		System.out.println(sum);
		
		sum = 0.0f;
		for(float k=n;k>=1;k--){
			sum += 1/(k*k);
		}
		System.out.println("k:n→1");
		System.out.println(sum);
		
	}

}
