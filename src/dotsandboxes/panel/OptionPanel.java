package dotsandboxes.panel;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import dotsandboxes.main.DotsAndBoxes;
import dotsandboxes.main.Start;
import dotsandboxes.option.Load;
import dotsandboxes.option.Save;
import dotsandboxes.sound.MP3Player;
import dotsandboxes.ui.GameDialog;
import dotsandboxes.ui.SpcPan;



public class OptionPanel extends SpcPan{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected JLabel Theme;
	protected JButton Theme1;
	protected JButton Theme2;
	protected JLabel jlbMusic;
	protected JButton jlbMusic1;
	protected JButton jlbMusic2;
	protected JTextField t;
	protected JButton enter;
	protected JLabel gameBgLabel;
	protected JButton jbtGoBack;
	protected JButton jbtSave;
	protected String[] tempSave;
	protected String[] newSave;
	protected String theme=Load.getTheme();
	protected String Music=Load.getHasMusicStr();
	
	
		
	public OptionPanel(){
		ImageIcon gameBg = new ImageIcon("images/"+theme+"/optionBG.png");
		gameBgLabel = new JLabel(gameBg); 
		gameBgLabel.setBounds(0,0,gameBg.getIconWidth(),gameBg.getIconHeight());
		this.add(gameBgLabel);
			
		ImageIcon themeIcon = new ImageIcon("images/"+theme+"/optionTheme.png");
		Theme = new JLabel(themeIcon);
		Theme.setBounds(20,20,themeIcon.getIconWidth(),themeIcon.getIconHeight());
		gameBgLabel.add(Theme);
		
		ImageIcon theme1Icon = new ImageIcon("images/"+theme+"/theme1.png");
		Theme1 = new JButton(theme1Icon);
		Theme1.setBounds(50,100,theme1Icon.getIconWidth(),theme1Icon.getIconHeight());
		Theme1.setContentAreaFilled(false);
		Theme1.setBorderPainted(false);
		Theme1.setFocusPainted(false);
		Theme1.addMouseListener(new ThemeListener());
		gameBgLabel.add(Theme1);
		
		ImageIcon theme2Icon = new ImageIcon("images/"+theme+"/theme2.png");
		Theme2 = new JButton(theme2Icon);
		Theme2.setBounds(300,100,theme2Icon.getIconWidth(),theme2Icon.getIconHeight());
		Theme2.setContentAreaFilled(false);
		Theme2.setBorderPainted(false);
		Theme2.setFocusPainted(false);
		Theme2.addMouseListener(new ThemeListener());
		gameBgLabel.add(Theme2);
		
		ImageIcon musicIcon = new ImageIcon("images/"+theme+"/optionMusic.png");
		jlbMusic = new JLabel(musicIcon);
		jlbMusic.setBounds(20,230,musicIcon.getIconWidth(),musicIcon.getIconHeight());
		gameBgLabel.add(jlbMusic);
		
		ImageIcon music1Icon = new ImageIcon("images/"+theme+"/on.png");
		jlbMusic1 = new JButton(music1Icon);
		jlbMusic1.setBounds(50,330,music1Icon.getIconWidth(),music1Icon.getIconHeight());
		jlbMusic1.setContentAreaFilled(false);
		jlbMusic1.setBorderPainted(false);
		jlbMusic1.setFocusPainted(false);
		jlbMusic1.addMouseListener(new MusicListener());
		gameBgLabel.add(jlbMusic1);
		
		ImageIcon music2Icon = new ImageIcon("images/"+theme+"/off.png");
		jlbMusic2 = new JButton(music2Icon);
		jlbMusic2.setBounds(300,330,music2Icon.getIconWidth(),music2Icon.getIconHeight());
		jlbMusic2.setContentAreaFilled(false);
		jlbMusic2.setBorderPainted(false);
		jlbMusic2.setFocusPainted(false);
		jlbMusic2.addMouseListener(new MusicListener());
		gameBgLabel.add(jlbMusic2);
		
		ImageIcon addIcon=new ImageIcon("images/"+theme+"/optionAdd.png");
		JLabel jlbAdd=new JLabel(addIcon);
		jlbAdd.setBounds(20,435,addIcon.getIconWidth(),addIcon.getIconHeight());
		gameBgLabel.add(jlbAdd);
		
		t=new JTextField(Load.getAdd());
		t.setBounds(20,540,540,40);
		t.setFont(new Font("微软雅黑",Font.BOLD,30));
		t.addKeyListener(new KeyListener() {
			public void keyPressed(KeyEvent e) {// 捕获按键被按下的事件
				tempSave[8]=t.getText();
			}
			public void keyTyped(KeyEvent e) {
			}
			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		gameBgLabel.add(t);
		
		ImageIcon goBackIcon = new ImageIcon("images/"+theme+"/return.png");
		jbtGoBack = new JButton(goBackIcon);
		jbtGoBack.setBounds(600,620,goBackIcon.getIconWidth(),goBackIcon.getIconHeight());
		jbtGoBack.setOpaque(false);
		jbtGoBack.setContentAreaFilled(false);
		jbtGoBack.setFocusPainted(false);
		jbtGoBack.setBorderPainted(false);
		jbtGoBack.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Start.dotsandboxes.showMenu();
			}
			
		});
		gameBgLabel.add(jbtGoBack);
		
