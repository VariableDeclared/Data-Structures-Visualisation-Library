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

/**
 *
 * @author UP732011 <UP732011@myport.ac.uk>
 */
public class BSTPanel extends JPanel {
    BST<String> _tree;
    public BSTPanel(BST tree)
    {
        super();
        _tree = tree;
    }
    public void paint(Graphics g)
    {
        super.paint(g);
        
        int treeHeight = _tree.getHeight(_tree.getRoot(), 0);
        int nodeWidth = (int)Math.round((1/Math.pow(2, treeHeight-1))
                *this.getWidth());
        
        System.out.println(Math.round(0.2*this.getHeight()));
        drawTree((Graphics2D) g,nodeWidth, treeHeight, 
                Math.round(0.2f*this.getHeight()), _tree.getRoot(), 1, 0);
    }
    private void drawTree(Graphics2D g,int nodeWidth,
            int treeHeight, int nodeHeight, Node<Integer, String> node, int sequence,
            int level)
    {
        
        int xPos = (int) Math.round(nodeWidth*sequence);
        int yPos = (int) Math.round(nodeHeight*level);
        System.out.println(yPos);
        g.setColor(Color.BLACK);
        g.fillOval(xPos, yPos, nodeWidth, nodeWidth);
        g.setColor(Color.WHITE);
        g.drawString(node.getKey().toString(), xPos, yPos);
        level += 1;
        if(node.getLeft() != null)
        {
            //draw line
            drawTree(g,nodeWidth, 
                    treeHeight, nodeHeight,node.getLeft(), 1, level);
        }
        else if (node.getRight() != null)
        {
            drawTree(g,nodeWidth,
                    treeHeight, nodeHeight, node.getRight(), 2, level);
        }

        
        
        
        
        
    }
            
}
