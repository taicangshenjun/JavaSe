package designpattern.singleton;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SingletonTest {

	public static void main(String[] args)
    {
        JFrame jf=new JFrame("饿汉单例模式测试");
        jf.setLayout(new GridLayout(1,2));
        Container contentPane=jf.getContentPane();
        Bajie obj1=Bajie.getInstance();
        contentPane.add(obj1);    
        Bajie obj2=Bajie.getInstance(); 
        contentPane.add(obj2);
        if(obj1==obj2)
        {
            System.out.println("他们是同一人！");
        }
        else
        {
            System.out.println("他们不是同一人！");
        } 
        jf.pack();       
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
	
}

class Bajie extends JPanel
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static Bajie instance=new Bajie();
    private Bajie()
    { 
        JLabel l1=new JLabel(new ImageIcon("src/designpattern/singleton/imgs/bajie.jpg"));
        this.add(l1);   
    }
    public static Bajie getInstance()
    {
        return instance;
    }
}
