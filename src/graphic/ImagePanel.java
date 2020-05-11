/*
 * 우리는 JPanel 을 호출만 할것이 아니라, 메서드자체를 수정해야 하므로 클래스 코드를 작성해야 한다..
 * */
package graphic;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class ImagePanel extends JPanel{
	//JPanel이 보유한 메서드 중 스스로를 그리는 메서드인 paint 를 나의 기호에 맞게 수정해버릴거다!!(OVerriding)
	/*
	 * 자바의 이미지를 생성하는 방법은 여러가지가 있다!!
	 * 1)Toolkit 객체를 이용하는 법!!
	 * 	 툴킷은 추상클래스이므로 new 연산자를 이용하여 인스턴스를 생성할 수 없다. 앞으로 추상클래스를 만났을때 대체법
	 * 	 원칙) 추상클래스를 상속받는 자식 클래스를 정의하여 그 자식을 new하면 된다
	 * 	예외 ) 이미 벤더사에서 인스턴스를 얻어갈수 있는 메서드를 제공
	 * */
	Toolkit kit = Toolkit.getDefaultToolkit();
	Image[] img;
	int index = 0; //배열에 몇번째를 보여줘야할지를 결정!!
	public ImagePanel(String[] arr) {
		img = new Image[arr.length];
		//String 배열만큼 이미지 객체도 왕창 생성하자!!
		for(int i=0; i<arr.length; i++) {
			img[i] = kit.getImage(arr[i]);
			//모든 이미지마다 크기가 틀리므로, 고정시키자!!
			
		}
	}
	@Override
	public void paint(Graphics g) {
		g.drawImage(img[index], 0, 0,450,400, this);
	}
}
