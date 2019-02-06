package Assign4;




import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.StringTokenizer;




class Binaryminheap {
    private Path[] Binaryminheap; // Binaryminheap variable.
    private int size; // Variable to store the size of the heap.
    private int maxsize; // Maxsize of the heap (total number of vertices).
    private static final int FRONT = 1; // Constant storing the Front value.

    private int parent(int pos) {
        return pos / 2;
    }

    private int l_child(int pos) {
        return (2 * pos);
    }

    private int r_child(int pos) {
        return (2 * pos) + 1;
    }

    private boolean checkleaf(int pos) {
        if (pos - 1 >= (size / 2) && pos <= size) {
            return true;
        }
        return false;
    }

    public int size() {
        return size;
    }

    private void swap(int fpos, int spos) {
        Path tmp;
        tmp = Binaryminheap[fpos];
        Binaryminheap[fpos] = Binaryminheap[spos];
        Binaryminheap[spos] = tmp;
    }

    private void minBinaryminheapify(int pos) {
        if (!checkleaf(pos) && this.size > 0) {
            if (Binaryminheap[pos].distance > Binaryminheap[l_child(pos)].distance
                    || Binaryminheap[pos].distance > Binaryminheap[r_child(pos)].distance) {
                if (Binaryminheap[l_child(pos)].distance < Binaryminheap[r_child(pos)].distance) {
                    swap(pos, l_child(pos));
                    minBinaryminheapify(l_child(pos));
                } else {
                    swap(pos, r_child(pos));
                    minBinaryminheapify(r_child(pos));
                }
            }
        }
    }

    public void insert(Path element) {
        Binaryminheap[++size] = element;
        int current = size;
        while (Binaryminheap[current].distance < Binaryminheap[parent(current)].distance) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    public Path extract() {
        Path popped = Binaryminheap[FRONT];
        Binaryminheap[FRONT] = Binaryminheap[size--];
        minBinaryminheapify(FRONT);
        return popped;
    }

    //Constructor
    public Binaryminheap(int maxsize) {
        this.maxsize = maxsize;
        this.size = 0;
        Binaryminheap = new Path[this.maxsize + 1];
        Binaryminheap[0] = new Path("null", (double) Integer.MIN_VALUE);
    }

}


/*
 * This is the main class which initializes and handles all the operations related to the Graph.
 */
public class Graph {


    Map<String, Vertex> vertices_map = new HashMap<String, Vertex>(); //Hashmap used to store vertices with their name as key.

    LinkedList<Pair> downlist = new LinkedList<Pair>(); //List containing all the edges which are disabled.

    TreeSet<String> reachable_vertices = new TreeSet<String>(); // TreeSet to generate tree to find the reachable nodes

    static final int Inf = Integer.MAX_VALUE; //stores infinity value
    
    ArrayList<String> route_path = new ArrayList<>();
    
    
    public String a[] = new String[]{  
    		"Northborough, MA",	
    		  "Edison, NJ",	
    		  "Pittsburgh, PA",	
    		  "Allentown, PABD Strap Endlinksth",	
    		  "Martinsburg, WV",	
    		  "Charlotte, NC",	
    		  "Atlanta, GA",	
    		  "Orlando, FL",	
    		  "Memphis, TN",	
    		  "Grove City, OH",	
    		  "Indianapolis, IN",	
    		  "Detroit, MI",	
    		  "New Berlin, WI",	
    		  "Minneapolis, MN",	
    		  "St. Louis, MO",	
    		  "Kansas, KS",	
    		  "Dallas, TX",	
    		  "Houston, TX",	
    		  "Denver, CO",	
    		  "Salt Lake City, UT",	
    		  "Phoenix, AZ",	
    		  "Los Angeles, CA",	
    		  "Chino, CA",	
    		  "Sacramento, CA",	
    		  "Seattle, WA"	
};

    
    public String b[] = new String[]{  
    		  "Edison, NJ",
    		  "Pittsburgh, PA",
    		  "Allentown, PABD Strap Endlinksth",
    		  "Martinsburg, WV",
    		  "Charlotte, NC",
    		  "Atlanta, GA",
    		  "Orlando, FL",
    		  "Memphis, TN",
    		  "Grove City, OH",
    		  "Indianapolis, IN",
    		  "Detroit, MI",
    		  "New Berlin, WI",
    		  "Minneapolis, MN",
    		  "St. Louis, MO",
    		  "Kansas, KS",
    		  "Dallas, TX",
    		  "Houston, TX",
    		  "Denver, CO",
    		  "Salt Lake City, UT",
    		  "Phoenix, AZ",
    		  "Los Angeles, CA",
    		  "Chino, CA",
    		  "Sacramento, CA",
    		  "Seattle, WA",
    		  ""


};
    
