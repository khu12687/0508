/*
 * paint 메서드를 재정의해서 ,즉 뺏어서 내가 주도하여 그림을 그려보자 
 * */
package graphic;

import java.awt.Canvas;
import java.awt.Graphics;

public class XCanvas extends Canvas {
	int x1,x2,y1,y2; //개발자가 맴버변수를 초기화 하지 않으면 에러지만 자바가 알아서 최소한의 관여를 한다 숫자일 경우 0으로 초기화!!
	//개발자가 원하는 그림으로 업그레이드!!
	//paint 메서드는 그냥 호출되는 용도일뿐이고, 실제적인 그래픽작업은 팔레트 역할을 해주는 
	//Grapghics 객체가 담당!!
	@Override
	public void paint(Graphics g) {
		System.out.println("x1="+x1+",y1="+y1);
		g.drawLine(x1,y1,x2,y2);
	}
}
