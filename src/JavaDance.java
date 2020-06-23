import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.*;
import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import javax.swing.border.EmptyBorder;

public class JavaDance extends JFrame implements ActionListener{

	static int flag = 0 , flag2 = 0 , flag3 = 0;
	static int flag4[]=new int[6];
	static int flag5 = 0;
	static int flag6 = 0;
	static boolean flag70;
	static boolean flag71;
	static boolean flag72;
	static boolean flag73;
	static int flag80 = 0;
	static int flag81 = 0;
	static int flag82 = 0;
	static int flag83 = 0;
	static int temposcore = 0;
	static int bubblescore = 0;
	static int bubbletimes = 0;
	static boolean bubbleclick = false;
	static int arrowflag[] = new int[4];
	static int score = 0;
	static int alltime = 60;
	static int total = 0;
	static int c=0 ;
	static int music = (int) (Math.random()*100%17);
	static int[] ran = new int[6];
	static JavaDance frm = new JavaDance();
	static JavaDance frm2 = new JavaDance();
	static JavaDance frm3 = new JavaDance();
	static JavaDance frm4 = new JavaDance();
	static JavaDance frm5 = new JavaDance();
	static JavaDance bubble = new JavaDance();
	static JavaDance tempo = new JavaDance();
	static JavaDance hard = new JavaDance();
	static JavaDance hell = new JavaDance();
	static Point p[] = new Point[4];
	//一般模式

	public static BufferedImage bubbleimg(int i) throws IOException {
		BufferedImage bubble1 = ImageIO.read(new File("..//JAVA勁舞團//Image//bubble1.png"));
		BufferedImage bubble2 = ImageIO.read(new File("..//JAVA勁舞團//Image//bubble2.png"));
		BufferedImage bubble3 = ImageIO.read(new File("..//JAVA勁舞團//Image//bubble3.png"));
		BufferedImage bubble4 = ImageIO.read(new File("..//JAVA勁舞團//Image//bubble4.png"));
		if(i==1) {
			return bubble1;
		}else if(i==2) {
			return bubble2;
		}else if(i==3) {
			return bubble3;
		}else if(i==4) {
			return bubble4;
		}else {
			return null;
		}
	}
	public static boolean click() {
		return bubbleclick;
	}
	public static boolean click2(boolean clickflag) {
		bubbleclick = clickflag;
		return bubbleclick;
	}
	public static int alltime() {
		return alltime;
	}
	
