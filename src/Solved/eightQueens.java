package Solved;

import java.util.*;
public class eightQueens
{

	public static void main(String[] args)
	{
		Map<Integer, Integer> tups = new TreeMap<>();
		Scanner kb = new Scanner(System.in);
		String[] rows = new String[8];
		for (int i = 0; i < 8; i++)
			rows[i] = kb.nextLine();
		boolean good = true;
		for (int i = 0; i < 8; i++)
		{
			int col = rows[i].indexOf('*');
			if (col == -1 || tups.containsKey(col))
			{
				good = false;
				break;
			}
			else
				tups.put(col, i);
		}

		if (good)
			for (int i = 0; i < 7; i++)
				for (int j = i + 1; j < 8; j++)
					if (Math.abs(i - j) == Math.abs(tups.get(i) - tups.get(j)))
					{
						good = false;
						break;
					}

		System.out.println(good ? "valid" : "invalid");
		kb.close();
	}
}
