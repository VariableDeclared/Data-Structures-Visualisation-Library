/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilLib.datastructures.interfaces.graphs;

/**
 *
 * @author 732011 <up732011@myport.ac.uk>
 */
public interface AbstractGraph
{
    public AbstractGraph getGraphInstance();
    public int getEdgeConnectivity();
    public int getVertexConnectivity();
    public int getSmallestEdge();
    public boolean isGraphWeighted();
    public boolean isGraphDirected();
    //public AbstrctGraph(boolean isWeighted, boolean isDirected);
}
