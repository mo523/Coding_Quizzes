package Solved;

import java.util.*;

public class ACM18H
{
	public static void main(String[] args)
	{
		Scanner kb = new Scanner(System.in);
		int amt = kb.nextInt();

		String ans[] = new String[amt];
		for (int i = 0; i < amt; i++)
		{
			kb.nextInt();
			int max = kb.nextInt();
			int term1 = kb.nextInt();
			int term2 = kb.nextInt();

			int[] terms = new int[max];
			terms[0] = term1;
			terms[1] = term2;

			for (int j = 2; j < max; j++)
				terms[j] = subPrime((terms[j - 1]) + (terms[j - 2]));

			boolean repeat = false;
			int dist = 0;
			int loc = 0;

			out: for (int j = 0; j < terms.length; j++)
			{
				for (int k = j + 1; k < terms.length - 1; k++)
				{
					if (terms[k] == terms[j] && terms[k + 1] == terms[j + 1])
					{
						repeat = true;
						dist = k - j;
						loc = k;
						break out;
					}
				}
			}
			if (repeat)
			{
				ans[i] = (i + 1) + " " + (loc + 1) + " " + dist;
				ans[i] += "\n";
				int acc = 0;
				for (int j = loc - dist; j < loc + 2; j++)
				{
					acc++;
					ans[i] += terms[j] + " ";
					if (acc % 20 == 0 && j + 1 < loc + 2)
						ans[i] += "\n";

				}
			}
			else
			{
				ans[i] = (i + 1) + " " + max + " " + 0;
				ans[i] += "\n" + subPrime(terms[max - 1] + terms[max - 2]);
			}

		}

		for (int i = 0; i < ans.length; i++)
			System.out.println(ans[i]);
		kb.close();
	}

	public static boolean same(int[] terms, int loc)
	{

		return true; 
	}

	public static boolean isPrime(int x)
	{
		if (x == 0 || x == 1)
			return false;
		for (int div = 2; div < x; div++)
			if (x % div == 0)
				return false;
		return true;
	}

	public static int smallPrime(int x)
	{
		for (int i = 1; i < x; i++)
			if (x % i == 0 && isPrime(i))
				return x / i;
		return 0;
	}

	public static int subPrime(int num)
	{
		if (num == 1 || isPrime(num))
			return num;
		else
			return smallPrime(num);

	}
}
