package controller;

import model.Cat;
import model.Dog;
import view.MyFrame;
import view.MyPanel;
import model.SpeakBchavior;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RectangularShape;

public class Controller {
    Point2D [] points;
    Cat cat;
    Dog dog;
    SpeakBchavior enimal;
    MyPanel myPanel;
    MyFrame myFrame;
    RectangularShape currentShape;
    Rectangle2D rectangle2D;
    Ellipse2D ellipse2D;
    public Controller() {
        points = new Point2D[2];
        rectangle2D = new Rectangle2D.Double();
        ellipse2D = new Ellipse2D.Double();
        cat = new Cat();
        dog = new Dog();
        myPanel = new MyPanel(this);
        myFrame = new MyFrame(myPanel);
        enimal = cat;
       currentShape =rectangle2D;
    }
    public String speak() { return enimal.speak();}
    public void setCat() {enimal = cat;}
    public void setDog() {
        enimal = dog;
    }


    public void mousePressed(Point point) {
        points[0] = point;
    }

    public void mouseMotion(Point point) {
        points[1] = point;
    }

    public void setRectangle2D() {
        currentShape = rectangle2D;
    }

    public void setEllipse2D() {
        currentShape = ellipse2D;
    }
    public void draw(Graphics2D g2) {
        if(points[0]!=null) {
            currentShape.setFrameFromDiagonal(points[0], points[1]);
            g2.draw(currentShape);
        }
    }
}
