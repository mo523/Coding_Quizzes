package Attempting;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class coloring
{

	public static void main(String[] args)
	{
		Scanner kb = new Scanner(System.in);
		int nodeAmt = Integer.parseInt(kb.nextLine());

		Node[] nodes = new Node[nodeAmt];
		for (int i = 0; i < nodeAmt; i++)
			nodes[i] = new Node(i);

		String[] line;
		for (int i = 0; i < nodeAmt; i++)
		{
			line = kb.nextLine().split(" ");
			for (int j = 0; j < line.length; j++)
				nodes[i].addNeighbor(nodes[Integer.parseInt(line[j])]);
		}

		kb.close();
	}

	static class Node
	{
		private int nn, color;
		private HashSet<Node> neigbors = new HashSet<>();

		public Node(int nn)
		{
			this.nn = nn;
		}

		public void addNeighbor(Node node)
		{
			neigbors.add(node);
		}

		public void setColor(int color)
		{
			this.color = color;
		}

		public boolean isColored()
		{
			return color != 0;
		}

		public int getNN()
		{
			return nn;
		}

		public int hashCode()
		{
			return nn;
		}

		public boolean equals(Object o)
		{
			return ((Node) o).getNN() == this.getNN();
		}

		public HashSet<Node> getNeigbors()
		{
			return neigbors;
		}
	}
}