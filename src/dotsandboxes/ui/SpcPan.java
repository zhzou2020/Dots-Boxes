package dotsandboxes.ui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import dotsandboxes.main.Start;
import dotsandboxes.option.Load;
import dotsandboxes.option.Save;
import dotsandboxes.panel.DoubleGamePanel;
import dotsandboxes.panel.SingleGamePanel;

public class SpcPan extends JPanel{
	String theme=Load.getTheme();
	JButton min;
	JButton close;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected SpcPan(){
		this.setLayout(null);
		this.setVisible(true);
		min=new JButton(new ImageIcon("images/"+theme+"/min1.png"));
		min.setBounds(730,0,30,20);
		min.setRolloverIcon(new ImageIcon("images/"+theme+"/min2.png"));//设置鼠标移动上去用的图片
		min.addMouseListener(new minListener());
		min.setContentAreaFilled(false);
		min.setBorderPainted(false);
		min.setFocusPainted(false);
		min.setVisible(true);
		this.add(min);
		
		close=new JButton(new ImageIcon("images/"+theme+"/close1.png"));
		close.setBounds(760,0,40,20);
		close.setRolloverIcon(new ImageIcon("images/"+theme+"/close2.png"));//设置鼠标移动上去用的图片
		close.addMouseListener(new closeListener());
		close.setContentAreaFilled(false);
		close.setBorderPainted(false);
		close.setFocusPainted(false);
		close.setVisible(true);
		this.add(close);
	}
	class minListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			min.setIcon(new ImageIcon("images/"+theme+"/min2.png"));
			Start.dotsandboxes.setExtendedState(JFrame.ICONIFIED);
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
	class closeListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			close.setIcon(new ImageIcon("images/"+theme+"/close2.png"));
			int k=0;
			if(SingleGamePanel.isstart){
				k=GameDialog.twoButtonDialog("提示", "你想要中途退出吗？", "yes.png","no.png");
				if(k==1){
					Save.save("score", String.valueOf(Load.getScore()-5));
					System.exit(0);
				}
			}
			else if(DoubleGamePanel.isstart){
				k=GameDialog.twoButtonDialog("提示", "你想要中途退出吗？", "yes.png","no.png");
				if(k==1){
					System.exit(0);
				}
			}
			else
				System.exit(0);
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
