Mazes
=====

Unfortunately there is no way of solving one in an "interactive" sort of way.  I never got around to it, but maybe if I made a solver I might...

The maze is initially a solid "block" with no passages.  We start by picking a random node inside this block, and carving a passage to a random, adjacent block which has not yet been carved.  From that block, we repeat the carving process, keeping in mind that we will not carve a passage into a node which has already been traversed.  If all adjacent nodes have already been carved into, we return from the method call and essentially "backtrack" along the path (via the call stack) we just made until we find a node which still has carvable adjacent nodes.  This process is continued until all nodes have been carved.

This results in what is called a "perfect" maze where, given any two points within the maze, there exists exactly one non-backtracking path between them.  A neat consequence of this property is that the "entrance" and "exit" may be placed anywhere along the maze boundaries.  There are actually many different algorithms which are capable of producing such a maze.

One day I found that I programmed this same algorithm on my TI-84 Plus a long time ago, and it was abysmally slow.  So, I decided to program it on a computer instead, because why not?
