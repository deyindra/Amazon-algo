package org.idey.algo.controller;

import org.idey.algo.ds.Graph;
import org.idey.algo.model.User;

import java.util.*;

public class CourseController {
    public static List<String> getRankedCourseList(User user, Graph<User> graph){
        if(user==null){
            throw new NullPointerException("Invalid User");
        }

        if(graph==null){
            throw new NullPointerException("Invalid graph");
        }

        List<String> rankedCourses = Collections.emptyList();
        List<User> list = graph.getAllNeighboursTillCertainDepth(user,2);
        Map<String, Integer> courseRank = new HashMap<>();
        if(list!=null && !list.isEmpty()){
            Set<String> currentUserCourseList = user.getCourseList();
            for(User neighbour:list){
                Set<String> courseList = neighbour.getCourseList();
                for(String course:courseList){
                    if(!currentUserCourseList.contains(course)){
                        Integer count = courseRank.get(course);
                        if(count==null){
                            count=1;
                        }else{
                            count=count+1;
                        }
                        courseRank.put(course,count);
                    }
                }
            }
            if(!courseRank.isEmpty()) {
                rankedCourses = new ArrayList<>();
                List<Map.Entry<String, Integer>> entries = new ArrayList<>(courseRank.entrySet());
                Collections.sort(entries, new Comparator<Map.Entry<String, Integer>>() {
                    @Override
                    public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                        return -(o1.getValue().compareTo(o2.getValue()));
                    }
                });

                for (Map.Entry<String, Integer> entry : entries) {
                    rankedCourses.add(entry.getKey());
                }
            }
        }
        return rankedCourses;
    }
}