    public String c[] = new String[]{  
"",    		
    		  "Northborough, MA",	
    		  "Edison, NJ",	
    		  "Pittsburgh, PA",	
    		  "Allentown, PABD Strap Endlinksth",	
    		  "Martinsburg, WV",	
    		  "Charlotte, NC",	
    		  "Atlanta, GA",	
    		  "Orlando, FL",	
    		  "Memphis, TN",	
    		  "Grove City, OH",	
    		  "Indianapolis, IN",	
    		  "Detroit, MI",	
    		  "New Berlin, WI",	
    		  "Minneapolis, MN",	
    		  "St. Louis, MO",	
    		  "Kansas, KS",	
    		  "Dallas, TX",	
    		  "Houston, TX",	
    		  "Denver, CO",	
    		  "Salt Lake City, UT",	
    		  "Phoenix, AZ",	
    		  "Los Angeles, CA",	
    		  "Chino, CA",	
    		  "Sacramento, CA",	
};

    /*
    Main function which parses the input file( whose filename is provided by the command line argument) and stores the graph
    */
    
    
    public void init(){
    	
    	    	
    	for(int i =0; i<a.length;i++){
    		if(!b[i].matches(""))
    		{	addEdge(a[i], b[i], 1);
    			addEdge(b[i], a[i], 1);
    		}
    	}
    	
    	
    	for(int i =0; i<a.length;i++){
    		if(!c[i].matches(""))
    		{	addEdge(a[i], c[i], 1);
    			addEdge(c[i], a[i], 1);
    		}
    	}
    
    }
    
    
    
