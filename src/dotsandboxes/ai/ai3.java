package dotsandboxes.ai;

public class ai3 {
	private int[][] column;
	private int[][] row;
	private int[][] box;
	private int[][] newBox={{0,0,0,0,0},    //记录格子值为2的情况
			{0,0,0,0,0},
			{0,0,0,0,0},
			{0,0,0,0,0},
			{0,0,0,0,0}};
	private int[][] boxOfRangGe={{0,0,0,0,0},    //记录让格算法里格子的情况
			{0,0,0,0,0},
			{0,0,0,0,0},
			{0,0,0,0,0},
			{0,0,0,0,0}};
	private int[][] clain=new int[25][25];
	private int[][] cXingLian=new int[24][26];
	private int i,j;
	private int m=0;
	private int n=0;
	private int a=0;
	private int b=0;
	int x1;
	int y1;
	int rowOrColumn;
	 public static boolean qianQiYiGuo;// 
	
	
	
	
	
	//构造方法
	public  ai3(int[][] row, int[][] column , int[][] box) {
		this.column=column;
		this.row=row;
		this.box=box;
	}
	//为每个边赋值 根据格子的值
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
	//根据格子的值赋比重
	private int calculate(int i){
		switch(i){
		case 0:return 3;
		case 1:return 3;
		case 2:return 1;
		case 3:return 7;
		default: return 0;  //应锟矫诧拷锟斤拷锟斤拷执锟斤拷锟斤拷
		}
	}
	//判断是否为前期 
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
	//前期随机算法
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
	//寻找长链 其中环被视为长链
	private int searchForLongClain(){
		int x;
		int count=0;
		int length=1;
		int x1headOfCircle=0;
		int y1headOfCircle=0;
		boolean hasCircle=false;
label5:	while(this.theBoxOfTwoIsExist()){
		 x=this.searchForTheHead();
		 if(x==-1){
			 break   label5  ;
			
		 }
		 clain[count][0]=-2;   //-2代表链
		 clain[count][1]=x;
	
		 newBox[x/10][x%10]=0;
		 do{
		 length++;
		 if(this.searchForTheNeighbour(clain[count][length-1])==-1){
			
		 }
		 clain[count][length]=this.searchForTheNeighbour(clain[count][length-1]);
		 if(!(this.searchForTheNeighbour(clain[count][length-1])==-1)){
			 newBox[clain[count][length]/10][clain[count][length]%10]=0;
		 }
		 }while(clain[count][length]!=-1);
		 count++;
		 length=1;
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
			clain[count][0]=-3;  //-3代表环
			 clain[count][1]=10*x1headOfCircle+y1headOfCircle;
			 newBox[x1headOfCircle][y1headOfCircle]=0;
			 do{
				 length++;
				 if(this.searchForTheNeighbour(clain[count][length-1])==-1){
				 }
				 clain[count][length]=this.searchForTheNeighbour(clain[count][length-1]);
				 if(!(this.searchForTheNeighbour(clain[count][length-1])==-1)){
					 newBox[clain[count][length]/10][clain[count][length]%10]=0;
				 }
				 }while(clain[count][length]!=-1);
				 count++;
				 length=1;
				}
		}
		for(i=0;i<count;i++){
			length=0;
			do{
			length++;
			}while(clain[i][length-1]!=-1);
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
		
	if(this.theLengthOfClain(clain[ShortClain])>3)
	return this.findTheDoor(clain[ShortClain][1], clain[ShortClain][2]);
	else
	{
		if(row[clain[ShortClain][1]/10][clain[ShortClain][1]%10]!=-1)
			return 100+clain[ShortClain][1];
		if(row[clain[ShortClain][1]/10][clain[ShortClain][1]%10+1]!=-1)
			return 100+clain[ShortClain][1]+1;
		if(column[clain[ShortClain][1]/10][clain[ShortClain][1]%10]!=-1)
			return 200+clain[ShortClain][1];
		if(column[clain[ShortClain][1]/10+1][clain[ShortClain][1]%10]!=-1)
			return 200+clain[ShortClain][1]+10;
		else {
			return -1;
		}
		
	}
	}

	
	
	
	
	
	
		
//锟斤拷锟斤拷为锟矫革拷锟姐法锟斤拷准锟斤拷
	