	public static void main(String[] args) {
		
		ImageIcon Arrowframe[] = new ImageIcon[4];
		for(int i=0 ; i<4 ; i++) {
			Arrowframe[i] = new ImageIcon("Image\\arrow2\\arrow11"+i+".png"); }
		ImageIcon Dance[] = new ImageIcon[11];
		for(int i=0 ; i<11 ; i++) {
			Dance[i] = new ImageIcon("人物跳舞\\"+i+".gif"); }
		ImageIcon Arrow[] = new ImageIcon[4];
		for(int i=0 ; i<4 ; i++) {
			Arrow[i] = new ImageIcon("Image\\arrow\\arrow"+i+".png"); }
		ImageIcon Arrowblack[] = new ImageIcon[4];
		for(int i=0 ; i<4 ; i++) {
			Arrowblack[i] = new ImageIcon("Image\\arrow\\arrowblack"+i+".png"); }
		ImageIcon Tempoline = new ImageIcon("Image\\tempoline.png");
		ImageIcon Miss = new ImageIcon("Image\\miss.png");
		ImageIcon Great = new ImageIcon("Image\\great.png");
		ImageIcon Timeover=new ImageIcon("Image\\遊戲over.gif");
		ImageIcon Helllevel=new ImageIcon("Image\\地獄模式.png");
		ImageIcon Hardlevel=new ImageIcon("Image\\高級模式.png");
		ImageIcon Tempolevel = new ImageIcon("Image\\節奏模式.png");
		ImageIcon Bubblelevel=new ImageIcon("Image\\泡泡模式.png");
		ImageIcon Level=new ImageIcon("Image\\難度.jpg");
		ImageIcon Scoreback=new ImageIcon("Image\\scoreback1.jpg");
		ImageIcon Temposcoreback = new ImageIcon("Image\\scoreback2.png");
		ImageIcon Bubblescoreback = new ImageIcon("Image\\scoreback3.png");
		ImageIcon Team=new ImageIcon("Image\\團隊2.png");
		ImageIcon Good=new ImageIcon("Image\\GOOD.png");
		ImageIcon One=new ImageIcon("Image\\1.png");
		ImageIcon Two=new ImageIcon("Image\\2.png");
		ImageIcon Three=new ImageIcon("Image\\3.png");
		ImageIcon Back = new ImageIcon("Image\\上一頁.gif");
		ImageIcon banner2 = new ImageIcon("Image\\5.png");
		ImageIcon banner = new ImageIcon("Image\\banner.png");
		ImageIcon gamebackground = new ImageIcon("Image\\遊戲背景.png");
		ImageIcon end = new ImageIcon("Image\\遊戲結束.png");
		ImageIcon about = new ImageIcon("Image\\關於製作群.png");
		ImageIcon explain = new ImageIcon("Image\\遊戲說明.png");
		ImageIcon StartBtn = new ImageIcon("Image\\遊戲開始.png");
		ImageIcon Start = new ImageIcon("Image\\start.png");
		ImageIcon LOgo = new ImageIcon("Image\\logo.png");
		ImageIcon firstground = new ImageIcon("Image\\主畫面.jpg");
		ImageIcon backf1 = new ImageIcon("Image\\一般說明.png");
		ImageIcon backf2 = new ImageIcon("Image\\泡泡說明.png");
		ImageIcon backf3 = new ImageIcon("Image\\節奏說明.png");
		ImageIcon back = new ImageIcon("Image\\背景舞台.jpg");
		ImageIcon Tempoback = new ImageIcon("Image\\Tempoback.jpg");
		ImageIcon Bubbleback = new ImageIcon("Image\\bubbleback.jpg");
		ImageIcon ball = new ImageIcon("Image\\圓球.png");
		ImageIcon Musicleft = new ImageIcon("Image\\musicleft.png");
		ImageIcon Musicright = new ImageIcon("Image\\musicright.png");
		ImageIcon Normalbtn = new ImageIcon("Image\\Normal Button.png");
		ImageIcon Bubblebtn = new ImageIcon("Image\\Bubble Button.png");
		ImageIcon Tempobtn = new ImageIcon("Image\\Tempo Button.png");

		JButton[] btn = new JButton[10];
		for(int i=0;i<10;i++) {
			btn[i] = new JButton();}
		JButton[] dirbtn = new JButton[3];
		for(int i=0;i<3;i++) {
			dirbtn[i] = new JButton();}
		JButton easybtn=new JButton();
		JButton normalbtn=new JButton();
		JButton hardbtn=new JButton();
		JButton hellbtn=new JButton();
		JButton musicleft = new JButton();
		JButton musicright = new JButton();
		
		JTextField fgdtext=new JTextField();
		fgdtext.setFont(new Font("setofont",Font.BOLD,15));
		fgdtext.setForeground(Color.white);
		fgdtext.setBorder(new EmptyBorder(0,0,0,0));
		fgdtext.setHorizontalAlignment(JTextField.CENTER);
		fgdtext.setOpaque(false);
		fgdtext.setEditable(false);
		
		JTextField temposcoretext=new JTextField();
		temposcoretext.setFont(new Font("setofont",Font.BOLD,27));
		temposcoretext.setForeground(Color.white);
		temposcoretext.setBorder(new EmptyBorder(0,0,0,0));
		temposcoretext.setHorizontalAlignment(JTextField.CENTER);
		temposcoretext.setOpaque(false);
		temposcoretext.setEditable(false);
		
		JTextField tempotime=new JTextField();
		tempotime.setFont(new Font("setofont",Font.BOLD,27));
		tempotime.setForeground(Color.white);
		tempotime.setBorder(new EmptyBorder(0,0,0,0));
		tempotime.setHorizontalAlignment(JTextField.CENTER);
		tempotime.setOpaque(false);
		tempotime.setEditable(false);
		
		JTextField score1=new JTextField();
		score1.setFont(new Font("微軟正黑體",Font.BOLD,30));
		score1.setBorder(new EmptyBorder(0,0,0,0));
		score1.setHorizontalAlignment(JTextField.CENTER);
		score1.setOpaque(false);
		score1.setEditable(false);
		
		JTextField normaltimes=new JTextField();
		normaltimes.setFont(new Font("setofont",Font.BOLD,27));
		normaltimes.setForeground(Color.white);
		normaltimes.setBorder(new EmptyBorder(0,0,0,0));
		normaltimes.setHorizontalAlignment(JTextField.CENTER);
		normaltimes.setOpaque(false);
		normaltimes.setEditable(false);

		JLabel[] arrowframe = new JLabel[4];
		for(int i=0 ; i<4 ; i++) {
			arrowframe[i] = new JLabel();}
		JLabel[] dance = new JLabel[11];
		for(int i=0 ; i<11 ; i++) {
			dance[i] = new JLabel(); }
		JLabel[] arrow = new JLabel[6];
		for(int i=0 ; i<6 ; i++) {
			arrow[i] = new JLabel(); }
		JLabel[] great = new JLabel[4];
		for(int i=0 ; i<4 ; i++) {
			great[i] = new JLabel();}
		JLabel tempoline = new JLabel();
		JLabel timeover=new JLabel();
		JLabel level=new JLabel();
		JLabel scoreback=new JLabel();
		JLabel good=new JLabel();
		JLabel logo = new JLabel();
		JLabel ban = new JLabel();
		JLabel ban2 = new JLabel();
		JLabel one=new JLabel();
		JLabel two=new JLabel();
		JLabel three=new JLabel();
		JLabel start = new JLabel();
		JLabel bak = new JLabel();
		JLabel bal = new JLabel();
		JLabel exp = new JLabel();
		JLabel fgd = new JLabel();
		JLabel team = new JLabel();
		JLabel bakf = new JLabel();
		JLabel gamebkgd = new JLabel();
		JLabel tempoback = new JLabel();
		JLabel bubbleback = new JLabel();
		
		for(int i=0;i<11;i++) {
			dance[i].setIcon(Dance[i]); }
		for(int i=0 ; i<4 ; i++) {
			great[i].setIcon(Great);}
		tempoline.setIcon(Tempoline);
		timeover.setIcon(Timeover);
		level.setIcon(Level);
		team.setIcon(Team);
		good.setIcon(Good);
		one.setIcon(One);
		two.setIcon(Two);
		three.setIcon(Three);
		start.setIcon(Start);
		ban.setIcon(banner);
		ban2.setIcon(banner2);
		btn[1].setIcon(StartBtn);
		btn[2].setIcon(explain);
		btn[3].setIcon(end);
		btn[4].setIcon(about);
		btn[5].setIcon(end);
		for(int i=6;i<=8;i++) {
			btn[i].setIcon(Back);}
		btn[9].setIcon(end);
		dirbtn[0].setIcon(Normalbtn);
		dirbtn[1].setIcon(Bubblebtn);
		dirbtn[2].setIcon(Tempobtn);
		logo.setIcon(LOgo);
		bak.setIcon(back);
		bal.setIcon(ball);
		bakf.setIcon(backf1);
		fgd.setIcon(firstground);
		gamebkgd.setIcon(gamebackground);
		tempoback.setIcon(Tempoback);
		bubbleback.setIcon(Bubbleback);
		easybtn.setIcon(Bubblelevel);
		normalbtn.setIcon(Tempolevel);
		hardbtn.setIcon(Hardlevel);
		hellbtn.setIcon(Helllevel);
		musicleft.setIcon(Musicleft);
		musicright.setIcon(Musicright);
		

		for(int i=1;i<=9;i++) {
			btn[i].setOpaque(false);
			btn[i].setBorder(null);
			btn[i].setContentAreaFilled(false);
			btn[i].setFocusPainted(false);}
		for(int i=0;i<3;i++) {
			dirbtn[i].setOpaque(false);
			dirbtn[i].setBorder(null);
			dirbtn[i].setContentAreaFilled(false);
			dirbtn[i].setFocusPainted(false);}
		easybtn.setOpaque(false);
		easybtn.setBorder(null);
		easybtn.setContentAreaFilled(false);
		easybtn.setFocusPainted(false);
		normalbtn.setOpaque(false);
		normalbtn.setBorder(null);
		normalbtn.setContentAreaFilled(false);
		normalbtn.setFocusPainted(false);
		hardbtn.setOpaque(false);
		hardbtn.setBorder(null);
		hardbtn.setContentAreaFilled(false);
		hardbtn.setFocusPainted(false);
		hellbtn.setOpaque(false);
		hellbtn.setBorder(null);
		hellbtn.setContentAreaFilled(false);
		hellbtn.setFocusPainted(false);
		musicleft.setOpaque(false);
		musicleft.setBorder(null);
		musicleft.setContentAreaFilled(false);
		musicleft.setFocusPainted(false);
		musicright.setOpaque(false);
		musicright.setBorder(null);
		musicright.setContentAreaFilled(false);
		musicright.setFocusPainted(false);
		
		great[0].setBounds(185,504,124,102);
		great[1].setBounds(325,504,124,102);
		great[2].setBounds(465,504,124,102);
		great[3].setBounds(605,504,124,102);
		dance[1].setBounds(390,180,165,315);
		dance[2].setBounds(375,175,190,320);
		dance[3].setBounds(330,180,285,320);
		dance[4].setBounds(395,180,155,315);
		dance[5].setBounds(380,180,200,310);
		dance[6].setBounds(375,185,195,315);
		dance[7].setBounds(330,180,290,315);
		dance[8].setBounds(380,175,195,320);
		dance[9].setBounds(370,175,195,320);
		dance[10].setBounds(370,168,215,330);
		dance[0].setBounds(335,175,275,320);
		tempoline.setBounds(40,490,833,100);
		timeover.setBounds(270,250,415,218);
		tempotime.setBounds(10,10,168,50);
		temposcoretext.setBounds(720,10,200,50);
		normaltimes.setBounds(10,10,168,50);
		score1.setBounds(338,240,250,100);
		good.setBounds(530,375,180,180);
		one.setBounds(400,230,200,200);
		two.setBounds(400,230,200,200);
		three.setBounds(400,230,200,200);
		start.setBounds(280,230,365,200);
		arrow[0].setBounds(293, 559, 60, 60);
		arrow[1].setBounds(348, 559, 60, 60);
		arrow[2].setBounds(403, 559, 60, 60);
		arrow[3].setBounds(458, 559, 60, 60);
		arrow[4].setBounds(513, 559, 60, 60);
		arrow[5].setBounds(568, 559, 60, 60);
		exp.setBounds(63, 450, 155, 50);
		logo.setBounds(363, 60, 260, 150);
		btn[1].setBounds(416, 380, 150, 50);
		btn[2].setBounds(228, 450, 155, 50);
		btn[3].setBounds(430, 610, 150, 50);
		btn[4].setBounds(633, 450, 150, 50);
		for(int i=5;i<=8;i++) {
			btn[i].setBounds(740, 610, 150, 50);}
		btn[9].setBounds(770, 630, 150, 50);
		dirbtn[0].setBounds(40, 5, 225, 80);
		dirbtn[1].setBounds(350, 5, 225, 80);
		dirbtn[2].setBounds(660, 5, 225, 80);
		easybtn.setBounds(7, 152, 230, 390);
		normalbtn.setBounds(230, 152, 230, 390);
		hardbtn.setBounds(456, 155, 230, 390);
		hellbtn.setBounds(680, 155, 230, 390);
		level.setBounds(0,0,932,702);
		bak.setBounds(0, 0, 932, 702);
		bakf.setBounds(0, 0, 932, 702);
		team.setBounds(0,0,945,710);
		gamebkgd.setBounds(0, 0, 932, 702);
		scoreback.setBounds(0,0,932,702);
		tempoback.setBounds(0,0,932,702);
		bubbleback.setBounds(0,0,932,720);
		fgd.setBounds(0, 0, 1000, 702);
		fgdtext.setBounds(760,8,200,15);
		ban.setBounds(250, 550, 450, 78);
		ban2.setBounds(550, 520, 150, 30);
		bal.setBounds(550, 520, 30, 30);
		musicleft.setBounds(760,4,20,20);
		musicright.setBounds(939,4,20,20);
		
		for(int i=0;i<4;i++) {
			arrowframe[i].setVisible(false);
			great[i].setVisible(false);}
		for(int i=0;i<11;i++) {
			dance[i].setVisible(false); }
		for(int i=0;i<6;i++) {
			arrow[i].setVisible(false); }
		timeover.setVisible(false);
		good.setVisible(false);
		one.setVisible(false);
		two.setVisible(false);
		three.setVisible(false);
		start.setVisible(false);
		frm.setResizable(false);
		frm2.setResizable(false);
		frm3.setResizable(false);
		frm4.setResizable(false);
		frm5.setResizable(false);
		tempo.setResizable(false);
		bubble.setResizable(false);
		hard.setResizable(false);
		hell.setResizable(false);

		// 主畫面(第一視窗)設置
		frm.setBounds(10, 10, 1005, 740);
		for(int i=1;i<=4;i++) {
			frm.add(btn[i]);}
		frm.add(logo);
		frm.add(musicleft);
		frm.add(musicright);
		frm.add(fgdtext);
		frm.add(fgd);
		frm.setLayout(null);
		frm.setVisible(true);

		// 遊戲說明(第二視窗)設置
		JPanel dir = new JPanel();
		dir.setBounds(0, 0, 937, 742);
		dir.setLayout(null);
		for(int i=0;i<3;i++) {
			dir.add(dirbtn[i]);}
		dirbtn[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bakf.setIcon(backf1);}});
		dirbtn[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bakf.setIcon(backf2);}});
		dirbtn[2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bakf.setIcon(backf3);}});
		dir.add(btn[6]);
		dir.add(bakf);
		frm2.setBounds(10, 10, 937, 742);
		frm2.setLayout(null);
		frm2.add(dir);

		// 遊戲開始(第三視窗)設置
		frm3.setBounds(10, 10, 937, 742);
		frm3.setLayout(null);
		frm3.add(btn[8]);
		frm3.add(easybtn);
		frm3.add(normalbtn);
		frm3.add(hardbtn);
		frm3.add(hellbtn);
		frm3.add(level);
		
		
		//關於製作群(第四視窗)設置
		frm4.setBounds(10, 10, 930, 748);
		frm4.setLayout(null);
		frm4.add(btn[7]);
		frm4.add(team);
		
		//成績單結算(第五視窗)設置
		frm5.setBounds(10,10,938,742);
		frm5.setLayout(null);
		frm5.add(score1);
		frm5.add(btn[9]);
		frm5.add(scoreback);
		
		Clip[] clip = new Clip[21];
		AudioInputStream[] ais = new AudioInputStream[21];
		
		try {
			URL a0=frm.getClass().getClassLoader().getResource("原子邦妮 - 這樣我就能忘記你了.wav");
			URL a1=frm.getClass().getClassLoader().getResource("原子邦妮 - 謝謝你曾經讓我悲傷.wav");
			URL a2=frm.getClass().getClassLoader().getResource("原子邦妮 - 在名為未來的波浪裡.wav");
			URL a3=frm.getClass().getClassLoader().getResource("(G)I-DLE - Lion.wav");
			URL a4=frm.getClass().getClassLoader().getResource("(G)I-DLE - Oh my god.wav");
			URL a5=frm.getClass().getClassLoader().getResource("Zico - anysong.wav");
			URL a6=frm.getClass().getClassLoader().getResource("ITZY - wannabe.wav");
			URL a7=frm.getClass().getClassLoader().getResource("IU - BBIBBI.wav");
			URL a8=frm.getClass().getClassLoader().getResource("IU - Blueming.wav");
			URL a9=frm.getClass().getClassLoader().getResource("KDA - POPSTARS.wav");
			URL a10=frm.getClass().getClassLoader().getResource("True Damage - GIANTS.wav");
			URL a11=frm.getClass().getClassLoader().getResource("Marshmello Halsey - Be Kind.wav");
			URL a12=frm.getClass().getClassLoader().getResource("Justin Bieber - E.T.A..wav");
			URL a13=frm.getClass().getClassLoader().getResource("Ariana Grande, Justin Bieber - Stuck with U.wav");
			URL a14=frm.getClass().getClassLoader().getResource("Red Velvet - Psycho.wav");
			URL a15=frm.getClass().getClassLoader().getResource("TWICE - MORE MORE.wav");
			URL a16=frm.getClass().getClassLoader().getResource("WINNER - Remember.wav");
			URL a17=tempo.getClass().getClassLoader().getResource("ITZY - WANNABE(cut).wav");
			URL a18=tempo.getClass().getClassLoader().getResource("ITZY - TING TING TING(cut).wav");
			URL a19=tempo.getClass().getClassLoader().getResource("Tones and I - Dance Monkey(cut).wav");
			URL a20=tempo.getClass().getClassLoader().getResource("Mike Perry - The Ocean(cut).wav");
			ais[0]=AudioSystem.getAudioInputStream(a0);
			ais[1]=AudioSystem.getAudioInputStream(a1);
			ais[2]=AudioSystem.getAudioInputStream(a2);
			ais[3]=AudioSystem.getAudioInputStream(a3);
			ais[4]=AudioSystem.getAudioInputStream(a4);
			ais[5]=AudioSystem.getAudioInputStream(a5);
			ais[6]=AudioSystem.getAudioInputStream(a6);
			ais[7]=AudioSystem.getAudioInputStream(a7);
			ais[8]=AudioSystem.getAudioInputStream(a8);
			ais[9]=AudioSystem.getAudioInputStream(a9);
			ais[10]=AudioSystem.getAudioInputStream(a10);
			ais[11]=AudioSystem.getAudioInputStream(a11);
			ais[12]=AudioSystem.getAudioInputStream(a12);
			ais[13]=AudioSystem.getAudioInputStream(a13);
			ais[14]=AudioSystem.getAudioInputStream(a14);
			ais[15]=AudioSystem.getAudioInputStream(a15);
			ais[16]=AudioSystem.getAudioInputStream(a16);
			ais[17]=AudioSystem.getAudioInputStream(a17);
			ais[18]=AudioSystem.getAudioInputStream(a18);
			ais[19]=AudioSystem.getAudioInputStream(a19);
			ais[20]=AudioSystem.getAudioInputStream(a20);
			for(int i=0 ; i<21 ; i++) {
				clip[i]=AudioSystem.getClip();
				clip[i].open(ais[i]);
			}
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error loading sound file, it may not exist or another program has a lock on it.");
			System.exit(1);
		}
		
		
		switch(music) {
			case 0:fgdtext.setText("原子邦妮-這樣我就能忘記你了"); break;
			case 1:fgdtext.setText("原子邦妮-謝謝你曾經讓我悲傷"); break;
			case 2:fgdtext.setText("原子邦妮-在名為未來的波浪裡"); break;
			case 3:fgdtext.setText("(G)I-DLE-Lion"); break;
			case 4:fgdtext.setText("(G)I-DLE-Oh my god"); break;
			case 5:fgdtext.setText("Zico-Anysong"); break;
			case 6:fgdtext.setText("ITZY-wannabe"); break;
			case 7:fgdtext.setText("IU-BBIBBI"); break;
			case 8:fgdtext.setText("IU-Blueming"); break;
			case 9:fgdtext.setText("KDA-POPSTARS"); break;
			case 10:fgdtext.setText("TrueDamage-GIANTS"); break;
			case 11:fgdtext.setText("Marshemllo Halsey-Be Kind"); break;
			case 12:fgdtext.setText("Justin Bieber-E.T.A."); break;
			case 13:fgdtext.setText("Justin Bieber-Stuck with U"); break;
			case 14:fgdtext.setText("Red Velvet-Psycho"); break;
			case 15:fgdtext.setText("TWICE-More&More"); break;
			case 16:fgdtext.setText("Winner-Remember"); break;
		}
		try {
			clip[music].setFramePosition(music);
			clip[music].loop(0); //0=play once
			
		}catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("Error loading sound file, it may not exist or another program has a lock on it.");
			System.exit(1);
		}
		
		musicleft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clip[music].stop();
				music--;
				if(music==-1) {
					music=16;}
				switch(music) {
				case 0:fgdtext.setText("原子邦妮-這樣我就能忘記你了"); break;
				case 1:fgdtext.setText("原子邦妮-謝謝你曾經讓我悲傷"); break;
				case 2:fgdtext.setText("原子邦妮-在名為未來的波浪裡"); break;
				case 3:fgdtext.setText("(G)I-DLE-Lion"); break;
				case 4:fgdtext.setText("(G)I-DLE-Oh my god"); break;
				case 5:fgdtext.setText("Zico-Anysong"); break;
				case 6:fgdtext.setText("ITZY-wannabe"); break;
				case 7:fgdtext.setText("IU-BBIBBI"); break;
				case 8:fgdtext.setText("IU-Blueming"); break;
				case 9:fgdtext.setText("KDA-POPSTARS"); break;
				case 10:fgdtext.setText("TrueDamage-GIANTS"); break;
				case 11:fgdtext.setText("Marshemllo Halsey-Be Kind"); break;
				case 12:fgdtext.setText("Justin Bieber-E.T.A."); break;
				case 13:fgdtext.setText("Justin Bieber-Stuck with U"); break;
				case 14:fgdtext.setText("Red Velvet-Psycho"); break;
				case 15:fgdtext.setText("TWICE-More&More"); break;
				case 16:fgdtext.setText("Winner-Remember"); break;
				}
				try {
					clip[music].setFramePosition(music);
					clip[music].loop(0); //0=play once
					
				}catch (Exception ex) {
					ex.printStackTrace();
					System.out.println("Error loading sound file, it may not exist or another program has a lock on it.");
					System.exit(1);
				}
			}
		});
		musicright.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clip[music].stop();
				music++;
				if(music==17) {
					music=0;}
				switch(music) {
				case 0:fgdtext.setText("原子邦妮-這樣我就能忘記你了"); break;
				case 1:fgdtext.setText("原子邦妮-謝謝你曾經讓我悲傷"); break;
				case 2:fgdtext.setText("原子邦妮-在名為未來的波浪裡"); break;
				case 3:fgdtext.setText("(G)I-DLE-Lion"); break;
				case 4:fgdtext.setText("(G)I-DLE-Oh my god"); break;
				case 5:fgdtext.setText("Zico-Anysong"); break;
				case 6:fgdtext.setText("ITZY-wannabe"); break;
				case 7:fgdtext.setText("IU-BBIBBI"); break;
				case 8:fgdtext.setText("IU-Blueming"); break;
				case 9:fgdtext.setText("KDA-POPSTARS"); break;
				case 10:fgdtext.setText("TrueDamage-GIANTS"); break;
				case 11:fgdtext.setText("Marshemllo Halsey-Be Kind"); break;
				case 12:fgdtext.setText("Justin Bieber-E.T.A."); break;
				case 13:fgdtext.setText("Justin Bieber-Stuck with U"); break;
				case 14:fgdtext.setText("Red Velvet-Psycho"); break;
				case 15:fgdtext.setText("TWICE-More&More"); break;
				case 16:fgdtext.setText("Winner-Remember"); break;
				}
				try {
					clip[music].setFramePosition(music);
					clip[music].loop(0); //0=play once
					
				}catch (Exception ex) {
					ex.printStackTrace();
					System.out.println("Error loading sound file, it may not exist or another program has a lock on it.");
					System.exit(1);
				}
			}
		});
		
		//遊戲開始(簡單)視窗鍵盤事件
		
		//遊戲開始(一般)視窗鍵盤事件
			tempo.addKeyListener(new KeyAdapter() {
						public void keyPressed(KeyEvent e) {
							
							switch (e.getKeyCode()) {
							
							case KeyEvent.VK_UP:
								if(flag70==true&&arrowflag[0]==0){	flag80++;}
								else if (flag71==true&&arrowflag[1]==0) {	flag81++;}
								else if (flag72==true&&arrowflag[2]==0) {	flag82++;}
								else if (flag73==true&&arrowflag[3]==0) {	flag83++;}
								break;
							case KeyEvent.VK_DOWN:
								if(flag70==true&&arrowflag[0]==1){	flag80++;}
								else if (flag71==true&&arrowflag[1]==1) {	flag81++;}
								else if (flag72==true&&arrowflag[2]==1) {	flag82++;}
								else if (flag73==true&&arrowflag[3]==1) {	flag83++;}
								break;
							case KeyEvent.VK_RIGHT:
								if(flag70==true&&arrowflag[0]==3){	flag80++;}
								else if (flag71==true&&arrowflag[1]==3) {	flag81++;}
								else if (flag72==true&&arrowflag[2]==3) {	flag82++;}
								else if (flag73==true&&arrowflag[3]==3) {	flag83++;}
								break;
							case KeyEvent.VK_LEFT:
								if(flag70==true&&arrowflag[0]==2){	flag80++;}
								else if (flag71==true&&arrowflag[1]==2) {	flag81++;}
								else if (flag72==true&&arrowflag[2]==2) {	flag82++;}
								else if (flag73==true&&arrowflag[3]==2) {	flag83++;}
								break;
							}}});
				
		//遊戲開始(困難)視窗鍵盤事件
				hard.addKeyListener(new KeyAdapter() {
					public void keyPressed(KeyEvent e) {
						
						switch (e.getKeyCode()) {
						
						case KeyEvent.VK_UP:
							if(flag==0&&ran[0]==0)	{	arrow[0].setIcon(Arrowblack[0]);	 flag++;	flag3+=0; }
							else if(flag==1&&ran[1]==0){	arrow[1].setIcon(Arrowblack[0]);	flag++;	flag3+=0; }
							else if(flag==2&&ran[2]==0){	arrow[2].setIcon(Arrowblack[0]);	flag++;	flag3+=0; }
							else if(flag==3&&ran[3]==0){	arrow[3].setIcon(Arrowblack[0]);	flag++;	flag3+=0; }
							else if(flag==4&&ran[4]==0){	arrow[4].setIcon(Arrowblack[0]);	flag++;	flag3+=0; }
							else if(flag==5&&ran[5]==0){	arrow[5].setIcon(Arrowblack[0]);	flag++;	flag3+=0; }
							break;
						case KeyEvent.VK_DOWN:
							if(flag==0&&ran[0]==1){		arrow[0].setIcon(Arrowblack[1]);	flag++;	flag3+=1; }
							else if(flag==1&&ran[1]==1){	arrow[1].setIcon(Arrowblack[1]);	flag++;	flag3+=1; }
							else if(flag==2&&ran[2]==1){	arrow[2].setIcon(Arrowblack[1]);	flag++;	flag3+=1; }
							else if(flag==3&&ran[3]==1){	arrow[3].setIcon(Arrowblack[1]);	flag++;	flag3+=1; }
							else if(flag==4&&ran[4]==1){	arrow[4].setIcon(Arrowblack[1]);	flag++;	flag3+=1; }
							else if(flag==5&&ran[5]==1){	arrow[5].setIcon(Arrowblack[1]);	flag++;	flag3+=1; }
							break;
						case KeyEvent.VK_RIGHT:
							if(flag==0&&ran[0]==3){		arrow[0].setIcon(Arrowblack[3]);	flag++;	flag3+=3; }
							else if(flag==1&&ran[1]==3){	arrow[1].setIcon(Arrowblack[3]);	flag++;	flag3+=3; }
							else if(flag==2&&ran[2]==3){	arrow[2].setIcon(Arrowblack[3]);	flag++;	flag3+=3; }
							else if(flag==3&&ran[3]==3){	arrow[3].setIcon(Arrowblack[3]);	flag++;	flag3+=3; }
							else if(flag==4&&ran[4]==3){	arrow[4].setIcon(Arrowblack[3]);	flag++;	flag3+=3; }
							else if(flag==5&&ran[5]==3){	arrow[5].setIcon(Arrowblack[3]);	flag++;	flag3+=3; }
							break;
						case KeyEvent.VK_LEFT:
							if(flag==0&&ran[0]==2){		arrow[0].setIcon(Arrowblack[2]);	flag++;	flag3+=2; }
							else if(flag==1&&ran[1]==2){	arrow[1].setIcon(Arrowblack[2]);	flag++;	flag3+=2; }
							else if(flag==2&&ran[2]==2){	arrow[2].setIcon(Arrowblack[2]);	flag++;	flag3+=2; }
							else if(flag==3&&ran[3]==2){	arrow[3].setIcon(Arrowblack[2]);	flag++;	flag3+=2; }
							else if(flag==4&&ran[4]==2){	arrow[4].setIcon(Arrowblack[2]);	flag++;	flag3+=2; }
							else if(flag==5&&ran[5]==2){	arrow[5].setIcon(Arrowblack[2]);	flag++;	flag3+=2; }
							break;
						}}});
				
		//遊戲開始(地獄)視窗鍵盤事件
				hell.addKeyListener(new KeyAdapter() {
					public void keyPressed(KeyEvent e) {
						
						switch (e.getKeyCode()) {
						
						case KeyEvent.VK_UP:
							if(flag==0&&ran[0]==0)	{	arrow[0].setIcon(Arrowblack[0]);	 flag++;	flag3+=0; }
							else if(flag==1&&ran[1]==0){	arrow[1].setIcon(Arrowblack[0]);	flag++;	flag3+=0; }
							else if(flag==2&&ran[2]==0){	arrow[2].setIcon(Arrowblack[0]);	flag++;	flag3+=0; }
							else if(flag==3&&ran[3]==0){	arrow[3].setIcon(Arrowblack[0]);	flag++;	flag3+=0; }
							else if(flag==4&&ran[4]==0){	arrow[4].setIcon(Arrowblack[0]);	flag++;	flag3+=0; }
							else if(flag==5&&ran[5]==0){	arrow[5].setIcon(Arrowblack[0]);	flag++;	flag3+=0; }
							break;
						case KeyEvent.VK_DOWN:
							if(flag==0&&ran[0]==1){		arrow[0].setIcon(Arrowblack[1]);	flag++;	flag3+=1; }
							else if(flag==1&&ran[1]==1){	arrow[1].setIcon(Arrowblack[1]);	flag++;	flag3+=1; }
							else if(flag==2&&ran[2]==1){	arrow[2].setIcon(Arrowblack[1]);	flag++;	flag3+=1; }
							else if(flag==3&&ran[3]==1){	arrow[3].setIcon(Arrowblack[1]);	flag++;	flag3+=1; }
							else if(flag==4&&ran[4]==1){	arrow[4].setIcon(Arrowblack[1]);	flag++;	flag3+=1; }
							else if(flag==5&&ran[5]==1){	arrow[5].setIcon(Arrowblack[1]);	flag++;	flag3+=1; }
							break;
						case KeyEvent.VK_RIGHT:
							if(flag==0&&ran[0]==3){		arrow[0].setIcon(Arrowblack[3]);	flag++;	flag3+=3; }
							else if(flag==1&&ran[1]==3){	arrow[1].setIcon(Arrowblack[3]);	flag++;	flag3+=3; }
							else if(flag==2&&ran[2]==3){	arrow[2].setIcon(Arrowblack[3]);	flag++;	flag3+=3; }
							else if(flag==3&&ran[3]==3){	arrow[3].setIcon(Arrowblack[3]);	flag++;	flag3+=3; }
							else if(flag==4&&ran[4]==3){	arrow[4].setIcon(Arrowblack[3]);	flag++;	flag3+=3; }
							else if(flag==5&&ran[5]==3){	arrow[5].setIcon(Arrowblack[3]);	flag++;	flag3+=3; }
							break;
						case KeyEvent.VK_LEFT:
							if(flag==0&&ran[0]==2){		arrow[0].setIcon(Arrowblack[2]);	flag++;	flag3+=2; }
							else if(flag==1&&ran[1]==2){	arrow[1].setIcon(Arrowblack[2]);	flag++;	flag3+=2; }
							else if(flag==2&&ran[2]==2){	arrow[2].setIcon(Arrowblack[2]);	flag++;	flag3+=2; }
							else if(flag==3&&ran[3]==2){	arrow[3].setIcon(Arrowblack[2]);	flag++;	flag3+=2; }
							else if(flag==4&&ran[4]==2){	arrow[4].setIcon(Arrowblack[2]);	flag++;	flag3+=2; }
							else if(flag==5&&ran[5]==2){	arrow[5].setIcon(Arrowblack[2]);	flag++;	flag3+=2; }
							break;
						}}});
		
