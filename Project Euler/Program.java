import java.math.BigInteger;

/*
 * 
 *@author Mitchell Zinck
 * 
 */

public class Program {
	
	private static BigInteger num = new BigInteger ("1");
	private static BigInteger integer = new BigInteger ("0");
	private static BigInteger fibonacci = new BigInteger ("0");
	private static BigInteger mod10 = new BigInteger ("10");
	private static BigInteger tailCut = new BigInteger ("1000000000");
	private static BigInteger tailTrue = new BigInteger ("0");
	private static int runTime = 0;
	
	public static void loop(double time) {
		while(isPandigital()){
			fibonacci();
			isPandigital();
			runTime++;
			System.out.println(runTime);
		}
		System.out.println("Program completed in " + (timeEnd(time)/1000) + " seconds.\nThe correct number was " + runTime);
	}
	
	public static boolean isPandigital() {
		if(!tail()) {
			if(!front()) {
				return false;
			}
		}
		return true;		
	}
	
	public static boolean front() {		

		String fib = fibonacci.toString().substring(0, 9);
		
		/*
		 * 
		 * I found this other snippet on google just to see if it was any faster which it kinda was. Just uncomment everything that is commented, 
		 * and comment String fib.
		 * int fib = lead9(fibonacci).intValue();
		 * 
		 */
		
		for(int i = 1; i <= 9; i++) {
			//String numb = Integer.toString(fib);
			String digit = Integer.toString(i);
			//if(!numb.contains(digit))
			if(!fib.contains(digit)) {
				return true;
			}
		}		
		return false;
	}
	
	public static boolean tail() {
		if(fibonacci.bitCount() < 58) {
			return true;
		}
		
		int fib = fibonacci.mod(tailCut).intValue();
		
		for(int i = 1; i <= 9; i++) {
			String numb = Integer.toString(fib);
			String digit = Integer.toString(i);
			if(!numb.contains(digit)){
				return true;
			}
		}		
		return false;		
	}
	
	public static BigInteger lead9(BigInteger n) {
        int aprox = (int) ((n.bitLength() * Math.log10(2)) + 1);
        n = n.divide(BigInteger.TEN.pow(aprox - 10));
        n = n.longValue() > 999999999 ? n.divide(BigInteger.TEN) : n;
        return n;
    }
	
	public static void fibonacci() {
		integer = fibonacci;
		fibonacci = fibonacci.add(num);
		num = integer;
	}
	
	public static double timeEnd(double time) {
		return System.currentTimeMillis() - time;
	}

	public static void main (String[] args) {
		double time = System.currentTimeMillis();
		loop(time);
	}
}
