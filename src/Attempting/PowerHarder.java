package Attempting;
import java.util.Scanner;
import java.util.*;
import java.util.Map.Entry;

public class PowerHarder
{

	public static void main( String[] args )
	{
		Map<Double, String> hm = new TreeMap<>();
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
		double[] results = new double[size];

		for ( int i = 0; i < size; i++ )
		{
			iows[i] = new int[pows[i].length];
			for ( int j = 0; j < pows[i].length; j++ )
				iows[i][j] = Integer.parseInt(pows[i][j]);
		}
		for ( int i = 0; i < size; i++ )
		{
			double total = iows[i][iows[i].length - 1];
			for ( int j = iows[i].length - 2; j >= 0; j-- )
			{
				total = Math.pow(iows[i][j], total);
			}
			results[i] = total;
			if (hm.containsKey(results[i]))
				hm.put(results[i], hm.get(results[i]) +"\n"+ origIn[i]);
			else
				hm.put(results[i], origIn[i]);
		}
		System.out.println("Case 1:");
		for ( Entry<Double, String> entry : hm.entrySet() )
		{
			System.out.println(entry.getValue());
			System.out.println(entry.getKey());
		}
		kb.close();
	}
}