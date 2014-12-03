package newton;

public class Secant { //セカント法

	public static void main(String[] args) {

		//√5を求める

		double x0 = 4.0;
		double x1 = 3.0;
		double eps = 1.0E-10;
		int N = 50;
		int count = 0;
		double a = 0;

		for(int i=0;i<N;i++){
			if(Math.abs(((x1-x0)/x1))<eps){ //相対誤差判定
				break;
			}else{
				//System.out.println(x1);
				count++;
				a = x1;
				x1 = x1-F(x1)*((x1-x0)/(F(x1)-F(x0)));
				x0 = a;
			}
		}
		System.out.println("√5="+x1);
		System.out.println("再帰回数"+count);
		
		count = 0;
		x0 = 4.0;
		x1 = 3.0;
		while(Math.abs(F(x1))>=eps){ //残差判定
			count++;
			//System.out.println(x1);
			a = x1;
			x1 = x1-F(x1)*((x1-x0)/(F(x1)-F(x0)));
			x0 = a;
			if(count==N){
				break;
			}
		}
		
		System.out.println("√5="+x1);
		System.out.println("再帰回数"+count);

	}
	
	static double F (double x){
		return x*x-5;
	}

}
