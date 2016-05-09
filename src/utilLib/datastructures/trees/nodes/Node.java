/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilLib.datastructures.trees.nodes;

/**
 *
 * @author UP732011 UP732011@myport.ac.uk
 */
public class Node<K, V> {
    
    private final V _value;
    private final K _key;
    protected Node<K, V> _left, _right, _parent;
    public Node(K key, V value)
    {
        this(key, value, null);
    }
    protected Node(K key, V value, Node<K, V> left)
    {
        this(key, value, left, null);
    }
    protected Node(K key, V value, Node<K, V> left, Node<K, V> parent)
    {
        this(key, value, left, null, parent);
    }
    protected Node(K key, V value, Node<K, V> left,
            Node<K, V> right, Node<K, V> parent)
    {
        _key = key;
        _value = value;
        _left = left;
        _right = right;
        _parent = parent;
    }
    public K getKey()
    {
        return _key;
    }
    public V getValue()
    {
        return _value;
    }
    protected void setParent(Node<K, V> node)
    {
        _parent = node;
    }
    public Node<K, V> getParent()
    {
        return _parent;
    }
    private void nullParent(Node node)
    {
        if(node == null)
            return; //do nothing
        node.setParent(null);
    }
    private void changeNode(Node node, Node replacement, Branch side)
    {
        if(side == null)
        {return;} //do nothing
        
        Node target;
        
        if(side == Branch.LEFT)
        {
            target = node.getLeft();
            node._left = replacement;
        }
        else
        {
            target = node.getRight();
            node._right = replacement;
        }
        nullParent(target);
        if(replacement != null)
            replacement.setParent(node);
 
    }
    public void setRight(Node<K, V> right)
    {
        changeNode(this, right, Branch.RIGHT);
    }
    public void setLeft(Node<K, V> left)
    {
        changeNode(this, left, Branch.LEFT);
    }
    public Node<K, V> getRight()
    {
        return _right;
    }
    public Node<K, V> getLeft()
    {
        return _left;
    }

}
