import java.math.BigInteger;
import java.util.Arrays;

/*
 * 
 *@author Mitchell Zinck
 * 
 */

public class Program {
	
	private static BigInteger num = new BigInteger ("1");
	private static BigInteger integer = new BigInteger ("0");
	private static BigInteger fibonacci = new BigInteger ("0");
	private static BigInteger tailCut = new BigInteger ("1000000000");
	private static int runTime = 0;
	
	/*
	 * The main loop
	 */
	public static void loop(double time) {
		while(isPandigital()){
			fibonacci();
			//isPandigital();
			runTime++;
			System.out.println(runTime);
		}
		System.out.println("Program completed in " + (timeEnd(time)/1000) + " seconds.\nThe correct number was " + runTime);
	}
	
	/*
	 * Calls the methods that check whether {@fibonacci} is pandigital on both ends
	 */
	public static boolean isPandigital() {
		if(!tail()) {
			if(!front()) {
				return false;
			}
		}
		return true;		
	}
	
	/*
	 * Check the first 9 numbers of {@fibonacci} to see if they are pandigital
	 */
	public static boolean front() {		
		int fib = lead9(fibonacci).intValue();
		int[] integer = new int[9];
		
		for(int z = 0; z < 9; z++) {
			integer[z] = fib % 10;
			fib /= 10;
		}
		
		Arrays.sort(integer);
		
		for(int i = 0; i < integer.length; i++) {
			if(integer[i] != i + 1) {
				return true;
			}
		}
		return false;
	}
	
	/*
	 * Check the last 9 numbers of {@fibonacci} to see if they are pandigital
	 */
	public static boolean tail() {		
		int fib = fibonacci.mod(tailCut).intValue();		
		int[] integer = new int[9];
		
		for(int z = 0; z < 9; z++) {
			integer[z] = fib % 10;
			fib /= 10;
		}
		
		Arrays.sort(integer);
		
		for(int i = 0; i < integer.length; i++) {
			if(integer[i] != i + 1) {
				return true;
			}
		}
		return false;		
	}
	
	/*
	 * Algorithm to cut the first 9 digits out of the {@fibonacci} integer
	 */
	public static BigInteger lead9(BigInteger n) {
        int aprox = (int) ((n.bitLength() * Math.log10(2)) + 1);
        n = n.divide(BigInteger.TEN.pow(aprox - 10));
        n = n.longValue() > 999999999 ? n.divide(BigInteger.TEN) : n;
        return n;
    }
	
	/*
	 * Fibonacci generator
	 */
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
