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

/*자바에서 이미지 처리하는 법을배운다!!
 * 참고로 자바에서 이미지를 불러오는 방법은 다양하다!!
 * 한번 익혀놓으면 안드로이드에서 비슷함
 * */
public class ImageApp extends JFrame{
	ImagePanel p;
	JPanel p_north;
	JButton bt_prev, bt_next;
	JTextField t_path; //이미지의 경로와 이름을 출력하는 텍스트필트
	
	//이미지 10개를 배열로 보관해보자!!
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
		bt_prev = new JButton("◀");
		bt_next = new JButton("▶");
		t_path = new JTextField(30);
		//패널은 아무런 색상이 없으므로, 배경색을 입혀보자!!
		p.setBackground(Color.YELLOW);
		
		//페널의 크기를 width 450, height 400 
		p.setPreferredSize(new Dimension(450,400));
		
		setLayout(new FlowLayout());
		
		//북쪽 패널에 버튼과 텍스트필드 부착!!
		p_north.add(bt_prev);
		p_north.add(t_path);
		p_north.add(bt_next);
		
		//북쪽 패널을 윈도우에 부착
		add(p_north,BorderLayout.NORTH);
		add(p);
		
		//이전 이미지 보여주기
		bt_prev.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				prev();
				
			}
		});
		//다음 이미지 보여주기
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
		//이미지패널이 보유한 index 1감소
		p.index--;
		p.repaint();
		 printPath();
	}
	
	public void next() {
		//이미지패널이 보유한 index 1증가
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
