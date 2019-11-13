package Solved;

import java.util.*;

public class TenKindsOfPeople
{

	static int[] dx = new int[] { 0, 0, -1, 1 };
	static int[] dy = new int[] { -1, 1, 0, 0 };

	public static void main(String[] args)
	{

		Scanner kb = new Scanner(System.in);

		String wa[] = kb.nextLine().split("\\s+");
		int rows = Integer.parseInt(wa[0]);
		int cols = Integer.parseInt(wa[1]);

		char[][] board = new char[rows][cols];
		int[][] zips = new int[rows][cols];
		for (int i = 0; i < rows; i++)
			board[i] = kb.nextLine().toCharArray();

		int zip = 1;
		for (int i = 0; i < rows; i++)
			for (int j = 0; j < cols; j++)
				if (zips[i][j] == 0)
				{
					boolean binary = board[i][j] == 49;
					int[] coords = new int[] {i,j};
					Stack<int[]> stack = new Stack<>();
					stack.push(coords);
					zips[i][j] = zip;
					while (!stack.isEmpty())
					{
						int[] curr = stack.pop();
						int x = curr[0];
						int y = curr[1];
						for (int k = 0; k < 4; k++)
						{
							int nx = x + dx[k];
							int ny = y + dy[k];
							if (nx >= 0 && nx < rows && ny >= 0 && ny < cols && binary == (board[nx][ny] == 49)
									&& zips[nx][ny] == 0)
							{
								stack.push(new int[] {nx, ny});
								zips[nx][ny] = zip;
							}
						}
					}
					zip++;
				}

		int cases = Integer.parseInt(kb.nextLine());
		for (int i = 0; i < cases; i++)
		{
			String[] line = kb.nextLine().split("\\s+");
			int x1 = Integer.parseInt(line[0]) - 1;
			int y1 = Integer.parseInt(line[1]) - 1;
			int x2 = Integer.parseInt(line[2]) - 1;
			int y2 = Integer.parseInt(line[3]) - 1;
			System.out.println(zips[x1][y1] == zips[x2][y2] ? (board[x1][y1] == 49 ? "decimal" : "binary") : "neither");
		}
		kb.close();
	}

}
