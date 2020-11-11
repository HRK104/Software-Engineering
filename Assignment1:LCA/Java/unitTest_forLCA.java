

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

//	@Test
//	public void test() {
//		fail("Not yet implemented");
//	}
	
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
	public void test_DAG() {
		DAG dag = new DAG();
		int []par1 = {1};
		int []par2 = {2,3};
		int []par3 = {4};
		
		dag.makeDAGNode(dag.root, null, 1);
		dag.makeDAGNode(dag.root,par1, 2);
		dag.makeDAGNode(dag.root, par1, 3);
		dag.makeDAGNode(dag.root,par2, 4);
		dag.makeDAGNode(dag.root, par3, 5);
		
		int result = dag.findLCA(dag.root, 2,3);
		assertEquals("result of 2 and 3: ","1",dag.findLCA(dag.root, 2,3));
		assertEquals("result of 1 and 2: ","1",dag.findLCA(dag.root, 1,2));
		dag = null;
		assertEquals("result of 4 and 5: ","4",dag.findLCA(dag.root, 4,5));
		System.out.println("result: "+result);
	}

}