//遊戲開始(簡單)按鈕事情---------------------------------------------------------------------------------
		easybtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					JButton btn = (JButton) e.getSource();
					if(btn == easybtn)
					{
						clip[18].setFramePosition(0);
						clip[18].loop(0); //0=play once
					}
				}catch (Exception ex) {
					ex.printStackTrace();
					System.out.println("Error loading sound file, it may not exist or another program has a lock on it.");
					System.exit(1);
				}
				
				//遊戲開始(簡單)設置
				scoreback.setIcon(Bubblescoreback);
				MyPanel bubblepanel = new MyPanel();
				bubblepanel.setBounds(0,0,937,720);
				bubblepanel.setLayout(null);
				bubblepanel.add(timeover);
				bubblepanel.add(one);
				bubblepanel.add(two);
				bubblepanel.add(three);
				bubblepanel.add(start);
				bubblepanel.add(btn[5]);
				bubblepanel.add(tempotime);
				bubblepanel.add(temposcoretext);
				bubblepanel.add(bubbleback);
				bubble.add(bubblepanel);
				bubble.setBounds(10, 10, 937, 720);
				bubble.setLayout(null);
				Thread thread = new Thread(bubblepanel);
				thread.start();
				
				bubblepanel.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {
						int i = bubblepanel.gettimes();
						int imgx = bubblepanel.getlocationx();
						int imgy = bubblepanel.getlocationy();
						int mousex = e.getX();
						int mousey = e.getY();
						int distance=PyTheorem(imgx,imgy,mousex,mousey);
						int radius = bubblepanel.getradius();
						if(radius>=150&&distance<=radius) {
							bubbleclick = true;
							if(bubbletimes != i) {
								bubblescore++;
								System.out.println(bubblescore);
								temposcoretext.setText("泡泡顆數："+Integer.toString(bubblescore));
								bubbletimes = i;
							}
						}
					}
					
					public int PyTheorem(int iX,int iY,int mX,int mY) {
						int d = (int) (Math.sqrt(Math.pow((iX-mX),2)+Math.pow((iY-mY),2)));
						return d;
					}
				});
				
				Timer AllTimer = new Timer();
				AllTimer.schedule(new TimerTask() {
					public void run() {
						if(alltime==0) {
							int r = bubblepanel.getradius();
							if(r==30) {
								alltime--;
								timeover.setVisible(true);
								System.out.println(bubblescore+" "+alltime);
							}
						}else if(alltime==-1){
							AllTimer.cancel();
							bubble.setVisible(false);
							frm5.setVisible(true);
							score1.setText(Integer.toString(bubblescore));
						}else {
							alltime--;
							tempotime.setText("遊戲時間："+Integer.toString(alltime));
						}
					}},8500,1000);
				
				frm3.setVisible(false);
				bubble.setVisible(true);
				
				Timer timer1 = new Timer();
				timer1.schedule(new TimerTask() {
					public void run() {
						switch(c) {
							case 0:	three.setVisible(true);		break;
							case 1:	three.setVisible(false);	break;
							case 2:	two.setVisible(true);	break;
							case 3:	two.setVisible(false);	break;
							case 4:	one.setVisible(true);	break;
							case 5:	one.setVisible(false);	break;
							case 6: start.setVisible(true); break;
							case 7: start.setVisible(false); break;
							case 8:
								timer1.cancel();
								break;}
						c++;
						}},1500,1000);

				btn[5].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						System.exit(0);
					}
				});
	
				bubble.setFocusable(true);
				bubble.requestFocus(true);
			}
		});
