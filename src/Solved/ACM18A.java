package Solved;

import java.util.*;

public class ACM18A
{
	public static void main( String[] args )
	{
		Scanner kb = new Scanner(System.in);
		int amt = kb.nextInt();
		int[] yesno = new int[amt];
		for ( int i = 0; i < amt; i++ )
		{
			// int num = kb.nextInt();
			int sack = kb.nextInt();
			int total = 0;
			int[] weights = new int[10];
			for ( int j = 0; j < 10; j++ )
			{
				int newNum = kb.nextInt();
				total += newNum;
				weights[j] = newNum;
			}
			boolean good = true;
			if ( total < sack )
				good = false;
			else if ( total > sack )
			{
				int remain = total - sack;
				for ( int j = 0; j < 10; j++ )
				{
					good = thingamadoo(weights, remain, j, sack, total);
					if ( good )
						break;
				}
			}
			if ( good )
				yesno[i] = 1;
		}
		for ( int i = 0; i < amt; i++ )
		{
			System.out.println(i + 1 + " " + ( yesno[i] == 1 ? "YES" : "NO" ));
		}
		kb.close();
	}

	public static boolean thingamadoo( int[] weights, int remain, int curr, int sack, int total )
	{

		remain -= weights[curr];
		if ( remain == 0 )// remain - weights[curr] == 0)
			return true;
		else if ( curr == 10 - 1 )
		{
			if ( remain - weights[9] == 0 )
				return true;
			else
				return false;
		}

		else
		{
			// if ( i != curr)
			if ( remain == 0 )
				return true;
			if ( remain < 0 )
				return false;
			return thingamadoo(weights, remain, curr + 1, sack, total);

		}

	}

}
