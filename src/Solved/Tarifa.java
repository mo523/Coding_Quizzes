package Solved;

import java.util.*;

public class Tarifa
{
	public static void main(String[] args)
	{
		Scanner kb = new Scanner(System.in);
		int dat = kb.nextInt();
		int amt = kb.nextInt();
		int total = amt * dat + dat;
		for (int i = 0; i < amt; i++)
			total -= kb.nextInt();
		System.out.println(total);
		kb.close();
	}
}