package Mazes;
import java.util.Random;
public class RecursiveBacktracker
{
  public static Maze create(int dim)
	{
		Maze m = new Maze(dim);
		Random r = new Random();
		int x = r.nextInt(dim), y = r.nextInt(dim);
		m.nodes[x][y].carved = true;
		carve(m, x, y);
		m.nodes[r.nextInt(dim)][0].up = true;
		m.nodes[r.nextInt(dim)][dim - 1].down = true;
		return m;
	}
	
	private static void carve(Maze m, int xNode, int yNode)
	{
		// Determine which directions are not available
		boolean a1 = yNode == 0 || m.nodes[xNode][yNode - 1].carved;
		boolean a2 = yNode == m.h - 1 || m.nodes[xNode][yNode + 1].carved;
		boolean a3 = xNode == 0 || m.nodes[xNode - 1][yNode].carved;
		boolean a4 = xNode == m.w - 1 || m.nodes[xNode + 1][yNode].carved;
		
		// Loop until all adjacent nodes are closed
		while (!(a1 && a2 && a3 && a4))
		{
			boolean[] adjList = {a1, a2, a3, a4};
			
			// Randomly choose an open direction
			Random r = new Random();
			int dir = r.nextInt(4);
			while (adjList[dir])
				dir = r.nextInt(4);
			
			// Determine the direction
			int xInc = 0, yInc = 0;
			switch (dir)
			{
				case 0:
					yInc = -1;
					m.nodes[xNode][yNode].up = true;
					m.nodes[xNode][yNode - 1].down = true;
					break;
				case 1:
					yInc = 1;
					m.nodes[xNode][yNode].down = true;
					m.nodes[xNode][yNode + 1].up = true;
					break;
				case 2:
					xInc = -1;
					m.nodes[xNode][yNode].left = true;
					m.nodes[xNode - 1][yNode].right = true;
					break;
				case 3:
					xInc = 1;
					m.nodes[xNode][yNode].right = true;
					m.nodes[xNode + 1][yNode].left = true;
					break;
			}
			
			// Carve into that direction and repeat
			m.nodes[xNode + xInc][yNode + yInc].carved = true;
			carve(m, xNode + xInc, yNode + yInc);
			
			// Recalculate if nodes are open
			a1 = yNode == 0 || m.nodes[xNode][yNode - 1].carved;
			a2 = yNode == m.h - 1 || m.nodes[xNode][yNode + 1].carved;
			a3 = xNode == 0 || m.nodes[xNode - 1][yNode].carved;
			a4 = xNode == m.w - 1 || m.nodes[xNode + 1][yNode].carved;
		}
	}
}
