package flujoMexPue;


import flujoMexPue.Arbol;
import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Juan Jose Perez
 */
public class FlujoMaximo {
    
    int i;
    Arbol arbol;

    public boolean bfs(int rGraph[][], int s, int t, int parent[], int V)
    {
        boolean visited[] = new boolean[V];
        for(int i=0; i<V; ++i)
            visited[i]=false;
        
        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.add(s);
        visited[s] = true;
        parent[s]=-1;
 
        while (queue.size()!=0)
        {
            int u = queue.poll();
 
            for (int v=0; v<V; v++)
            {
                if (visited[v]==false && rGraph[u][v] > 0)
                {
                    queue.add(v);
                    parent[v] = u;
                    visited[v] = true;
                }
            }
        }
        return (visited[t] == true);
    }
    public int fordFulkerson(int graph[][], int s, int t, int V)
    {
        int u, v;
        int rGraph[][] = new int[V][V];
 
        for (u = 0; u < V; u++)
            for (v = 0; v < V; v++)
                rGraph[u][v] = graph[u][v];
        int parent[] = new int[V];
 
        int max_flow = 0; 
        while (bfs(rGraph, s, t, parent, V))
        {
            int path_flow = Integer.MAX_VALUE;
            for (v=t; v!=s; v=parent[v])
            {
                u = parent[v];
                path_flow = Math.min(path_flow, rGraph[u][v]);
            }
            for (v=t; v != s; v=parent[v])
            {
                u = parent[v];
                rGraph[u][v] -= path_flow;
                rGraph[v][u] += path_flow;
            }
            max_flow += path_flow;
        }
        return max_flow;
    }
    
    public int[][] mati(int i,Arbol arboles,int matriz, int tope){
        int matrizFinal[][] =new int[tope][tope];
        
                this.i=i;
        this.arbol=arboles;

        if(matriz==2){
         for (int j = 0; j < i; j++) {
            for (int k = 0; k < i; k++) {
                matrizFinal[j][k]=arboles.getmCoeficiente(j, k);
                
            }
         }
        }
        
        
        return matrizFinal;
    }
    
}
