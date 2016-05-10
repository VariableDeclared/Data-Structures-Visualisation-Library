/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilLib.datastructures.lists;

/**
 *
 * @author UP732011 UP732011@myport.ac.uk
 * @param <T> the type of this DLNode
 */
public class DoubleyLinkedNode<T> extends LLNode<T>
{
    private DoubleyLinkedNode<T> _previous;
    public DoubleyLinkedNode(T value, DoubleyLinkedNode<T> next,
            DoubleyLinkedNode<T> previous)
    {
        super(value, next);
        _previous = previous;
        
    }
    public DoubleyLinkedNode(LLNode<T> node)
    {
        super(node.getValue(), node._next);
        _previous = null;
    }
    public synchronized void setPrevious(DoubleyLinkedNode<T> previous)
    {
        _previous = previous;
    }
    public DoubleyLinkedNode<T> getPrevious()
    {
        return _previous;
    }
    
}