    public ArrayList<String> startfinding(String source,String destination){
    	find_path(source,destination) ;
    	return route_path;

    }
private void find_path(String sou,String dest) {
		// TODO Auto-generated method stub
	     try {
			dijkstra(sou);
			printPath(dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
}



    public void addEdge(String sName, String dname, double distance) {
        int i = 0;
        int update = 0;
        Vertex v = getVertex(sName);
        Vertex w = getVertex(dname);

        Iterator<Edge> listIterator;
        listIterator = v.adjacent.listIterator();

        while (listIterator.hasNext()) {

            Edge e = listIterator.next();

            if (w.name.equals(e.dname.name)) {
                v.adjacent.get(i).distance = distance;
                update = 1;
            }
            i++;
        }
        if (update == 0)
            v.adjacent.add(new Edge(w, distance));
    }


 

     public void dijkstra(String startName) throws IOException {
        clearAll();

        Binaryminheap pQueue = new Binaryminheap(vertices_map.size());

        Vertex start = vertices_map.get(startName);
        if (start == null){
            System.out.println("Start vertex not found");return;
        }
        if (start.status != "UP"){
            System.out.println("Vertex is Down");
            return;
        }

        start.distance = 0.0;

        pQueue.insert(new Path(start.name, start.distance));

        while (pQueue.size() != 0) {
            Vertex v = getVertex(pQueue.extract().str);

            for (Edge e : v.adjacent) {
                Vertex w = e.dname;
                if (w.status != "UP")
                    continue;
                if (isEdgeDown(v.name, w.name))
                    continue;

                double cvw = e.distance;

                if (cvw < 0)
                    throw new Exception_for_Graph("Graph has negative edges");
                if (w.distance > v.distance + cvw) {
                    w.distance = v.distance + cvw;
                    w.previous = v;

                    pQueue.insert(new Path(w.name, w.distance));
                }
            }
        }
    }

     //This function returns the vertex from the Hashmap if the vertex is present otherwise creates a new vertex.
     private Vertex getVertex(String vertex_name) {
         Vertex v = vertices_map.get(vertex_name);
         if (v == null) {
             v = new Vertex(vertex_name);
             vertices_map.put(vertex_name, v);
         }
         return v;
     }

     // This function is used to delete all the vertices from the map.
     private void clearAll() {
        for (Vertex v : vertices_map.values())
            v.reset();
    }

    // This function is used to enable the vertex by setting it's status as UP. One the vertex is set as UP,
    // it can be used to calculate shortest path.
    public void vertexUp(String str) {
        Vertex v = vertices_map.get(str);
        v.status = "UP";
    }

    // This function is used to disable the vertex by setting it's status as DOWN.
    // Once the vertex is DOWN all the edges connected to it will be set as DOWN.
     public void vertexDown(String str) {
        Vertex v = vertices_map.get(str);
        v.status = "DOWN";
    }

    // This function is used to enable the edge by removing it from the downlist, if the edge was in the downlist.
     public void edgeUp(String source, String dest) {

        Iterator<Pair> itr = downlist.iterator();
        int exist = 0;
        Pair temp = null;

        if (downlist.size() != 0) {
            while (itr.hasNext()) {
                temp = itr.next();
                if (source.equals(temp.key()) && dest.equals(temp.value())) {
                    exist = 1;
                    break;
                }
            }
        }
        if (exist == 1)
            downlist.remove(temp);
    }

        // This function adds the edge to the downlist and makes it disable so thar it can not be traversed..
      public void edgeDown(String source, String dest) {
        Iterator<Pair> itr = downlist.iterator();
        int add = 1;

        if (downlist.size() != 0) {
            while (itr.hasNext()) {
                Pair temp = itr.next();
                if (temp.key() == source && temp.value() == dest) {
                    add = 0;
                    break;
                }
            }
        }

        if (add == 1)
            downlist.add(new Pair(source, dest));
    }

    // This function is used to delete the edge from the graph
   public void removeEdge(String sName, String dname) {
        Vertex v = getVertex(sName);
        Vertex w = getVertex(dname);
        int removed = 0;

        Iterator<Edge> listIterator = v.adjacent.listIterator();
        int i = 0;
        while (listIterator.hasNext()) {

            Edge e = listIterator.next();

            if (w.name.equals(e.dname.name)) {
                removed = 1;
                break;
            }
            i++;
        }
        if (removed == 1)
            v.adjacent.remove(i);
    }

    // This function returns true if edge is disabled otherwise false.
    public Boolean isEdgeDown(String source, String dest) {
        Iterator<Pair> itr = downlist.iterator();
        int down = 0;

        if (downlist.size() != 0) {
            while (itr.hasNext()) {
                Pair temp = itr.next();
                if (temp.key().equals(source) && temp.value().equals(dest)) {
                    down = 1;
                    break;
                }
            }
        }

        if (down == 0)
            return false;
        else
            return true;
    }

    // This function is used to print the graph in Alphabetical order.
    // It will also print the down vertices with "DOWN" return along with it.    // This recursive function is used to print the shortest path to the destination vertex.
     private void printPath(Vertex dest) throws IOException {
        if (dest.previous != null) {
            printPath(dest.previous);
            System.out.print(" ");

        }
        System.out.print(dest.name);
        route_path.add(dest.name);
        
        //second_write(dest.name);
    }

     public void printPath(String dname) throws IOException {
        Vertex w = vertices_map.get(dname);
        
        if (w == null){
            System.out.println("Destination vertex not found");
          //  second_write("\nDestination vertex not found");
            return;
        }
        else if (w.distance == Inf) {
            System.out.println(dname + " is unreachable");
            //second_write("\n" +dname + " is unreachable");
        }
        else {
            System.out.println();
            //second_write("\n");
            printPath(w);
            System.out.printf(" %.2f", w.distance);
            //second_write(String.format(" %.2f", w.distance));
            System.out.println();
          }
    }


/*
     * REACHABLE-VERTICES ALGORITHM
     * This algorithm will be used to display the set of vertices reachable from each vertex by
     * valid paths in alphabetical order.
     *
     * ALGORITHM ->
     *
     * 		REACHABLE-VERTICES( )
     * 		Sort all the vertices in alphabetical order.
     * 		foreach Vertex which is UP
     * 		 		print v_name
     * 				add Vertex to visited_nodes list
     * 				call REACHABLE(Vertex) algorithm
     *
     * 		endforeach;
     * 		print all the Vertices from visited_nodes in alphabetical order
     *
     * 		REACHABLE(Vertex)
     * 		foreach adjacent vertices
     * 				if(edge is down or vertex is down) then
     * 					continue
     *
     * 				if(Vertex exists in visited_node list) then
     * 					continue
     * 				else
     * 					add vertex to visited nodes list
     * 					call REACHABLE(Vertex)
     *
     * 		endforeach;
     *
     *
     * Complexity -
     * The algorithm REACHABLE is a recursive algorithm which will call itself for all the adjacent
     * vertices, thus will run for O(logn) times. The algorithm REACHABLE-VERTICES( ) will be
     * executed n times for each of the n vertices thus taking O(n*logn) time for the whole operation
     * to execute.
     *
     * Thus, overall complexity to find reachable vertices - O(nlogn)
     *
*/

    private void Reachable_ALgorithm() throws IOException {

        TreeSet<String> tree = new TreeSet<String>();

        System.out.println();

        for (String key : vertices_map.keySet()) {   // Finding the list of vertices which are valid( UP ).
            if (vertices_map.get(key).status != "UP")
                continue;
            tree.add(key);
        }

        Iterator<String> itr = tree.iterator();


        while (itr.hasNext()) {
            String adjacentN = itr.next();
            System.out.print(adjacentN);
            System.out.println();

            reachable_vertices.clear();
            reachable_vertices.add(adjacentN);

            reachable(adjacentN); // For every adjacent node reachable is called.

            Iterator<String> adjacentItr = reachable_vertices.iterator();
            while (adjacentItr.hasNext()) {
                String adjacentItrN = adjacentItr.next();
                if (adjacentItrN != adjacentN) {
                    System.out.println("  " + adjacentItrN);
                }
            }

        }
    }

    // This function will be called by itself( Recursive) until all the adjacent vertices are found.
    private void reachable(String node) {

        TreeSet<String> adjacent = new TreeSet<String>();
        for (Edge key : vertices_map.get(node).adjacent) {
            if (key.dname.status != "UP")
                continue;
            if (isEdgeDown(node, key.dname.name))
                continue;

            adjacent.add(key.dname.name);
        }
        for (String str : adjacent) {
            if (reachable_vertices.contains(str))
                continue;
            else {
                reachable_vertices.add(str);
                reachable(str);
            }
        }
    }
}

// User-Defined exception which executes anytime the graph throws an exception.
class Exception_for_Graph extends RuntimeException {
    public Exception_for_Graph(String name) {
        super(name);
    }
}

class Vertex {
    public String name; // Vertex name
    public List<Edge> adjacent; // Adjacent vertices
    public Vertex previous; // Variable used to show the previous vertex on the shortest path.
    public Double distance; // Variable used to store the distance.
    public String status; // Status

    // Initializes the Vertex with default status as "UP".
    public Vertex(String nm) {
        name = nm;
        adjacent = new LinkedList<Edge>();
        status = "UP";
        reset();
    }

    // Resets the distance of Vertex to infinity and pointer to previous Vertex as NULL.
    public void reset() {
        distance = (double) Graph.Inf;
        previous = null;
    }

}



// Base class to store the edge information.
class Edge {
    public Vertex dname;
    public double distance;

    public Edge(Vertex w, double d) {
        dname = w;
        distance = d;
    }
}

// Base class which is used by Min-heap to create the Min-heap of the tree.
class Path {
    public String str;
    public double distance;

    public Path(String s, Double d) {
        str = s;
        distance = d;
    }

}

// Base class which is used in Graph class to represent edges.
class Pair {
    private final String str1;
    private final String str2;

    public Pair(String aStr1, String aStr2) {
        str1 = aStr1;
        str2 = aStr2;
    }

    public String key() {
        return str1;
    }

    public String value() {
        return str2;
    }
}




