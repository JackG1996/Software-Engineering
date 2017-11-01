import java.util.LinkedList;

public class BFS {
	public void colourChangeBlue(DAG g, DagNode x) 
	{
		LinkedList<DagNode> q = new LinkedList<DagNode>();
		q.add(x);

		while (!q.isEmpty()) 
		{
			DagNode temp = q.removeFirst();

			for (int i = 0; i < temp.parents.size(); i++) 
			{
				temp.parents.get(i).color = "Blue";
				q.addLast(temp.parents.get(i));
			}
		}
	}

	public void blueChangeRed(DAG g, DagNode y) 
	{
		LinkedList<DagNode> q = new LinkedList<DagNode>();
		q.add(y);

		while (!q.isEmpty()) 
		{
			DagNode temp = q.removeFirst();
			for (int i = 0; i < temp.parents.size(); i++) 
			{
				if (temp.parents.get(i).color == "Blue") 
				{
					temp.parents.get(i).color = "Red";
					for (int j = 0; j < temp.parents.get(i).parents.size(); j++) 
					{
						temp.parents.get(i).parents.get(j).count++;
					}
				}
				q.addLast(temp.parents.get(i));
			}
		}
	}
}