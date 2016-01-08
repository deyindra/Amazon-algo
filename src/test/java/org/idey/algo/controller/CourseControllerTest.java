package org.idey.algo.controller;

import org.idey.algo.ds.Graph;
import org.idey.algo.ds.GraphNode;
import org.idey.algo.model.User;
import org.idey.algo.rule.ExceptionLoggingRule;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.List;

public class CourseControllerTest {
    @Rule
    public ExceptionLoggingRule exceptionLoggingRule = new ExceptionLoggingRule();
    @Rule public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void failedCourseControllerTest(){
        expectedException.expect(Exception.class);
        CourseController.getRankedCourseList(null,null);
    }

    @Test
    public void successCourseControllerTest(){
        Graph<User> graph = new Graph<>();
        GraphNode<User> A = new GraphNode<>(new User("A").addCourse("ACCT").addCourse("SCIENCE"));
        GraphNode<User>  B = new GraphNode<>(new User("B").addCourse("BIO").addCourse("CHEM"));
        GraphNode<User>  C = new GraphNode<>(new User("C").addCourse("BIO"));
        GraphNode<User>  D = new GraphNode<>(new User("D").addCourse("LIT").addCourse("SCIENCE"));
        GraphNode<User>  E = new GraphNode<>(new User("E"));
        GraphNode<User>  F = new GraphNode<>(new User("F"));
        GraphNode<User>  G = new GraphNode<>(new User("G"));
        GraphNode<User>  H = new GraphNode<>(new User("H"));
        GraphNode<User>  I = new GraphNode<>(new User("I").addCourse("CHEM"));
        GraphNode<User>  J = new GraphNode<>(new User("J").addCourse("BIO"));

        graph.addNode(A).addNode(B).addNode(C).addNode(D).addNode(E).addNode(F).addNode(G).addNode(H).addNode(I).addNode(J);
        graph.addNeighbour(A,B).addNeighbour(A, C).addNeighbour(B,D).addNeighbour(C,D).addNeighbour(D,E).addNeighbour(D,F).addNeighbour(F,G).addNeighbour(F,H).addNeighbour(A,I).addNeighbour(A,J);

        List<String> listOfCourses = CourseController.getRankedCourseList(A.getObject(),graph);

        Assert.assertEquals(listOfCourses.size(), 3);
    }

}
