package Solved;

import java.util.*;

public class ACM19A
{

	public static void main(String[] args)
	{
		Scanner kb = new Scanner(System.in);
		String num = kb.nextLine();
		System.out.println(num.substring(0, 3).equals("555") ? "YES" : "NO");
		kb.close();
	}

}
