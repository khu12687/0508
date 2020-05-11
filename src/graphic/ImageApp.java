package graphic;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*�ڹٿ��� �̹��� ó���ϴ� ��������!!
 * ����� �ڹٿ��� �̹����� �ҷ����� ����� �پ��ϴ�!!
 * �ѹ� ���������� �ȵ���̵忡�� �����
 * */
public class ImageApp extends JFrame{
	ImagePanel p;
	JPanel p_north;
	JButton bt_prev, bt_next;
	JTextField t_path; //�̹����� ��ο� �̸��� ����ϴ� �ؽ�Ʈ��Ʈ
	
	//�̹��� 10���� �迭�� �����غ���!!
	String[] imgArray = new String[10];
	String dir = "C:\\\\web_app DB\\\\oracle_workspace\\\\GUIProject\\\\res\\\\";
	public ImageApp() {
		imgArray[0]=dir+"i1.png";
		imgArray[1]=dir+"i2.png";
		imgArray[2]=dir+"i3.png";
		imgArray[3]=dir+"i4.png";
		imgArray[4]=dir+"i5.png";
		imgArray[5]=dir+"i6.png";
		imgArray[6]=dir+"i7.png";
		imgArray[7]=dir+"i8.png";
		imgArray[8]=dir+"i9.png";
		imgArray[9]=dir+"i10.png";
		
		p_north = new JPanel();
		p=new ImagePanel(imgArray);
		bt_prev = new JButton("��");
		bt_next = new JButton("��");
		t_path = new JTextField(30);
		//�г��� �ƹ��� ������ �����Ƿ�, ������ ��������!!
		p.setBackground(Color.YELLOW);
		
		//����� ũ�⸦ width 450, height 400 
		p.setPreferredSize(new Dimension(450,400));
		
		setLayout(new FlowLayout());
		
		//���� �гο� ��ư�� �ؽ�Ʈ�ʵ� ����!!
		p_north.add(bt_prev);
		p_north.add(t_path);
		p_north.add(bt_next);
		
		//���� �г��� �����쿡 ����
		add(p_north,BorderLayout.NORTH);
		add(p);
		
		//���� �̹��� �����ֱ�
		bt_prev.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				prev();
				
			}
		});
		//���� �̹��� �����ֱ�
		bt_next.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				next();
				
			}
		});
		setSize(500,500);
		setVisible(true);
		printPath();
	}
	
	
	public void prev() {
		//�̹����г��� ������ index 1����
		p.index--;
		p.repaint();
		 printPath();
	}
	
	public void next() {
		//�̹����г��� ������ index 1����
		p.index++;
		p.repaint();
		printPath();
	}
	
	
	public void printPath() {
		t_path.setText(imgArray[p.index]);
	}
	public static void main(String[] args) {
		new ImageApp();
	}
}
