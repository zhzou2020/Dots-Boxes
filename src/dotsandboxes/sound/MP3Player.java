package dotsandboxes.sound;
import java.io.BufferedInputStream;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class MP3Player{ 
	private String filename;
    private Player player;
	public MP3Player(String filename) { 
        this.filename = filename;
     } 
  
    public void play() {

        try { 
           BufferedInputStream buffer = new BufferedInputStream( 
                    new FileInputStream(filename)); 
            player = new Player(buffer); 
            player.play(); 
         } catch (Exception e) { 
            System.out.println(e); 
         } 
    }
    public void play(int i){
    	MusicThread mt=new MusicThread(this,i);
    	mt.start();
    	this.play();
    }
    public void stop(){
    	player.close();
    }

}