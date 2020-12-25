package travel.tourism.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class SignUp extends JFrame implements ActionListener{
    JButton b1, b2;
    JTextField t1, t2, t3, t4;
    Choice c1;
    
    
    SignUp(){
        setBounds(600, 280, 900, 360);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JPanel p1 = new JPanel();
        p1.setBackground(new Color(133, 193, 233));
        p1.setBounds(0, 0, 500, 400);
        p1.setLayout(null);
        add(p1);
        
        JLabel l1 = new JLabel("Username");
        l1.setFont(new Font("Tahoma", Font.BOLD, 14));
        l1.setBounds(50, 20, 130, 25);
        p1.add(l1);
        
        t1 = new JTextField();
        t1.setBounds(195, 20, 180, 25);
        t1.setBorder(BorderFactory.createEmptyBorder());
        add(t1);
        
        JLabel l2 = new JLabel("Name");
        l2.setFont(new Font("Tahoma", Font.BOLD, 14));
        l2.setBounds(50, 60, 130, 25);
        p1.add(l2);
        
        t2 = new JTextField();
        t2.setBounds(195, 60, 180, 25);
        t2.setBorder(BorderFactory.createEmptyBorder());
        add(t2);
        
        JLabel l3 = new JLabel("Password");
        l3.setFont(new Font("Tahoma", Font.BOLD, 14));
        l3.setBounds(50, 100, 130, 25);
        p1.add(l3);
        
        t3 = new JTextField();
        t3.setBounds(195, 100, 180, 25);
        t3.setBorder(BorderFactory.createEmptyBorder());
        add(t3);
        
        JLabel l4 = new JLabel("Security Question");
        l4.setFont(new Font("Tahoma", Font.BOLD, 14));
        l4.setBounds(50, 140, 130, 25);
        p1.add(l4);
        
        c1 = new Choice();
        c1.add("Favourite Childhood hero?");
        c1.add("Captain America or Ironman");
        c1.add("Call of Duty or PUBG");
        c1.add("Your unique name?");
        c1.setBounds(195, 140, 190, 25);
        p1.add(c1);
        
        JLabel l5 = new JLabel("Answer");
        l5.setFont(new Font("Tahoma", Font.BOLD, 14));
        l5.setBounds(50, 180, 130, 25);
        p1.add(l5);
        
        t4 = new JTextField();
        t4.setBounds(195, 180, 180, 25);
        t4.setBorder(BorderFactory.createEmptyBorder());
        add(t4);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("travel/tourism/management/system/icons/signup.png"));
        Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l6 = new JLabel(i3);
        l6.setBounds(580, 50, 250, 250);
        add(l6);
        
        b1 = new JButton("Create");
        b1.setFont(new Font("Tahoma", Font.BOLD,14));
        b1.setForeground(new Color(133, 193, 233));
        b1.setBackground(Color.WHITE);
        b1.addActionListener(this);
        b1.setBounds(80, 250, 100, 30);
        p1.add(b1);
        
        b2 = new JButton("Back");
        b2.setFont(new Font("Tahoma", Font.BOLD,14));
        b2.setForeground(new Color(133, 193, 233));
        b2.setBackground(Color.WHITE);
        b2.addActionListener(this);
        b2.setBounds(250, 250, 100, 30);
        p1.add(b2);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1){
            String username = t1.getText();
            String name = t2.getText();
            String password = t3.getText();
            String security = c1.getSelectedItem();
            String answer = t4.getText();
            
            String query = "insert into account values('"+username+"', '"+name+"', '"+password+"', '"+security+"', '"+answer+"')";
            try{
                Conn c = new Conn();
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Account Created Successfully");
                
                this.setVisible(false);
                new LogIn().setVisible(true);
            }catch(Exception e){
                
            }
        }else if(ae.getSource() == b2){
            new LogIn().setVisible(true);
            this.setVisible(false);
        }
    }
    
    public static void main(String [] args){
        new SignUp().setVisible(true);
    }
    
}
