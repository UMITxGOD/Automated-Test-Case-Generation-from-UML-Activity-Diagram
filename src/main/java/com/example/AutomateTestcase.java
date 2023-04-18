package com.example;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.paypal.digraph.parser.GraphEdge;
import com.paypal.digraph.parser.GraphNode;
import com.paypal.digraph.parser.GraphParser;
public class AutomateTestcase {
        /*
         * graph : stores the adjacency List  of the graph 
         * visited : stores the visited List of the graph 
         */
        HashMap<String,List<String>> graph = new HashMap<>() ;
        HashMap<String,Boolean> visited = new HashMap<>();
         /*
         *  Parsing the dot file for getting nodes and edges of the graph 
         */
    AutomateTestcase (String Path) {
        try {
            GraphParser parser = new GraphParser(new FileInputStream(Path));
            Map<String, GraphNode> nodes = parser.getNodes();
            Map<String, GraphEdge> edges = parser.getEdges();	 
            /*
             *  Getting the vertex of the graph and storing into our datastructure
             */
            for (GraphNode node : nodes.values()) {
                visited.put(node.getId() , false);
                graph.put(node.getId() , new ArrayList<>());
            }
            /*
             *  Getting the Edge of the graph and storing into our datastructure
             */
            for (GraphEdge edge : edges.values()) {
                var list_of_edges = graph.get(edge.getNode1().getId());
                list_of_edges.add(edge.getNode2().getId());
                graph.put(edge.getNode1().getId(),list_of_edges);   
            }  
        } catch (IOException ioException) {
            System.out.println(ioException);
        }
    }
        void generate(String FromNode){
            /*
             * Using DFS to get automate test paths 
             */
            GRAPH automate_test_case = new GRAPH() ;
            automate_test_case.setGraph(graph);
            automate_test_case.setVisited(visited);
            System.out.println(automate_test_case);
            automate_test_case.DFS(FromNode);
            System.out.println("\n");
        }
}
