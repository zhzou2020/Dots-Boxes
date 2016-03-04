package dotsandboxes.ui;

import java.awt.Color;

import javax.swing.JLabel;


public class TimeLabel {
	private JLabel label;
	private JiShiQi jiShi;
	public JLabel label(){
		label=new JLabel();
		jiShi=new JiShiQi(label);	
		return label;
	}
	public void start(){
		jiShi.start();
	}
	public void pause(){
		jiShi.sec=new Integer(Integer.MAX_VALUE);
	}
	public void end(){
		jiShi.doRun=false;
	}
	public void restart(){
		jiShi.time=120;
	}
	public void setColor(Color k){
		jiShi.color=k;
	}
}
