public class edge {
    //Three String variable: store the name of the edge and two vertices of the edges
    private String name;
    private String node1_name;
    private String node2_name;
    //constructor
    public edge(String name,String node1_name,String node2_name){
        this.name=name;
        this.node1_name=node1_name;
        this.node2_name=node2_name;
    }
    //All the getter method for the variable
    public String getNode1_name(){ return node1_name;}
    public String getNode2_name(){ return node2_name;}
    public String getName(){return name;}
}
