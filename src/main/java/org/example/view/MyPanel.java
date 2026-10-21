package view;
import controller.Controller;
import model.SpeakBchavior;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyPanel extends JPanel {



    JTextField t1;
    JTextField t2;
    JButton button;
    JButton button1;
    JButton button2;
    JButton button3;
    JButton button4;
    //  Cat cat;
    Controller controller;

    public MyPanel(Controller controller) {
        this.controller = controller;
        //  this.cat = cat;
        t1 = new JTextField("              ");
        t2 = new JTextField("              ");
        button = new JButton("speak");
        button1 = new JButton("cat");
        button2 = new JButton("dog");
        button3 = new JButton("pryamougolnick");
        button4 = new JButton("oval");
        add(t1);
        add(t2);
        add(button);
        add(button1);
        add(button2);
        add(button3);
        add(button4);
        button.addActionListener(e -> {

            // String input = t1.getText().trim().toLowerCase();
            t2.setText(controller.speak());
        });


        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.setCat();
            }
        });


        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.setDog();
            }
        });


        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.setRectangle2D();
            }
        });


        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.setEllipse2D();
            }
        });


        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                controller.mousePressed(e.getPoint());
            }
        });

        this.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
                controller.mouseMotion(e.getPoint());
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2=(Graphics2D) g;
        controller.draw(g2);
    }
}



