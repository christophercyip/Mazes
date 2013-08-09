package Mazes;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.*;
@SuppressWarnings("serial")
public class MazeFrame extends JFrame
{
  static int scale = 10;
	
	public MazeFrame(int x, int y)
	{
		setVisible(true);
		setTitle("MAZE");
		setSize(2 * (x + 1) * scale + 10, 2 * (y + 1) * scale + 30);
	}
	
	class MazeComponent extends JComponent
	{
		Maze m;
		
		public MazeComponent()
		{}
		
		public MazeComponent(Maze m)
		{
			this.m = m;
		}
		
		public void paintComponent(Graphics g)
		{
			int pX = 2 * m.w + 1, pY = 2 * m.h + 1;
			boolean[][] pixels = new boolean[pX][pY];
			for (int x = 0; x < m.w; x++)
			{
				for (int y = 0; y < m.h; y++)
				{
					MazeNode n = m.nodes[x][y];
					if (n.carved)
					{
						pixels[2 * x + 1][2 * y + 1] = true;
						if (n.up)
							pixels[2 * x + 1][2 * y] = true;
						if (n.down)
							pixels[2 * x + 1][2 * y + 2] = true;
						if (n.left)
							pixels[2 * x][2 * y + 1] = true;
						if (n.right)
							pixels[2 * x + 2][2 * y + 1] = true;
					}
				}
			}
			MazeComponent pen = new MazeComponent();
			for (int x = 0; x < pX; x++)
				for (int y = 0; y < pY; y++)
					if (!pixels[x][y])
						pen.drawBox(g, x * scale, y * scale);
		}
		
		public void drawBox(Graphics g, double x, double y)
		{
			for (int i = 0; i < scale; i++)
			{
				Rectangle2D.Double box = new Rectangle2D.Double(x + i, y + i, scale - 2 * i, scale - 2 * i);
				((Graphics2D) g).draw(box);
			}
		}
	}
}
