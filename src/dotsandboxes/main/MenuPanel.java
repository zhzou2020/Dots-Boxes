package dotsandboxes.main;




import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import dotsandboxes.option.Load;
import dotsandboxes.sound.MP3Player;
import dotsandboxes.ui.SpcPan;

/**@author mcc&zb
 *@version2014.3.26
 */


public class MenuPanel extends SpcPan{
	private static final long serialVersionUID = 1L;
	protected String theme=Load.getTheme();
	protected static JButton jbtSingle;
	protected static JButton jbtDouble;
	//单双人按钮（位于开始按钮之下）
	protected static JButton jbtHelp;//帮助按钮
	protected static JButton jbtOption;//设置按钮	
	protected static JButton jbtAchievement;//成就按钮
	//游戏开始界面上的按钮
	
	protected JLabel isLoading;//正在加载标签
	protected boolean isloading=false;
	protected MP3Player m;
	protected JLabel backgroundLabel;
	
	MenuPanel() {
		m=new MP3Player("sound/enter.mp3");
		
		jbtSingle = new JButton(new ImageIcon("images/"+theme+"/SingleGame.png"));//图片待定未创建！！！
		jbtSingle.setBounds(440, 280, 300,70);
		jbtSingle.setContentAreaFilled(false);
		jbtSingle.setBorderPainted(false);
		jbtSingle.setFocusPainted(false);
		//
		jbtDouble = new JButton(new ImageIcon("images/"+theme+"/DoubleGame.png"));//图片待定未创建
		jbtDouble.setBounds(440, 360, 300, 70);
		jbtDouble.setContentAreaFilled(false);
		jbtDouble.setBorderPainted(false);
		jbtDouble.setFocusPainted(false);
		//
		ImageIcon helpIcon = new ImageIcon("images/"+theme+"/Help.png");//未创建
		jbtHelp = new JButton(helpIcon);
		jbtHelp.setBounds(440, 440, 300, 70);
		jbtHelp.setContentAreaFilled(false);
		jbtHelp.setBorderPainted(false);
		jbtHelp.setFocusPainted(false);
		//
		ImageIcon optionIcon = new ImageIcon("images/"+theme+"/Option.png");//未创建
		jbtOption = new JButton(optionIcon);
		jbtOption.setBounds(440,520,300,70);
		jbtOption.setContentAreaFilled(false);
		jbtOption.setBorderPainted(false);
		jbtOption.setFocusPainted(false);
		//
		ImageIcon careerIcon = new ImageIcon("images/"+theme+"/Achievement.png");
		jbtAchievement = new JButton(careerIcon);
		jbtAchievement.setBounds(440,600,300,70);
		jbtAchievement.setContentAreaFilled(false);
		jbtAchievement.setBorderPainted(false);
		jbtAchievement.setFocusPainted(false);
		//
		ImageIcon menuBg = new ImageIcon("images/"+theme+"/background.png");
		backgroundLabel = new JLabel(menuBg);
		backgroundLabel.setBounds(0, 0, menuBg.getIconWidth(),
				menuBg.getIconHeight());
		//
		this.add(jbtSingle);
		this.add(jbtDouble);
		this.add(jbtOption);
		this.add(jbtHelp);
		this.add(jbtAchievement);
		this.add(backgroundLabel);
		this.setOpaque(false);
		
	}
		class SingleActionListener implements MouseListener {
			int x = jbtSingle.getX();
			int y = jbtSingle.getY();

			@Override
			public void mouseClicked(MouseEvent e) {
				Start.dotsandboxes.showSingle();
				m.play();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				jbtSingle.setLocation(x + 5, y + 5);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				jbtSingle.setLocation(x - 3, y - 3);

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				jbtSingle.setLocation(x - 3, y - 3);

			}

			@Override
			public void mouseExited(MouseEvent e) {
				jbtSingle.setLocation(x, y);

			}
		}

		class DoubleActionListener implements MouseListener {
			int x = jbtDouble.getX();
			int y = jbtDouble.getY();

			@Override
			public void mouseClicked(MouseEvent e) {
				Start.dotsandboxes.showDouble();
				m.play();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				jbtDouble.setLocation(x + 5, y + 5);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				jbtDouble.setLocation(x - 3, y - 3);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				jbtDouble.setLocation(x - 3, y - 3);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				jbtDouble.setLocation(x, y);
			}
		}

		class OptionActionListener implements MouseListener {

			public void mouseClicked(MouseEvent e) {
				Start.dotsandboxes.showOption();
				m.play();
			}

			public void mousePressed(MouseEvent e) {
				int x = jbtOption.getX();
				int y = jbtOption.getY();
				jbtOption.setLocation(x + 5, y + 5);
			}

			public void mouseReleased(MouseEvent e) {
				int x = jbtOption.getX();
				int y = jbtOption.getY();
				jbtOption.setLocation(x - 5, y - 5);
			}

			public void mouseEntered(MouseEvent e) {
				int x = jbtOption.getX();
				int y = jbtOption.getY();
				jbtOption.setLocation(x - 3, y - 3);
			}

			public void mouseExited(MouseEvent e) {
				int x = jbtOption.getX();
				int y = jbtOption.getY();
				jbtOption.setLocation(x + 3, y + 3);
			}
		}

		class HelpActionListener implements MouseListener {
			int x = jbtHelp.getX();
			int y = jbtHelp.getY();
			@Override
			public void mouseClicked(MouseEvent e) {
				Start.dotsandboxes.showHelp();
				m.play();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				jbtHelp.setLocation(x + 5, y + 5);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				jbtHelp.setLocation(x - 5, y - 5);

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				jbtHelp.setLocation(x - 3, y - 3);

			}

			@Override
			public void mouseExited(MouseEvent e) {
				jbtHelp.setLocation(x + 3, y + 3);

			}
		}

		class AchievementActionListener implements MouseListener {
			int x = jbtAchievement.getX();
			int y = jbtAchievement.getY();
			@Override
			public void mouseClicked(MouseEvent e) {
				Start.dotsandboxes.showAchievement();
				m.play();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				jbtAchievement.setLocation(x + 5, y + 5);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				jbtAchievement.setLocation(x - 5, y - 5);

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				jbtAchievement.setLocation(x - 3, y - 3);

			}

			@Override
			public void mouseExited(MouseEvent e) {
				jbtAchievement.setLocation(x + 3, y + 3);

			}
		}
		public void AddAll(){
			jbtSingle.addMouseListener(new SingleActionListener());
			jbtDouble.addMouseListener(new DoubleActionListener());
			jbtHelp.addMouseListener(new HelpActionListener());
			jbtOption.addMouseListener(new OptionActionListener());
			jbtAchievement.addMouseListener(new AchievementActionListener());
		}
	
	}
/*	class LoadingThread extends Thread{
		public void run(){
			try {
				sleep(1000);
			} catch (InterruptedException e1) {
			}
			if (!isloading){
				ImageIcon loadingiIcon = new ImageIcon(Theme.loading1);
				System.out.println(Theme.loading1);
				isLoading = new JLabel(loadingiIcon);
				isLoading.setBounds(200, 300,loadingiIcon.getIconWidth(),loadingiIcon.getIconHeight());
				Start.gomoku.add(isLoading);
				while (!isloading){
					try {
						sleep(100);
					} catch (InterruptedException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}
				}	
			}
			
			isLoading.setVisible(false);
		}
*/	






