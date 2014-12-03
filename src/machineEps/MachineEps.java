package machineEps;

public class MachineEps {

	public static void main(String[] args) {
		
		double Eps = 1.0;
		//double n = 6;
		
		while((1.0+Eps)!=1.0){
			Eps = Eps/2;
		}
		Eps = 2*Eps;
		System.out.println("Em="+Eps);
		
		float Epsf = 1.0f;
		while((1.0f+Epsf)!=1.0f){
			Epsf = Epsf/2.0f;
		}
		Epsf = Epsf*2.0f;
		System.out.println("Emf="+Epsf);
	}

}
