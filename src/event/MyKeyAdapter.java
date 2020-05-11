package event;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
//����ʹ� ���� �츮�� ������ �߾�� �� 3���� �޼��带 �������̵� �߱⶧����, �츮��� ���� ���� ���´�!!

public class MyKeyAdapter extends KeyAdapter{
	AdapterApp adapterApp;
	//���޹޾ƿ���!! ���α׷��� ���� �����Ѵٴ� ���� �޼��带 ���ؼ��� �����ϴ�!!
	public MyKeyAdapter(AdapterApp adapterApp) {
		this.adapterApp=adapterApp;
	}
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		//�����ڰ� Ű�ڵ尪�� ������ �˾ƾ� �Ѵ�??
		//�����ڴ� �ӽ��� �ƴϹǷ�, �ΰ����� ���� �� �ͼ���, �׸��� ���������� �����ϴ� �����??
		//����� �̿��ϸ�, �������� �ο��� �ܾ��� ���� ���ԵǾ� �ֱ⋚���� ������ ���Ǹ� �ش�.
		//ex) BorderLayout.NORTH
		if(key == KeyEvent.VK_ENTER) {
			//�����쿡 ������ area�� �޼��� ���!!
			
			String msg = adapterApp.t_input.getText();
			adapterApp.area.append(msg+"\n");
			adapterApp.t_input.setText("");
		}
	}

}
