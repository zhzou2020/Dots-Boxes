package dotsandboxes.ui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import dotsandboxes.constants.Constant;
import dotsandboxes.option.Load;
import dotsandboxes.sound.MP3Player;
//创建GameDialog对象 调用dialog方法 参数为一个string就是一个按钮 两个string就是两个按钮
public class GameDialog {
	public static JDialog dialog = new JDialog();
	public static JOptionPane dialogPane;
	public static int status=0;
	
	public static  void oneButtonDialog(String dialogName,String message){		
		MP3Player m=new MP3Player("sound/dialog.mp3");
		m.play();
		JButton okButton;
		
		ImageIcon dialogBgIcon = new ImageIcon("images/"+Load.getTheme()+"/dialogBG.png");
		ImageIcon okIcon = new ImageIcon("images/"+Load.getTheme()+"/ok.png");
		
		dialogPane = new JOptionPane();
		dialogPane.setLayout(null);
		Image cursorImage = Toolkit.getDefaultToolkit().getImage("images/"+Load.getTheme()+"/cursor.png");
		Cursor cursor = Toolkit.getDefaultToolkit().createCustomCursor(cursorImage,new Point(0, 0), "mycursor");
		dialogPane.setCursor(cursor);
		
		JLabel imageLabel = new JLabel(dialogBgIcon);
		imageLabel.setBounds(0,0,dialogBgIcon.getIconWidth(),dialogBgIcon.getIconHeight());

		JLabel wordLabel = new JLabel();
		if(message.length()>wordLabel.getWidth()){
			message = "<html>" + message + "<html/>";
			message.replaceAll(""+message.charAt(wordLabel.getWidth()),message.charAt(wordLabel.getWidth())+"<br/>");
		}
		wordLabel.setText(message);
		wordLabel.setForeground(Color.BLACK);
		wordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		wordLabel.setFont(new Font("微软雅黑",Font.BOLD,Constant.FONTBIG));
		wordLabel.setBounds(10,40,400,100);
		
		okButton = new JButton();
		okButton.setIcon(okIcon);
		okButton.setBounds(160,160,okIcon.getIconWidth(),okIcon.getIconHeight());
		okButton.setOpaque(true);
		okButton.setContentAreaFilled(false);
		okButton.setBorderPainted(false);
		okButton.setFocusPainted(false);
		okButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				dialog.dispose();
			}
			
		});
		
		dialogPane.add(wordLabel);
		dialogPane.add(okButton);
		dialogPane.add(imageLabel);
		//wordLabel-top;okButton-middle;imageLabel-bottom
		dialogPane.setOpaque(false);
		
		dialogPane.setPreferredSize(new Dimension(400,250));
		dialog = dialogPane.createDialog(okButton,dialogName);
	    dialog.setVisible(true);
	    //how to set a dialog as Opaque???
		dialog.add(dialogPane);
		dialog.getRootPane().setDefaultButton(okButton); 
	}
	
	public static  int twoButtonDialog(String dialogName,String message,String buttonMessage1,String buttonMessage2){
		MP3Player m=new MP3Player("sound/dialog.mp3");
		m.play();
		JButton button1;
		JButton button2;
		ImageIcon dialogBgIcon = new ImageIcon("images/"+Load.getTheme()+"/dialogBG.png");
		ImageIcon button1Icon = new ImageIcon("images/"+Load.getTheme()+"/"+buttonMessage1);
		ImageIcon button2Icon = new ImageIcon("images/"+Load.getTheme()+"/"+buttonMessage2);
		
		dialogPane = new JOptionPane();
		dialogPane.setLayout(null);
		Image cursorImage = Toolkit.getDefaultToolkit().getImage("images/"+Load.getTheme()+"/cursor.png");
		Cursor cursor = Toolkit.getDefaultToolkit().createCustomCursor(cursorImage,new Point(0, 0), "mycursor");
		dialogPane.setCursor(cursor);
		
		JLabel imageLabel = new JLabel(dialogBgIcon);
		imageLabel.setBounds(0,0,dialogBgIcon.getIconWidth(),dialogBgIcon.getIconHeight());

		JLabel wordLabel = new JLabel();
		if(message.length()>wordLabel.getWidth()){
			message = "<html>" + message + "<html/>";
			message.replaceAll(""+message.charAt(wordLabel.getWidth()),message.charAt(wordLabel.getWidth())+"<br/>");
		}
		wordLabel.setText(message);
		wordLabel.setForeground(Color.BLACK);
		wordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		wordLabel.setFont(new Font("微软雅黑",Font.BOLD,Constant.FONTBIG));
		wordLabel.setBounds(10,40,400,100);
		
		button1 = new JButton();
		button1.setIcon(button1Icon);
		button1.setBounds(80,160,button1Icon.getIconWidth(),button1Icon.getIconHeight());
		button1.setOpaque(true);
		button1.setContentAreaFilled(false);
		button1.setBorderPainted(false);
		button1.setFocusPainted(false);
		button1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				status = 1;
				dialog.dispose();
			}
			
		});
		
		button2 = new JButton();
		button2.setIcon(button2Icon);
		button2.setBounds(230,160,button2Icon.getIconWidth(),button2Icon.getIconHeight());
		button2.setOpaque(true);
		button2.setContentAreaFilled(false);
		button2.setBorderPainted(false);
		button2.setFocusPainted(false);
		button2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				status = 2;
				dialog.dispose();
			}
			
		});
		dialogPane.add(wordLabel);
		dialogPane.add(button1);
		dialogPane.add(button2);
		dialogPane.add(imageLabel);
		dialogPane.setOpaque(false);
		
		dialogPane.setPreferredSize(new Dimension(400,250));
		dialog = dialogPane.createDialog(dialogPane,dialogName);
	    dialog.setVisible(true);
		dialog.add(dialogPane);
		dialog.getRootPane().setDefaultButton(button1); 
		return status;
	}
	
}