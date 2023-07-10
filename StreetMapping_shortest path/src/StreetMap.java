import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.geom.Line2D;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
//A JFrame class to paint the point out
public class StreetMap extends JFrame {
   private HashMap<String,node> nodemap;// A HashMap store the node data
   private HashMap<String,edge> edgemap;// A HashMap store the edge data
   // The X_max, X_min,Y_max,Y_min store the biggest and smallest latitude and longitude we have
   private double X_max;
   private double X_min;
   private double Y_max;
   private double Y_min;
   // Frame_x,Frame_y store the width and height of the Frame
   private int Frame_x;
   private int Frame_y;
   private node endNode;// store the target node in the graph
   //the getter and setter method
   public void setX_max(double a){  X_max=a;}
   public void setX_min(double a){  X_min=a;}
   public void setY_max(double a){  Y_max=a;}
   public void setY_min(double a){  Y_min=a;}
   public double getX_max(){ return X_max;}
   public double getX_min(){return X_min;}
   public double getY_max(){return Y_max;}
   public double getY_min(){return Y_min;}
   public void setFrame_x(int a){ Frame_x=a;}
   public void setFrame_y(int a){ Frame_y=a;}
   //Constructor
   public StreetMap(graph g) {
      super("map");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      Frame_x=800;
      Frame_y=750;
      setBounds(0,0,800,800);
      setVisible(true);
      setResizable(true);
      setFocusable(true);
      nodemap=g.getnodemap();
      edgemap=g.getedgemap();
      endNode=g.Endnode;

      JPanel panel = new JPanel() {
         @Override
         protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            findMAXMIN();
            double X_difference=getX_max()-getX_min();
            double Y_difference=getY_max()-getY_min();
            //paint the every edge out
            for (Map.Entry<String, edge> entry : edgemap.entrySet()) {
               edge value = entry.getValue();
               double Lon1=nodemap.get(value.getNode1_name()).getLongitude();
               double Lon2=nodemap.get(value.getNode2_name()).getLongitude();
               double lat1=nodemap.get(value.getNode1_name()).getLatitude();
               double lat2=nodemap.get(value.getNode2_name()).getLatitude();
               double x1=((Lon1+1000)-(getX_min()+1000))*((double)(Frame_x - 50)/X_difference);
               double x2=((Lon2+1000)-(getX_min()+1000))*((double)(Frame_x - 50)/X_difference);
               double y1=-1*(lat1-getY_max())*((double)(Frame_y - 50)/Y_difference);
               double y2=-1*(lat2-getY_max())*((double)(Frame_y - 50)/Y_difference);

               //g.drawLine(100,120,500,500);
               Graphics2D g2=(Graphics2D) g;
               Line2D line2D=new Line2D.Double(x1,y1,x2,y2);
               g2.draw(line2D);
            }
            g.setColor(Color.RED);
            node End=endNode;
            //If there is the target point, paint the shortest path from starting point to target point use red color
            while(true){
               if (End==null) break;
               else if(End.getCome_from()==null) break;
               node farther=End.getCome_from();
               double Lon1=End.getLongitude();
               double Lon2=farther.getLongitude();
               double lat1=End.getLatitude();
               double lat2=farther.getLatitude();
               double x1=((Lon1+1000)-(getX_min()+1000))*((double)(Frame_x - 50)/X_difference);
               double x2=((Lon2+1000)-(getX_min()+1000))*((double)(Frame_x - 50)/X_difference);
               double y1=-1*(lat1-getY_max())*((double)(Frame_y - 50)/Y_difference);
               double y2=-1*(lat2-getY_max())*((double)(Frame_y - 50)/Y_difference);
               Graphics2D g2=(Graphics2D) g;
               Line2D line2D=new Line2D.Double(x1,y1,x2,y2);
               g2.draw(line2D);
               End=End.getCome_from();

            }
         }
      };
      panel.setBounds(0,0,800,750);
      add(panel);// add the panel to the frame


      //The Listener, when JFrame resized, repaint the graph
      panel.addComponentListener(new ComponentAdapter() {
         @Override
         public void componentResized(ComponentEvent e) {
            setFrame_x(getWidth());
            setFrame_y(getHeight());
            panel.repaint();
         }
      });
   }
   //print out the distance between starting point and target point
   public void printDistance(){
      if(endNode!=null) System.out.println(" the shortest distance is "+endNode.getDistance()+" km");
   }
   //The function find the biggest and smallest latitude or longitude in the node
   public void findMAXMIN(){
      double Xmax=Double.NEGATIVE_INFINITY;
      double Xmin=Double.POSITIVE_INFINITY;
      double Ymax=Double.NEGATIVE_INFINITY;
      double Ymin=Double.POSITIVE_INFINITY;
      for(node value:nodemap.values()){
         if(Xmax<value.getLongitude()) Xmax=value.getLongitude();
         if(Xmin>value.getLongitude()) Xmin=value.getLongitude();
         if(Ymax<value.getLatitude()) Ymax=value.getLatitude();
         if(Ymin>value.getLatitude()) Ymin=value.getLatitude();
      }
      setX_max(Xmax);setX_min(Xmin);setY_max(Ymax);setY_min(Ymin);
   }

   public static void main(String[] args) throws IOException {
      graph G = new graph();
      BufferedReader reader = new BufferedReader(new FileReader(args[0]));
      String input;
      while ((input = reader.readLine()) != null) {
         String[] In = input.split("\\s+");//use one space or more space split the String
         if (In[0].equals("i")) {
            G.add_node(new node(Double.parseDouble(In[3]), Double.parseDouble(In[2]), In[1]));//add mode
         } else {
            G.add_edge(new edge(In[1], In[2], In[3]));//add edge
            G.addAdj(In[2], In[3]);
            G.addAdj(In[3], In[2]);
            // update the adjacent
         }
      }
      //displace the graph in different case
      if(args[1].equals("--show")&&args.length<3){
         new StreetMap(G);
      }
      else if(args[1].equals("--directions")&&args.length<5){
         G.Dijkstra(args[2],args[3]);
         StreetMap map=new StreetMap(G);
         System.out.print("From "+args[2]+" to "+args[3]);
         map.printDistance();
      }
      else{
         G.Dijkstra(args[3],args[4]);
         StreetMap map=new StreetMap(G);
         System.out.print("From "+args[3]+" to "+args[4]);
         map.printDistance();
      }
   }
}
