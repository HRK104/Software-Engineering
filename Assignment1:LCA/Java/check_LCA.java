// I refered https://www.geeksforgeeks.org/binary-tree-set-1-introduction/ for creating a binary tree
import java.util.ArrayList;


public class check_LCA {

	public static Node root;
	public static ArrayList<Node> allNodes = new ArrayList<Node>();
	
	
	public static void makeTree(String text) {
		System.out.println("Text:"+text+"end");
		
		
		String[] integerStrings = text.split(" ");  
		// Splits each spaced integer into a String array. 
		int[] integers = new int[integerStrings.length];  
		// Creates the integer array. 
		for (int i = 0; i < integers.length; i++){ 
		    integers[i] = Integer.parseInt(integerStrings[i]);  
		//Parses the integer for each string. 
		} 
		
		root = new Node(integers[0]);
		root.level =0;
		allNodes.add(root);
		for(int i=1;i<integers.length;i++) {
			Node newNode = new Node(integers[i]);
			searchNode(newNode);
		}
		
	}
	
	
	public static void searchNode(Node newNode) {
		boolean finished = false;
		Node currentNode = root;
//		System.out.println("root.number: "+root.number);
		while(!finished) {
			if(newNode.number<currentNode.number) { //small -> right
				if(currentNode.right==null) { // if right is null, newNode must be there
					newNode.prev = currentNode;
					newNode.level = currentNode.level +1;
					currentNode.right = new Node(newNode);
					allNodes.add(newNode);
					finished = true;
				}
				else {
					currentNode = currentNode.right;
				}
			}
			else {//big -> left
				if(currentNode.left==null) { // if left is null, newNode must be there
					newNode.prev = currentNode;
					newNode.level = currentNode.level +1;
					currentNode.left = new Node(newNode);
					allNodes.add(newNode);
					finished = true;
				}
				else {
					currentNode = currentNode.left;
				}
			}
		}
	}
	
	
	public static Node searchLCA(Node node1, Node node2){
		ArrayList<Node> node1s = new ArrayList<Node>();
		ArrayList<Node> node2s = new ArrayList<Node>();
		
		createList(node1, node1s);
		createList(node2, node2s);
		
		Node result = null;
		
		System.out.println("node1.level: "+node1.level);
		System.out.println("node2.level: "+node2.level);
		if(node1.level < node2.level) {
			//System.out.println("through");
			for(int i=0; i<node1s.size() && result==null;i++) {
				for(int j=0;j<node2s.size() && result==null;j++) {
					System.out.println("node1s.get("+i+"): "+node1s.get(i).number+" node2s.get("+j+"): "+node2s.get(j).number);
					if(nodeMatched(node1s.get(i), node2s.get(j))) result = new Node(node1s.get(i));
				}
			}
		}
		else {
			//System.out.println("through2");
			for(int i=0; i<node2s.size() && result==null;i++) {
				for(int j=0;j<node1s.size() && result==null;j++) {
					System.out.println("node2s.get("+i+"): "+node2s.get(i).number+" node1s.get("+j+"): "+node1s.get(j).number);
					if(nodeMatched(node2s.get(i), node1s.get(j))) result = new Node(node2s.get(i));
				}
			}
		}
		
		
		return result;
	}
	
	public static boolean nodeMatched(Node node1, Node node2) {
		System.out.println("at nodeMatched");
//		System.out.println("node1.right.number:"+(node1.right).number);
//		System.out.println("node2.right.number:"+(node2.right).number);
		if(node1.number==node2.number) {
//			if(node1.right==null && node2.right==null) {
//				if(node1.left == null && node2.left== null) return true;
//				else if((node1.left).number==(node2.left).number) return true;
//				else return false;
//			}
//			else if((node1.right).number==(node2.right).number) {
//				if(node1.left == null && node2.left== null) return true;
//				else if((node1.left).number==(node2.left).number) return true;
//				else return false;
//			}
//			else return false;
			return true;
		}
		else return false;
	}
	
	public static void createList(Node node, ArrayList<Node> nodes) {
		
		boolean finishedNode = false;
		Node currentNode = new Node(node);
		while(!finishedNode) {
			nodes.add(currentNode);
			if(currentNode.prev==null) finishedNode = true;
			else {
				currentNode = currentNode.prev;
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		makeTree("3 5 1 6 2 0 8 7 4");
		System.out.println("number: "+allNodes.get(1).number);
		System.out.println("number: "+allNodes.get(8).number);
		Node result = new Node(searchLCA(allNodes.get(1), allNodes.get(8)));
		System.out.println("result of 5 and 2: "+result.number);
	}

}



