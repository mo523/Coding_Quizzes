package Solved;

import java.util.*;

public class AddingWords
{
	public static void main(String[] args)
	{
		Scanner kb = new Scanner(System.in);
		HashMap<String, Integer> maths = new HashMap<>();
		HashMap<Integer, String> defs = new HashMap<>();
		while (kb.hasNext())
		{
			String c = kb.nextLine();
			String[] calc = c.split("\\s+");
			if (calc.length == 1)
			{
				maths = new HashMap<>();
				defs = new HashMap<>();
			}
			else if (calc[0].equals("def"))
			{
				defs.remove(maths.get(calc[1]));
				maths.put(calc[1], Integer.parseInt(calc[2]));
				defs.put(Integer.parseInt(calc[2]), calc[1]);
			}
			else
			{
				int tot = 0;
				boolean bad = false;
				for (int i = 1; i < calc.length; i += 2)
				{
					if (!maths.containsKey(calc[i]))
					{
						bad = true;
						break;
					}
					if (i == 1)
						tot = maths.get(calc[i]);
					else if (calc[i - 1].equals("+"))
						tot += maths.get(calc[i]);
					else
						tot -= maths.get(calc[i]);
				}
				System.out.println(
						c.substring(5) + " " + (bad ? "unknown" : (defs.containsKey(tot) ? defs.get(tot) : "unknown")));
			}
		}
		kb.close();
	}
}
