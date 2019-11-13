package Solved;

import java.util.*;

public class PhoneList
{
	public static void main(String[] args)
	{
		Scanner kb = new Scanner(System.in);

		int caseAmt = Integer.parseInt(kb.nextLine());
		for (int c = 0; c < caseAmt; c++)
		{
			int numAmt = Integer.parseInt(kb.nextLine());
			String[] nums = new String[numAmt];

			for (int n = 0; n < numAmt; n++)
				nums[n] = kb.nextLine();
			Arrays.sort(nums);
			
			boolean good = true;
			for (int i = 1; i < nums.length; i++ )
				if (nums[i].startsWith(nums[i-1]))
				{
					good = false;
					break;
				}			
			System.out.println(good ? "YES" : "NO");
			kb.close();
		}
	}
}
