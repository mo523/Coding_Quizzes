package Attempting;

import java.util.*;

public class AnotherCandies
{

	public static void main(String[] args)
	{
		Scanner kb = new Scanner(System.in);
		int cases = kb.nextInt();
		for (int i = 0; i < cases; i++)
		{
			kb.nextLine();
			int total = 0;
			int kids = kb.nextInt();
			for (int j = 0; j < kids; j++)
			{
				long n = kb.nextLong();
				total += (n % kids == 0 ? 0 : n % kids);
			}

			System.out.println(total % kids == 0 ? "YES" : "NO");
		}
		kb.close();
	}

}
