package Attempting;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class TenKindsOfPeopleBadSolution
{
	@SuppressWarnings("serial")
	public static void main(String[] args)
	{
		Scanner kb = new Scanner(System.in);

		TenKindsOfPeopleBadSolution t = new TenKindsOfPeopleBadSolution();
		String wa[] = kb.nextLine().split("\\s+");
		int rows = Integer.parseInt(wa[0]);
		int cols = Integer.parseInt(wa[1]);

		boolean[][] board = new boolean[rows][cols];

		HashMap<String, HashSet<Pair>> bSet = new HashMap<>();;
		HashMap<String, HashSet<Pair>> dSet = new HashMap<>();;

		HashMap<Pair, String> bKey = new HashMap<>();
		HashMap<Pair, String> dKey = new HashMap<>();

		for (int i = 0; i < rows; i++)
		{
			char[] ca = kb.nextLine().toCharArray();
			for (int j = 0; j < cols; j++)
			{
				boolean x = ca[j] == 48;
				board[i][j] = x;
				Pair p = t.new Pair(i, j);
				HashMap<Pair, String> cpk = (x ? bKey : dKey);
				HashMap<String, HashSet<Pair>> cps = (x ? bSet : dSet);
				String up = null;
				boolean add = false;
				if (i > 0 && board[i - 1][j] == x)
				{
					up = cpk.get(t.new Pair(i - 1, j));
					cps.get(up).add(p);
					add = true;
					cpk.put(p, up);
				}

				if (j > 0 && board[i][j - 1] == x)
				{
					Pair l = t.new Pair(i, j - 1);
					if (up == null || !cps.get(up).contains(l))
					{
						HashSet<Pair> left = cps.get(cpk.get(l));
						if (left == null)
							System.err.println("why");
						if (add)
						{
							HashSet<Pair> combo = new HashSet<>();
							combo.addAll(cps.get(up));
							combo.addAll(left);
							cps.put(up, combo);
							cps.put(cpk.get(l), combo);
						}
						else
						{
							left.add(p);
							cpk.put(p, cpk.get(l));
							add = true;
						}
					}
				}

				if (!add)
				{
					cpk.put(p, p.toString());
					cps.put(p.toString(), new HashSet<>()
					{
						{
							add(p);
						}
					});
				}
			}
		}

		int q = Integer.parseInt(kb.nextLine());
		for (int i = 0; i < q; i++)
		{
			wa = kb.nextLine().split("\\s+");
			int x1 = Integer.parseInt(wa[0]) - 1;
			int y1 = Integer.parseInt(wa[1]) - 1;
			int x2 = Integer.parseInt(wa[2]) - 1;
			int y2 = Integer.parseInt(wa[3]) - 1;
			boolean bin = board[x1][y1];
			Pair s = t.new Pair(x1, y1);
			Pair e = t.new Pair(x2, y2);
			HashSet<Pair> ps = (bin ? bSet.get(bKey.get(s)) : dSet.get(dKey.get(s)));
			if (ps.contains(e))
				System.out.println(bin ? "binary" : "decimal");
			else
				System.out.println("neither");
		}

		kb.close();
	}

	class Pair
	{
		private int n1, n2;

		public Pair(int n1, int n2)
		{
			this.n1 = n1;
			this.n2 = n2;
		}

		public int getN1()
		{
			return n1;
		}

		public int getN2()
		{
			return n2;
		}

		@Override
		public int hashCode()
		{
			return n1 ^ n2;
		}

		@Override
		public boolean equals(Object o)
		{
			return (n1 == ((Pair) o).getN1() && n2 == ((Pair) o).getN2());
		}

		@Override
		public String toString()
		{
			return "(" + n1 + ", " + n2 + ")";
		}

	}

}
