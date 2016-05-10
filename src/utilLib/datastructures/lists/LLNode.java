/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilLib.datastructures.lists;

/**
 *
 * @author UP732011 UP732011@myport.ac.uk
 * @param <T> the type for this LL node
 */
public class LLNode<T>
{
    protected final T _value;
    protected LLNode<T> _next;
    public LLNode(T value, LLNode<T> next)
    {
        _value = value;
        _next = next;
    }
    public T getValue()
    {
        return _value;
    }
    public LLNode<T> getNext()
    {
        return _next;
    }
    public void setNext(LLNode<T> next)
    {
        _next = next;
    }
}
