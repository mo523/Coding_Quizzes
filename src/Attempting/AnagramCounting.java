package Attempting;

import java.math.BigInteger;
import java.util.Scanner;

public class AnagramCounting
{

	public static void main(String[] args)
	{

		System.out.println();
		Scanner kb = new Scanner(System.in);
		while (kb.hasNext())
		{
			String line = kb.nextLine();
			int len = line.length();
			String value;
			BigInteger bi = new BigInteger("1");
			for (int i = 2; i < len; i++)
				bi = bi.multiply(BigInteger.valueOf(i));
			
			System.out.println(bi);
		}

	}

}
// 403291461126605635584000000
// 9223372036854775807