package Solved;

import java.util.*;

public class ACM19H
{

	public static void main(String[] args)
	{
		Scanner kb = new Scanner(System.in);
		int lines = kb.nextInt();
		int[] keys = new int[lines];
		for (int i = 0; i < lines; i++)
			keys[i] = kb.nextInt();
		HashSet<Integer> factors = new HashSet<>();

		for (int i = 0; i < lines; i++)
		{
			int num = keys[i];
			for (int j = 2; j < (int) Math.sqrt(num); j++)
			{
				if (isPrime(j) && num % j == 0 && isPrime(num / j))
				{
					factors.add(j);
					factors.add(num / j);
					break;
				}
			}
		}
		int count = 0;
		Object[] sorted = factors.stream().sorted().toArray();
		for (int i = 0; i < sorted.length; i++)
		{

			if (count % 5 == 0)
				System.out.println();
			System.out.print(sorted[i] + " ");
			count++;
		}
		kb.close();
	}

	public static boolean isPrime(int p)
	{
		if (p == 0 || p == 1)
			return false;
		else if (p == 2)
			return true;
		else
			for (int i = 2; i <= (int) Math.sqrt(p); i++)
				if (p % i == 0)
					return false;
		return true;
	}
}
