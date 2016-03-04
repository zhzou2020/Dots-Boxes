package dotsandboxes.option;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Save {
	private static BufferedReader br;
	private static String temp;
	private static String[] str;
	private static StringBuffer sb;
	private static FileWriter wr;
	//save方法中第一个参数是你想修改的项目，第二个参数是修改的内容
	public static void save(String item,String newstr){
		try {
			br=new BufferedReader(new FileReader("data.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sb=new StringBuffer();
		try {
			while((temp=br.readLine())!=null){
				str=temp.split("!");
				if(str[0].equals(item)){
					sb.append(str[0]+"!"+newstr);
				}
				else
					sb.append(temp);
				sb.append("\r\n");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			wr=new FileWriter("data.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			wr.write(sb.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			wr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//achievement中无论如何都至少有一个0
	public static void save(String item,int[] num){
		StringBuffer sb=new StringBuffer();
		sb.append(num[0]);
		for(int i=1;i<num.length;i++){
			sb.append(";"+num[i]);
		}
		save(item,sb.toString());
	}
	public static void saveAll(String[] str){
		save("theme",str[0]);
		save("achievement",str[1]);
		save("p1Pic",str[2]);
		save("p2Pic",str[3]);
		save("music",str[4]);
		save("hasMusic",str[5]);
		save("difficulty",str[6]);
		save("score",str[7]);
		save("address",str[8]);
	}
}