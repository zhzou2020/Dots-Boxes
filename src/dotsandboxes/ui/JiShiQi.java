package dotsandboxes.ui;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;



    class JiShiQi extends Thread {  
 
        public int time=120;
        public int sec=1000;
        public Color color=Color.black;
        public boolean doRun=true;
        private JLabel jl;
        public JiShiQi(JLabel jl){
        	this.jl=jl;
        }
        public void run() {  

            super.run();  

            while (doRun&&(time>=0)) {  
            	jl.setText(time+"");
            	System.out.println(time);
        		jl.setForeground(color);
        		jl.setHorizontalAlignment(SwingConstants.CENTER);
        		jl.setFont(new Font("微软雅黑",Font.BOLD,30));
                time--;
                try {  

                    Thread.sleep(sec);  

                } catch (InterruptedException e) {  

                    e.printStackTrace();  

                } 

            }  
            if(time==0){
            	GameDialog.oneButtonDialog("游戏结束", "你的时间到了。。。");
            }

        }  

    } 