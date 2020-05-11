package event;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/*//�̺�Ʈ ���� ���α׷��ֽ�, �������� �������� �޼��尡 �������ϰ�� ���� ��������� �ʴ� �޼��带 Ŭ������ �״�� �ξ�� �ϴ°�?
//�ذ�å) �̹� SUN������ �츮��� �������� �߻�޼��带 �̹� ���������� �ǹ��� �س��� ��ü�� �������ִµ�, �� ��ü���� ������
// 		����Ͷ��Ѵ�!!
//����)	����ʹ� ��� �����ʸ��� �����Ǵ°� �ƴ϶�, �߻�޼��尡 �������� �����Ѵ�..
//		ActionListener : 1���̹Ƿ� ����Ͱ� ����
// 		KeyListener : 3���̹Ƿ�, ����Ͱ� �����ȴ�
//		WindowListener : 7���̹Ƿ�, ����� �翬 �����ȴ�
//���)  �������� �޼��尡 3���̻��̸� ����� �����ǽ�����!!
//����) ����͸� ��ӹ޾� ����ϸ� �ȴ�!!
*/
public class AdapterApp extends JFrame implements WindowListener{
	JTextField t_input;
	MyButton bt;
	JTextArea area;
	public AdapterApp() {
		t_input = new JTextField(10);
		bt = new MyButton("��ư");
		area = new JTextArea(10,20);
		setLayout(new FlowLayout());
		add(t_input);
		add(bt); //��ư����!!
		add(area);
		
		//�ؽ�Ʈ�ʵ�� �����ʿ��� ����!!
		//this �� �ǹ� : �ν��Ͻ��� �ڱ� �ڽ��� ����Ű�� ���۷��� ����
		
		//�����ʴ� ���� �� Ŭ�������� ������ ������â �ν��Ͻ��̴�!!
		
		//�Ʒ��� �ڵ忡��, ActionListener�� ���� �������̽��̱� ������ new �Ҽ� ����..
		//������ �� �ڿ� �������̽��� ������ �� �ڽ�Ŭ������ �̾��� �پ� �ֱ� ������ �Ʒ��� �ڵ�� �����ȴ�!!
		//�̷��� 1ȸ���� �ܼ��� ������ �ۼ��Ҷ��� ���� ����������.java���� �ҽ��� �ۼ��� �ʿ䰡 ����!!
		//�ذ�å) �̸����� ���� Ŭ������ �̿��ϸ� �ȴ�!!
		//�Ʒ��� ���� �̸����� ���� Ŭ������ ������ �����͸�Ŭ������ �Ѵ�!!
		// Annoymous inner Class
		bt.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("��������??");
				
				//area�� ����Ͻÿ�!!
				//area�� ���� Ŭ������ �������� �ʱ� ������...
				//���۷����� �Ѱܹ޾ƾ��Ѵ�!!
			}
			
		});
		//.java�� ������ �ʰ� �ذ��ϴ� �����ڵ�!!
		/* �����͸�Ŭ������ ���� 
		 * 1)���� .java���� �ʿ���� 1ȸ���ڵ忡 ȿ�����̴�
		 * 	 ���� �̺�Ʈ ������ ������ �е������� ���� ����!!
		 * 2)�ڽ��� �����ϰ� �ִ� �ٱ� �ܺ� Ŭ������ �ɹ��������� ���� �� �� �ִ�..
		 * 	��) �ɹ������� �ƴ� ���������� ����� �� ����, ���������� final�� ������������ ������ ����������, ������ �Ұ��ϴ�!!
		 * */
		
		int k=8;
		
		t_input.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				System.out.println(k);
				area.append(t_input.getText()+"\n");
			}
		});
		
		
		//������� �����ʿ��� ����
		this.addWindowFocusListener(new WindowAdapter(){
			@Override
			public void windowClosed(WindowEvent e) {
				System.exit(0);
			}
		});
		
		setSize(300,400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new AdapterApp();
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

}
