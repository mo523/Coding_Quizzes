package Solved;

import java.util.*;

public class DVDs
{
	public static void main(String[] args)
	{
		Scanner kb = new Scanner(System.in);
		int pos = Integer.parseInt(kb.nextLine());
		for (int i = 0; i < pos; i++)
		{
			int bad = 0;
			int tot = Integer.parseInt(kb.nextLine());
			String[] dvds = kb.nextLine().split("\\s+");
			for (int j = 0; j < tot; j++)
				if (j + 1 - bad != Integer.parseInt(dvds[j]))
					bad++;
			System.out.println(bad);
		}
		kb.close();
	}
}