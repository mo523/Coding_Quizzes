package Attempting;

import java.util.*;

public class Easiest
{

	public static void main(String[] args)
	{
		Scanner kb = new Scanner(System.in);

		while (true)
		{
			int num = (Integer.parseInt(kb.nextLine()));
			if (num == 0)
				break;
			int numSum = getSum(num);
			for (int i = 11;; i++)
				if (numSum == getSum(i * num))
				{
					System.out.println(i);
					break;
				}
		}

		kb.close();
	}

	private static int getSum(int x)
	{
		int sum = 0;
		int len = ("" + x).length();

		for (int i = 0; i < len; i++)
		{
			int pow = (int) Math.pow(10, (len - (i + 1)));
			int temp = x / pow;
			sum += temp;
			x -= temp * pow;
		}
		return sum;
	}

}
