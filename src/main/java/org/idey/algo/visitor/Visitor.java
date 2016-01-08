package org.idey.algo.visitor;

/**
 * Interface representing standard visistor pattern
 * @param <T>
 */
public interface Visitor<T> {
    void visit(T t);
}
