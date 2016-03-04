package dotsandboxes.option;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Load {
	private static BufferedReader br;
	private static String temp;
	private static String[] str;
	private static String load(String string) throws IOException{
		br=new BufferedReader(new FileReader("data.txt"));
		while((temp=br.readLine())!=null){
			str=temp.split("!");
			if(str[0].equals(string)){
				br.close();
				return str[1];
			}
		}
		br.close();
		return null;
	}
	//这个方法是将String的achivement转换为数组
	private static int[] achievement(String string){
		str=string.split(";");
		int[] ach=new int[str.length];
		int i=0;
		for(String x:str){
			ach[i]=Integer.parseInt(x);
			i++;
		}
		return ach;
	}
	public static String getTheme(){
		String str = null;
		try {
			str=load("theme");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}
	public static String getAchStr(){
		String str = null;
		try {
			str=load("achievement");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}
	public static String getP1Pic(){
		String str = null;
		try {
			str=load("p1Pic");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}
	public static String getP2Pic(){
		String str = null;
		try {
			str=load("p2Pic");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}
	public static String getMusic(){
		String str = null;
		try {
			str=load("music");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}
	public static boolean getHasMusic(){
		String str = null;
		try {
			str=load("hasMusic");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(str.equals("true"))
			return true;
		if(str.equals("false"))
			return false;
		System.out.println("hasMusic reported a bug!");
		return false;
	}
	public static int getDiff(){
		String str = null;
		try {
			str=load("difficulty");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Integer.parseInt(str);
	}
	public static int[] getAch(){
		String str = null;
		try {
			str=load("achievement");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return achievement(str);
	}
	public static String getHasMusicStr(){
		String str = null;
		try {
			str=load("hasMusic");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}
	public static String getDiffStr(){
		String str = null;
		try {
			str=load("difficulty");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}
	public static int getScore(){
		String str = null;
		try {
			str=load("score");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Integer.parseInt(str);
	
	}
	public static String getAdd(){
		String str = null;
		try {
			str=load("address");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}
}
