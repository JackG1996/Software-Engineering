import java.util.ArrayList;

public class DagNode {
	public String color = "White";// associated colour
	public Object val; // associated data
	public ArrayList<DagNode> parents;
	public int count = 0;

	public DagNode(Object val, DAG g) {
		this.val = val;
		this.parents = new ArrayList<DagNode>();
		g.allVertices.add(this);

	}

}
