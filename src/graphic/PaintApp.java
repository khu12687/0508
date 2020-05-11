/*
 *�ڹ��� GUI ���α׷��� ������� �׷����� ó���غ���!!
 *					[����]				[�ڹ�]
 *1)�׸��� ��ü			ȭ��					������Ʈ �ڽ�(��ư,üũ..���������Ʈ)
 *2)�ȷ�Ʈ			����					�۾�,����,�̹���,���� ������ �׷���ó��
 *3)��				�׸��� ����				���α׷������� ������ �޼���� ����
 *4)�׷��� ���			�˹���				������Ʈ ������ (Ÿ���ϴ� ����)
 * */

package graphic;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PaintApp extends JFrame{
	XCanvas xcanvas; //�� �׷��� �׳� ��ȭ����!! �ƹ��͵� ���� ����
					//�ƹ��͵� ���� ������ �����ں��� �׸���� �Ŵ� w
	
	JPanel p_north; //��Ʈ�� �г�!!
	JLabel la_x1,la_y1,la_x2,la_y2;
	JTextField t_x1,t_y1,t_x2,t_y2;
	JButton bt;
	
	public PaintApp() {
		xcanvas = new XCanvas();
		p_north = new JPanel();
		
		la_x1 = new JLabel("x1");
		la_y1 = new JLabel("y1");
		la_x2 = new JLabel("x2");
		la_y2 = new JLabel("y2");
		
		t_x1 = new JTextField(5);		
		t_y1 = new JTextField(5);		
		t_x2 = new JTextField(5);		
		t_y2 = new JTextField(5);		
		
		bt = new JButton("����");
		
		p_north.add(la_x1);
		p_north.add(t_x1);
		
		p_north.add(la_y1);
		p_north.add(t_y1);
		
		p_north.add(la_x2);
		p_north.add(t_x2);
		
		p_north.add(la_y2);
		p_north.add(t_y2);
		
		p_north.add(bt);
	
		xcanvas.setBackground(Color.YELLOW);
		add(xcanvas);
		add(p_north,BorderLayout.NORTH);
		addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		//��ư�� ������ ����!!
		bt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("�� ������?");
				 setPos();
				
			}
		});
		
		setSize(500,500);
		setVisible(true);
		
	}
	
	//���� �׷��� ������ ����!!
	//javascript ������ parseInt() �޼��尡 �ڹٿ����� �����Ǵµ�, �ణ�� ��ĸ�Ʋ��!!
	/*
	 * �ڹ��� �⺻�ڷ����� ��ü�ڷ������� ����ȯ�� �����ϴ� ��ü���� ������  ����Ŭ������ �θ���, �ڹ��� ��� �⺻�ڷ�������
	 * 1:1�����ϴ� ����Ŭ������ �����ȴ�!!
	 * ���� char : Character(*), ���� byte:Byte short:Short int:Integer(*) long:Long
	 *  float:Float double:Double, ���� boolean:Boolean
	 * */
	public void setPos() {
		int x1 = Integer.parseInt(t_x1.getText());
		int y1 = Integer.parseInt(t_y1.getText());
		int x2 = Integer.parseInt(t_x2.getText());
		int y2 = Integer.parseInt(t_y2.getText());
		
		//�˹����� ��������!!
		xcanvas.x1=x1;
		xcanvas.y1=y1;
		xcanvas.x2=x2;
		xcanvas.y2=y2;
		
		//xcanvas�� �̹� �׷��� ������ ����ڰ� �׷��������� ��翡 ��ȭ�� �ְԵ� ���� paint �޼��尡 �ٽ� ���ŵ� �׸���
		//������� �ϹǷ�, �ý��ۿ� ���� ȣ��ǰ� �ȴ�!!
		//������, ���ŵ� �׸��� ���� ���� �׷��ȿ� ��ȭ�� ���콺�� �شٴ°��� �ùٸ� ����� �ƴϹǷ�,
		//�����ڰ� ���α׷��������� �ٽ� �׷������� ����ؾ� �Ѵ�!!
		//xcanvas.paint() �ùٸ��� �ʴ�!!
		//��?? �ڹٿ��� �׸��� ��ü�� �����ͽ� ������ �̱� ������ 
		// paint �޼���� �ý��ۿ� ���� ȣ��Ǿ�� �ϸ� �����ڰ� ȣ�� �ؼ��� �ȵȴ�!!
		// ���� �����ڴ� �ٽ� �׷��� ���� �ý��ۿ� ��Ź�� �� �� �ִ�..
		// repaint() ---> update(ȭ������) --->paint(�׸�)
		//�� update() �޼���� ȭ���� �����.
		// paint() ������ ȭ�鿡 �ٽ� �׷���ó���� �������Ѵ�!!
		xcanvas.repaint();
		
	}
	//JFrame �� ������ ��� ������Ʈ�� ������ �׸��� �ɷ��� �������ְ�, ���� �츮�� �������� �������� �� �� �־��� ������
	//������ �׸��� �׷ȱ� �����̴�.. �̶� ������Ʈ�� ������ �׸��� ������ ����ϴ� �޼��尡 �ٷ� paint() �޼����̸� �׸� �׸��� �ʿ���
	//�����̳� �پ��� ����� �ȷ�Ʈ ������ ���ִ� Graphics ��ü�� �̿��Ѵ�
	
	//�Ʒ��� ���� �����ڰ� paint�޼��带 �������̵� �ϰ� �Ǹ� ���׷��̵� �ϰ� �Ǵ� ���̹Ƿ�, ������Ʈ�� ������ �׷��� �� �ִ� ��ȸ�� �����ڰ�
	// ���� ���̹Ƿ�, �׸� �׸����� ����� �׷����Ѵ�.
	@Override
	public void paint(Graphics g) {
		System.out.println("paint �޼��� ȣ��");
	}
	public static void main(String[] args) {
		new PaintApp();
	}
}

