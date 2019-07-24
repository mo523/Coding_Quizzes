package Attempting;

import java.util.Scanner;

public class AplusB
{
	public static void main(String[] args)
	{
		Scanner kb = new Scanner(System.in);
		int amt = kb.nextInt();
		int[] nums = new int[amt];
		for (int i = 0; i < nums.length; i++)
			nums[i] = kb.nextInt();

		int pairs = 0;
		for (int i = 0; i < nums.length; i++)
		{
			int temp = 0;
			for (int j = 0; j < nums.length; j++)
			{
				if (i != j)
				{
					temp = nums[i] + nums[j];
					for (int k = 0; k < nums.length; k++)
					{
						if (k != i && k != j && temp == nums[k])
							pairs++;
					}
				}
			}

		}
		kb.close();

		System.out.println(pairs);

	}

}