		ImageIcon saveIcon = new ImageIcon("images/"+theme+"/save.png");
		jbtSave = new JButton (saveIcon);
		jbtSave.setBounds(50,620,saveIcon.getIconWidth(),saveIcon.getIconHeight());
		jbtSave.setOpaque(false);
		jbtSave.setContentAreaFilled(false);
		jbtSave.setFocusPainted(false);
		jbtSave.setBorderPainted(false);
		gameBgLabel.add(jbtSave);
		
		tempSave=new String[9];
		tempSave[0]=Load.getTheme();
		tempSave[1]=Load.getAchStr();
		tempSave[2]=Load.getP1Pic();
		tempSave[3]=Load.getP2Pic();
		tempSave[4]=Load.getMusic();
		tempSave[5]=Load.getHasMusicStr();
		tempSave[6]=Load.getDiffStr();
		tempSave[7]=String.valueOf(Load.getScore());
		tempSave[8]=Load.getAdd();
		
		newSave=new String[9];
		newSave[0]=Load.getTheme();
		newSave[1]=Load.getAchStr();
		newSave[2]=Load.getP1Pic();
		newSave[3]=Load.getP2Pic();
		newSave[4]=Load.getMusic();
		newSave[5]=Load.getHasMusicStr();
		newSave[6]=Load.getDiffStr();
		newSave[7]=String.valueOf(Load.getScore());
		newSave[8]=Load.getAdd();
		
