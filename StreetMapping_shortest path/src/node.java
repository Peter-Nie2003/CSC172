
import java.util.HashMap;

public class node  {
    //variable store the longitude,latitude,name,distance from starting,the node they come_from
    private double Longitude;
    private double Latitude;
    private String name;
    private double distance= Double.POSITIVE_INFINITY;
    private node come_from=null;
    private HashMap<String, node> adjacent_point=new HashMap<>(); //The HashMap store the adjacent point
    //constructor
    public node(double longitude,double latitude,String name){
        this.Longitude=longitude;
        this.Latitude=latitude;
        this.name=name;
    }
    //The setter and getter method for all the class variable

    public void addAdj_point(String a,node b){
        adjacent_point.put(a,b);
    }//add the adjacent point
    public double getDistance(){ return distance;}
    public void setCome_from(node a){ come_from=a;}
    public void setDistance(double a){ distance=a;}
    public String getName(){ return name;}
    public HashMap<String, node> getAdj(){ return adjacent_point;}
    public double getLongitude(){return Longitude;}
    public double getLatitude(){return Latitude;}
    public node getCome_from(){return come_from;}

}
