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
        Node child, cr;
        System.out.println("Rotating: "+ rotation);
        traverseTree(INORDER, _root, elm -> 
            {System.out.println(elm.getValue()); });
        switch(rotation)
        {
            
            case LL:
                child = node.getLeft();
                node.setLeft(child.getRight());
                child.setRight(node);
                break;
            case RR:
                child = node.getRight();
                node.setRight(child.getLeft());
                child.setLeft(node);
                break;
            case LR:
                child = node.getLeft();
                cr = child.getRight();
                child.setRight(cr.getLeft());
                node.setLeft(cr.getRight());
                break;
            case RL:
                child = node.getRight();
                cr = child.getLeft();
                child.setLeft(cr.getRight());
                node.setRight(cr.getLeft());
                break;
                
        }
        
        traverseTree(INORDER, _root, elm -> 
            {System.out.println(elm.getValue()); });
    }
    private void rebalanceTree()
    {
        //System.out.println(getBalanceFactor(this._root));
        traverseTree(INORDER, _root, node -> {
            
            int balanceFactor = getBalanceFactor(node);
            //System.out.println(node.getValue() + " : " + balanceFactor);
            if(balanceFactor >= -1 && balanceFactor <= 1)
            {} //no rebalancing required.
            else if (balanceFactor < 0) //right heavy
            {
                if(balanceFactor == -2)
                {
                    
                    rotate(node, RR);
                }
                else
                {
                    rotate(node, RL);
                }
            }
            else //left heavy
            {
                if(balanceFactor == 2)
                {
                    rotate(node, LL);
                }
                else
                {
                    rotate(node, LR);
                }
            }
            balanceFactor = getBalanceFactor(node);

            //System.out.println(node.getValue() + " after  : " + balanceFactor);
        });
    }
    private int getBalanceFactor(Node<Integer, V> node)
    {

        return getHeight(node.getLeft(),0) - getHeight(node.getRight(),0);
    }
    
}
