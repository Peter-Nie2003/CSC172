Peter Nie && David Yang
email:jnie7@u.rochester.edu && yyand156@u.rochester.edu
------------------------------------------------------------------------------------------------------------------------
node class:
    -The node class has the variable store the longitude,latitude,name,distance from starting,the node they come_from.
    -A HashMap store the adjacent point of the node.
    -Contains the constructor for creating the new node and all the setter and getter function of the variable.
------------------------------------------------------------------------------------------------------------------------
edge class:
    -Three String variable: store the name of the edge and two vertices of the edges.
    -Contains the constructor and the variable getter functions.
------------------------------------------------------------------------------------------------------------------------
graph class:
    -A inner class which is a node comparator class, overwrite the compare() method. Use the distance between two node as the
    compare data.
    -Contains two HashMap as variable store the node and edge in the graph
    -A priority queue use the node comparator, which is useful in the Dijkstra algorithm.
    -A variable store the target node.
    -the add functions and getter functions for the node and edge HashMap.
    -addAdj() update the adjacent node of the node in the HashMap.
    -distance() the algorithm calculate the distance between the two address in the earth.
    -Dijkstra() the Dijkstra algorithm to calculate the shortest distance between the other node and starting node
    -In Dijkstra algorithm we just do some improve. When we find the target point was dequeue from the priority queue we
    just stop the algorithm.
------------------------------------------------------------------------------------------------------------------------
StreetMap class:
    -contains a HashMap store the node data.
    -contains a HashMap store the edge data
    -The X_max, X_min,Y_max,Y_min store the biggest and smallest latitude and longitude in the node
    -Frame_x,Frame_y store the width and height of the Frame.
    -endNode store the target node in the graph.
    -contains the getter and setter method for all the variable.
    -contains a constructor initialize the Frame default size.
    -A panel on the frame and rewrite the paintComponent(), draw all the edge in the graph first. If there is target node
    use red color to draw the shortest path from starting point to the target point.
    -printDistance(node) print out the distance from starting point to target point.
    -findMAXMIN(HashMap) find the biggest and smallest longitude/latitude in the node and set up the class variable.
    -main() use filereader to read the input file.add the node and edge in the graph class.
    -display the graph according different case.
------------------------------------------------------------------------------------------------------------------------
Runtime:
ur.txt: just for the map:<1s       map+path:<1s
monroe.txt: just for the map:~1s   map+path:~1s
nys.txt:just for the map:~2s       map+path:~3s
------------------------------------------------------------------------------------------------------------------------
Workload distribution:
Peter Nie: the code of paint the graph. code the StreetMap class.
David Yang: the part of graph implementation and the dijkstra algorithm.
------------------------------------------------------------------------------------------------------------------------
Implementation of the graph:
-Use two HashMap to implement the graph.
-One store the node and one store the edge.
-every node contain a HashMap that store their adjacent node.
-use the HashMap is decrease the run time for find the node or the edge in the graph.
------------------------------------------------------------------------------------------------------------------------
obstacle:
how to use the longitude and latitude draw a correct graph in the swing.
how to improve the run time of dijkstra.
Hard to debug when the swing draw nothing in the panel.