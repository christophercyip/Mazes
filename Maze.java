package Mazes;
public class Maze
{
  protected int w;
	protected int h;
	protected MazeNode[][] nodes;
	
	public Maze(int size)
	{
		w = size;
		h = size;
		nodes = new MazeNode[size][size];
		for (int a = 0; a < w; a++)
			for (int b = 0; b < h; b++)
				nodes[a][b] = new MazeNode();
	}
	
	public void draw()
	{
		MazeFrame frame = new MazeFrame(w, h);
		MazeFrame.MazeComponent frameComp = frame.new MazeComponent(this);
		frame.add(frameComp);
	}
	
	public static void main(String[] args)
	{
		Maze t = RecursiveBacktracker.create(30);
		t.draw();
	}
}
