package travel.tourism.management.system;

import javax.swing.*;
import java.awt.*;

public class Splash {
    public static void main(String[] args){
        SplashFrame frame = new SplashFrame();
        frame.setVisible(true);
        int x = 1;
        for (int i =1; i<=500; i+=6, x+=7){
             frame.setLocation(900 - (x + i)/2,400 - (i/2));
             frame.setSize(x + i,  i);
             try{
                 Thread.sleep(10);
             }catch (Exception e){}
        }

        frame.setVisible(true);
        
        
  }
}

class SplashFrame extends JFrame implements Runnable{
    Thread t1;
    SplashFrame(){                                 //constructor
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("travel/tourism/management/system/icons/splash.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel  l1 = new JLabel(i3);
        add(l1);
        
        
        // setBounds(200, 200, 1000, 400);    //locaion, size
        
        setUndecorated(true);
        t1 = new Thread(this);
        t1.start();
    }
    public void run(){
        try{
            Thread.sleep(7000);
            this.setVisible(false);
            
            new LogIn().setVisible(true);
        }catch(Exception e){}
    
    }
}
