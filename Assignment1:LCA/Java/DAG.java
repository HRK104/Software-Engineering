import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

public class DAG {
	
	DAGNode root = null;
	
	public static class DAGNode{
		int data;
		ArrayList<DAGNode> children = new ArrayList<DAGNode>();
		ArrayList<DAGNode> parents = new ArrayList<DAGNode>();
		
		DAGNode(int number){
			data = number;
			
		}
	}
	
	public void makeDAGNode(DAGNode root, int []parent_num, int num) {
		if(root == null) root = new DAGNode(num);
		else {
			for(int i=0; i<root.children.size(); i++) {
				for(int j=0; j<parent_num.length; j++) {
					if(root.data == parent_num[j]) {
						DAGNode newNode = new DAGNode(num);
						newNode.parents.add(root);
						root.children.add(newNode);
					}
				}
				makeDAGNode(root.children.get(i), parent_num,num);
			}
		}
	}
	
	public int findLCA(DAGNode root, int num1, int num2) {
		int result = -1;
		
		
		
		for(int i=0; i<root.children.size();i++) {
			if(root.children.get(i).data==num1) {
				for(int j=0; j<root.children.size();j++) {
					if(root.children.get(j).data==num2) result = root.data;
				}
			}
		}
		if(result!=-1) return result;
		boolean matched = false;
		for(int i=0; !matched && i<root.children.size();i++) {
			result = findLCA(root.children.get(i),num1,num2);
			if(result != -1) {
				matched = true;
			}
		}
		return result;
	}
	
	public static void main(String[]args) {
		DAG dag = new DAG();
		int []par1 = {1};
		int []par2 = {2,3};
		int []par3 = {4};
		
		dag.makeDAGNode(dag.root, null, 1);
		dag.makeDAGNode(dag.root,par1, 2);
		dag.makeDAGNode(dag.root, par1, 3);
		dag.makeDAGNode(dag.root,par2, 4);
		dag.makeDAGNode(dag.root, par3, 5);
		
		int result2 = dag.findLCA(dag.root, 2,3);
		assertEquals("result of 2 and 3: ","1",dag.findLCA(dag.root, 2,3));
		assertEquals("result of 1 and 2: ","1",dag.findLCA(dag.root, 1,2));
		dag = null;
		assertEquals("result of 4 and 5: ","3",dag.findLCA(dag.root, 4,5));
		System.out.println("result: "+result2);
	}

}