//遊戲開始(簡單)按鈕事情---------------------------------------------------------------------------------
		
		
//遊戲開始(一般)按鈕事情---------------------------------------------------------------------------------
				normalbtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						try {
							JButton btn = (JButton) e.getSource();
							if(btn == normalbtn)
							{
								clip[17].setFramePosition(0);
								clip[17].loop(0); //0=play once
							}
						}catch (Exception ex) {
							ex.printStackTrace();
							System.out.println("Error loading sound file, it may not exist or another program has a lock on it.");
							System.exit(1);
						}
						
						//遊戲開始(一般)設置
						scoreback.setIcon(Temposcoreback);
						tempo.setBounds(10, 10, 937, 720);
						tempo.setLayout(null);
						for(int i=0;i<4;i++) {
							tempo.add(arrowframe[i]);
							tempo.add(great[i]);}
						tempo.add(three);
						tempo.add(two);
						tempo.add(one);
						tempo.add(start);
						tempo.add(timeover);
						tempo.add(tempoline);
						tempo.add(btn[5]);
						tempo.add(tempotime);
						tempo.add(temposcoretext);
						tempo.add(tempoback);
						arrowframe[0].setBounds(185,10,120,40);
						arrowframe[1].setBounds(325,10,120,40);
						arrowframe[2].setBounds(465,10,120,40);
						arrowframe[3].setBounds(605,10,120,40);
						
						flag70=false;
						flag71=false;
						flag72=false;
						flag73=false;
						int ran[] = new int[4];
						int arrowran[] = new int[4];
						for(int i=0;i<4;i++) {
							ran[i] = (int) (Math.random()*100%3+2);
							arrowran[i] = (int) (Math.random()*100%4);
							arrowflag[i] = arrowran[i];
							arrowframe[i].setIcon(Arrowframe[arrowran[i]]);}

						
						Timer AllTimer = new Timer();
						AllTimer.schedule(new TimerTask() {
							public void run() {
								if(alltime==0) {
									if(p[0].y==10&&p[1].y==10&&p[2].y==10&&p[3].y==10) {
										alltime--;
										timeover.setVisible(true);
										System.out.println(temposcore+" "+alltime);
									}
								}else if(alltime==-1){
									AllTimer.cancel();
									tempo.setVisible(false);
									frm5.setVisible(true);
									score1.setText(Integer.toString(temposcore));
								}else {
									alltime--;
									tempotime.setText("遊戲時間："+Integer.toString(alltime));
								}
							}},10000,1000);
						
						Timer timer00 = new Timer();
						timer00.schedule(new TimerTask() {
							public void run() {
								p[0] = arrowframe[0].getLocation();
								p[0].y += ran[0];
								arrowframe[0].setLocation(p[0]);
								if(p[0].y<=554&&p[0].y>=514) {
									flag70=true;
									if(flag80>0) {
										arrowframe[0].setVisible(false);
										great[0].setVisible(true);}}
								if(p[0].y>=555&&flag80==0){
									arrowframe[0].setIcon(Miss);
									flag70=false;}
								if(p[0].y>=700) {
									arrowframe[0].setVisible(true);
									great[0].setVisible(false);
									if(alltime==0) {
										timer00.cancel();}
									if(flag80>0) {
										temposcore+=20;
									}else if(flag80==0) { temposcore-=10;}
									temposcoretext.setText("遊戲分數："+Integer.toString(temposcore));
									p[0].y=10;
									ran[0] = (int) (Math.random()*100%3+2);
									arrowran[0] = (int) (Math.random()*100%4);
									arrowflag[0] = arrowran[0];
									arrowframe[0].setLocation(p[0]);
									arrowframe[0].setIcon(Arrowframe[arrowran[0]]);
									flag80=0;
									flag70=false;
								}
								}},10000,10);
						Timer timer01 = new Timer();
						timer01.schedule(new TimerTask() {
							public void run() {
								p[1] = arrowframe[1].getLocation();
								p[1].y += ran[1];
								arrowframe[1].setLocation(p[1]);
								if(p[1].y<=554&&p[1].y>=514) {
									flag71=true;
									if(flag81>0) {
										arrowframe[1].setVisible(false);
										great[1].setVisible(true);}}
								if(p[1].y>=555&&flag81==0){
									arrowframe[1].setIcon(Miss);
									flag71=false;}
								if(p[1].y>=700){
									arrowframe[1].setVisible(true);
									great[1].setVisible(false);
									if(alltime==0) {
										timer01.cancel();}
									if(flag81>0) {
										temposcore+=20;
									}else if(flag81==0) { temposcore-=10;}
									temposcoretext.setText("遊戲分數："+Integer.toString(temposcore));
									p[1].y=10;
									ran[1] = (int) (Math.random()*100%3+2);
									arrowran[1] = (int) (Math.random()*100%4);
									arrowflag[1] = arrowran[1];
									arrowframe[1].setLocation(p[1]);
									arrowframe[1].setIcon(Arrowframe[arrowran[1]]);
									flag81=0;
									flag71=false;
								}
							}},10000,10);
						Timer timer02 = new Timer();
						timer02.schedule(new TimerTask() {
							public void run() {
								p[2] = arrowframe[2].getLocation();
								p[2].y += ran[2];
								arrowframe[2].setLocation(p[2]);
								if(p[2].y<=554&&p[2].y>=514) {
									flag72=true;
									if(flag82>0) {
										arrowframe[2].setVisible(false);
										great[2].setVisible(true);}}
								if(p[2].y>=555&&flag82==0){
									arrowframe[2].setIcon(Miss);
									flag72=false;}
								if(p[2].y>=700){
									arrowframe[2].setVisible(true);
									great[2].setVisible(false);
									if(alltime==0) {
										timer02.cancel();}
									if(flag82>0) {
										temposcore+=20;
									}else if(flag82==0) { temposcore-=10;}
									temposcoretext.setText("遊戲分數："+Integer.toString(temposcore));
									p[2].y=10;
									ran[2] = (int) (Math.random()*100%3+2);
									arrowran[2] = (int) (Math.random()*100%4);
									arrowflag[2] = arrowran[2];
									arrowframe[2].setLocation(p[2]);
									arrowframe[2].setIcon(Arrowframe[arrowran[2]]);
									flag82=0;
									flag72=false;
								}
							}},10000,10);
						Timer timer03 = new Timer();
						timer03.schedule(new TimerTask() {
							public void run() {
								p[3] = arrowframe[3].getLocation();
								p[3].y += ran[3];
								arrowframe[3].setLocation(p[3]);
								if(p[3].y<=554&&p[3].y>=514) {
									flag73=true;
									if(flag83>0) {
										arrowframe[3].setVisible(false);
										great[3].setVisible(true);}}
								if(p[3].y>=555&&flag83==0){
									arrowframe[3].setIcon(Miss);
									flag73=false;}
								if(p[3].y>=700){
									arrowframe[3].setVisible(true);
									great[3].setVisible(false);
									if(alltime==0) {
										timer03.cancel();}
									if(flag83>0) {
										temposcore+=20;
									}else if(flag83==0) { temposcore-=10;}
									temposcoretext.setText("遊戲分數："+Integer.toString(temposcore));
									p[3].y=10;
									ran[3] = (int) (Math.random()*100%3+2);
									arrowran[3] = (int) (Math.random()*100%4);
									arrowflag[3] = arrowran[3];
									arrowframe[3].setLocation(p[3]);
									arrowframe[3].setIcon(Arrowframe[arrowran[3]]);
									flag83=0;
									flag73=false;
								}
							}},10000,10);
						
						frm3.setVisible(false);
						tempo.setVisible(true);
						
						Timer timer1 = new Timer();
						timer1.schedule(new TimerTask() {
							public void run() {
								switch(c) {
									case 0:	three.setVisible(true);		break;
									case 1:	three.setVisible(false);	break;
									case 2:	two.setVisible(true);	break;
									case 3:	two.setVisible(false);	break;
									case 4:	one.setVisible(true);	break;
									case 5:	one.setVisible(false);	break;
									case 6: start.setVisible(true); break;
									case 7: start.setVisible(false); break;
									case 8:
										for(int i=0;i<4;i++) {
											arrowframe[i].setVisible(true);}
										temposcoretext.setText("遊戲分數："+Integer.toString(temposcore));
										timer1.cancel();
										break;}
								c++;
								}},1500,1000);
						
						btn[5].addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								System.exit(0);}});
						tempo.setFocusable(true);
						tempo.requestFocus(true);
					}});
