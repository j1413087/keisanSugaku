package p0417;

public class Lesson2 {
	
	public static void main(String[] args) {
		
		/*問１******************/
		
		double a = Math.pow(5,9);
		double b = Math.pow(8,7);
		double root = 0;
		
		root = Math.pow((a/b), 0.5);
		
		System.out.println(root);
		
		double sin = Math.sin(3*Math.PI/4.0);
		double Abs = sin-Math.E*Math.E*Math.pow(Math.log(3),0.5);
		Abs = Math.abs(Abs);
		
		System.out.println(Abs);
		
		/*問２********************/
		
		long Fn2 = 0;
		long Fn1 = 1;
		long Fn = 0;
		for(int i=0;i<49;i++){
			Fn2 = Fn1+Fn;
			Fn = Fn1;
			Fn1 = Fn2;
		}
		System.out.println(Fn2);
		System.out.println(Fn1);
		System.out.println(Fn);
		
		/*問３********************/
		
		double an=1;
		int i=1;
		while(an>Math.pow(10,-8)){
			long ii = 1;
			for(int j=1;j<=i;j++){
				ii = ii*j;
			}
			an = 1/ii;
		}
		
		System.out.println(an);
	}
}
