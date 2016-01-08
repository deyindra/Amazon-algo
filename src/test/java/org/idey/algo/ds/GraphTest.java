package org.idey.algo.ds;

import org.idey.algo.model.User;
import org.idey.algo.rule.ExceptionLoggingRule;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.List;

public class GraphTest {

    @Rule
    public ExceptionLoggingRule exceptionLoggingRule = new ExceptionLoggingRule();
    @Rule public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void successNodeAddTest(){
        GraphNode<Integer> node = new GraphNode<>(1);
        Graph<Integer> integerGraph = new Graph<>();
        integerGraph.addNode(node);
        Assert.assertEquals(integerGraph.size(),1);
    }

    @Test
    public void failureNodeAddTestWithNull(){
        expectedException.expect(Exception.class);
        Graph<Integer> integerGraph = new Graph<>();
        integerGraph.addNode(null);
    }

    @Test
    public void failureNodeAddTestWithAlreadyExists(){
        expectedException.expect(Exception.class);
        GraphNode<Integer> node = new GraphNode<>(1);
        Graph<Integer> integerGraph = new Graph<>();
        integerGraph.addNode(node);
        integerGraph.addNode(node);
    }

    @Test
    public void successAddNeighbourTest(){
        GraphNode<Integer> node1 = new GraphNode<>(1);
        GraphNode<Integer> node2 = new GraphNode<>(2);
        Graph<Integer> integerGraph = new Graph<>();
        integerGraph.addNode(node1);
        integerGraph.addNode(node2);
        integerGraph.addNeighbour(node1, node2);
        Assert.assertEquals(integerGraph.getAllNeighbours(1).size(), 1);
        Assert.assertEquals(integerGraph.getAllNeighbours(2).size(),1);
    }

    @Test
    public void FailureAddNeighbourTest(){
        expectedException.expect(Exception.class);
        GraphNode<Integer> node1 = new GraphNode<>(1);
        GraphNode<Integer> node2 = new GraphNode<>(2);
        Graph<Integer> integerGraph = new Graph<>();
        integerGraph.addNeighbour(node1, node2);
    }

    @Test
    public void successTestOfGetAllNeighbourToCertainDepth(){
        Graph<User> graph = new Graph<>();
        GraphNode<User> A = new GraphNode<>(new User("A"));
        GraphNode<User>  B = new GraphNode<>(new User("B"));
        GraphNode<User>  C = new GraphNode<>(new User("C"));
        GraphNode<User>  D = new GraphNode<>(new User("D"));
        GraphNode<User>  E = new GraphNode<>(new User("E"));
        GraphNode<User>  F = new GraphNode<>(new User("F"));
        GraphNode<User>  G = new GraphNode<>(new User("G"));
        GraphNode<User>  H = new GraphNode<>(new User("H"));
        GraphNode<User>  I = new GraphNode<>(new User("I"));
        GraphNode<User>  J = new GraphNode<>(new User("J"));

        graph.addNode(A).addNode(B).addNode(C).addNode(D).addNode(E).addNode(F).addNode(G).addNode(H).addNode(I).addNode(J);
        graph.addNeighbour(A,B).addNeighbour(A, C).addNeighbour(B,D).addNeighbour(C,D).addNeighbour(D,E).addNeighbour(D,F).addNeighbour(F,G).addNeighbour(F,H).addNeighbour(A,I).addNeighbour(A,J);

        List<User> list = graph.getAllNeighboursTillCertainDepth(new User("A"),2);
        Assert.assertEquals(list.size(),5);
    }


