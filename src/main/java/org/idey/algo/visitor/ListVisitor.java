package org.idey.algo.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @param <T> any object Concrete class representing standard visitor pattern
 */
public class ListVisitor<T> implements Visitor<T> {
    private List<T> list;

    @Override
    public void visit(T t) {
        if(list==null){
            list = new ArrayList<>();
        }
        list.add(t);
    }

    public List<T> getList() {
        return list;
    }
}
