package Solved;

import java.util.PriorityQueue;
import java.util.Scanner;

public class SquarePegs
{

	public static void main(String[] args)
	{
		Scanner kb = new Scanner(System.in);

		String[] sizes = kb.nextLine().split("\\s+");
		int plotAmt = Integer.parseInt(sizes[0]);
		int roundAmt = Integer.parseInt(sizes[1]);
		int squareAmt = Integer.parseInt(sizes[2]);

		sizes = kb.nextLine().split("\\s+");
		PriorityQueue<Double> plots = new PriorityQueue<>((x, y) -> y > x ? 1 : -1);
		PriorityQueue<Double> houses = new PriorityQueue<>((x, y) -> y > x ? 1 : -1);

		for (int i = 0; i < plotAmt; i++)
			plots.add(Double.parseDouble(sizes[i]) * 2);

		sizes = kb.nextLine().split("\\s+");
		for (int i = 0; i < roundAmt; i++)
			houses.add(Double.parseDouble(sizes[i]) * 2);

		sizes = kb.nextLine().split("\\s+");
		for (int i = 0; i < squareAmt; i++)
			houses.add(Math.sqrt(Math.pow(Double.parseDouble(sizes[i]), 2) * 2));

		int tot = 0;
		do
		{
			double plot = plots.poll();
			while (!houses.isEmpty())
				if (houses.poll() < plot)
				{
					tot++;
					break;
				}
		} while (!plots.isEmpty() && !houses.isEmpty());

		System.out.println(tot);
		kb.close();
	}
}