	//给出一个格子和它的一边 返回相邻的格子 到边界就返回-2 边不是格子的边就返回-1
	private int searchForTheNextBox(int box,int side){
		if(side/100==1){
			if(side-100-box==0){
				if(side%10!=0){
					return box-1;
				}else{
					return -2;
				}
			}else if(side-100-box==1){
				if(side%10!=5){
					return box+1;
				}else{
					return -2;
				}
			}else{
				return -1;
			}
		}else if(side/100==2){
			if(side-200-box==0){
				if(box>5){
					return box-10;
				}else{
					return -2;
				}
			}else if(side-200-box==10){
				if(box<39){
					return box+10;
				}else{
					return -2;
				}
			}else{
				return -1;
			}
		}else{
			return -1;
		}
	}
	//寻找格子值为3的格子 根据 boxOfRangGe 
	private int searchForTheBoxOfThree(){
		for(i=0;i<5;i++)
			for(j=0;j<5;j++){
				if(boxOfRangGe[i][j]==3)
					return i*10+j;
			}
		return -1;
	}
	//寻找值为3的格子的边
	private int searchForTheSideOfBox(int box){
		if(row[box/10][box%10]!=-1){
			return 100+box;
		}else if(row[box/10][box%10+1]!=-1){
			return 100+box+1;
		}else if(column[box/10][box%10]!=-1){
			return 200+box;
		}else if(column[box/10+1][box%10]!=-1){
			return 200+box+10;
		}else{
			return -1;
		}
	}
	//寻找值为2的格子除去给出边的另一边
	private int searchForTheSideOfBox(int box,int side){
		if(row[box/10][box%10]!=-1&&side!=100+box){
			return 100+box;
		}else if(row[box/10][box%10+1]!=-1&&side!=100+1+box){
			return 100+box+1;
		}else if(column[box/10][box%10]!=-1&&side!=200+box){
			return 200+box;
		}else if(column[box/10+1][box%10]!=-1&&side!=200+10+box){
			return 200+box+10;
		}else{
			return -1;
		}
	}
	
	


