package org.idey.algo.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @author  indranil dey
 * Class represent user, assumption user's name supposed to be unique
 *
 */
public class User {
    /**
     * name of the user
     */
    private String name;
    /**
     * list of course user attended.
     */
    private Set<String> courseList;


    public User(String name) {
        assert(name!=null && name.trim().length()>0);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public User addCourse(String course){
        assert(name!=null && name.trim().length()>0);
        if(courseList==null){
            courseList = new HashSet<>();
        }
        courseList.add(course);
        return this;
    }

    /**
     *
     * @return return {@link Set} of courses attended by the user
     */
    public Set<String> getCourseList() {
        return (courseList==null ? Collections.EMPTY_SET : courseList);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return !(name != null ? !name.equals(user.name) : user.name != null);

    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public String toString() {
        return name;
    }
}
