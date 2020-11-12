

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;


@RunWith(JUnit4.class)
public class unitTest_forLCA {
	
	@Test
    public void testConstructor()
    {
      new check_LCA();
    }
	
	@Test
	public void test_for_Check_LCA() {
		check_LCA test = new check_LCA();
		
		test.makeTree("3 5 1 6 2 0 8 7 4");
		
		Node result = new Node(test.searchLCA(test.allNodes.get(1), test.allNodes.get(8)));
		assertEquals("result of 5 and 4: ","5",String.valueOf(result.number));
		
		result = new Node(test.searchLCA(test.allNodes.get(2), test.allNodes.get(4)));
		assertEquals("result of 1 and 2: ","1",String.valueOf(result.number));
		
	
	}
	
	@Test
	public void test_for_Check_LCA_left() {
		check_LCA test2 = new check_LCA();
		
		test2.makeTree("10 20 30 40 50 60 70 80");
		
		Node result = new Node(test2.searchLCA(test2.allNodes.get(1), test2.allNodes.get(5)));
		assertEquals("result of 2 and 6: ","20",String.valueOf(result.number));
		
		result = new Node(test2.searchLCA(test2.allNodes.get(2), test2.allNodes.get(4)));
		assertEquals("result of 3 and 5: ","30",String.valueOf(result.number));
		
	
	}
	
	

	
    @Test
    public void testNull(){
    	DAG.DAGNode testNode = null;
        DAG.DAGNode a = new DAG.DAGNode(3);
        DAG.DAGNode b= new DAG.DAGNode(4);
        assertEquals("testingNull ",null,DAG.findLCA(testNode,a,b));

    }

    @Test
    public void testSingleN0deTree(){
    	DAG.DAGNode root = new DAG.DAGNode(1);
    	DAG.DAGNode a = new DAG.DAGNode(1);
    	DAG.DAGNode b = new DAG.DAGNode(1);
    	assertEquals("if it is dingle node tree",1,DAG.findLCA(root,a,b).data);
    }

    @Test
    public void testDAGNode() {
    	DAG.DAGNode rootDAG = new DAG.DAGNode(1);
    	DAG.DAGNode node2 = new DAG.DAGNode(2);
    	DAG.DAGNode node3 = new DAG.DAGNode(3);
    	DAG.DAGNode node4 = new DAG.DAGNode(4);
    	DAG.DAGNode node5 = new DAG.DAGNode(5);
        DAG.DAGNode node6 = new DAG.DAGNode(6);

        rootDAG.children.add(node2);
        rootDAG.children.add(node3);
        rootDAG.children.add(node4);
        rootDAG.children.add(node5);
        rootDAG.children.add(node6);
        node2.children.add(node4);
        node2.parents.add(rootDAG);
        node3.children.add(node4);
        node3.children.add(node5);
        node3.parents.add(rootDAG);
        node4.children.add(node5);
        node4.parents.add(node2);
        node4.parents.add(node3);
        node4.parents.add(rootDAG);
        node5.parents.add(node3);
        node5.parents.add(node4);
        node5.parents.add(rootDAG);
        node6.parents.add(node4);

        assertEquals("result of DAG.findLCA(rootDAG, rootDAG, node4): ",1,DAG.findLCA(rootDAG, rootDAG, node4).data);
        assertEquals("result of DAG.findLCA(null,null,null: ",null,DAG.findLCA(null,null,null));
        assertEquals("result of DAG.findLCA(rootDAG, node6, node6): ",6, DAG.findLCA(rootDAG, node6, node6).data);
        assertEquals("result of DAG.findLCA(rootDAG, node6, node6): ",3, DAG.findLCA(rootDAG, node4, node5).data);
        assertEquals("result of DAG.findLCA(rootDAG, new DAG.DAGNode(9),new DAG.DAGNode(99)): ",null, DAG.findLCA(rootDAG, new DAG.DAGNode(9),new DAG.DAGNode(99)));



    }

}
