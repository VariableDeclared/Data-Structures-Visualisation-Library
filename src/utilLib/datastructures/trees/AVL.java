/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilLib.datastructures.trees;

import utilLib.datastructures.interfaces.TreeAction;

/**
 *
 * @author UP732011 <UP732011@myport.ac.uk>
 */
public class AVL<V> extends BST<V> {
    
    @Override
    public Node<Integer, V> insert(Node<Integer, V> node)
    {
        Node<Integer, V> insertedNode = super.insert(node);
        rebalanceTree();
        
        return insertedNode;
    }
    private void rebalanceTree()
    {
        traverseTree(PREORDER, _root,node -> {
            
        });
    }
    private int getBalanceFactor(Node<Integer, V> node)
    {
        return getHeight(node.getLeft(),0) - getHeight(node.getRight(),0);
    }
    
}
