package org.idey.algo.ds;

import org.idey.algo.rule.ExceptionLoggingRule;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class GraphNodeTest {
    @Rule
    public ExceptionLoggingRule exceptionLoggingRule = new ExceptionLoggingRule();
    @Rule public ExpectedException expectedException = ExpectedException.none();


    @Test
    public void testSuccessGraphNode(){
        GraphNode<Integer> node = new GraphNode<>(1);
        Assert.assertEquals(node.toString(), "1");
    }

    @Test
    public void testFailedGraphNode(){
        expectedException.expect(AssertionError.class);
        GraphNode<Integer> graphNode = new GraphNode<>(null);
    }

}
