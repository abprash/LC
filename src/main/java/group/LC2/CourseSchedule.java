package group.LC2;

import java.util.ArrayList;

public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
//         if(prerequisites == null || prerequisites.length == 0 || numCourses == 0)
//             return false;
        
        ArrayList[] graph = new ArrayList[numCourses];
        for(int i=0;i<numCourses;i++)
            graph[i] = new ArrayList();

        //visited array - shd be as long as the number of courses
        boolean[] visited = new boolean[numCourses];
        
        //load them into a graph
        //we load the prereq first, because that prereq can be a prereq for many courses... so we shd not get caught in the visited array
        for(int i=0; i<prerequisites.length;i++){
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        
        for(int i=0; i<numCourses; i++){
            if(!dfs(graph,visited,i))
                return false;
        }
        return true;
        
    }
    
    public boolean dfs(ArrayList[] graph, boolean[] visited, int course){
        //now check for visited
        if(visited[course])
            return false; //a loop has been detected, so return false
        else
            visited[course] = true; //mark the course as visited
        //now lets dfs further
        for(int i=0; i<graph[course].size(); i++){
            if(!dfs(graph, visited, (int) graph[course].get(i)))
                return false;
        }
        //we shouls reset this for every further iteration
        visited[course] = false;
        return true;
    }
}