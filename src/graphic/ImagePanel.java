/*
 * �츮�� JPanel �� ȣ�⸸ �Ұ��� �ƴ϶�, �޼�����ü�� �����ؾ� �ϹǷ� Ŭ���� �ڵ带 �ۼ��ؾ� �Ѵ�..
 * */
package graphic;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class ImagePanel extends JPanel{
	//JPanel�� ������ �޼��� �� �����θ� �׸��� �޼����� paint �� ���� ��ȣ�� �°� �����ع����Ŵ�!!(OVerriding)
	/*
	 * �ڹ��� �̹����� �����ϴ� ����� ���������� �ִ�!!
	 * 1)Toolkit ��ü�� �̿��ϴ� ��!!
	 * 	 ��Ŷ�� �߻�Ŭ�����̹Ƿ� new �����ڸ� �̿��Ͽ� �ν��Ͻ��� ������ �� ����. ������ �߻�Ŭ������ �������� ��ü��
	 * 	 ��Ģ) �߻�Ŭ������ ��ӹ޴� �ڽ� Ŭ������ �����Ͽ� �� �ڽ��� new�ϸ� �ȴ�
	 * 	���� ) �̹� �����翡�� �ν��Ͻ��� ���� �ִ� �޼��带 ����
	 * */
	Toolkit kit = Toolkit.getDefaultToolkit();
	Image[] img;
	int index = 0; //�迭�� ���°�� ������������� ����!!
	public ImagePanel(String[] arr) {
		img = new Image[arr.length];
		//String �迭��ŭ �̹��� ��ü�� ��â ��������!!
		for(int i=0; i<arr.length; i++) {
			img[i] = kit.getImage(arr[i]);
			//��� �̹������� ũ�Ⱑ Ʋ���Ƿ�, ������Ű��!!
			
		}
	}
	@Override
	public void paint(Graphics g) {
		g.drawImage(img[index], 0, 0,450,400, this);
	}
}
