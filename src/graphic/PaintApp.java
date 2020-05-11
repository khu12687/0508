/*
 *자바의 GUI 프로그래밍 기반으로 그래픽을 처리해보자!!
 *					[현실]				[자바]
 *1)그림의 주체			화가					컴포넌트 자신(버튼,체크..모든컴포넌트)
 *2)팔레트			색상					글씨,도형,이미지,색상 실제적 그래픽처리
 *3)붓				그리는 행위				프로그램에서는 행위는 메서드로 지원
 *4)그려질 대상			켄버스				컴포넌트 스스로 (타투하는 느낌)
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
	XCanvas xcanvas; //뜻 그래도 그냥 도화지다!! 아무것도 없는 백지
					//아무것도 없는 이유는 개발자보고 그리라는 거다 w
	
	JPanel p_north; //컨트롤 패널!!
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
		
		bt = new JButton("갱신");
		
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
		
		//버튼과 리스너 연결!!
		bt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("나 눌렀어?");
				 setPos();
				
			}
		});
		
		setSize(500,500);
		setVisible(true);
		
	}
	
	//선이 그려질 포져션 세팅!!
	//javascript 시절의 parseInt() 메서드가 자바에서도 지원되는데, 약간의 방식만틀림!!
	/*
	 * 자바의 기본자료형과 객체자료형간의 형변환을 지원하는 객체들을 가리켜  레퍼클래스가 부르고, 자바의 모든 기본자료형마다
	 * 1:1댕응하는 레퍼클래스가 지원된다!!
	 * 문자 char : Character(*), 숫자 byte:Byte short:Short int:Integer(*) long:Long
	 *  float:Float double:Double, 논리값 boolean:Boolean
	 * */
	public void setPos() {
		int x1 = Integer.parseInt(t_x1.getText());
		int y1 = Integer.parseInt(t_y1.getText());
		int x2 = Integer.parseInt(t_x2.getText());
		int y2 = Integer.parseInt(t_y2.getText());
		
		//켄버스에 전달하자!!
		xcanvas.x1=x1;
		xcanvas.y1=y1;
		xcanvas.x2=x2;
		xcanvas.y2=y2;
		
		//xcanvas가 이미 그려진 시점에 사용자가 그래픽적으로 모양에 변화를 주게될 때만 paint 메서드가 다시 갱신된 그림을
		//보여줘야 하므로, 시스템에 의해 호출되게 된다!!
		//하지만, 갱신된 그림을 보기 위한 그래픽에 변화를 마우스로 준다는것은 올바른 방식이 아니므로,
		//개발자가 프로그래밍적으로 다시 그려질것을 명령해야 한다!!
		//xcanvas.paint() 올바르지 않다!!
		//왜?? 자바에선 그림의 주체가 컴포넌스 스스로 이기 때문에 
		// paint 메서드는 시스템에 의해 호출되어야 하며 개발자가 호출 해서는 안된다!!
		// 단지 개발자는 다시 그려질 것을 시스템에 부탁만 할 수 있다..
		// repaint() ---> update(화면지움) --->paint(그림)
		//즉 update() 메서드는 화면을 지운다.
		// paint() 지워진 화면에 다시 그래픽처리를 랜더링한다!!
		xcanvas.repaint();
		
	}
	//JFrame 을 포함한 모든 컴포넌트는 스스로 그리는 능력을 가지고있고, 현재 우리가 프레임을 육안으로 볼 수 있었던 이유도
	//스스로 그림을 그렸기 때문이다.. 이때 컴포넌트가 스스로 그리는 행위를 담당하는 메서드가 바로 paint() 메서드이며 그림 그릴때 필요한
	//색상이나 다양한 기능은 팔레트 역할을 해주는 Graphics 객체를 이용한다
	
	//아래와 같이 개발자가 paint메서드를 오버라이드 하게 되면 업그레이드 하게 되는 것이므로, 컴포넌트가 스스로 그려질 수 있는 기회를 개발자가
	// 뺏는 것이므로, 그림 그리려면 제대로 그려야한다.
	@Override
	public void paint(Graphics g) {
		System.out.println("paint 메서도 호출");
	}
	public static void main(String[] args) {
		new PaintApp();
	}
}

