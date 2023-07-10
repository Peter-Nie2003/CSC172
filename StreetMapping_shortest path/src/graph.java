
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class graph{
    //The comparator class
    public static class nodeComparator implements Comparator<node> {
        @Override
        //use the distance as the comparator
        public int compare(node a, node b) {
            if(a.getDistance() - b.getDistance()<0) return -1;
            else if(a.getDistance() - b.getDistance()>0) return 1;
            else return 0;
        }
    }
    public node Endnode; //The target point
    private HashMap<String,node> nodemap=new HashMap<>();//The HashMap store all the node
    private HashMap<String,edge> edgemap=new HashMap<>();//The HashMap store all the edge
    private PriorityQueue<node> PQ = new PriorityQueue<>(new nodeComparator());//The PQ used in Dijkstra algorithm
    //4 getter and setter method
    public HashMap getnodemap(){ return nodemap;}
    public HashMap getedgemap(){return edgemap;}

    public void setEndnode(String t){ Endnode=nodemap.get(t);}
    public node getEndnode(){return Endnode;}

    //Functions add the add adjacent point
    public void addAdj(String s,String t){
        nodemap.get(s).addAdj_point(t,nodemap.get(t));
    }

    //Functions calculate the distance between 2 address use the longitude and latitude
    public static double distance(double lat1, double lon1, double lat2, double lon2) {
        final int R = 6371; // Radius of the earth in km
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                        Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = R * c; // Distance in km
        return distance;
    }
    public void add_node(node a){ nodemap.put(a.getName(),a);}//add the node into the HashMap
    public void add_edge(edge a){ edgemap.put(a.getName(),a);}//add the edge into the HashMap
    //Dijkstra algorithm, update the distance of each node
    public void Dijkstra(String s,String t){
        setEndnode(t);//update the target point
        nodemap.get(s).setDistance(0);
        PQ.add(nodemap.get(s));
        while(PQ.size()!=0){
            node p=PQ.poll();
            if(p.getName().equals(t)) break;
            for(node value: p.getAdj().values()) {
                double weight =distance(p.getLatitude(),p.getLongitude(),value.getLatitude(), value.getLongitude());
               if(p.getDistance()+weight<value.getDistance()){
                   nodemap.get(value.getName()).setDistance(p.getDistance()+weight);
                   nodemap.get(value.getName()).setCome_from(p);
                   PQ.remove(nodemap.get(value.getName()));
                   PQ.add(nodemap.get(value.getName()));
               }
            }
        }

        }
    }


