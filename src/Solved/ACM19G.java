package Solved;

import java.util.*;

public class ACM19G
{

	public static void main(String[] args)
	{
		Scanner kb = new Scanner(System.in);

		long num = kb.nextLong();
		long count = 0;
		while (num != 1)
		{
			if (num % 2 == 0)
				num /= 2;
			else
				num++;
			count++;
		}
		System.out.println(count);
		kb.close();
	}
}
