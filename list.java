import java.awt.*;
import java.awt.event.*;
import java.applet.*;
/*<applet code="list" height=1000 width=1000></applet>*/
public class list extends Applet implements ActionListener
{
List list1;
Button b1,b2;
String msg="SELECTED ITEMS ARE:";
public void init()
{
setBackground(Color.yellow);
setForeground(Color.blue);
list1=new List(5,true);
list1.add("C");
list1.add("C++");
list1.add("JAVA");
list1.add("PHYTHON");
list1.add("COBOL");
add(list1);
b1=new Button("Select");
b2=new Button("close");
add(b1);
add(b2);
b1.addActionListener(this);
b2.addActionListener(this);
}
public void actionPerformed(ActionEvent e)
{
if(e.getSource()==b1)
{
repaint();
}
if(e.getSource()==b2)
{
System.exit(0);
}
}
public void paint(Graphics g)
{
int index[];
index=list1.getSelectedIndexes();
for(int i=0;i<index.length;i++)
msg+=list1.getItem(index[i])+"\n"+" ";
g.drawString(msg,100,200);
}
}


