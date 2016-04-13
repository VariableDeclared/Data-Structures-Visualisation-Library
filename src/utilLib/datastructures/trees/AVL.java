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
    private static final int LL = 0;
    private static final int RR = 1;
    private static final int LR = 2;
    private static final int RL = 3;
    
    public AVL()
    {
        super();
    }
    @Override
    public Node<Integer, V> insert(Node<Integer, V> node)
    {
        Node<Integer, V> insertedNode = super.insert(node);
        rebalanceTree();
        
        return insertedNode;
    }
    private void rotate(Node<Integer, V> node, int rotation)
    {
        switch(rotation)
        {
            case LL:
                node.getLeft().setRight(node);
                node.setLeft(node.getLeft().getLeft().getLeft());
                break;
            case RR:
                node.getRight().setLeft(node);
                node.setRight(node.getRight().getRight().getRight());
                break;
            case LR:
                
                break;
            case RL:
                
                break;
                
        }
    }
    private void rebalanceTree()
    {
        //System.out.println(getBalanceFactor(this._root));
        traverseTree(PREORDER, _root,node -> {
            int balanceFactor = getBalanceFactor(node);
            if(balanceFactor >= -1 || balanceFactor <= 1)
            {} //no rebalancing required.
            else if (balanceFactor < 0) //right heavy
            {
                if(balanceFactor == -2)
                {
                    
                }
                else
                {
                    
                }
            }
            else //left heavy
            {
                
            }
        });
    }
    private int getBalanceFactor(Node<Integer, V> node)
    {

        return getHeight(node.getLeft(),0) - getHeight(node.getRight(),0);
    }
    
}
