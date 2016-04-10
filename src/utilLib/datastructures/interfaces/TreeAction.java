/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilLib.datastructures.interfaces;
import utilLib.datastructures.trees.Node;
/**
 *
 * @author UP732011 <UP732011@myport.ac.uk>
 */
public interface TreeAction<V> {
    public void action(Node<Integer, V> node);
}
