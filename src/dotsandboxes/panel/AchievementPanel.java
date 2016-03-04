package dotsandboxes.panel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import dotsandboxes.constants.Constant;
import dotsandboxes.main.Start;
import dotsandboxes.option.Load;
import dotsandboxes.sound.MP3Player;
import dotsandboxes.ui.SpcPan;

public class AchievementPanel extends SpcPan implements ActionListener{
	private static String theme;
	private JButton goBack;
    private JLabel scoreLabel;
    private JLabel scoreCountingLabel;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public AchievementPanel(){
		theme=Load.getTheme();
		
		ImageIcon background=new ImageIcon("images/"+theme+"/achievementBG.png");
        JLabel wholeBG=new JLabel(background);
        wholeBG.setBounds(0, 0, 800, 720);
        this.add(wholeBG);
        
        scoreLabel=new JLabel(new ImageIcon("images/"+theme+"/scoreLabel.png"));
        scoreLabel.setBounds(200,20,300,80);
        wholeBG.add(scoreLabel);
        
        JLabel[] lab=new JLabel[7];
        JLabel[] score=new JLabel[7];
        
        HashMap<Integer,String> hash=new HashMap<Integer,String>(7);
        hash.put(1999,"master.png");
        hash.put(999,"expert.png");
        hash.put(499,"professional.png");
        hash.put(199,"advanced.png");
        hash.put(99,"intermediate.png");
        hash.put(9,"beginner.png");
        hash.put(Load.getScore(),"you.png");
        
        Iterator<Integer> it;
        for(int i=0;i<7;i++){
        	it=hash.keySet().iterator();
        	int max=-10000;
        	int num;
        	while(it.hasNext()){
        		if((num=it.next().intValue())>max)
        			max=num;
        	}
        	lab[i]=new JLabel(new ImageIcon("images/"+theme+"/"+hash.get(max)));
        	lab[i].setBounds(120,195+56*i,300,50);
        	wholeBG.add(lab[i]);
        	
        	score[i]=new JLabel();
        	score[i].setBounds(450,195+56*i,300,50);
        	score[i].setText(String.valueOf(max));
    		score[i].setForeground(Color.BLACK);
    		score[i].setHorizontalAlignment(SwingConstants.CENTER);
    		score[i].setFont(new Font("Î¢ÈíÑÅºÚ",Font.BOLD,Constant.FONTBIG));
        	wholeBG.add(score[i]);
        	hash.remove(max);
        }
        scoreCountingLabel=new JLabel(new ImageIcon("images/"+theme+"/scoreBoard.png"));
        scoreCountingLabel.setBounds(100,120,600,500);
        wholeBG.add(scoreCountingLabel);
        
       goBack=new JButton(new ImageIcon("images/"+theme+"/return.png"));
       goBack.setBounds(600,640,180,60);
       goBack.setContentAreaFilled(false);
       goBack.setFocusPainted(false);
       goBack.setBorderPainted(false);
       goBack.addActionListener(this);
       wholeBG.add(goBack);
       
       //
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		MP3Player m=new MP3Player("sound/enter.mp3");
		m.play();
		Start.dotsandboxes.showMenu();
	}
}
