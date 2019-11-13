package Attempting;

import java.util.Scanner;

public class ACM19C
{

	public static void main(String[] args)
	{
		Scanner kb = new Scanner(System.in);

		String[] linein = kb.nextLine().split(" ");
		int n = Integer.parseInt(linein[0]);
		int p = Integer.parseInt(linein[1]);

		int[][] table = new int[n][];
		for (int i = 0; i < n; i++)
		{
			linein = kb.nextLine().split(" ");
			table[i] = new int[linein.length - 1];
			for (int j = 1; j < linein.length; j++)
				table[i][j - 1] = Integer.parseInt(linein[j]) - 1;
		}
		int[][] se = new int[p][2];
		for (int i = 0; i < p; i++)
		{
			linein = kb.nextLine().split(" ");
			se[i][0] = Integer.parseInt(linein[1]);
			se[i][1] = Integer.parseInt(linein[2]);
		}
		System.out.println();

		kb.close();
	}

}
