package newton;

public class Newton {
	
	//√5を求める
	
	public static void main(String[] args) {
		double x = 4.0;
		double x0 = 0.0;
		double x1 = 4.0;
		double eps = 1.0E-10;
		int N = 100; //最大反復回数
		int count = 0;
		
		for(int i=0;i<N;i++){
			if(Math.abs(((x1-x0)/x1))<eps){ //相対誤差判定
				break;
			}else{
				//System.out.println(x1);
				count++;
				x0 = x1;
				x1 = x1-f(x1)/df(x1);
			}
		}
		System.out.println("√5="+x1);
		System.out.println("再帰回数"+count);
		
		
		count = 0;
		while(Math.abs(f(x))>=eps){ //残差判定
			count++;
			//System.out.println(x);
			x = x-f(x)/df(x);
			if(count==N){
				break;
			}
		}
		System.out.println("√5="+x);
		System.out.println("再帰回数"+count);
	
	}
	
	static double f (double x){
		return x*x-5;
	}
	
	static double df (double x){
		return 2.0*x;
	}
}
