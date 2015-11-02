package com.guille.ed.allTests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({	com.guille.ed.algorithmics.test.AlgorithmicsTest.class, com.guille.ed.avlTrees.tests.AllAVLTests.class,
				com.guille.ed.graphs.tests.AllGraphsTests.class	})
/**
 * 
 * @author Guillermo Facundo Colunga
 * @version carlos.1
 */
public class AllTests {

}
