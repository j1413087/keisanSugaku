package binaryDigits;

class Convertsion {
	public static void main(String args[]) {
		char[] c = { '1', '1', '1' };
		conversionInt(c, 10, 2);
	}

	static void print(char[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]);
		}
	}

	static char[] radixData(int n) { //任意の数の配列を作る
		if (n > 36) {
			System.out.println("それ以上の基数はまだつくれないよおおおお");
			char[] cha = { '0' };
			return cha;
		}
		char[] cha = new char[n];
		for (int i = 0; i < cha.length; i++) {
			if (i < 10) {
				cha[i] = (char) ('0' + i);
			} else if (i >= 10) {
				cha[i] = (char) ('a' + (i - 10));
			}
		}
		return cha;
	}

	static void radixConversion(String str, int radBefore, int radAfter) { //メイン

	}

	static void conversionInt(char[] mainBefore, int radixBefore, int radixAfter) { //整数部
		char[] radixData = radixData(radixBefore);
		int x = 0; //配列から10進数にする
		for (int i = 0; i < mainBefore.length; i++) {
			x = x + coefficient(radixData, mainBefore[i]) * (int) Math.pow(radixBefore, mainBefore.length - (i + 1));
		}

		char[] mainAfter = new char[length(x, radixAfter)];	//10進数から変換し、配列にする
		radixData = radixData(radixAfter);
		for (int i = 0; i < mainAfter.length; i++) {
			mainAfter[i] = radixData[x % radixAfter];
			x = x / radixAfter;
		}
	}

	static void conversionDec(char[] main, int radix) { //小数部

	}

	static char[] split(String str, int a) { //整数部と小数部をわける、整数部は0 小数部は1
		String[] strs = str.split(",");

		if (strs.length == 1 && a >= 1) {
			System.out.println("小数部なし");
			char[] ch = { '0' };
			return ch;
		}
		char[] cha = new char[strs[a].length()];
		for (int i = 0; i < cha.length; i++) {
			cha[i] = strs[a].charAt(i);
		}
		return cha;
	}

	static int length(int x, int radix) {
		int temp = 1;
		int count = 0;
		do {
			count++;
			temp = radix * temp;
		} while (temp <= x);
		return count;
	}

	static int coefficient(char[] data, char main) {
		int i = 0;
		for (i = 0; i < data.length; i++) {
			if (data[i] == main) {
				break;
			}
		}
		return i;
	}
	static char[] swap(char[] c){
		char temp;
		int i = 0;
		int  j = c.length-1;
		while(i<j){
			temp = c[i];
			c[i] = c[j];
			c[j] = temp;

			i++;
			j--;
		}
		return c;
	}
}
