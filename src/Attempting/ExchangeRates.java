package Attempting;

import java.util.Scanner;

public class ExchangeRates
{

	public static void main(String[] args)
	{
		Scanner kb = new Scanner(System.in);
		int days;
		double myMoney = 1000;

		while ((days = kb.nextInt()) != 0)
		{
			for (int i = 0; i < days; i++)
			{
				double rate = kb.nextDouble() / 100;
				double newmon = myMoney * rate;
				newmon -= newmon * .03;
				myMoney = newmon;
				System.out.println(myMoney);
			}
			System.out.printf("%.2f", myMoney);
			System.out.println();

		}
		kb.close();
	}
}
