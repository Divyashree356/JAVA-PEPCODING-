import java.io.*;
import java.util.*;

public class Main {
   static class Edge {
      int src;
      int nbr;
      int wt;

      Edge(int src, int nbr, int wt) {
         this.src = src;
         this.nbr = nbr;
         this.wt = wt;
      }
   }

   public static boolean checkCyclic(ArrayList<Edge>[] graph , boolean[] vis , int src)
   {
      Queue<Integer> q= new LinkedList<>();
      q.add(src);
      
      while(!q.isEmpty())
      {
         int rem= q.remove();
         
         if(vis[rem])
           return true;

        vis[rem]=true;
        for(Edge e: graph[src])
         {
            int nbr=e.nbr;

            if(!vis[nbr])
             q.add(nbr);
            
         }
      }
return false;

      }
   
   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int vtces = Integer.parseInt(br.readLine());
      ArrayList<Edge>[] graph = new ArrayList[vtces];
      for (int i = 0; i < vtces; i++) {
         graph[i] = new ArrayList<>();
      }

      int edges = Integer.parseInt(br.readLine());
      for (int i = 0; i < edges; i++) {
         String[] parts = br.readLine().split(" ");
         int v1 = Integer.parseInt(parts[0]);
         int v2 = Integer.parseInt(parts[1]);
         int wt = Integer.parseInt(parts[2]);
         graph[v1].add(new Edge(v1, v2, wt));
         graph[v2].add(new Edge(v2, v1, wt));
      }

   
    boolean[] vis= new boolean[vtces];
    for(int i=0;i<vtces;i++)
{
   if(!vis[i])
      {
      boolean ans=  checkCyclic(graph , vis ,i);
      if(ans==true)
       {
          System.out.println(ans);
          return;
      }
      }
}
System.out.println(false);
   }
}
