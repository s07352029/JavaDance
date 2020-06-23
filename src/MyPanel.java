import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;

public class MyPanel extends JPanel implements Runnable{
	int x = 110 , y = 110 ;
	int r1 = 30 , r2 = 30;
	int times = 1;
	static int time = 0;
	static int f = 0;
	static boolean clickflag , flag=false;
	
	public void paint(Graphics g) {
		BufferedImage bubbleimg = null;
		if(r1<90) {
			try {
				bubbleimg = JavaDance.bubbleimg(1);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else if(r1>=90&&r1<150) {
			try {
				bubbleimg = JavaDance.bubbleimg(2);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else if(r1>=150&&r1<=200&&clickflag==false) {
			try {
				bubbleimg = JavaDance.bubbleimg(3);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else if (r1>=150&&r1<=200&&clickflag==true) {
			try {
				bubbleimg = JavaDance.bubbleimg(4);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		super.paint(g);
		g.drawImage(bubbleimg,x-r1/2,y-r1/2,r1,r2,this);
	}
	
	public void run() {
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			public void run() {
				r1+=1;
				r2+=1;
				if(r1==201) {
					x = (int) (Math.random()*1000%700+100);
					y = (int) (Math.random()*1000%430+110);
					r1=r2=30;
					flag = JavaDance.click2(flag);
					times++;
					time = JavaDance.alltime();
					if(time==0) {
						timer.cancel();
					}
				}
				if(r1>=150&&r1<=200) {
					clickflag = JavaDance.click();
				}
				repaint();
			}
		},8500,8);
	}
	
	public int getlocationx() {
		return x;
	}
	public int getlocationy() {
		return y;
	}
	public int getradius() {
		return r1;
	}
	public int gettimes() {
		return times;
	}
}
