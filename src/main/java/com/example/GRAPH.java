package com.example; 
import java.util.HashMap;
import java.util.List;
import java.util.Stack;
class GRAPH{
     HashMap<String,List<String>> graph = new HashMap<>() ; 
     HashMap<String,Boolean> visited = new HashMap<>();
   
     void DFS(String vertex){
        System.out.println("\n\t----- Generated Test Path is ----- \n");
        Stack<String> stack = new Stack<>();
        stack.push(vertex);
        
        while(!stack.isEmpty()){
            var ele = stack.pop();
            if(!visited.get(ele)){
                System.out.print("\t ---> "+ele+" ----> \n");
                visited.put(ele,true);
                graph.get(ele).forEach(value->{
                    if(!visited.get(value)){
                        stack.push(value);
                    }
                });

            }
        }
        
    }
    public void setGraph(HashMap<String, List<String>> graph) {
        this.graph = graph;
    }
    public void setVisited(HashMap<String, Boolean> visited) {
        this.visited = visited;
    }
    @Override
    public String toString() {
        return "\n\n\t\t Vertices \n >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<\n"+ 
        visited.toString() + 
        "\n\n\t\t Adjacency List \n >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<\n"
        +graph.toString() + "\n" ; 
    }
}

