package Attempting;
import java.util.*;

public class ACM18E
{
	public static void main(String[] args)
	{
		Scanner kb = new Scanner(System.in);
		int amt = kb.nextInt();
		int trk = 1;
		do
		{
			//int set = kb.nextInt();
			int clks = kb.nextInt();

			String[] times = new String[clks];
			String[] offs = new String[clks];
			kb.nextLine();
			for (int i = 0; i < clks; i++)
			{
				times[i] = kb.nextLine();
			}
			for (int i = 0; i < clks; i++)
			{
				offs[i] = kb.nextLine();
			}
			int[] t = new int[clks];
			int[] o = new int[clks];
			for (int i = 0; i < clks; i++)
			{
				if (times[i].charAt(2) == ':')
					t[i] = (10 + times[i].charAt(1) -48)* 60 + (times[i].charAt(3)-48)*10 + times[i].charAt(4)-48;
				else
					t[i] = (times[i].charAt(0)-48)* 60 +  (times[i].charAt(2)-48)*10 + times[i].charAt(3) -48;
				int m = offs[i].charAt(0) == '+' ? 1 : -1; 
				if (offs[i].charAt(3) == ':')
					o[i] = (10 + offs[i].charAt(2)-48)* 60 + (offs[i].charAt(4)-48)*10 + offs[i].charAt(5)-48;
				else
					o[i] = (offs[i].charAt(1)-48)* 60 +  (offs[i].charAt(3)-48)*10 + offs[i].charAt(4)-48;
				o[i] *= m;				
			}
			
			for (int i = 0; i < clks; i++)
			{
				System.out.println(t[i]+ "     " + o[i]);
			}
			
			//int num = checker(0, o, t);
			for (int i = 0; i < clks; i++)
			{

			}
			
			
			trk++;
		} while (trk < amt);

		kb.close();
	}
	
	public static int checker(int loc, int[]o, int[]t)
	{
		//int time;
		for (int i = 0; i < o.length; i++)
		{
			for (int j = 0; j < o.length; j++)
			{
				
			}
		}
		return 0;
	}
}
