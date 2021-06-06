import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;
class test{
public static void main(String [ ] args){
convert  obj=new convert();
       }
}

class  convert  implements  FocusListener,KeyListener{
JFrame   frame=new JFrame();
JTextField    tf1=new JTextField();
JTextField    tf2=new JTextField();
JTextField    tf3=new JTextField();
JTextField    tf4=new JTextField();
JLabel    l1=new  JLabel("DECIMAL",JLabel.CENTER);
JLabel    l2=new  JLabel("BINARY",JLabel.CENTER);
JLabel    l3=new  JLabel("OCTAL",JLabel.CENTER);
JLabel    l4=new  JLabel("HEXA-DECIMAL",JLabel.CENTER);

Container  c;

convert(){
c=frame.getContentPane();
c.setLayout(null);
c.setBackground(Color.gray);
frame.setVisible(true);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setSize(387,162);
frame.setLocationRelativeTo(null);
frame.setResizable(false);
l1.setBounds(0,0,100,30); l1.setForeground(Color.yellow);  
l2.setBounds(0,30,100,30);  l2.setForeground(Color.yellow);
l3.setBounds(0,60,100,30);   l3.setForeground(Color.yellow);
l4.setBounds(0,90,100,30);   l4.setForeground(Color.yellow);
tf1.setBounds(100,0,270,30);   tf1.addFocusListener(this);  tf1.addKeyListener(this);
tf2.setBounds(100,30,270,30);   tf2.addFocusListener(this);  tf2.addKeyListener(this);
tf3.setBounds(100,60,270,30);   tf3.addFocusListener(this);  tf3.addKeyListener(this);
tf4.setBounds(100,90,270,30);   tf4.addFocusListener(this);  tf4.addKeyListener(this);

c.add(l1);c.add(l2);
c.add(l3);c.add(l4);
c.add(tf1);c.add(tf2);
c.add(tf3);c.add(tf4);
      }

public void focusGained(FocusEvent   ev){

if(ev.getSource()==tf1){
tf1.setEditable(true);
tf1.setText("");
tf2.setEditable(false);   
tf3.setEditable(false);   
tf4.setEditable(false);
                                   }
if(ev.getSource()==tf2){
tf2.setEditable(true);
tf2.setText("");
tf1.setEditable(false);
tf3.setEditable(false);
tf4.setEditable(false);
                                   }
if(ev.getSource()==tf3){
tf3.setEditable(true);
tf3.setText("");
tf1.setEditable(false);
tf2.setEditable(false);
tf4.setEditable(false);
                                   }
if(ev.getSource()==tf4){
tf4.setEditable(true);
tf4.setText("");
tf1.setEditable(false);
tf2.setEditable(false);
tf3.setEditable(false);
                                   }
           }
public void focusLost(FocusEvent   ev){   }

public void keyPressed(KeyEvent    key){ 
/*FOR CHECK  FIRST TEXTFIELD*/    
if(key.getSource()==tf1   && !Character.isDigit(key.getKeyChar()))
tf1.setEditable(false);
 else
 tf1.setEditable(true);
 if(key.getSource()==tf1    && key.getKeyCode()==KeyEvent.VK_BACK_SPACE)
tf1.setEditable(true);
/*****/ 
/*FOR CHECK  SECOND TEXTFIELD*/   
 if(key.getSource()==tf2 && !(key.getKeyChar()=='1'  || key.getKeyChar()=='0'))
tf2.setEditable(false);
 else
 tf2.setEditable(true);
 if(key.getSource()==tf2    && key.getKeyCode()==KeyEvent.VK_BACK_SPACE)
tf2.setEditable(true);
/*******/
/*FOR CHECK  THIRD TEXTFIELD*/   
 if(key.getSource()==tf3 && !(0>=key.getKeyChar()  ||  key.getKeyChar()<='7'))
tf3.setEditable(false);
 else
 tf3.setEditable(true);
 if(key.getSource()==tf3    && key.getKeyCode()==KeyEvent.VK_BACK_SPACE)
tf3.setEditable(true);
/*******/
/*FOR CHECK  FOURTH TEXTFIELD*/   
 if(key.getSource()==tf4 && !('0'>=key.getKeyChar()  ||  key.getKeyChar()<='7') && !('a'>=key.getKeyChar()  ||  key.getKeyChar()<='f'))
tf4.setEditable(false);
 else
 tf4.setEditable(true);
 if(key.getSource()==tf4    && key.getKeyCode()==KeyEvent.VK_BACK_SPACE)
tf4.setEditable(true);
/*******/

   }
public void keyReleased(KeyEvent    key){
/***/    
if(key.getSource()==tf1  &&  (tf1.getText()).length()>0)
All_For_Decimal();
/****/
if(key.getSource()==tf2  &&  (tf2.getText()).length()>0)
All_For_BINARY();
/****/
if(key.getSource()==tf3  &&  (tf3.getText()).length()>0)
All_For_OCTAL();
if(key.getSource()==tf4  &&  (tf4.getText()).length()>0)
All_For_HEX();
  }
public void keyTyped(KeyEvent  key){ 
/*FOR CHECK  FIRST TEXTFIELD*/        
if(key.getSource()==tf1    && (tf1.getText()).length()>8)
tf1.setEditable(false);
/******/
/*FOR CHECK  SECOND TEXTFIELD*/        
if(key.getSource()==tf2    && (tf2.getText()).length()>30)
tf2.setEditable(false);
/******/
/*FOR CHECK  THIRD TEXTFIELD*/   
if(key.getSource()==tf3    && (tf3.getText()).length()>9)
tf3.setEditable(false);
/***/
/*FOR CHECK  FOURTH TEXTFIELD*/   
if(key.getSource()==tf4    && (tf4.getText()).length()>=8)
tf4.setEditable(false);
/***/
}

public void All_For_Decimal(){
String s1=tf1.getText();
int num=Integer.parseInt(s1);
tf2.setText(Integer.toBinaryString(num));
tf3.setText(Integer.toOctalString(num));
tf4.setText(Integer.toHexString(num));
         }
public void All_For_BINARY(){         
 String s1=tf2.getText();
 int num=Integer.parseInt(s1,2);
 tf1.setText(String.valueOf(num));
 tf3.setText(Integer.toOctalString(num));  
 tf4.setText(Integer.toHexString(num)); 
       }     
public void All_For_OCTAL(){
   String s1=tf3.getText();  
     int num=Integer.parseInt(s1,8);
   tf1.setText(String.valueOf(num));
    tf2.setText(Integer.toBinaryString(num));  
 tf4.setText(Integer.toHexString(num));
    }
public void All_For_HEX(){
     String s1=tf4.getText();  
     int num=Integer.parseInt(s1,16);
   tf1.setText(String.valueOf(num));
    tf2.setText(Integer.toBinaryString(num));  
 tf3.setText(Integer.toOctalString(num)); 
    }    
}