//遊戲開始(一般)按鈕事情---------------------------------------------------------------------------------
		
//遊戲開始(困難)按鈕事情---------------------------------------------------------------------------------
				hardbtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						try {
							JButton btn = (JButton) e.getSource();
							
							if(btn == hardbtn)
							{
								clip[19].setFramePosition(0);
								clip[19].loop(0); //0=play once
							}
							
						}catch (Exception ex) {
							ex.printStackTrace();
							System.out.println("Error loading sound file, it may not exist or another program has a lock on it.");
							System.exit(1);
						}
						
						//遊戲開始(困難)設置
						scoreback.setIcon(Scoreback);
						hard.setBounds(10, 10, 937, 720);
						hard.setLayout(null);
						hard.add(timeover);
						for(int i=0;i<11;i++) {
							hard.add(dance[i]);
						}
						hard.add(good);
						hard.add(one);
						hard.add(two);
						hard.add(three);
						hard.add(start);
						for(int i=0 ; i<6 ; i++) {
							hard.add(arrow[i]);
						}
						hard.add(bal);
						hard.add(ban);
						hard.add(ban2);
						hard.add(btn[5]);
						hard.add(normaltimes);
						hard.add(temposcoretext);
						hard.add(gamebkgd);
						
						total=0;
						frm3.setVisible(false);
						hard.setVisible(true);
						
						Timer ttimer = new Timer();
						ttimer.schedule(new TimerTask() {
							public void run() {
								int c=0;
								Timer timer = new Timer();
								timer.schedule(new TimerTask() {
									public void run()
									{
										flag2=0;
										for (int i = 0; i <= 5; i++) {
											ran[i] = (int) ((Math.random() * 100) % 4);
											arrow[i].setIcon(Arrow[ran[i]]);
											arrow[i].setVisible(true);
											flag2+=ran[i];
										}
										
										//最初設定
										flag=0;
										flag3=0;
										bal.setLocation(550, 520);
										bal.setVisible(true);
										
										total++;
										normaltimes.setText("遊戲次數："+Integer.toString(total));
										System.out.println(total);
										
										Timer TImer = new Timer();
										TImer.schedule(new TimerTask() {
											public void run() {
												Point p = bal.getLocation();
												p.x += 1;
												bal.setLocation(p);
												if (p.x == 613)
												{
													TImer.cancel();
													bal.setVisible(false);
												}}
										}, 0, 33);
										
										if(total==10)
										{
											timer.cancel();
											Timer ttimer=new Timer();
											ttimer.schedule(new TimerTask() {
												public void run() {
													int b=0;
													timeover.setVisible(true);
													b++;
													if(b==1)
													{
														ttimer.cancel();
													}
												}
											},4000,100);
											Timer tttimer=new Timer();
											tttimer.schedule(new TimerTask() {
												public void run() {
													int a=0;
													hard.setVisible(false);
													frm5.setVisible(true);
													if(hard.isVisible()==false)
													{
														clip[2].stop();	
													}
													System.out.println(score);
													score1.setText(Integer.toString(score));
													a++;
													if(a==1)
													{
														tttimer.cancel();
													}
												}
												
											},7000,100);
										}
									}
								}, 2000, 6000);
								
								
								
								Timer Timer = new Timer();
								Timer.schedule(new TimerTask() {
									public void run() {
										for(int i=0 ; i<6 ;i++) {
											arrow[i].setVisible(false);
										}

										flag6=0;
										
										if(flag3==flag2)
										{
											flag5=0;
											flag6++;
											score+=10;
											temposcoretext.setText("遊戲分數："+Integer.toString(score));
											Timer Timer1=new Timer();
											Timer1.schedule(new TimerTask() {
												public void run() {
													int a=0;
													good.setVisible(true);
													System.out.println(flag3+" "+flag2);
													a++;
													if(a==1)
													{
														Timer1.cancel();
													}
												}
											},200,1000);
											
											Timer Timer2=new Timer();
											Timer2.schedule(new TimerTask() {
												public void run() {
													int a=0;
													good.setVisible(false);
													a++;
													if(a==1)
													{
														Timer2.cancel();
													}
												}
											},1500,1000);
											
											Timer Timer3=new Timer();
											Timer3.schedule(new TimerTask() {
												public void run() {
													if(flag5==0)
													{
														for(int i=0;i<11;i++) {
															dance[i].setVisible(false);
														}
													}
													flag5++;
													if(flag5==1) { dance[1].setVisible(true); dance[0].setVisible(false);}
													if(flag5==2) { dance[2].setVisible(true); dance[1].setVisible(false);}
													if(flag5==3) { dance[3].setVisible(true); dance[2].setVisible(false);}
													if(flag5==4) { dance[4].setVisible(true); dance[3].setVisible(false);}
													if(flag5==5) { dance[5].setVisible(true); dance[4].setVisible(false);}
													if(flag5==6) { dance[6].setVisible(true); dance[5].setVisible(false);}
													if(flag5==7) { dance[7].setVisible(true); dance[6].setVisible(false);}
													if(flag5==8) { dance[8].setVisible(true); dance[7].setVisible(false);}
													if(flag5==9) { dance[9].setVisible(true); dance[8].setVisible(false);}
													if(flag5==10) { dance[10].setVisible(true); dance[9].setVisible(false);}
													if(flag5==11) { dance[0].setVisible(true); dance[10].setVisible(false); flag5=0;}
													if(flag6!=1) { Timer3.cancel(); }
												}
											},0,1000);
										
										if(total==10)
										{
											Timer.cancel();
										}
									}}
								}, 4200, 6000);
								
								c++;
								if (c == 1) {
									ttimer.cancel();
								}
							}
						}, 7000, 100);
						
						Timer timer1 = new Timer();
						timer1.schedule(new TimerTask() {
							public void run() {
								switch(c) {
									case 0:	three.setVisible(true);		break;
									case 1:	three.setVisible(false);	break;
									case 2:	two.setVisible(true);	break;
									case 3:	two.setVisible(false);	break;
									case 4:	one.setVisible(true);	break;
									case 5:	one.setVisible(false);	break;
									case 6: start.setVisible(true); break;
									case 7: start.setVisible(false); break;
									case 8:
										for(int i=0;i<4;i++) {
											arrowframe[i].setVisible(true);}
										timer1.cancel();
										break;}
								c++;
								}},1500,1000);

						btn[5].addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								System.exit(0);
							}
						});
						hard.setFocusable(true);
						hard.requestFocus(true);
					}
				});
