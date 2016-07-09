/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilLib.datastructures.trees;

import utilLib.datastructures.interfaces.graphs.AbstractGraph;
import utilLib.datastructures.lists.LinkedList;

/**
 *
 * @author 732011 <up732011@myport.ac.uk>
 */
public class Graph implements AbstractGraph
{
    LinkedList adjacencyList;
    
    public Graph()
    {
        adjacencyList = new LinkedList();
    }

}
