package com.swing;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class calculator implements ActionListener{
	
	static JFrame f;
	static JTextField l;
	

	String s0, s1, s2;
	
	calculator()
    {

        s0 = s1 = s2 = "";

    }
	
	
	public static void main(String[] args) {
		calculator c = new calculator();
		
		f=new JFrame("Calculator");
		f.setVisible(true);
		f.setSize(350, 392);
		//f.setLayout(new FlowLayout());
		//f.setLayout(new GridLayout(4, 4));
		f.setLayout(null);
		f.setResizable(false);
		
		
		l = new JTextField(16);
		
		l.setEditable(false);
		
		
		JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,sum,sub,mul,div,dot,ecu,b0,b00,back;

		b1 = new JButton("1");
		b2 = new JButton("2");
		b3 = new JButton("3");
		b4 = new JButton("4");
		b5 = new JButton("5");
		b6 = new JButton("6");
		b7 = new JButton("7");
		b8 = new JButton("8");
		b9 = new JButton("9");
		sum = new JButton("+");
		sub = new JButton("-");
		mul = new JButton("*");
		div = new JButton("/");
		ecu = new JButton("=");
		b0 = new JButton("0");
		b00 = new JButton("00");
		back = new JButton("C");
		dot = new JButton(".");
		
	
		
		f.add(l);
		f.add(b1);
		f.add(b2);
		f.add(b3);
		f.add(sum);
		f.add(b4);
		f.add(b5);
		f.add(b6);
		f.add(sub);
		f.add(b7);
		f.add(b8);
		f.add(b9);
		f.add(mul);
		f.add(b00);
		f.add(b0);
		f.add(dot);
		f.add(div);
		f.add(back);
		f.add(ecu);
	
		l.setBounds(20, 10, 300, 80); 
		b1.setBounds(1, 100, 83, 50);
		b4.setBounds(1, 150, 83, 50);
		b7.setBounds(1, 200, 83, 50);
		b0.setBounds(1, 250, 83, 50);
		b2.setBounds(83, 100, 83, 50);
		b5.setBounds(83, 150, 83, 50);
		b8.setBounds(83, 200, 83, 50);
		b00.setBounds(83, 250, 83, 50);
		b3.setBounds(166, 100, 83, 50);
		b6.setBounds(166, 150, 83, 50);
		b9.setBounds(166, 200, 83, 50);
		dot.setBounds(166, 250, 83, 50);
		sum.setBounds(249, 100, 83, 50);
		sub.setBounds(249, 150, 83, 50);
		mul.setBounds(249, 200, 83, 50);
		div.setBounds(249, 250, 83, 50);
		back.setBounds(1, 302, 165, 50);
		ecu.setBounds(166, 302, 165, 50);
		
	    b1.addActionListener(c);	
	    b2.addActionListener(c);
	    b3.addActionListener(c);
	    b4.addActionListener(c);
	    b5.addActionListener(c);
	    b6.addActionListener(c);
	    b7.addActionListener(c);
	    b8.addActionListener(c);
	    b9.addActionListener(c);
	    b0.addActionListener(c); 
	    b00.addActionListener(c);
	    dot.addActionListener(c);
	    sum.addActionListener(c);
	    sub.addActionListener(c);
	    mul.addActionListener(c);	
	    div.addActionListener(c);
	    back.addActionListener(c);
	    ecu.addActionListener(c);
	}
	public void actionPerformed(ActionEvent e)
	{
		
	
			String s = e.getActionCommand();
			 

	        // if the value is a number

	        if ((s.charAt(0) >= '0' && s.charAt(0) <= '9') || s.charAt(0) == '.') {

	            // if operand is present then add to second no

	            if (!s1.equals(""))

	                s2 = s2 + s;

	            else

	                s0 = s0 + s;
	 

	            // set the value of text

	            l.setText(s0 + s1 + s2);

	        }

	        else if (s.charAt(0) == 'C') {

	            // clear the one letter

	            s0 = s1 = s2 = "";
	 

	            // set the value of text

	            l.setText(s0 + s1 + s2);

	        }

	        else if (s.charAt(0) == '=') {
	 

	            double te;
	 

	            // store the value in 1st

	            if (s1.equals("+"))

	                te = (Double.parseDouble(s0) + Double.parseDouble(s2));

	            else if (s1.equals("-"))

	                te = (Double.parseDouble(s0) - Double.parseDouble(s2));

	            else if (s1.equals("/"))

	                te = (Double.parseDouble(s0) / Double.parseDouble(s2));

	            else

	                te = (Double.parseDouble(s0) * Double.parseDouble(s2));
	 

	            // set the value of text

	            l.setText(s0 + s1 + s2 + "=" + te);
	 

	            // convert it to string

	            s0 = Double.toString(te);
	 

	            s1 = s2 = "";

	        }

	        else {

	            // if there was no operand

	            if (s1.equals("") || s2.equals(""))

	                s1 = s;

	            // else evaluate

	            else {

	                double te;
	 

	                // store the value in 1st

	                if (s1.equals("+"))

	                    te = (Double.parseDouble(s0) + Double.parseDouble(s2));

	                else if (s1.equals("-"))

	                    te = (Double.parseDouble(s0) - Double.parseDouble(s2));

	                else if (s1.equals("/"))

	                    te = (Double.parseDouble(s0) / Double.parseDouble(s2));

	                else

	                    te = (Double.parseDouble(s0) * Double.parseDouble(s2));
	 

	                // convert it to string

	                s0 = Double.toString(te);
	 

	                // place the operator

	                s1 = s;
	 

	                // make the operand blank

	                s2 = "";

	            }
	            l.setText(s0 + s1 + s2);
	            
	}
	       
	}
}
	

	
