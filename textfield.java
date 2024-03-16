import java.awt.*;
import java.applet.*;
import java.awt.event.*;
/*<applet code="textfield" Height=500 width=500></applet>*/
public class textfield extends Frame implements ActionListener
{
TextField tname,tstreet,tcity,tpin;
Label lname,lstreet,lcity,lpin;
Button b1;
public lab06()
{
setBackground(Color.gray);
setForeground(Color.red);
FlowLayout f=new FlowLayout();
setLayout(f);
lname=new Label("NAME ");
lstreet=new Label("STREET");
lcity=new Label("CITY ");
lpin=new Label("PINCODE");
tname=new TextField(35);
tstreet=new TextField(35);
tcity=new TextField(35);
tpin=new TextField(35);
b1=new Button("click me");
add(lname);
add(tname);
add(lstreet);
add(tstreet);
add(lcity);
add(tcity);
add(lpin);
add(tpin);
add(b1);
b1.addActionListener(this);
}
public void actionPerformed(ActionEvent e)
{
if(e.getSource()==b1)
{
tname.setText("RABIR");
tstreet.setText("75,JEEVA NAGAR");
tcity.setText("OOTY");
tpin.setText("641017");
}
}
public boolean handleEvent(Event e)
{
if(e.id==Event.WINDOW_DESTROY)
System.exit(0);
return(super.handleEvent(e));
}
public static void main(String args[])
{
lab06 a=new lab06();
a.resize(380,300);
a.show();
}
}
