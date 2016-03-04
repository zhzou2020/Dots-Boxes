package dotsandboxes.panel;



import javax.swing.*;



public class CatDoubleGamePanel extends DoubleGamePanel{
	protected static final long serialVersionUID=1L;
	protected JButton start;
	protected JLabel catPoint;
	protected JLabel dogPoint;
	protected JButton musicButton;
	protected JButton playAgain;
	protected JButton backToMainMenu;
	protected JLabel catPlayer;
    protected JLabel dogPlayer;
    protected JLabel menuLabel;
    protected JLabel gameBackGround;
    protected boolean hasmusic=true;
    
    public CatDoubleGamePanel(){
  	this.setLayout(null);
  	
    ImageIcon gamebg=new ImageIcon("images/cat/gameBG.png");//tianjiatupian
    gameBackGround=new JLabel(gamebg);
    gameBackGround.setBounds(0,0,800,720);
    this.add(gameBackGround);    
    
    catPlayer=new JLabel(new ImageIcon("images/cat/catPlayer.png"));
    catPlayer.setBounds(0, 200, 145, 100);
    gameBackGround.add(catPlayer);
    
    
    dogPlayer=new JLabel(new ImageIcon("images/cat/dogPlayer.png"));
    dogPlayer.setBounds(650, 200, 145, 100);
    gameBackGround.add(dogPlayer);
    
    catPoint=new JLabel(new ImageIcon("images/cat/number0.png"));
    catPoint.setBounds(30,100,100,100);//分数板的位置还要调整
    gameBackGround.add(catPoint);
    
    dogPoint=new JLabel(new ImageIcon("images/cat/number0.png"));
    dogPoint.setBounds(680,100,100,100);
    gameBackGround.add(dogPoint);
    
    startgame.setBounds(0,600,150,100);
    startgame.setContentAreaFilled(false);
    startgame.setBorderPainted(false);
    gameBackGround.add(startgame);
    
    back.setBounds(650,600,150,100);
    back.setContentAreaFilled(false);
    back.setBorderPainted(false);
    gameBackGround.add(back);
    
    cam.setBounds(20,20,100,82);
    cam.setContentAreaFilled(false);
    cam.setBorderPainted(false);
    gameBackGround.add(cam);
    
    for(int p=0;p<5;p++)
			for(int q=0;q<6;q++){
				button1[p][q].setBounds(180+90*p, 110+90*q, 70, 15);
				gameBackGround.add(button1[p][q]);
				
			}
	    for(int a=0;a<6;a++)
			for(int b=0;b<5;b++){
				button2[a][b].setBounds(163+90*a, 130+90*b, 15, 70);				
				gameBackGround.add(button2[a][b]);
				}
	    
	    for(int x=0;x<5;x++)
			for(int y=0;y<5;y++){				
				Box[x][y].setBounds(183+90*x,130+90*y,65,65);
			}	   
	    
	    timeLabel.setBounds(350, 20,80,40);
	    gameBackGround.add(timeLabel);
	 }	
    protected void scoreChange(int i){
    	if(i==1)
    	catPoint.setIcon(new ImageIcon("images/cat/number"+score[1]+".png"));
    	else if(i==2)
    		dogPoint.setIcon(new ImageIcon("images/cat/number"+score[0]+".png"));
    }
}
	
    
