package floatNumber;

public class Float {

	public static void main(String[] args) {
		
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
		
		double x = 1.0E-7;
		double Fx = 0.0;
		
		Fx = (Math.sin(x)*Math.sin(x))/(x*x+x*x*Math.cos(x));
		
		System.out.printf("%.10f\n",Fx);
		
		Fx = ((1-Math.cos(x))/(x*x));
		
		System.out.println(Fx);
		
		float sum = 0.0f;
		
		int n=50000;
		for(float i=1.0f;i<=n;i++){
			sum += 1/(i*i);
		}
		System.out.println(sum);
		
		sum = 0.0f;
		for(float i=n;i>=1;i--){
			sum += 1/(i*i);
		}
		System.out.println(sum);
		
		sum = 0.0f;
		float sum2 = 0.0f;
		int N = 0;
		for(float i=1;i<=n;i++){
			sum += 1/(i*i);
			if(sum==sum2){
				N = (int)i-1;
				break;
			}
			sum2=sum;
		}
		System.out.println("N="+N);
		System.out.println(sum);
	}

}
