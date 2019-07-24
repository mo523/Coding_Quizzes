package Solved;

import java.util.Scanner;

public class RockPaperScissors
{
	public static void main(String[] args)
	{
		Scanner kb = new Scanner(System.in);
		int wars = Integer.parseInt(kb.nextLine());
		for (int z = 0; z < wars; z++)
		{
			// Setup
			String[] rcd = kb.nextLine().split("\\s+");
			int r = Integer.parseInt(rcd[0]);
			int c = Integer.parseInt(rcd[1]);
			int d = Integer.parseInt(rcd[2]);
			char[][] field = new char[r][c];
			for (int i = 0; i < r; i++)
				field[i] = kb.nextLine().toCharArray();

			// Simulation
			for (int y = 0; y < d; y++)
			{
				char newField[][] = new char[r][c];
				for (int i = 0; i < r; i++)
				{
					for (int j = 0; j < c; j++)
					{
						char a = field[i][j];
						if (newField[i][j] == '\u0000')
							newField[i][j] = a;
						for (int ar = -1; ar <= 1; ar++)
							for (int ac = -1; ac <= 1; ac++)
							{
								if (Math.abs(ar + ac) != 1 || ar + i < 0 || ar + i >= r || ac + j < 0 || ac + j >= c)
									continue;

								char l = field[i + ar][j + ac];

								if ((a == 'S' && l == 'P') || (a == 'P' && l == 'R') || (a == 'R' && l == 'S'))
									newField[i + ar][j + ac] = a;
							}
					}
				}
				field = newField;
			}
			// Final Output
			for (int i = 0; i < r; i++)
			{
				for (int j = 0; j < c; j++)
					System.out.print(field[i][j]);
				System.out.println();
			}
			System.out.println();
		}
		kb.close();
	}
}
