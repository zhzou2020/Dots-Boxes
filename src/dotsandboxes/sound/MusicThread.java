package dotsandboxes.sound;

public class MusicThread extends Thread{
	MP3Player mp;
	int i;
	public MusicThread(MP3Player mp,int i){
		this.mp=mp;
		this.i=i;
	}
	public void run(){
		try {
			sleep(i*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mp.stop();
	}
}
