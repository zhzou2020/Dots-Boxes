package dotsandboxes.panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import dotsandboxes.main.Start;
import dotsandboxes.option.Load;
import dotsandboxes.sound.MP3Player;
import dotsandboxes.ui.GameDialog;
import dotsandboxes.ui.ScreenShot;
import dotsandboxes.ui.SpcPan;
import dotsandboxes.ui.TimeLabel;
//@author zzj 
//@2014.4.4
public class DoubleGamePanel extends SpcPan{
	/**
	 * 
	 */
	 
	private static final long serialVersionUID = 1L;
	public JButton startgame;
	public JButton back;
	public JButton cam;
	public TimeLabel tl;
	public JLabel timeLabel;
	
	private int i=0,j=0,a=0,b=0,x=0,y=0;
	public int p=1;
	//p就是player，p%2=1时即p1，p%2=0时为p2
	private String theme=Load.getTheme();
	protected JButton[][] button1;
	protected int[][] line1;
	//横行
	protected JButton[][] button2;
	protected int[][] line2;
	//竖行
	protected JButton[][] Box;
	protected int[][] box;
	protected int[] score;//用于计分,p1的score置于score【1】中，p2的score置于score【0】中
	
	protected boolean isadd=false;
	protected boolean hasMusic=Load.getHasMusic();
	public static boolean isstart=false;
	protected boolean isend=false;
	protected Thread t;
	
	ImageIcon player1linehen=new ImageIcon("images/"+theme+"/player1linehen.png");
	ImageIcon player2linehen=new ImageIcon("images/"+theme+"/player2linehen.png");
	ImageIcon player1lineshu=new ImageIcon("images/"+theme+"/player1lineshu.png");
	ImageIcon player2lineshu=new ImageIcon("images/"+theme+"/player2lineshu.png");
	ImageIcon player1box=new ImageIcon("images/"+theme+"/player1box.png");
	ImageIcon player2box=new ImageIcon("images/"+theme+"/player2box.png");
	
