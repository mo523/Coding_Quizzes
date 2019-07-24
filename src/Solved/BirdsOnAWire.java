package Solved;

import java.util.*;

public class BirdsOnAWire
{
	public static void main(String[] args)
	{
		Scanner kb = new Scanner(System.in);

		int length = kb.nextInt();
		int distance = kb.nextInt();
		int birdsSitting = kb.nextInt();
		int[] birds = new int[birdsSitting];
		for (int i = 0; i < birdsSitting; i++)
			birds[i] = kb.nextInt();
		int index = 0;
		int newBirds = 0;
		Arrays.sort(birds);
		for (int i = 6; i < length - 5; i += distance)
		{
			if (index < birds.length && i == birds[index])
				index++;
			else
			{
				newBirds++;
				for (int j = 1; j < distance && j + i < length; j++)
					if (index < birds.length && i + j == birds[index])
					{
						index++;
						newBirds--;
						i += j;
						break;
					}
			}

		}
		System.out.println(newBirds);
		kb.close();
	}
}
