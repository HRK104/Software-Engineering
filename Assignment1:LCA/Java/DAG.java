import static org.junit.Assert.assertEquals;
import java.util.ArrayList;


public class DAG {
	
	DAGNode root = null;
	
	public static class DAGNode{
		int data;
		ArrayList<DAGNode> children ;
		ArrayList<DAGNode> parents ;
		
		DAGNode(int number){
			data = number;
			children = new ArrayList<DAGNode>();
			parents = new ArrayList<DAGNode>();
		}
	}
	
	

	public  static DAGNode findLCA(DAGNode root, DAGNode a, DAGNode b){
        if (root==null) return null;
        if (root == a ||root == b) return root;
        if(a.data==b.data)	return a;

        ArrayList <DAGNode> lca = new ArrayList<DAGNode>();
        if(a.parents.size()==0||b.parents.size()==0) return null;
        for(int i=0; i<a.parents.size();i++){
            for(int j=0;j<b.parents.size();j++){
                if(a.parents.get(i).data==b.parents.get(j).data){
                    lca.add(a.parents.get(i));
                }
            }

        }

        if(lca.size()==0){
            if (a.data>b.data) lca.add(findLCA(root,a.parents.get(0), b));
            else lca.add(findLCA(root,a,b.parents.get(0)));
        }

	for (int i = 0; i < lca.size(); i++) {
		if (lca.get(i).data > lca.get(0).data) maxTemp = lca.get(i);
	}
	return maxTemp;



    }

	

}
