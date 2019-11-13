package Attempting;

import java.util.Scanner;

public class ACM19J
{

	public static void main(String[] args)
	{

		Scanner kb = new Scanner(System.in);
		int in = kb.nextInt();
		int[][] graph = new int[in + 1][];
		for (int i = 0; i < in; i++)
		{
			graph[i] = new int[3];

			graph[i][0] = i - 1 < 0 ? in - 1 : i - 1;
			graph[i][1] = i + 1 >= in ? 0 : i + 1;
			graph[i][2] = in;
		}
		graph[in] = new int[in];
		for (int i = 0; i < in; i++)
			graph[in][i] = i;

//		int count = 0;

		// for ()
		System.out.println();
		kb.close();
	}

}
