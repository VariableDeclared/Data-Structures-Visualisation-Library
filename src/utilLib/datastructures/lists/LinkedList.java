/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilLib.datastructures.lists;

import utilLib.datastructures.interfaces.*;
/**
 *
 * @author UP732011 UP732011@myport.ac.uk
 * @param <T> the type to be used for nodes of this list
 */
public class LinkedList<T> implements Queue<T>, Stack<T>, List<T>
{
    private DoubleyLinkedNode<T> head, tail;
    public LinkedList()
    {
        head = new DoubleyLinkedNode<>(null, null, null);
        tail = head;
    }
    public LinkedList(T[] items)
    {
        this();
        insertListOfItems(items);
        
    }
    public final void insertListOfItems(T [] items)
    {
        if(items.length == 0)
            return;
        LLNode current = head;
        for(int i = 0; i < items.length; i++)
        {
            if(i == items.length)
            {
                tail = new DoubleyLinkedNode(items[i], null, 
                        new DoubleyLinkedNode(current));
                current.setNext(tail);
            }
            else
                current.setNext(new DoubleyLinkedNode(items[i], null, 
                        new DoubleyLinkedNode(current)));
        }
    }
    
    @Override
    public T getItem(T item)
    {
        DoubleyLinkedNode current = new DoubleyLinkedNode(head);
        
        throw new UnsupportedOperationException("Not implemented");
        //not implemented.
        //return null;
    }
    @Override
    public T pop()
    {
        T value = head.getValue();
        head.setPrevious(null);
        head = new DoubleyLinkedNode(head.getNext());
        return value;
    }
    @Override
    public boolean isEmpty()
    {
        return head.getNext() == null || tail == null;
    }
    
    @Override
    public void push(T value)
    {
        DoubleyLinkedNode newNode = new DoubleyLinkedNode(value, head, null);
        head.setPrevious(newNode);
        head = newNode;
    }
    @Override
    public void enqueue(T value)
    {
        DoubleyLinkedNode newNode = new DoubleyLinkedNode(value, head, null);
        head.setPrevious(newNode);
        head = newNode;
    }
    @Override
    public T dequeue()
    {
        T value = tail.getValue();
        //delete the last node
        tail = tail.getPrevious();
        
        return value;
    }
}
