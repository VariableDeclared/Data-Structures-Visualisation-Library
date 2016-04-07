/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilLib.datastructures.trees;

/**
 *
 * @author UP732011 <UP732011@myport.ac.uk>
 */
public class Node<K, V> {
    private final V _value;
    private final K _key;
    private Node<K, V> _left, _right;
    public Node(K key, V value)
    {
        this(key, value, null, null);
    }
    protected Node(K key, V value, Node<K, V> left)
    {
        this(key, value, left, null);
    }
    protected Node(K key, V value, Node<K, V> left, Node<K, V> right)
    {
        _key = key;
        _value = value;
        _left = left;
        _right = right;
    }
    public K getKey()
    {
        return _key;
    }
    public V getValue()
    {
        return _value;
    }
    public void setRight(Node<K, V> right)
    {
        _right = right;
    }
    public void setLeft(Node<K, V> left)
    {
        _left = left;
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