		change();
		jbtGoBack.addMouseListener(new goBackListener());
		jbtSave.addMouseListener(new SaveListener());
	}
	
	public void change(){
		switch(theme){
			case"car":
				int x=Theme1.getX();
				int y=Theme1.getY();
				Theme1.setLocation(x+5, y+5);
				break;
			case"cat":
				x=Theme2.getX();
				y=Theme2.getY();
				Theme2.setLocation(x+5,y+5);
				break;
		}
		switch(Music){
		case"true":
			int x=jlbMusic1.getX();
			int y=jlbMusic1.getY();
			jlbMusic1.setLocation(x+5, y+5);
			break;
		case"false":
		    x=jlbMusic2.getX();
			y=jlbMusic2.getY();
			jlbMusic2.setLocation(x+5, y+5);
			break;
		}
		
	}
	
	class goBackListener implements MouseListener{

		int x = jbtGoBack.getX();
		int y = jbtGoBack.getY();
		@Override
		public void mouseClicked(MouseEvent e) {
			MP3Player p=new MP3Player("sound/enter.mp3");
			p.play();
			Start.dotsandboxes.showMenu();
			
		}
		
		public void mousePressed(MouseEvent e) {
			jbtGoBack.setLocation(x+5,y+5);
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			jbtGoBack.setLocation(x-3,y-3);
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			jbtGoBack.setLocation(x-3,y-3);
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			jbtGoBack.setLocation(x,y);
			
		}
		
		
	}
	
	class SaveListener implements MouseListener{
		int x = jbtSave.getX();
		int y = jbtSave.getY();

		@Override
		public void mouseClicked(MouseEvent e) {
			MP3Player m=new MP3Player("sound/enter.mp3");
			m.play();
			if(!(newSave[0].equals(tempSave[0])&&newSave[5].equals(tempSave[5]))&&newSave[8].equals(tempSave[8])){
				Save.saveAll(newSave);
				GameDialog.oneButtonDialog("提示", "修改成功！");
				Start.dotsandboxes.dispose();
				Start.dotsandboxes= new DotsAndBoxes();
				Start.dotsandboxes.addOpening();
			}
			else
				GameDialog.oneButtonDialog("提示","你没有做出修改！");
		}

		@Override
		public void mousePressed(MouseEvent e) {
			jbtSave.setLocation(x+5,y+5);
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			jbtSave.setLocation(x-3,y-3);
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			jbtSave.setLocation(x-3,y-3);
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			jbtSave.setLocation(x,y);
			
		}
		
		
	}
	
	
	class ThemeListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			MP3Player m=new MP3Player("sound/choose.mp3");
			m.play();

			if (e.getSource().equals(Theme1)){
				newSave[0]= "car";
			} else if (e.getSource().equals(Theme2)){
				newSave[0]= "cat";
			}
			if (e.getSource().equals(Theme1)){
				int x = Theme1.getX();
				int y = Theme1.getY();
				Theme1.setLocation(x+5,y+5);
			} else if(e.getSource().equals(Theme2)){
				int x = Theme2.getX();
				int y = Theme2.getY();
				Theme2.setLocation(x+5,y+5);
			} 
		}

		
		public void mousePressed(MouseEvent e) {

		}

		
		public void mouseReleased(MouseEvent e) {
			
		}

	
		public void mouseEntered(MouseEvent e) {
			if (e.getSource().equals(Theme1)){
				int x = Theme1.getX();
				int y = Theme1.getY();
				Theme1.setLocation(x-5,y-5);
			} else if(e.getSource().equals(Theme2)){
				int x = Theme2.getX();
				int y = Theme2.getY();
				Theme2.setLocation(x-5,y-5);
			} 
		}

		
		public void mouseExited(MouseEvent e) {
			if (e.getSource().equals(Theme1)){
				int x = Theme1.getX();
				int y = Theme1.getY();
				Theme1.setLocation(x+5,y+5);
			} else if(e.getSource().equals(Theme2)){
				int x = Theme2.getX();
				int y = Theme2.getY();
				Theme2.setLocation(x+5,y+5);
			
			}			
		}

	}
	
	
	class MusicListener implements MouseListener{
		public void mouseClicked(MouseEvent e) {
			MP3Player m=new MP3Player("sound/choose.mp3");
			m.play();

			if (e.getSource().equals(jlbMusic1)){
				newSave[5] ="true";
			} else if (e.getSource().equals(jlbMusic2)) {
				newSave[5] ="false";
			}
			if (e.getSource().equals(jlbMusic1)){
				int x = jlbMusic1.getX();
				int y = jlbMusic1.getY();
				jlbMusic1.setLocation(x+5,y+5);
			} else if(e.getSource().equals(jlbMusic2)){
				int x = jlbMusic2.getX();
				int y = jlbMusic2.getY();
				jlbMusic2.setLocation(x+5,y+5);
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			if (e.getSource().equals(jlbMusic1)){
				int x = jlbMusic1.getX();
				int y = jlbMusic1.getY();
				jlbMusic1.setLocation(x-5,y-5);
			} else if(e.getSource().equals(jlbMusic2)){
				int x = jlbMusic2.getX();
				int y = jlbMusic2.getY();
				jlbMusic2.setLocation(x-5,y-5);
			}
		}

		@Override
		public void mouseExited(MouseEvent e) {
			if (e.getSource().equals(jlbMusic1)){
				int x = jlbMusic1.getX();
				int y = jlbMusic1.getY();
				jlbMusic1.setLocation(x+5,y+5);
			} else if(e.getSource().equals(jlbMusic2)){
				int x = jlbMusic2.getX();
				int y = jlbMusic2.getY();
				jlbMusic2.setLocation(x+5,y+5);
			}
		}
		
	}
	
}

	

	

