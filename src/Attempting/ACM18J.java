package Attempting;
import java.util.*;

public class ACM18J
{

	public static void main(String[] args)
	{
		Scanner kb = new Scanner(System.in);
		int amt = kb.nextInt();
		kb.nextInt();
		for (int i = 0; i < amt; i++)
		{
			int[][] grid = new int[10][10];

			for (int j = 0; j < 10; j++)
				for (int k = 0; k < 10; k++)
					grid[j][k] = kb.nextInt();

//			for (int j = 0; j < 10; j++)
//			{
//				for (int k = 0; k < 10; k++)
//				{
//					for (int l = 1; l < 4; l++)
//					{
//						if (grid[j][k] < 0)
//							grid[j][k] = l * -1;
//					}
//				}
//			}
			grid = ott(grid, 0, 0);
			System.out.println(i + 1);
			for (int j = 0; j < 10; j++)
			{
				for (int k = 0; k < 10; k++)
					System.out.print(grid[j][k] + " ");
				System.out.println();
			}

		}
		kb.close();
	}

	public static int[][] ott(int[][] grid, int io, int jo)
	{
		for (int i = io; i < 10; i++)
		{
			for (int j = jo; j < 10; j++)
			{
				for (int l = 1; l < 4; l++)
				{
					if (grid[i][j] < 0)
						grid[i][j] = l * -1;
					if (allGood(grid))
						return grid;
					else
					{
						if (jo == 9)
						{
							io++;
							jo = 0;
						} else
							jo++;
						ott(grid, io, jo);

					}

				}
			}
		}
		return grid;
	}

	public static boolean allGood(int[][] grid)
	{
		int totallr = 0;
		int totalud = 0;
		for (int i = 0; i < 10; i++)
			for (int j = 0; j < 10; j++)
			{
				if (grid[i][j] < 0)
					totallr += grid[i][j] * -1;
				if (grid[j][i] < 0)
					totalud += grid[j][i] * -1;
			}
		if (totallr != 10 || totalud != 10)
			return false;

		int total = 0;
		for (int i = 0; i < 10; i++)
			for (int j = 0; j < 10; j++)
			{
				if (grid[i][j] > 0)
				{
					if (i - 1 > 0 && j - 1 > 0 && grid[i - 1][j - 1] < 0)
						total += grid[i - 1][j - 1] * 1;
					if (i - 1 > 0 && grid[i - 1][j] < 0)
						total += grid[i - 1][j] * 1;
					if (i - 1 > 0 && j + 1 < 10 && grid[i - 1][j + 1] < 0)
						total += grid[i - 1][j + 1] * 1;
					if (j - 1 > 0 && grid[i][j - 1] < 0)
						total += grid[i][j - 1] * 1;
					if (j + 1 < 10 && grid[i][j + 1] < 0)
						total += grid[i][j + 1] * 1;
					if (i + 1 < 10 && j - 1 > 0 && grid[i + 1][j - 1] < 0)
						total += grid[i + 1][j - 1] * 1;
					if (i + 1 < 10 && grid[i = 1][j] < 0)
						total += grid[i = 1][j] 
								* 1;
					if (i + 1 < 10 && j + 1 < 10 && grid[i + 1][j + 1] < 0)
						total += grid[i + 1][j + 1] * 1;
				}
				if (total != 10)
					return false;
			}
		System.out.println();
		return true;

	}

}
