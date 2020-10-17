

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
	
	public void test_for_Check_LCA() {
		check_LCA test = new check_LCA();
		
		test.makeTree("3 5 1 6 2 0 8 7 4");
		
		Node result = new Node(test.searchLCA(test.allNodes.get(1), test.allNodes.get(8)));
		assertEquals("result of 5 and 4: ","5",result.number);
		
		result = new Node(test.searchLCA(test.allNodes.get(2), test.allNodes.get(4)));
		assertEquals("result of 1 and 2: ","1",result.number);
		
	
	}

}
