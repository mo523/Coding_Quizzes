package Attempting;

import java.util.Scanner;

public class TwentyFortyEight
{

	public static void main( String[] args )
	{
		Scanner kb = new Scanner(System.in);
		int[][] board = new int[4][4];
		for (int i = 0; i < 16; i++)
			board[i/4][i%4] = kb.nextInt();
		
		int x = kb.nextInt();
		switch ( x )
		{
		case 0:
			break;
		case 1:
			break;
		case 2:
			break;
		case 3:
			break;
		}
		board = move(board);
		for ( int i = 0; i < 4; i++ )
		{
			for ( int j = 0; j < 4; j++ )
				System.out.print(board[i][j] + " ");
			System.out.println();
		}
		kb.close();
	}
	
	public static int[][] rotate(int[][] board)
	{
		int[][] newBoard = new int[4][4];
		for (int i = 0; i < 4; i++)
			for(int j = 0; j < 4; j ++)
				newBoard[i][j] = board[3-j][i];
		return newBoard;
	}
	public static int[][] move(int[][]board)
	{
		for (int i = 0; i < 4; i++)
			for (int j = 1; j < 4; j++)
				if (board[i][j-1] == 0)
				{
					board[i][j-1] = board[i][j];
					board[i][j] = 0;
				}
		
		return board;
		
	}

}
