package event;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
//어댑터는 원래 우리가 재정의 했어야 할 3개의 메서드를 오버라이드 했기때문에, 우리대신 고난을 받은 상태다!!

public class MyKeyAdapter extends KeyAdapter{
	AdapterApp adapterApp;
	//전달받아오자!! 프로그래밍 언어에서 전달한다는 것은 메서드를 통해서만 가능하다!!
	public MyKeyAdapter(AdapterApp adapterApp) {
		this.adapterApp=adapterApp;
	}
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		//개발자가 키코드값을 언제나 알아야 한다??
		//개발자는 머신이 아니므로, 인간에게 조금 더 익숙한, 그리고 직관적으로 개발하는 방법은??
		//상수를 이용하면, 직관성을 부여한 단어의 뜻이 포함되어 있기떄문에 개발의 편의를 준다.
		//ex) BorderLayout.NORTH
		if(key == KeyEvent.VK_ENTER) {
			//윈도우에 부착된 area에 메세지 출력!!
			
			String msg = adapterApp.t_input.getText();
			adapterApp.area.append(msg+"\n");
			adapterApp.t_input.setText("");
		}
	}

}