    @Test
    public void failureTestOfGetAllNeighbourToCertainDepth1(){
        expectedException.expect(Exception.class);

        Graph<User> graph = new Graph<>();
        GraphNode<User> A = new GraphNode<>(new User("A"));
        GraphNode<User>  B = new GraphNode<>(new User("B"));
        GraphNode<User>  C = new GraphNode<>(new User("C"));
        GraphNode<User>  D = new GraphNode<>(new User("D"));
        GraphNode<User>  E = new GraphNode<>(new User("E"));
        GraphNode<User>  F = new GraphNode<>(new User("F"));
        GraphNode<User>  G = new GraphNode<>(new User("G"));
        GraphNode<User>  H = new GraphNode<>(new User("H"));
        GraphNode<User>  I = new GraphNode<>(new User("I"));
        GraphNode<User>  J = new GraphNode<>(new User("J"));

        graph.addNode(A).addNode(B).addNode(C).addNode(D).addNode(E).addNode(F).addNode(G).addNode(H).addNode(I).addNode(J);
        graph.addNeighbour(A,B).addNeighbour(A, C).addNeighbour(B,D).addNeighbour(C,D).addNeighbour(D,E).addNeighbour(D,F).addNeighbour(F,G).addNeighbour(F,H).addNeighbour(A,I).addNeighbour(A,J);

        List<User> list = graph.getAllNeighboursTillCertainDepth(null,2);
    }

    @Test
    public void failureTestOfGetAllNeighbourToCertainDepth2(){
        expectedException.expect(Exception.class);

        Graph<User> graph = new Graph<>();
        GraphNode<User> A = new GraphNode<>(new User("A"));
        GraphNode<User>  B = new GraphNode<>(new User("B"));
        GraphNode<User>  C = new GraphNode<>(new User("C"));
        GraphNode<User>  D = new GraphNode<>(new User("D"));
        GraphNode<User>  E = new GraphNode<>(new User("E"));
        GraphNode<User>  F = new GraphNode<>(new User("F"));
        GraphNode<User>  G = new GraphNode<>(new User("G"));
        GraphNode<User>  H = new GraphNode<>(new User("H"));
        GraphNode<User>  I = new GraphNode<>(new User("I"));
        GraphNode<User>  J = new GraphNode<>(new User("J"));

        graph.addNode(A).addNode(B).addNode(C).addNode(D).addNode(E).addNode(F).addNode(G).addNode(H).addNode(I).addNode(J);
        graph.addNeighbour(A,B).addNeighbour(A, C).addNeighbour(B,D).addNeighbour(C,D).addNeighbour(D,E).addNeighbour(D,F).addNeighbour(F,G).addNeighbour(F,H).addNeighbour(A,I).addNeighbour(A,J);

        List<User> list = graph.getAllNeighboursTillCertainDepth(new User("A"),0);
    }


    @Test
    public void failureTestOfGetAllNeighbourToCertainDepth3(){
        expectedException.expect(Exception.class);

        Graph<User> graph = new Graph<>();
        GraphNode<User> A = new GraphNode<>(new User("A"));
        GraphNode<User>  B = new GraphNode<>(new User("B"));
        GraphNode<User>  C = new GraphNode<>(new User("C"));
        GraphNode<User>  D = new GraphNode<>(new User("D"));
        GraphNode<User>  E = new GraphNode<>(new User("E"));
        GraphNode<User>  F = new GraphNode<>(new User("F"));
        GraphNode<User>  G = new GraphNode<>(new User("G"));
        GraphNode<User>  H = new GraphNode<>(new User("H"));
        GraphNode<User>  I = new GraphNode<>(new User("I"));
        GraphNode<User>  J = new GraphNode<>(new User("J"));

        graph.addNode(A).addNode(B).addNode(C).addNode(D).addNode(E).addNode(F).addNode(G).addNode(H).addNode(I).addNode(J);
        graph.addNeighbour(A,B).addNeighbour(A, C).addNeighbour(B,D).addNeighbour(C,D).addNeighbour(D,E).addNeighbour(D,F).addNeighbour(F,G).addNeighbour(F,H).addNeighbour(A,I).addNeighbour(A,J);

        List<User> list = graph.getAllNeighboursTillCertainDepth(new User("X"),2);
    }

}
