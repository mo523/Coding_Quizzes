package Attempting;
import java.util.Scanner;
import java.math.BigInteger;
import java.util.*;
import java.util.Map.Entry;

public class ph2
{

	public static void main( String[] args )
	{
		Map<BigInteger, String> hm = new TreeMap<>();
		
		Scanner kb = new Scanner(System.in);
		int size = kb.nextInt();
		String[][] pows = new String[size][];
		String[] origIn = new String[size];
		for ( int i = 0; i < size; i++ )
		{
			origIn[i] = kb.next();
			pows[i] = origIn[i].split("\\^");
		}

		int[][] iows = new int[size][];
		BigInteger[] results = new BigInteger[size];

		for ( int i = 0; i < size; i++ )
		{
			iows[i] = new int[pows[i].length];
			for ( int j = 0; j < pows[i].length; j++ )
				iows[i][j] = Integer.parseInt(pows[i][j]);
		}
		for ( int i = 0; i < size; i++ )
		{
			BigInteger b = new BigInteger(pows[i][pows[i].length-1]);
			for ( int j = pows[i].length - 2; j >= 0; j-- )
			{
				b = pow(new BigInteger(pows[i][j]), b);
			}
			results[i] = b;
			if (hm.containsKey(results[i]))
				hm.put(results[i], hm.get(results[i]) +"\n"+ origIn[i]);
			else
				hm.put(results[i], origIn[i]);
		}
		System.out.println("Case 1:");
		for ( Entry<BigInteger, String> entry : hm.entrySet() )
		{
			System.out.println(entry.getValue());
			System.out.println(entry.getKey());
		}
		kb.close();
	}
	public static BigInteger pow(BigInteger base, BigInteger exponent) {
		  BigInteger result = BigInteger.ONE;
		  while (exponent.signum() > 0) {
		    if (exponent.testBit(0)) result = result.multiply(base);
		    base = base.multiply(base);
		    exponent = exponent.shiftRight(1);
		  }
		  return result;
		}
}