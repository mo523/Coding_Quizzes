package Solved;
import java.util.Scanner;
public class forThought
{
	public static void main( String[] args )
	{
		Scanner kb = new Scanner(System.in);
		int amt = kb.nextInt();
		String ans[] = new String[amt];
		for ( int sc = 0; sc < amt; sc++ )
		{
			int num = kb.nextInt();
			ans[sc] = "no solution";
			out: for ( int i = 0; i < 4; i++ )
				for ( int j = 0; j < 4; j++ )
					for ( int k = 0; k < 4; k++ )
					{
						int result;
						if ( i >= j && j >= k )
							result = op(k, op(j, op(i, 4, 4), 4), 4);
						else if ( i >= j )
							result = op(j, op(i, 4, 4), op(k, 4, 4));
						else if ( i >= k )
							result = op(k, op(i, 4, op(j, 4, 4)), 4);
						else
							result = op(i, 4, op(k, op(j, 4, 4), 4));
						if ( result == num )
						{
							ans[sc] = 4 + op(i) + 4 + op(j) + 4 + op(k) + 4 + " = " + num;
							break out;
						}
					}
		}
		for ( String index : ans )
			System.out.println(index);
		kb.close();
	}

	public static int op( int x, int a, int b )
	{
		switch ( x )
		{
		case 0:
			return a + b;
		case 1:
			return a - b;
		case 2:
			return a * b;
		default:
			return a / b;
		}
	}

	public static String op( int x )
	{
		switch ( x )
		{
		case 0:
			return " + ";
		case 1:
			return " - ";
		case 2:
			return " * ";
		default:
			return " / ";
		}
	}
}