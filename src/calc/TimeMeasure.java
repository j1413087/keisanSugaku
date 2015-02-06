package calc;

public abstract class TimeMeasure { //時間計測
	
	public abstract void work(); //何か作業をする
	
	public void measure() {
		long start = System.currentTimeMillis();//現在時刻
		work();
		long stop = System.currentTimeMillis();//現在時刻
		System.out.println(stop-start);//所要時間
	}
}