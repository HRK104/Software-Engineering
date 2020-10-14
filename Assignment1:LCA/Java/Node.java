


public class Node{
	int number;
	Node right;
	Node left;
	Node prev;
	int level;
	
	Node(int num){
		number = num;
		right = null;
		left = null;
		prev = null;
		level = -1;
	}
	Node(int num, Node previous){
		number = num;
		right = null;
		left = null;
		prev = previous;
		level = -1;
	}
	
	Node(Node node){
		number=node.number;
		right = null;
		left = null;
		prev = node.prev;
		level =node.level;
	}
}