//遊戲開始(困難)按鈕事情---------------------------------------------------------------------------------
				
//遊戲開始(地獄)按鈕事情---------------------------------------------------------------------------------
				hellbtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						try {
							JButton btn = (JButton) e.getSource();
							
							if(btn == hellbtn)
							{
								clip[20].setFramePosition(0);
								clip[20].loop(0); //0=play once
							}
						}catch (Exception ex) {
							ex.printStackTrace();
							System.out.println("Error loading sound file, it may not exist or another program has a lock on it.");
							System.exit(1);
						}
						
						//遊戲開始(地獄)設置
						scoreback.setIcon(Scoreback);
						hell.setBounds(10, 10, 937, 720);
						hell.setLayout(null);
						hell.add(timeover);
						for(int i=0;i<11;i++) {
							hell.add(dance[i]);
						}
						hell.add(good);
						hell.add(one);
						hell.add(two);
						hell.add(three);
						hell.add(start);
						hell.add(bal);
						for(int i=0;i<6;i++) {
							hell.add(arrow[i]);
						}
						hell.add(ban);
						hell.add(ban2);
						hell.add(btn[5]);
						hell.add(normaltimes);
						hell.add(temposcoretext);
						hell.add(gamebkgd);
						
						total=0;
						frm3.setVisible(false);
						hell.setVisible(true);
						
						Timer ttimer = new Timer();
						ttimer.schedule(new TimerTask() {
							public void run() {
								int c=0;
								Timer timer = new Timer();
								timer.schedule(new TimerTask() {
									public void run()
									{
										flag2=0;
										for (int i = 0; i <= 5; i++) {
											ran[i] = (int) ((Math.random() * 100) % 4);
											arrow[i].setIcon(Arrow[ran[i]]);
											arrow[i].setVisible(true);
											flag2+=ran[i];
										}
										
										//最初設定
										flag=0;
										flag3=0;
										bal.setLocation(550, 520);
										bal.setVisible(true);
										
										total++;
										normaltimes.setText("遊戲次數："+Integer.toString(total));
										System.out.println(total);
										
										Timer TImer = new Timer();
										TImer.schedule(new TimerTask() {
											public void run() {
												Point p = bal.getLocation();
												p.x += 1;
												bal.setLocation(p);
												if (p.x == 613)
												{
													TImer.cancel();
													bal.setVisible(false);
												}}
										}, 0, 15);
										
										if(total==10)
										{
											timer.cancel();
											Timer ttimer=new Timer();
											ttimer.schedule(new TimerTask() {
												public void run() {
													int b=0;
													timeover.setVisible(true);
													b++;
													if(b==1)
													{
														ttimer.cancel();
													}
												}
											},2000,100);
											Timer tttimer=new Timer();
											tttimer.schedule(new TimerTask() {
												public void run() {
													int a=0;
													hell.setVisible(false);
													frm5.setVisible(true);
													if(hell.isVisible()==false)
													{
														clip[3].stop();
													}
													System.out.println(score);
													score1.setText(Integer.toString(score));
													a++;
													if(a==1)
													{
														tttimer.cancel();
													}
												}
												
											},5000,100);
										}
									}
								}, 2000, 4000);
								
								
								
								Timer Timer = new Timer();
								Timer.schedule(new TimerTask() {
									public void run() {
										for(int i=0 ; i<6 ;i++) {
											arrow[i].setVisible(false);
										}

										flag6=0;
										
										if(flag3==flag2)
										{
											flag5=0;
											flag6++;
											score+=10;
											temposcoretext.setText("遊戲分數："+Integer.toString(score));
											Timer Timer1=new Timer();
											Timer1.schedule(new TimerTask() {
												public void run() {
													int a=0;
													good.setVisible(true);
													System.out.println(flag3+" "+flag2);
													a++;
													if(a==1)
													{
														Timer1.cancel();
													}
												}
											},200,1000);
											
											Timer Timer2=new Timer();
											Timer2.schedule(new TimerTask() {
												public void run() {
													int a=0;
													good.setVisible(false);
													a++;
													if(a==1)
													{
														Timer2.cancel();
													}
												}
											},1500,1000);
											
											Timer Timer3=new Timer();
											Timer3.schedule(new TimerTask() {
												public void run() {
													if(flag5==0)
													{
														for(int i=0;i<11;i++) {
															dance[i].setVisible(false);
														}
													}
													flag5++;
													if(flag5==1) { dance[1].setVisible(true); dance[0].setVisible(false);}
													if(flag5==2) { dance[2].setVisible(true); dance[1].setVisible(false);}
													if(flag5==3) { dance[3].setVisible(true); dance[2].setVisible(false);}
													if(flag5==4) { dance[4].setVisible(true); dance[3].setVisible(false);}
													if(flag5==5) { dance[5].setVisible(true); dance[4].setVisible(false);}
													if(flag5==6) { dance[6].setVisible(true); dance[5].setVisible(false);}
													if(flag5==7) { dance[7].setVisible(true); dance[6].setVisible(false);}
													if(flag5==8) { dance[8].setVisible(true); dance[7].setVisible(false);}
													if(flag5==9) { dance[9].setVisible(true); dance[8].setVisible(false);}
													if(flag5==10) { dance[10].setVisible(true); dance[9].setVisible(false);}
													if(flag5==11) { dance[0].setVisible(true); dance[10].setVisible(false); flag5=0;}
													if(flag6!=1) { Timer3.cancel(); }
												}
											},0,1000);
										
										if(total==10)
										{
											Timer.cancel();
										}
									}}
								}, 3000, 4000);
								
								c++;
								if (c == 1) {
									ttimer.cancel();
								}
							}
						}, 7000, 100);
						
						Timer timer1 = new Timer();
						timer1.schedule(new TimerTask() {
							public void run() {
								switch(c) {
									case 0:	three.setVisible(true);		break;
									case 1:	three.setVisible(false);	break;
									case 2:	two.setVisible(true);	break;
									case 3:	two.setVisible(false);	break;
									case 4:	one.setVisible(true);	break;
									case 5:	one.setVisible(false);	break;
									case 6: start.setVisible(true); break;
									case 7: start.setVisible(false); break;
									case 8:
										for(int i=0;i<4;i++) {
											arrowframe[i].setVisible(true);}
										timer1.cancel();
										break;}
								c++;
								}},1500,1000);

						btn[5].addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								System.exit(0);}});
						hell.setFocusable(true);
						hell.requestFocus(true);
					}});
//遊戲開始(地獄)按鈕事情---------------------------------------------------------------------------------
		
		//遊戲主畫面切換至遊戲關卡選擇畫面
		btn[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frm3.setVisible(true);
				frm.setVisible(false);
				clip[music].stop();
				
				btn[8].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						frm3.setVisible(false);
						frm.setVisible(true);
						clip[music].start();}});}});
				
		// 遊戲說明按鈕事件
		btn[2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frm.setVisible(false);
				frm2.setVisible(true);

				btn[6].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						frm2.setVisible(false);
						frm.setVisible(true);}});}});
		
		// 關於製作群按鈕事件
		btn[4].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frm.setVisible(false);
				frm4.setVisible(true);

				btn[7].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						frm4.setVisible(false);
						frm.setVisible(true);}});}});

		// 遊戲結束按鈕事件
		btn[3].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);}});
		
		btn[9].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);}});

		// 關閉視窗
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		bubble.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tempo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		hard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		hell.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	}}