package dotsandboxes.ai;

public class ai1 {
	private int[][] column;
	private int[][] row;
	private int[][] box;
	private int[][] newBox={{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0}};
	private int[][] clain=new int[100][100];
	private int i,j;
	private int m=0;
	private int n=0;
	private int a=0;
	private int b=0;
	int x1;
	int y1;
	int rowOrColumn;
	public  ai1(int[][] row, int[][] column , int[][] box) {
		this.column=column;
		this.row=row;
		this.box=box;
	}
	private void setTheValue(int[][] row, int[][] column , int[][] box){
		for(i=0;i<5;i++)
				for(j=0;j<6;j++){
					if(row[i][j]==-1){
						continue;
					}
					
					if(j==0){
						row[i][j]=this.calculate(box[i][j]);
					}
					else if(j==5){
						row[i][j]=this.calculate(box[i][j-1]);
					}
					else{
						row[i][j]=(this.calculate(box[i][j])+this.calculate(box[i][j-1]))/2;
					}
			}
				for(i=0;i<6;i++)
					for(j=0;j<5;j++){
						if(column[i][j]==-1){
							continue;
						}
						if(i==0){
							column[i][j]=this.calculate(box[i][j]);
						}else if(i==5){
							column[i][j]=this.calculate(box[i-1][j]);
						}else{
							column[i][j]=(this.calculate(box[i][j])+this.calculate(box[i-1][j]))/2;
						}
					}
	}
	private int calculate(int i){
		switch(i){
		case 0:return 3;
		case 1:return 3;
		case 2:return 1;
		case 3:return 7;
		default: return 0;  //应该不会出现此情况
		}
	}
	private boolean isQianQi(){
		for(i=0;i<5;i++)
			for(j=0;j<6;j++){
				if(row[i][j]!=-1&&row[i][j]!=1&&row[i][j]!=2)
					return true;
			}
		for(i=0;i<6;i++)
			for(j=0;j<5;j++){
				if(column[i][j]!=-1&&column[i][j]!=1&&column[i][j]!=2)
					return true;
			}
		return false;
	}
	private int qianqi(){
		for(i=0;i<5;i++)
			for(j=0;j<6;j++){
				if(row[i][j]>=row[m][n]){
					if(row[i][j]>row[m][n]){
					m=i;n=j;}
					else if((int)(Math.random()*10)==0){
						m=i;n=j;
					}
				}
			}
		for(i=0;i<6;i++)
			for(j=0;j<5;j++){
				if(column[i][j]>=column[a][b]){
					if(column[i][j]>column[a][b]){
					a=i;b=j;}
					else if((int)(Math.random()*10)==0){
						a=i;b=j;
					}
				}
			}
		if(row[m][n]>column[a][b])
			return 100+10*m+n;
		else if(row[m][n]==column[a][b]){
			if((int)(Math.random()*2)==0)
				return 100+10*m+n;
			else 
				return 200+10*a+b;
		}
			
		else 
			return 200+10*a+b;
	}	
	private int searchForLongClain(){
		int x;
		int count=0;
		int length=0;
		int x1headOfCircle=0;
		int y1headOfCircle=0;
		boolean hasCircle=false;
		for(i=0;i<5;i++)
			for(j=0;j<5;j++){
				if(box[i][j]==2){
					newBox[i][j]=1;
				}
			}
label5:	while(this.theBoxOfTwoIsExist()){
		 x=this.searchForTheHead();
		 if(x==-1){
			 System.out.println("zhen de cuo le");
			 break   label5  ;
			
		 }
		 clain[count][0]=x;
		 System.out.println("count="+count);
		 newBox[x/10][x%10]=0;
		 do{
		 length++;
		 if(this.searchForTheNeighbour(clain[count][length-1])==-1){
			 System.out.println("error");
		 }
		 clain[count][length]=this.searchForTheNeighbour(clain[count][length-1]);
		 if(!(this.searchForTheNeighbour(clain[count][length-1])==-1)){
			 newBox[clain[count][length]/10][clain[count][length]%10]=0;
		 }
		 }while(clain[count][length]!=-1);
		 System.out.println(" length "+length);
		 count++;
		 length=0;
		}
		while(this.theBoxOfTwoIsExist()){
		for(i=0;i<5;i++)
			for(j=0;j<5;j++){
				if(newBox[i][j]==1){
				x1headOfCircle=i;
				y1headOfCircle=j;
				hasCircle=true;
				break;
				}
			}
		if(hasCircle){
			 clain[count][0]=10*x1headOfCircle+y1headOfCircle;
			 System.out.println("count="+count);
			 newBox[x1headOfCircle][y1headOfCircle]=0;
			 do{
				 length++;
				 if(this.searchForTheNeighbour(clain[count][length-1])==-1){
					 System.out.println("error of circle"+clain[count][length-1]);
				 }
				 clain[count][length]=this.searchForTheNeighbour(clain[count][length-1]);
				 if(!(this.searchForTheNeighbour(clain[count][length-1])==-1)){
					 newBox[clain[count][length]/10][clain[count][length]%10]=0;
				 }
				 }while(clain[count][length]!=-1);
				 System.out.println(" length "+length);
				 count++;
				 length=0;
				}
		}
			return count;
	}
	private boolean theBoxOfTwoIsExist(){
		for(i=0;i<5;i++)
			for(j=0;j<5;j++){
				if(newBox[i][j]==1)
					return true;
			}
		return false;
	}
	private int searchForTheHead(){
		int x;
		for(i=0;i<5;i++)
			for(j=0;j<5;j++){
				if(newBox[i][j]==1){
					x=i*10+j;
					if((this.theDoorOfBoxTwoIsOpen(x, x-1)^this.theDoorOfBoxTwoIsOpen(x, x+1)^this.theDoorOfBoxTwoIsOpen(x, x-10)^this.theDoorOfBoxTwoIsOpen(x, x+10))
							||!(this.theDoorOfBoxTwoIsOpen(x, x-1)||this.theDoorOfBoxTwoIsOpen(x, x+1)||this.theDoorOfBoxTwoIsOpen(x, x-10)||this.theDoorOfBoxTwoIsOpen(x, x+10))){
						return x;
					}
				}
			}
		return -1;
	}
	private int searchForTheNeighbour(int x){
		if(this.theDoorIsOpen(x, x-1)&&(newBox[x/10][x%10-1]==1)){
				return x-1;
		}
		if(this.theDoorIsOpen(x,x+1)&&(newBox[x/10][x%10+1]==1)){
			return x+1;
		}
		if(this.theDoorIsOpen(x, x+10)&&newBox[x/10+1][x%10]==1){
			return x+10;
		}
		if(this.theDoorIsOpen(x, x-10)&&newBox[x/10-1][x%10]==1){
			return x-10;
		}
		return -1;
	}
	private int findTheDoor(int i,int j){
		if(i%10>4||i<0||i>45)
			return -1;
		if(j%10>4||j<0||j>45)
			return -1;
		int temp;
		if(i<j){
			temp=i;
			i=j;
			j=temp;
		}
		if(i-j==10)
			return 200+i;
		else
			return 100+i;
	}
	private boolean theDoorIsOpen(int i,int j){
		int x=this.findTheDoor(i, j);
		if(x==-1)
			return false;
		if(x/100==1){
			if(row[(x-100)/10][x%10]!=-1)
				return true;
			else 
				return false;
		}
		else{
			if(column[(x-200)/10][x%10]!=-1)
				return true;
			else 
				return false;
		}
	}
	private boolean theDoorOfBoxTwoIsOpen(int i,int j){
		if(this.theDoorIsOpen(i, j)&&newBox[i/10][i%10]==1&&newBox[j/10][j%10]==1)
			return true;
		else 
			return false;
	}
	private int theLengthOfClain(int[] a){
		int x=0;
		do{
			x++;
		}while(a[x-1]!=-1);
		return x;
	}
	private int houqi(){
		int ShortClain=0;
		int theShortLength=0;
		System.out.println("houqilaile");
		int count=this.searchForLongClain();
		for (i=0;i<count;i++){
			if(i==0){
				theShortLength=this.theLengthOfClain(clain[i]);
				ShortClain=i;
			}else{
				if(this.theLengthOfClain(clain[i])<theShortLength){
					theShortLength=this.theLengthOfClain(clain[i]);
					ShortClain=i;
				}
			}
		}
		
	if(this.theLengthOfClain(clain[ShortClain])>2)
	return this.findTheDoor(clain[ShortClain][0], clain[ShortClain][1]);
	else
	{
		if(row[clain[ShortClain][0]/10][clain[ShortClain][0]%10]!=-1)
			return 100+clain[ShortClain][0];
		if(row[clain[ShortClain][0]/10][clain[ShortClain][0]%10+1]!=-1)
			return 100+clain[ShortClain][0]+1;
		if(column[clain[ShortClain][0]/10][clain[ShortClain][0]%10]!=-1)
			return 200+clain[ShortClain][0];
		if(column[clain[ShortClain][0]/10+1][clain[ShortClain][0]%10]!=-1)
			return 200+clain[ShortClain][0]+10;
		else {
			System.out.println("theNextStep error!!");
			return -1;
		}
		
	}
	}
	public int theNextStep(){
		this.setTheValue(row, column, box);
		if(this.isQianQi()){
		return this.qianqi();
		}
		else
			return this.houqi();
	}
}
