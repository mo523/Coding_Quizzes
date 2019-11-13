package Attempting;

import java.util.ArrayList;
import java.util.Scanner;

public class BusClock
{

	static boolean[][] clock = { { true, true, true, false, true, true, true },
			{ false, false, true, false, false, true, false }, { true, false, true, true, true, false, true },
			{ true, false, true, true, false, true, true }, { false, true, true, true, false, true, false },
			{ true, true, false, true, false, true, true }, { true, true, false, true, true, true, true },
			{ true, false, true, false, false, true, false }, { true, true, true, true, true, true, true },
			{ true, true, true, true, false, true, true } };

	public static void main(String[] args)
	{
		Scanner kb = new Scanner(System.in);

		while (true)
		{
			int bta = Integer.parseInt(kb.nextLine());
			if (bta == 0)
				break;

			int prevTime = 0;
			int min = 0, max = 0;
			char[][] time = new char[4][7];
			String[] tim = new String[5];
			for (int i = 0; i < bta; i++)
			{
				if (i != 0)
				{
					String mm[] = kb.nextLine().split("\n+");
					min = Integer.parseInt(mm[0]);
					max = Integer.parseInt(mm[1]);
				}
				for (int r = 0; r < 5; r++)
					tim[r] = kb.nextLine().replace(" ", "");

				for (int r = 0; r < tim.length; r++)
					if (r % 2 == 0)
					{
						time[0][r + r / 2] = tim[r].charAt(0);
						time[1][r + r / 2] = tim[r].charAt(1);
						time[2][r + r / 2] = tim[r].charAt(2);
						time[3][r + r / 2] = tim[r].charAt(3);
					}
					else if (r == 1)
					{
						time[0][r] = tim[r].charAt(0);
						time[0][r + 1] = tim[r].charAt(1);
						time[1][r] = tim[r].charAt(2);
						time[1][r + 1] = tim[r].charAt(3);
						time[2][r] = tim[r].charAt(4);
						time[2][r + 1] = tim[r].charAt(5);
						time[3][r] = tim[r].charAt(6);
						time[3][r + 1] = tim[r].charAt(7);
					}
					else
					{
						time[0][4] = tim[r].charAt(0);
						time[0][4 + 1] = tim[r].charAt(1);
						time[1][4] = tim[r].charAt(2);
						time[1][4 + 1] = tim[r].charAt(3);
						time[2][4] = tim[r].charAt(4);
						time[2][4 + 1] = tim[r].charAt(5);
						time[3][4] = tim[r].charAt(6);
						time[3][4 + 1] = tim[r].charAt(7);
					}

				ArrayList<ArrayList<Integer>> poss = new ArrayList<>()
				{
					{
						add(new ArrayList<>());
						add(new ArrayList<>());
						add(new ArrayList<>());
						add(new ArrayList<>());
					}
				};

				for (int t = 0; t < 4; t++)
				{
					for (int p = 0; p < 10; p++)
						if (canBeNum(time[t], p))
							poss.get(t).add(p);
				}
				

			}

		}

		kb.close();
	}

	private static boolean canBeNum(char[] q, int n)
	{
		for (int i = 0; i < 7; i++)
		{
			char c = q[i];
			if ((c == '.' && clock[n][i]) || ((c == '-' || c == '|') && !clock[n][i]))
				return false;
		}
		return true;
	}

}
