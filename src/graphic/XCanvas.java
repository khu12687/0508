/*
 * paint �޼��带 �������ؼ� ,�� ��� ���� �ֵ��Ͽ� �׸��� �׷����� 
 * */
package graphic;

import java.awt.Canvas;
import java.awt.Graphics;

public class XCanvas extends Canvas {
	int x1,x2,y1,y2; //�����ڰ� �ɹ������� �ʱ�ȭ ���� ������ �������� �ڹٰ� �˾Ƽ� �ּ����� ������ �Ѵ� ������ ��� 0���� �ʱ�ȭ!!
	//�����ڰ� ���ϴ� �׸����� ���׷��̵�!!
	//paint �޼���� �׳� ȣ��Ǵ� �뵵�ϻ��̰�, �������� �׷����۾��� �ȷ�Ʈ ������ ���ִ� 
	//Grapghics ��ü�� ���!!
	@Override
	public void paint(Graphics g) {
		System.out.println("x1="+x1+",y1="+y1);
		g.drawLine(x1,y1,x2,y2);
	}
}
