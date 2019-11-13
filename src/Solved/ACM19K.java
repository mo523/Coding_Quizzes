package Solved;

import java.util.*;

public class ACM19K
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		String name = kb.nextLine();
		System.out.println(name.matches("[^-]{2,8}-.{1,24}") ? "YES" : "NO");
		// System.out.println(name.matches("\\w{2,8}-(\\w|-){1,24}") ? "YES" : "NO");
	}

}
