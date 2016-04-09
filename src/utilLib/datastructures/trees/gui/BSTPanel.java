/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilLib.datastructures.trees.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import utilLib.datastructures.trees.*;
import utilLib.geom.*;
/**
 *
 * @author UP732011 <UP732011@myport.ac.uk>
 */
public class BSTPanel extends JPanel {
    BST<String> _tree;
    private static final int LEFT = 1;
    private static final int RIGHT = 2;
    public BSTPanel(BST tree)
    {
        super();
        _tree = tree;
    }
    public void paint(Graphics g)
    {
        super.paint(g);
        ((Graphics2D)g).setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        int treeHeight = _tree.getHeight(_tree.getRoot(), 0);
        float nodeWidth =
                new Double(this.getWidth()/(Math.pow(2, treeHeight+1)-1)).floatValue();
        
        System.out.println(treeHeight);
        drawTree((Graphics2D) g,nodeWidth, 
                Math.round(0.2f*this.getHeight()), _tree.getRoot(), 0, 
                new Position(Math.round(0.5*(this.getWidth()-nodeWidth)), 0));
    }
    private void drawTree(Graphics2D g, float nodeWidth,
            int treeHeight, Node<Integer, String> node,
            int level, Position pos)
    {
       //draw node
        g.setColor(Color.RED);
        g.fillOval(pos.getX().intValue(), pos.getY().intValue(), 
                Math.round(nodeWidth), Math.round(nodeWidth));
        g.setColor(Color.WHITE);
        g.fillOval(pos.getX().intValue()+3, pos.getY().intValue()+3, 
                Math.round(nodeWidth)-6, Math.round(nodeWidth)-6);
        g.setColor(Color.BLACK);
        g.drawString(node.getKey().toString(), pos.getX().intValue()+nodeWidth/2,
                pos.getY().intValue()+nodeWidth/2);
        level += 1;

        Integer y = new Long(Math.round(nodeWidth*level)).intValue();
        int roundedNodeWidth = Math.round(nodeWidth/2);
        int lineQuotient = Math.round(nodeWidth*0.85f);
        g.setColor(Color.RED);
        if(node.getLeft() != null)
        {
            Position leftPos = new Position(pos.getX().intValue()-nodeWidth, y);
            //draw line
            g.drawLine(pos.getX().intValue()+lineQuotient/2,
                    pos.getY().intValue()+lineQuotient,
                    leftPos.getX().intValue()+roundedNodeWidth,
                    leftPos.getY().intValue()+roundedNodeWidth);
            drawTree(g,nodeWidth,
                    treeHeight,node.getLeft(), level, leftPos);
            
        }
        if (node.getRight() != null)
        {
            Position rightPos = new Position(pos.getX().intValue()+nodeWidth, y);
            
             
            g.drawLine(pos.getX().intValue()+lineQuotient/2,
                    pos.getY().intValue()+lineQuotient,
                    rightPos.getX().intValue()+roundedNodeWidth,
                    rightPos.getY().intValue()+roundedNodeWidth);
            drawTree(g,nodeWidth, treeHeight, node.getRight(), level, rightPos);
            
        }

        
        
        
        
        
    }
            
}