	private boolean theBoxOfThreeExist(){
		for(i=0;i<5;i++)
			for(j=0;j<5;j++){
				if(boxOfRangGe[i][j]==3){
					return true;
				}
			}
		return false;
	}
	private int rangGe(){
		int length=1;
		int numOfCXingLian=0;
		int nextSide=0;
		int numOfCGeOfTwo=0;
		int numOfShuangCOfFour=0;
		do{
		
		int boxOfThree=this.searchForTheBoxOfThree();
		cXingLian[numOfCXingLian][length]=boxOfThree;
		boxOfRangGe[boxOfThree/10][boxOfThree%10]=-1;
		length++;
		int sideOfBoxOfThree=this.searchForTheSideOfBox(boxOfThree);
		int nextBox=this.searchForTheNextBox(boxOfThree, sideOfBoxOfThree);
		if(nextBox==-2){
			cXingLian[numOfCXingLian][length]=-1;
			cXingLian[numOfCXingLian][0]=2;
		}
		else if(boxOfRangGe[nextBox/10][nextBox%10]==5){
			
		}
		else if(boxOfRangGe[nextBox/10][nextBox%10]==3){
			cXingLian[numOfCXingLian][length]=nextBox;
			boxOfRangGe[nextBox/10][nextBox%10]=-1;
			length++;
			cXingLian[numOfCXingLian][length]=-1;
			cXingLian[numOfCXingLian][0]=1;    //首项值为1 说明此C链为两端C
		}else if(boxOfRangGe[nextBox/10][nextBox%10]==1||boxOfRangGe[nextBox/10][nextBox%10]==0){
			cXingLian[numOfCXingLian][length]=-1;
			cXingLian[numOfCXingLian][0]=2;   //首项为2说明此C链一端为C
		}else if(boxOfRangGe[nextBox/10][nextBox%10]==2){
			nextSide=sideOfBoxOfThree;
			do{
				newBox[nextBox/10][nextBox%10]=0;
				cXingLian[numOfCXingLian][length]=nextBox;
				length++;
				nextSide=this.searchForTheSideOfBox(nextBox, nextSide);
				nextBox=this.searchForTheNextBox(nextBox, nextSide);
			}while(nextBox!=-2&&boxOfRangGe[nextBox/10][nextBox%10]==2);
			if(nextBox==-2){
				cXingLian[numOfCXingLian][length]=-1;
				cXingLian[numOfCXingLian][0]=2;
			}else if(boxOfRangGe[nextBox/10][nextBox%10]==5){
				
			}
			else if(boxOfRangGe[nextBox/10][nextBox%10]==3){
				cXingLian[numOfCXingLian][length]=nextBox;
				boxOfRangGe[nextBox/10][nextBox%10]=-1;
				length++;
				cXingLian[numOfCXingLian][length]=-1;
				cXingLian[numOfCXingLian][0]=1;   
			}else if(boxOfRangGe[nextBox/10][nextBox%10]==1||boxOfRangGe[nextBox/10][nextBox%10]==0){
				cXingLian[numOfCXingLian][length]=-1;
				cXingLian[numOfCXingLian][0]=2;   
			}
		}
		numOfCXingLian++;
		length=1;
		}while(this.theBoxOfThreeExist());
		
		for(i=0;i<numOfCXingLian;i++){
			System.out.println(i+" "+this.theLengthOfClain(cXingLian[i]));
		}

		int clains=searchForLongClain();
		for(i=0;i<numOfCXingLian;i++){
			if(cXingLian[i][0]==1){
				if(this.theLengthOfClain(cXingLian[i])>6)
				return this.findTheDoor(cXingLian[i][1], cXingLian[i][2]);
				else if(this.theLengthOfClain(cXingLian[i])<6)
					return this.findTheDoor(cXingLian[i][1], cXingLian[i][2]);
			}
		}
		for(i=0;i<numOfCXingLian;i++){
			if(cXingLian[i][0]==1){
				if(this.theLengthOfClain(cXingLian[i])==6)
					numOfShuangCOfFour++;
			}
		for(i=0;i<numOfCXingLian;i++){
			if(cXingLian[i][0]==2){
				if(this.theLengthOfClain(cXingLian[i])==3){
					return this.searchForTheSideOfBox(cXingLian[i][1]);
				}else if(this.theLengthOfClain(cXingLian[i])>4){
					return this.findTheDoor(cXingLian[i][1], cXingLian[i][2]);
				}
			}
		}
		for(i=0;i<numOfCXingLian;i++){
			if(cXingLian[i][0]==2){
				numOfCGeOfTwo++;
			}
		}
		for(i=0;i<numOfCXingLian;i++){
			if(numOfCGeOfTwo+numOfShuangCOfFour==1){
				if(cXingLian[i][0]==2){					
					if(this.theLengthOfClain(cXingLian[i])==4){
						int doRangGe=0;
						for(j=0;j<clains;j++){
							if(clain[j][0]==-2){
								if(theLengthOfClain(clain[j])==3||theLengthOfClain(clain[j])==4){
									doRangGe++;
								}
							}
						}
						if(doRangGe%2==0)
							return this.searchForTheSideOfBox(cXingLian[i][2], this.findTheDoor(cXingLian[i][1], cXingLian[i][2]));
						else
							return  this.searchForTheSideOfBox(cXingLian[i][1]);
					}
				}else if(cXingLian[i][0]==1){  
					if(this.theLengthOfClain(cXingLian[i])==6){
						int profit=0;
						for(j=0;j<clains;j++){
							if(clain[j][0]==-2){
								profit=profit+theLengthOfClain(clain[j])-2-2;
							}
							if(clain[j][0]==-3){
								profit=profit+theLengthOfClain(clain[j])-4-2;
							}
						}
						profit=profit+2;
						if(profit>clains*2-2+4){
							return this.findTheDoor(cXingLian[i][2], cXingLian[i][3]);
						}else{
							return this.findTheDoor(cXingLian[i][1], cXingLian[i][2]);
						}
						
					}
				}
				
			}else{
				 if(cXingLian[i][0]==1){
					return this.findTheDoor(cXingLian[i][1], cXingLian[i][2]);
				 }
				 else if(cXingLian[i][0]==2){
					return this.searchForTheSideOfBox(cXingLian[i][1]);
				}
			}
		}
		}
		return 0;
		
	}
	private boolean isZhunHouQi(){  
		boolean a=false;
		boolean b=false;
		for(i=0;i<5;i++)
			for(j=0;j<5;j++){
				if(box[i][j]==3)
					b=true;
			}
		for(i=0;i<5;i++)
			for(j=0;j<6;j++){
				if(row[i][j]==3)
					a=true;
				if(column[j][i]==3)
					a=true;
			}
		if((!a)&&b)
			return true;
		else
			return false;
	}
	public int theNextStep(){
		int boxOfFive=0;
		System.out.println("dfafewf");
		for(i=0;i<5;i++)
			for(j=0;j<5;j++){
				if(box[i][j]==2){
					newBox[i][j]=1;
				}
			}
		for(i=0;i<5;i++)
			for(j=0;j<5;j++){
				boxOfRangGe[i][j]=box[i][j];
			}
		for(i=0;i<5;i++)
			for(j=0;j<5;j++){
				if(box[i][j]==5)
					boxOfFive++;
			}
		if(boxOfFive==25){
			return -1;
		}
		if(boxOfFive==23){
			for(i=0;i<5;i++)
				for(j=0;j<5;j++){
					if(box[i][j]==3)
						return this.searchForTheSideOfBox(10*i+j);
				}
		}
		
		
		
		this.setTheValue(row, column, box);
		if(!qianQiYiGuo){
			if(this.isQianQi()){
				if(this.isZhunHouQi()){
					System.out.println("qian qi yi guo111111");
					qianQiYiGuo=true;
					return this.rangGe();
				}
					
				else
					return this.qianqi();
			}else{
				System.out.println("qian qi yi guo");
				qianQiYiGuo=true;
				return this.houqi();
			}
		}else if(this.theBoxOfThreeExist()){
			return this.rangGe();
			
		}else{
			return this.houqi();
		}
		
	}
}
