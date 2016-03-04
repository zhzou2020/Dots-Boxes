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
	//��˫�˰�ť��λ�ڿ�ʼ��ť֮�£�
	protected static JButton jbtHelp;//������ť
	protected static JButton jbtOption;//���ð�ť	
	protected static JButton jbtAchievement;//�ɾͰ�ť
	//��Ϸ��ʼ�����ϵİ�ť
	
	protected JLabel isLoading;//���ڼ��ر�ǩ
	protected boolean isloading=false;
	protected MP3Player m;
	protected JLabel backgroundLabel;
	
	MenuPanel() {
		m=new MP3Player("sound/enter.mp3");
		
		jbtSingle = new JButton(new ImageIcon("images/"+theme+"/SingleGame.png"));//ͼƬ����δ����������
		jbtSingle.setBounds(440, 280, 300,70);
		jbtSingle.setContentAreaFilled(false);
		jbtSingle.setBorderPainted(false);
		jbtSingle.setFocusPainted(false);
		//
		jbtDouble = new JButton(new ImageIcon("images/"+theme+"/DoubleGame.png"));//ͼƬ����δ����
		jbtDouble.setBounds(440, 360, 300, 70);
		jbtDouble.setContentAreaFilled(false);
		jbtDouble.setBorderPainted(false);
		jbtDouble.setFocusPainted(false);
		//
		ImageIcon helpIcon = new ImageIcon("images/"+theme+"/Help.png");//δ����
		jbtHelp = new JButton(helpIcon);
		jbtHelp.setBounds(440, 440, 300, 70);
		jbtHelp.setContentAreaFilled(false);
		jbtHelp.setBorderPainted(false);
		jbtHelp.setFocusPainted(false);
		//
		ImageIcon optionIcon = new ImageIcon("images/"+theme+"/Option.png");//δ����
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
						// TODO �Զ����ɵ� catch ��
						e.printStackTrace();
					}
				}	
			}
			
			isLoading.setVisible(false);
		}
*/	






