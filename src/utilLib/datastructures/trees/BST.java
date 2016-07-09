/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilLib.datastructures.trees;

import utilLib.datastructures.trees.nodes.Node;
import utilLib.datastructures.interfaces.TreeAction;


/**
 *
 * @author UP732011 UP732011@myport.ac.uk
 */
public class BST<V> {
    private Node<Integer, V> _root;
    public static final int PREORDER = 0;
    public static final int INORDER = 1;
    public static final int POSTORDER = 2;
    public BST()
    {
        _root = null;
    }

    public Node<Integer, V> insert(Node<Integer, V> node)
    {
       Node<Integer, V> result = searchTree(this.getRoot(), node.getKey());
       if(result == null)
           _root = node;
       else if (node.getKey() < result.getKey())
           result.setLeft(node);
       else
           result.setRight(node);

       return node;
     }
//    private Node getNext(SearchAlgos alg)
//    {
//        if(alg.equals(SearchAlgos.BFS))
//        {
//
//        }
//        else
//        {
//
//        }
//    }
    public void searchTree(SearchAlgos alg, Node<Integer, V> beginningNode,
            TreeAction action)
    {


        if(beginningNode == null)
            action.action(new Node("0","Nothing"));
        if(alg.equals(SearchAlgos.BFS))
        {
            Queue q = new LinkedList();
            q.add(beginningNode);
            while(!q.isEmpty())
            {
                Node current = (Node) q.poll();
                action.action(current);
                if(current.getLeft() != null)
                    q.add(current.getLeft());
                if(current.getRight() != null)
                    q.add(current.getRight());
            }
        }
        else
        {
            Stack s = new Stack();
            s.add(beginningNode);
            while(!s.empty())
            {

                Node current = (Node) s.pop();

                if(current.getLeft() != null)
                    s.add(current.getLeft());
                if(current.getRight() != null)
                    s.add(current.getRight());
                action.action(current);


            }
        }




       return node;

    }
    private Node<Integer, V> getRoot(Node node)
    {
        if(node == null || node.getParent() == null )
            return node;
        else
            return getRoot(node.getParent());
    }
    public Node<Integer, V> getRoot()
    {
        //make sure the root is the root.
        _root = getRoot(_root);
        return _root;
    }
    public void traverseTree(int traversalType, Node<Integer, V> node,
            TreeAction action)
    {
        if(node == null)
        {
            //action.action(node);
            return;
        }
        //preorder
        switch(traversalType)
        {
            case PREORDER:
                traverseTree(PREORDER, node.getLeft(), action);
                traverseTree(PREORDER, node.getRight(), action);
                action.action(node);
                break;
            case INORDER:
                traverseTree(INORDER, node.getLeft(), action);
                action.action(node);
                traverseTree(INORDER, node.getRight(), action);
                break;
            case POSTORDER:
                action.action(node);
                traverseTree(POSTORDER, node.getLeft(), action);
                traverseTree(POSTORDER, node.getRight(), action);
                break;
        }
    }
    public int getHeight(Node<Integer, V> node, int accumulator)
    {
        if(node == null)
            return accumulator -= 1;
        accumulator += 1;
        return Math.max(getHeight(node.getRight(), accumulator),
                getHeight(node.getLeft(),accumulator));
    }
    public Node<Integer,V> searchTree(Node<Integer, V> node, Integer key)
    {
        if(node == null)
        {
            return node;
        }
        if(node.getKey().equals(key))
            return node;
        else
        {
            Node<Integer, V> result;
            if(key < node.getKey())
                result = searchTree(node.getLeft(), key);
            else
                result = searchTree(node.getRight(), key);
            if(result == null)
                return node;
            else
                return result;
        }
    }
}
