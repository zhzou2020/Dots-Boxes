package dotsandboxes.main;


import java.awt.CardLayout;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRootPane;

import dotsandboxes.constants.Constant;
import dotsandboxes.option.Load;
import dotsandboxes.panel.AchievementPanel;
import dotsandboxes.panel.CarDoubleGamePanel;
import dotsandboxes.panel.CarSingleGamePanel;
import dotsandboxes.panel.CatDoubleGamePanel;
import dotsandboxes.panel.CatSingleGamePanel;
import dotsandboxes.panel.HelpPanel;
import dotsandboxes.panel.OptionPanel;
import dotsandboxes.sound.MP3Player;

public class DotsAndBoxes extends JFrame{	
	private static final long serialVersionUID = 1L;
	public OpeningThread openingThread;
	public JLabel openingJLabel;
	
	public JPanel menupanel;
	public JPanel catsinglegamepanel;
	public JPanel catdoublegamepanel;
	public JPanel carsinglegamepanel;
	public JPanel cardoublegamepanel;
	public JPanel helpPanel;
	public JPanel optionpanel;
	public JPanel achievementpanel;
	
	public Cursor cursor;//创建光标
	private String theme=Load.getTheme();
	JButton openingJButton;
	public static CardLayout card=new CardLayout(); 
	
	public boolean isadd=false;
	
