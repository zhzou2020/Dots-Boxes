package dotsandboxes.panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import dotsandboxes.main.Start;
import dotsandboxes.option.Load;
import dotsandboxes.sound.MP3Player;
import dotsandboxes.ui.SpcPan;

public class HelpPanel extends SpcPan implements ActionListener{
	private static String theme;
	private static final long serialVersionUID = 1L;
	public static JButton reback;
	
	public HelpPanel(){		
		theme=Load.getTheme();		
		ImageIcon background=new ImageIcon("images/"+theme+"/helpBG.jpg");
        JLabel wholeBG=new JLabel(background);      
        wholeBG.setBounds(0, 0, 800, 720);
        this.add(wholeBG);    
    
       //
       ImageIcon rebackBG=new ImageIcon("images/"+theme+"/return.png");
       reback=new JButton(rebackBG);
       reback.setBounds(500,620,300,70);  
       reback.setContentAreaFilled(false);
       reback.setBorderPainted(false);
       reback.setFocusPainted(false);
       reback.addActionListener(this);
       wholeBG.add(reback);           
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(reback)){
			MP3Player m=new MP3Player("sound/enter.mp3");
			m.play();
			Start.dotsandboxes.showMenu();
		}
	}
}
