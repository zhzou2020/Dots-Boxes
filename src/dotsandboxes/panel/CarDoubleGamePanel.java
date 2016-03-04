package dotsandboxes.panel;
import java.awt.Color;

import javax.swing.*;

public class CarDoubleGamePanel extends DoubleGamePanel {
     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static int i,j,p,q,a,b,x,y;
	private  JButton[] scoreplayer1=new JButton[13];
	private  JButton[] scoreplayer2=new JButton[13];
	public CarDoubleGamePanel(){	
        ImageIcon background;
	    background = new ImageIcon("images/car/gameBackground.jpg");// 背景图片
	    JLabel wholeBG = new JLabel(background);// 把背景图片显示在一个标签里面
	  // 把标签的大小位置设置为图片刚好填充整个面板	    
	    wholeBG.setBounds(0, 0, 800,720); 
	    this.add(wholeBG);	    
	  //设置总背景
	    
	    ImageIcon player1score=new ImageIcon("images/car/player1score.jpg");//玩家1的得分列表
	    JLabel player1picture=new JLabel(player1score);
	    wholeBG.setLayout(null);
	    player1picture.setBounds(100, 50, player1score.getIconWidth()+10, player1score.getIconHeight());
	    player1picture.setLayout(null);
	    wholeBG.add(player1picture);//标签里放置图片，添加按钮
	    //	 
	    ImageIcon player2score=new ImageIcon("images/car/player2score.jpg");//玩家2的得分列表
	    JLabel player2picture=new JLabel(player1score);  
	    player2picture.setBounds(500, 50, player2score.getIconWidth()+10, player2score.getIconHeight());
	    player2picture.setLayout(null);
	    wholeBG.add(player2picture);//标签内放置图片，添加按钮
	    //
	    
	    startgame.setBounds(340, 20, 125, 65);
	    startgame.setContentAreaFilled(false);
	    startgame.setBorderPainted(false);
	    startgame.setFocusPainted(false);	    
	    wholeBG.add(startgame);
	    //
	    JLabel name1 =new JLabel(new ImageIcon("images/car/player1.png"));
	    name1.setBounds(135,1,105,55);	    	    	
	    wholeBG.add(name1);
	    //
	    JLabel name2 =new JLabel(new ImageIcon("images/car/player2.png"));
	    name2.setBounds(550,1,105,55);	    
	    wholeBG.add(name2);
	    
	    //
	  
	    back.setBounds(620, 600, 180, 70);
	    back.setContentAreaFilled(false);
	    back.setBorderPainted(false);
	    back.setFocusPainted(false);
	    wholeBG.add(back);
	    //	  
	    scoreplayer1[0]=new JButton();
    	scoreplayer1[0].setBounds(3, 5+(0-6)*(0-6)*2, 10, 20);
    	scoreplayer1[0].setOpaque(true);
    	scoreplayer1[0].setVisible(true);  
    	scoreplayer1[0].setEnabled(true);
    	scoreplayer1[0].setDisabledIcon(new ImageIcon("images/car/lightbefore.png"));
    	scoreplayer1[0].setIcon(new ImageIcon("images/car/lightbefore.png"));
    	player1picture.add(scoreplayer1[0]);
    	
	    for(i=1;i<=11;i++){
	    	scoreplayer1[i]=new JButton();
	    	scoreplayer1[i].setBounds(i*15, 5+(i-6)*(i-6)*2, 10, 20);
	    	scoreplayer1[i].setOpaque(true);
	    	scoreplayer1[i].setVisible(true);  
	    	scoreplayer1[i].setEnabled(true);
	    	scoreplayer1[i].setDisabledIcon(new ImageIcon("images/car/lightbefore.png"));
	    	scoreplayer1[i].setIcon(new ImageIcon("images/car/lightbefore.png"));
	    	player1picture.add(scoreplayer1[i]);
	    }
	    scoreplayer1[12]=new JButton();
    	scoreplayer1[12].setBounds(12*15-3, 5+(12-6)*(12-6)*2, 10, 20);
    	scoreplayer1[12].setOpaque(true);
    	scoreplayer1[12].setVisible(true);  
    	scoreplayer1[12].setEnabled(true);
    	scoreplayer1[12].setDisabledIcon(new ImageIcon("images/car/lightbefore.png"));
    	scoreplayer1[12].setIcon(new ImageIcon("images/car/lightbefore.png"));
    	player1picture.add(scoreplayer1[12]);
	    //
    	scoreplayer2[0]=new JButton();
    	scoreplayer2[0].setBounds(3, 10+(0-6)*(0-6)*2, 10, 20);
    	scoreplayer2[0].setOpaque(true);
    	scoreplayer2[0].setVisible(true); 
    	scoreplayer2[0].setEnabled(true);
    	scoreplayer2[0].setDisabledIcon(new ImageIcon("images/car/lightbefore.png"));
    	scoreplayer2[0].setIcon(new ImageIcon("images/car/lightbefore.png"));
    	player2picture.add(scoreplayer2[0]);
	    for(j=1;j<12;j++){
	    	scoreplayer2[j]=new JButton();
	    	scoreplayer2[j].setBounds(j*15, 10+(j-6)*(j-6)*2, 10, 20);
	    	scoreplayer2[j].setOpaque(true);
	    	scoreplayer2[j].setVisible(true); 
	    	scoreplayer2[j].setEnabled(true);
	    	scoreplayer2[j].setDisabledIcon(new ImageIcon("images/car/lightbefore.png"));
	    	scoreplayer2[j].setIcon(new ImageIcon("images/car/lightbefore.png"));
	    	player2picture.add(scoreplayer2[j]);
	    }
	    scoreplayer2[12]=new JButton();
    	scoreplayer2[12].setBounds(12*15-3, 10+(0-6)*(0-6)*2, 10, 20);
    	scoreplayer2[12].setOpaque(true);
    	scoreplayer2[12].setVisible(true); 
    	scoreplayer2[12].setEnabled(true);
    	scoreplayer2[12].setDisabledIcon(new ImageIcon("images/car/lightbefore.png"));
    	scoreplayer2[12].setIcon(new ImageIcon("images/car/lightbefore.png"));
    	player2picture.add(scoreplayer2[j]);
	 
    	cam.setBounds(20,230,100,82);
	    cam.setContentAreaFilled(false);
	    cam.setBorderPainted(false);
	    wholeBG.add(cam);
    	
	    for(p=0;p<5;p++)
			for(q=0;q<6;q++){
				button1[p][q].setBounds(160+90*p, 210+90*q, 70, 15);
				wholeBG.add(button1[p][q]);
				
			}
	    for(a=0;a<6;a++)
			for(b=0;b<5;b++){
				button2[a][b].setBounds(143+90*a, 230+90*b, 15, 70);				
				wholeBG.add(button2[a][b]);
				}
	    
	    for(x=0;x<5;x++)
			for(y=0;y<5;y++){				
				Box[x][y].setBounds(163+90*x,230+90*y,65,65);
			}	   
	    tl.setColor(Color.WHITE);
	    timeLabel.setBounds(20,360,80,40);
	    wholeBG.add(timeLabel);
	 }	
	protected void scoreChange(int i){
		if(i==1){
			scoreplayer1[score[1]-1].setDisabledIcon(new ImageIcon("images/car/lightafter.png"));
			scoreplayer1[score[1]-1].setIcon(new ImageIcon("images/car/lightafter.png"));
		}
		else if(i==2){
			scoreplayer2[score[0]-1].setDisabledIcon(new ImageIcon("images/car/lightafter.png"));
			scoreplayer2[score[0]-1].setIcon(new ImageIcon("images/car/lightafter.png"));
		}
	
	}
 
}
	
	
	 


	

	
