package Attempting;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ShovellingSnow
{
	static int[] dr = new int[] { 0, 0, -1, 1 };
	static int[] dc = new int[] { -1, 1, 0, 0 };

	public static void main(String[] args)
	{
		Scanner kb = new Scanner(System.in);

		int lines;
		while ((lines = Integer.parseInt(kb.nextLine().split(" ")[1])) != 0)
		{
			char[][] grid = new char[lines][];
			for (int i = 0; i < lines; i++)
				grid[i] = kb.nextLine().toCharArray();
			kb.nextLine();
			printGrid(grid);
			printGrid(bfs(grid, 1, 7, 3, 0));
		}

		kb.close();
	}

	static int[][] bfs(char[][] grid, int sr, int sc, int er, int ec)
	{
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { sr, sc });
		int[][] path = new int[grid.length][grid[0].length];
		path[sr][sc] = 1;
		while (!q.isEmpty())
		{
			int[] coords = q.poll();
			int cr = coords[0];
			int cc = coords[1];
			for (int i = 0; i < 4; i++)
				if (allowedMove(grid, path, cr, cc, cr + dr[i], cc + dc[i]))
				{
					q.add(new int[] { cr + dr[i], cc + dc[i] });
					path[cr + dr[i]][cc + dc[i]] = path[cr][cc] + 1;
				}

		}

		return path;
	}

	static boolean allowedMove(char[][] grid, int[][] path, int cr, int cc, int er, int ec)
	{

		return er >= 0 && er < grid.length && ec >= 0 && ec < grid[0].length && grid[er][ec] != '#'
				&& path[er][ec] == 0;
	}

	static int manhatten(int sr, int sc, int er, int ec)
	{
		return Math.abs(sr - er) + Math.abs(sc - ec);
	}

	static void printGrid(char[][] grid)
	{
		for (int i = 0; i < grid.length; i++)
		{
			for (int j = 0; j < grid[i].length; j++)
				System.err.print(grid[i][j]);
			System.err.println();
		}
	}

	static void printGrid(int[][] grid)
	{
		for (int i = 0; i < grid.length; i++)
		{
			for (int j = 0; j < grid[i].length; j++)
				System.err.print(grid[i][j]);
			System.err.println();
		}
	}

}