	public DotsAndBoxes(){
		openingThread=new OpeningThread();
		
		this.setUndecorated(true);
		this.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(card);
		
		
		Image cursorImage=Toolkit.getDefaultToolkit().getImage("images/"+theme+"/cursor.png");
		cursor=Toolkit.getDefaultToolkit().createCustomCursor(cursorImage,new Point(0,0),"gameCursor");
		this.setCursor(cursor);
	
		ImageIcon openingIcon = new ImageIcon("images/"+theme+"/opening.gif");//插入动画
		openingJLabel = new JLabel(openingIcon);
		openingJLabel.setBounds(0, 0, openingIcon.getIconWidth(),
				openingIcon.getIconHeight());
		this.getLayeredPane().add(openingJLabel, new Integer(Integer.MAX_VALUE));
		
		
		this.setSize(Constant.DEFAULT_WIDTH,Constant.DEFAULT_HEIGHT);
		this.setResizable(false);//不可调大小
		this.setLocationRelativeTo(null);//置中
		this.setTitle("Dots & Boxes");
		
		
		menupanel=new MenuPanel();
		this.getContentPane().add(menupanel,"menu");
		if(Load.getTheme().equals("car")){
			carsinglegamepanel=new CarSingleGamePanel();
			cardoublegamepanel=new CarDoubleGamePanel();
			this.getContentPane().add(carsinglegamepanel,"single");
			this.getContentPane().add(cardoublegamepanel,"double");
		}
		else if(Load.getTheme().equals("cat")){
			catsinglegamepanel=new CatSingleGamePanel();
			catdoublegamepanel=new CatDoubleGamePanel();
			this.getContentPane().add(catsinglegamepanel,"single");
			this.getContentPane().add(catdoublegamepanel,"double");
		}
		else{
			System.out.println("No theme!");
		}
		helpPanel=new HelpPanel();
		this.getContentPane().add(helpPanel,"help");
		optionpanel=new OptionPanel();
		this.getContentPane().add(optionpanel,"option");
		achievementpanel=new AchievementPanel();
		this.getContentPane().add(achievementpanel,"achievement");
		card.show(this.getContentPane(),"menu");
		
		this.addKeyListener(new openKeyListener());
		this.setVisible(true);
	}
	public DotsAndBoxes(String str){		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(card);

		Image cursorImage=Toolkit.getDefaultToolkit().getImage("images/"+theme+"/cursor.png");
		cursor=Toolkit.getDefaultToolkit().createCustomCursor(cursorImage,new Point(0,0),"gameCursor");
		this.setCursor(cursor);	
		
		this.setSize(Constant.DEFAULT_WIDTH,Constant.DEFAULT_HEIGHT);
		this.setResizable(false);//不可调大小
		this.setLocationRelativeTo(null);//置中
		this.setTitle("Dots & Boxes");
		
		menupanel=new MenuPanel();
		this.getContentPane().add(menupanel,"menu");
		if(Load.getTheme().equals("car")){
			carsinglegamepanel=new CarSingleGamePanel();
			cardoublegamepanel=new CarDoubleGamePanel();
			this.getContentPane().add(carsinglegamepanel,"single");
			this.getContentPane().add(cardoublegamepanel,"double");
		}
		else if(Load.getTheme().equals("cat")){
			catsinglegamepanel=new CatSingleGamePanel();
			catdoublegamepanel=new CatDoubleGamePanel();
			this.getContentPane().add(catsinglegamepanel,"single");
			this.getContentPane().add(catdoublegamepanel,"double");
		}
		else{
			System.out.println("No theme!");
		}
		helpPanel=new HelpPanel();
		this.getContentPane().add(helpPanel,"help");
		optionpanel=new OptionPanel();
		this.getContentPane().add(optionpanel,"option");
		achievementpanel=new AchievementPanel();
		this.getContentPane().add(achievementpanel,"achievement");
		card.show(this.getContentPane(),str);
		this.setVisible(true);
	}
	public void showMenu(){
		card.show(this.getContentPane(),"menu");
	}
	public void showSingle(){
		card.show(this.getContentPane(),"single");
	}
	public void showDouble(){
		card.show(this.getContentPane(), "double");
	}
	public void showHelp(){
		card.show(this.getContentPane(), "help");
	}
	public void showOption(){
		card.show(this.getContentPane(),"option");
	}
	public void showAchievement(){
		card.show(this.getContentPane(),"achievement");
	}
	public void addPanel(JPanel pan,String str){
		this.getContentPane().add(pan,str);
	}
	public void removeSinglePanel(){
		if(Load.getTheme().equals("car"))
			this.remove(carsinglegamepanel);
		else if(Load.getTheme().equals("cat"))
			this.remove(catsinglegamepanel);
		System.gc();
	}
	public void removeDoublePanel(){
		if(Load.getTheme().equals("car"))
			this.remove(cardoublegamepanel);
		else if(Load.getTheme().equals("cat"))
			this.remove(catdoublegamepanel);
		System.gc();
	}
	public void newSinglePanel(){
		this.removeSinglePanel();
		if(theme.equals("car")){
			JPanel carsinglegamepanel=new CarSingleGamePanel();
			this.addPanel(carsinglegamepanel,"single");
		}
		else if(theme.equals("cat")){
			JPanel catsinglegamepanel=new CatSingleGamePanel();
			this.addPanel(catsinglegamepanel,"single");
		}
		this.revalidate();
	}
	public void newDoublePanel(){
		this.removeDoublePanel();
		if(theme.equals("car")){
			JPanel cardoublegamepanel=new CarDoubleGamePanel();
			this.addPanel(cardoublegamepanel,"double");
		}
		else if(theme.equals("cat")){
			JPanel catdoublegamepanel=new CatDoubleGamePanel();
			this.addPanel(catdoublegamepanel,"double");
		}
		this.revalidate();
	}
	
	
	class OpeningThread extends Thread{
		public void run() {
			try {
				sleep(8000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			openingJLabel.setVisible(false);
			((MenuPanel) menupanel).AddAll();
		}//开场动画

	}
	class openKeyListener implements KeyListener {

		@Override
		public void keyTyped(KeyEvent e) {
			
		}

		public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE
					|| e.getKeyCode() == KeyEvent.VK_ENTER
					|| e.getKeyCode() == KeyEvent.VK_SPACE) {
				openingJLabel.setVisible(false);
				if (!isadd) {
					((MenuPanel) menupanel).AddAll();
					isadd = true;
				}

			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO 自动生成的方法存根

		}

	}
	public void addOpening(){
		openingThread.start();
		this.addKeyListener(new openKeyListener());
		MP3Player m=new MP3Player("sound/"+Load.getTheme()+".mp3");
		if(Load.getHasMusic())
			m.play(10);
	}


}
