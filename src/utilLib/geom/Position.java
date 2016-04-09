/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilLib.geom;

/**
 *
 * @author UP732011 <UP732011@myport.ac.uk>
 */
public class Position {
    private final Number _x, _y;
    
    public Position(Number x, Number y)
    {
        _x = x;
        _y = y;
        
    }
    public Position()
    {
        this(new Integer(0),new Integer(0));
    }
    public Number getX()
    {
        return _x;
    }
    public Number getY()
    {
        return _y;
    }
}
