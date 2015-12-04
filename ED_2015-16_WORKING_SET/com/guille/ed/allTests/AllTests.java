package com.guille.ed.allTests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({	com.guille.ed.algorithmics.test.AlgorithmicsTest.class, com.guille.ed.avlTrees.tests.AllAVLTests.class,
				com.guille.ed.graphs.tests.AllGraphsTests.class, com.guille.ed.priorityQueues.Tests.AllBinaryHeapTests.class,
				com.guille.ed.hashTables.tests.HashTableAllTests.class})
/**
 * 
 * @author Guillermo Facundo Colunga
 * @version exam.final
 */
public class AllTests {

}
