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

/*//이벤트 구현 프로그래밍시, 리스너의 재정의할 메서드가 여러개일경우 과연 사용하지도 않는 메서드를 클래스에 그대로 두어야 하는가?
//해결책) 이미 SUN에서는 우리대신 리스너의 추상메서드를 이미 구현강제의 의무를 해놓은 객체를 지원해주는데, 이 객체들을 가리켜
// 		어댑터라한다!!
//주의)	어댑터는 모든 리스너마다 지원되는게 아니라, 추상메서드가 많을때만 지원한다..
//		ActionListener : 1개이므로 어댑터가 없다
// 		KeyListener : 3개이므로, 어댑터가 지원된다
//		WindowListener : 7개이므로, 어댑터 당연 지원된다
//결론)  재정의할 메서드가 3개이상이면 어댑터 존재의심하자!!
//사용법) 어댑터를 상속받아 사용하면 된다!!
*/
public class AdapterApp extends JFrame implements WindowListener{
	JTextField t_input;
	MyButton bt;
	JTextArea area;
	public AdapterApp() {
		t_input = new JTextField(10);
		bt = new MyButton("버튼");
		area = new JTextArea(10,20);
		setLayout(new FlowLayout());
		add(t_input);
		add(bt); //버튼부착!!
		add(area);
		
		//텍스트필드와 리스너와의 연결!!
		//this 의 의미 : 인스턴스가 자기 자신을 가리키는 레퍼런스 변수
		
		//리스너는 현재 이 클래스부터 생성된 윈도우창 인스턴스이다!!
		
		//아래의 코드에서, ActionListener는 원래 인터페이스이기 때문에 new 할수 없다..
		//하지만 그 뒤에 인터페이스를 구현한 즉 자식클래스가 이어져 붙어 있기 때문에 아래의 코드는 인정된다!!
		//이렇게 1회성의 단순한 로직을 작성할때는 굳이 물리적으로.java원본 소스를 작성할 필요가 없다!!
		//해결책) 이름없는 내부 클래스를 이용하면 된다!!
		//아래와 같이 이름없는 내부 클래스를 가리켜 내부익명클래스라 한다!!
		// Annoymous inner Class
		bt.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("나눌렀어??");
				
				//area에 출력하시오!!
				//area가 같은 클래스에 존재하지 않기 때문에...
				//레퍼런스를 넘겨받아야한다!!
			}
			
		});
		//.java를 만들지 않고 해결하는 간단코드!!
		/* 내부익명클래스의 장점 
		 * 1)굳이 .java까지 필요없는 1회성코드에 효율적이다
		 * 	 따라서 이벤트 리스너 구현시 압도적으로 많이 사용됨!!
		 * 2)자신을 포함하고 있는 바깥 외부 클래스의 맴버변수들을 접근 할 수 있다..
		 * 	단) 맴버변수가 아닌 지역변수는 사용할 수 없고, 지역변수를 final로 선언했을때는 접근은 가능하지만, 변경은 불가하다!!
		 * */
		
		int k=8;
		
		t_input.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				System.out.println(k);
				area.append(t_input.getText()+"\n");
			}
		});
		
		
		//윈도우와 리스너와의 연결
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