	public static MP3Player m;
	DoubleGamePanel(){
		isstart=false;
		
		button1=new JButton[5][6];
		line1=new int[5][6];
		//横行
		button2=new JButton[6][5];
		line2=new int[6][5];
		//竖行
		Box=new JButton[5][5];
		box=new int[5][5];
		score=new int[2];
		score[0]=0;
		score[1]=0;
		
	for(x=0;x<5;x++)
		for(y=0;y<5;y++){
			Box[x][y]=new JButton();
			Box[x][y].setEnabled(false);
			Box[x][y].setContentAreaFilled(false);
			Box[x][y].setBorderPainted(false);
			Box[x][y].setFocusPainted(false);
			box[x][y]=0;
			this.add(Box[x][y]);
		}
	  for(i=0;i<5;i++)
			for(j=0;j<6;j++){
				button1[i][j]=new JButton(new ImageIcon("images/"+theme+"/linehen.png"));			
				this.add(button1[i][j]);
			}
	    for(a=0;a<6;a++)
			for(b=0;b<5;b++){
				button2[a][b]=new JButton(new ImageIcon("images/"+theme+"/lineshu.png"));
				this.add(button2[a][b]);
				}
	    startgame=new JButton(new ImageIcon("images/"+theme+"/start.png"));
	    startgame.addActionListener(new StartActionListener());
	    
	    back=new JButton(new ImageIcon("images/"+theme+"/return.png"));
	    back.addActionListener(new BackActionListener());
	    
	    cam=new JButton(new ImageIcon("images/"+theme+"/camera.png"));
	    cam.addActionListener(new CameraActionListener());
	    
	    tl=new TimeLabel();
	    timeLabel=tl.label();
	    m=new MP3Player("sound/move.mp3");
	}
	class ButtonActionListener implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e){
		// TODO Auto-generated method stub
		tl.restart();
		m.play();
		int k=1;
		boolean isbutton1=false;//判断是否是button1触发的事件
		boolean n=false;//如果产生了一个格子，设为true
label1:	for(i=0;i<5;i++)
			for(j=0;j<6;j++){
				if(e.getSource()==button1[i][j]){	
					if(line1[i][j]==-1)
						break label1;
					button1[i][j].setEnabled(false);
					line1[i][j]=-1;
					if(p%2==1)
						button1[i][j].setDisabledIcon(player1linehen);
					else
						button1[i][j].setDisabledIcon(player2linehen);
					if(j<=4){
					box[i][j]++;
					if(box[i][j]==4){
						//插图
						if(p%2==1){
							Box[i][j].setDisabledIcon(player1box);
							Box[i][j].setIcon(player1box);
							score[1]++;
							scoreChange(1);
						}
						else{
							Box[i][j].setDisabledIcon(player2box);
							Box[i][j].setIcon(player2box);
							score[0]++;
							scoreChange(2);
						}
						box[i][j]++;
						n=true;
					}
					}
					if(j>=1){
						box[i][j-1]++;
						if(box[i][j-1]==4){
							//插图
							if(p%2==1){
								Box[i][j-1].setDisabledIcon(player1box);
								Box[i][j-1].setIcon(player1box);
								score[1]++;
								scoreChange(1);
							}
							else{
								Box[i][j-1].setDisabledIcon(player2box);
								Box[i][j-1].setIcon(player2box);
								score[0]++;
								scoreChange(2);
							}
							box[i][j-1]++;
							n=true;
						}
					}
					isbutton1=true;
					break label1;
				}
			}
label2:		if(!isbutton1){
				for(a=0;a<6;a++)
					for(b=0;b<5;b++){
						if(e.getSource()==button2[a][b]){
							if(line2[a][b]==-1)
								break label2;
							line2[a][b]=-1;
							button2[a][b].setEnabled(false);
							if(p%2==1)
								button2[a][b].setDisabledIcon(player1lineshu);
							else
								button2[a][b].setDisabledIcon(player2lineshu);
							if(a<=4){
							box[a][b]++;
							if(box[a][b]==4){
								//插图
								if(p%2==1){
									Box[a][b].setDisabledIcon(player1box);
									Box[a][b].setIcon(player1box);
									score[1]++;
									scoreChange(1);
								}
								else{
									Box[a][b].setDisabledIcon(player2box);
									Box[a][b].setIcon(player2box);
									score[0]++;
									scoreChange(2);
								}
								box[a][b]++;
								n=true;
							}
							}
							if(a>=1){
								box[a-1][b]++;
								if(box[a-1][b]==4){
									//插图
									if(p%2==1){
										Box[a-1][b].setDisabledIcon(player1box);
										Box[a-1][b].setIcon(player1box);
										score[1]++;
										scoreChange(1);
									}
									else{
										Box[a-1][b].setDisabledIcon(player2box);
										Box[a-1][b].setIcon(player2box);
										score[0]++;
										scoreChange(2);
									}
									box[a-1][b]++;
									n=true;
								}
							}
							break label2;
							}
						}
			}
		isbutton1=false;
label3:	for(x=0;x<5;x++)
			for(y=0;y<5;y++)
				if(box[x][y]!=5){
					k=0;
					break label3;
				}
		if(k==1){
			isend=true;
			isstart=false;
			if(score[0]>score[1]){
				t=new animationThread(2);
				t.start();
				GameDialog.oneButtonDialog("End of Game","Player2 wins!");//player2wins!
				int a=GameDialog.twoButtonDialog("提示", "再来一局？", "yes.png", "no.png");
				if(a==2){
					Start.dotsandboxes.newDoublePanel();
					Start.dotsandboxes.showMenu();
				}
				else if(a==1){
					Start.dotsandboxes.newDoublePanel();
					Start.dotsandboxes.showDouble();
				}
			}
			else{
				t=new animationThread(1);
				t.start();
				GameDialog.oneButtonDialog("End of Game","Player1 wins!");//player1wins!
				int a=GameDialog.twoButtonDialog("提示", "再来一局？", "yes.png", "no.png");
				if(a==2){
					Start.dotsandboxes.newDoublePanel();
					Start.dotsandboxes.showMenu();
				}
				else if(a==1){
					Start.dotsandboxes.newDoublePanel();
					Start.dotsandboxes.showDouble();
				}
			}
		}
		//此处可设置一个提示，提示哪一方现在应该划线
		if(n)
			n=false;
		else{
			p++;
		}
	}
	}
	class StartActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			MP3Player m=new MP3Player("sound/enter.mp3");
			m.play();
			if(!isstart)
			{
			if(!isadd){
				isadd=true;
				isstart=true;
				 for(i=0;i<5;i++)
						for(j=0;j<6;j++){
							button1[i][j].addActionListener(new ButtonActionListener());	    
						}
				    for(a=0;a<6;a++)
						for(b=0;b<5;b++){
							button2[a][b].addActionListener(new ButtonActionListener());
							}
				    GameDialog.oneButtonDialog("提示", "游戏开始！");
				tl.start();
			}
			}
			else
				GameDialog.oneButtonDialog("Error", "游戏已经开始了。。。");
		}
		
	}
	class BackActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			MP3Player m=new MP3Player("sound/enter.mp3");
			m.play();
			int k=0;
			if(isstart){
				k=GameDialog.twoButtonDialog("提示", "你想要中途退出吗？", "yes.png","no.png");
				if(k==1){
					Start.dotsandboxes.newDoublePanel();
					Start.dotsandboxes.showMenu();
					isstart=false;
				}
			}
			else
				Start.dotsandboxes.showMenu();
		}
		
		
	}
	class CameraActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			MP3Player m=new MP3Player("sound/choose.mp3");
			m.play();
			ScreenShot cam= new ScreenShot(Load.getAdd()+"/gameShot", "png");//
			cam.snapShot();
			GameDialog.oneButtonDialog("提示", "已截屏~");
		}
		
	}
	class animationThread extends Thread{
		int i;
		public animationThread(int i){
			this.i=i;
		}
		public void run(){
			animation(i);
		}
	}
	private void animation(int i){
		int k=0;
		ImageIcon ima=new ImageIcon("images/"+theme+"/player"+i+"box.png");
		while(k!=2){
			for(int a=k;a<5;a++){
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Box[a][k].setDisabledIcon(ima);
				Box[a][k].setIcon(ima);
				this.revalidate();
			}
			for(int a=k;a<5;a++){
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Box[4-k][a].setDisabledIcon(ima);
				Box[4-k][a].setIcon(ima);
				this.revalidate();
			}
			for(int a=4-k;a>=0;a--){
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Box[a][4-k].setDisabledIcon(ima);
				Box[a][4-k].setIcon(ima);
				this.revalidate();
			}
			for(int a=4-k;a>=0;a--){
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Box[k][a].setDisabledIcon(ima);
				Box[k][a].setIcon(ima);
				this.revalidate();
			}
			k++;
		}
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Box[2][2].setDisabledIcon(ima);
		Box[2][2].setIcon(ima);
		this.revalidate();
	}
	protected void scoreChange(int i){
		
	}
}



