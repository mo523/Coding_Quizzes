package Attempting;

import java.util.*;

public class ACM19I
{

	public static void main(String[] args)
	{
		Scanner kb = new Scanner(System.in);
		String[] line = kb.nextLine().split(" ");
		float p = Float.parseFloat(line[0]);
		float q = Float.parseFloat(line[1]);
		int n = Integer.parseInt(line[2]);
		float base = p / q;
		char[] bases = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();
		ArrayList<Integer> baseout = new ArrayList<>();
		System.out.println(987654321 % 1.9032258);
		System.out.println(n % base);
		while (n != 0)
		{
			int count = 1;
			float mod = n - (n * q / p);// ((float) n )% base;
			while (Math.floor(mod) != mod)
			{
				mod += base;
				count++;
			}

			baseout.add((int) mod);
			n /= (base * count);

		}
		for (int i = baseout.size() - 1; i >= 0; i--)
			System.out.print(bases[baseout.get(i)]);
		kb.close();
	}

}
