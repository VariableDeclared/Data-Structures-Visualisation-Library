/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilLib.datastructures.interfaces;

/**
 *
 * @author UP732011 <UP732011@myport.ac.uk>
 */
public interface Queue<T>
{
    public void enqueue(T value);
    public T dequeue();
    
}
