/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graphtheory;

import java.awt.Color;
import java.awt.Point;
import java.util.Vector;
import java.awt.Graphics;

/**
 *
 * @author mk
 */
public class Vertex implements Comparable {

    public String name;
    public Point location;
    public boolean wasFocused;
    public boolean wasClicked;
    public boolean setWhite;
    public boolean setRed;
    public boolean setBlue;
    public boolean setGreen;
    public boolean setYellow;
    private int size1 = 30;
    private int size2 = 40;
    public Vector<Vertex> connectedVertices;

    public Vertex(String name, int x, int y) {
        this.name = name;
        location = new Point(x, y);
        connectedVertices = new Vector<Vertex>();
    }

    public void addVertex(Vertex v) {
        connectedVertices.add(v);
    }

    public boolean hasIntersection(int x, int y) {
        double distance = Math.sqrt(Math.pow((x - location.x), 2) + Math.pow((y - location.y), 2));

        if (distance > size2 / 2) {
            return false;
        } else {
            return true;
        }
    }

    public boolean connectedToVertex(Vertex v) {
        if (connectedVertices.contains(v)) {
            return true;
        }
        return false;
    }

    public int getDegree() {
        return connectedVertices.size();
    }

    public int compareTo(Object v) {
        if (((Vertex) v).getDegree() > getDegree()) {
            return 1;
        } else if (((Vertex) v).getDegree() < getDegree()) {
            return -1;
        } else {
            return 0;
        }
    }

    public void draw(Graphics g) {
        if (wasClicked) {
            g.setColor(Color.red);
        } else if (wasFocused) {
            g.setColor(Color.blue);
        } else if(setWhite) {
            g.setColor(Color.white);       	
        } else if(setRed) {
            g.setColor(Color.red);
        } else if(setGreen) {
            g.setColor(Color.green);        	
        } else if(setBlue) {
            g.setColor(Color.blue);        	
        } else if(setYellow) {
            g.setColor(Color.yellow);
        } else {
            g.setColor(Color.black);
        }

        g.fillOval(location.x - size2 / 2, location.y - size2 / 2, size2, size2);
        g.setColor(Color.WHITE);
        g.fillOval(location.x - size1 / 2, location.y - size1 / 2, size1, size1);
        g.setColor(Color.BLACK);
        g.drawString(name, location.x, location.y);
    }
}
