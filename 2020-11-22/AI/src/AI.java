import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import java.io.*;

public class AI extends MIDlet
{
	Display display;
	MainCanvas mc;
	public AI(){
		display=Display.getDisplay(this);
		mc=new MainCanvas();
		display.setCurrent(mc);
	}
	public void startApp(){
	}
	public void destroyApp(boolean unc){
	}
	public void pauseApp(){
	}
}
class MainCanvas extends Canvas
{

	/*
	变量的声明
	语法：数据类型 变量名称（标识符）;
	*/
	int x,y;
	Image  heroImg[][]=new Image[4][3];                 //建立一个二维图像数组变量，分别赋值四个方向的三张图片。0是左方向，1是右方向，2是上方向，3是下方向
	Image currentImg;

		
	public MainCanvas(){
		try
		{
			/*
			给变量赋值
			语法：变量名称=value;
			*/
			x=110;
			y=125;
			for(int i=0;i<heroImg.length;i++)
			{
				for(int j=0;j<heroImg[i].length;j++)
				{
                    heroImg[i][j]=Image.createImage("/sayo"+i+j+".png");
			        
				}
              
			}
			
		    
			currentImg=heroImg[3][1];
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	public void paint(Graphics g){
		g.setColor(66,204,255);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,x,y,0);//120：X坐标、100：Y坐标
	}
	public void keyPressed(int keyCode){
		int action=getGameAction(keyCode);
		/*
		action的值：UP、DOWN、LEFT、RIGHT
		*/
		if(action==LEFT){                   //左
			/*
			实现转向代码
			*/
			currentImg=heroImg[0][1];
			x=x-3;
			if(x%2==0)
			{
				currentImg=heroImg[0][2];
			}else{
				currentImg=heroImg[0][0];
			}
			
		}
		  


			if(action==RIGHT){              //右
			/*
			实现转向代码
			*/
             currentImg=heroImg[1][1];
			x=x+3;
			if(x%2==0)
			{
				currentImg=heroImg[1][2];
			}else{
				currentImg=heroImg[1][0];
			}

			
		
		}
            

		 
			if(action==UP){                //上
			/*
			实现转向代码
			*/
			
			currentImg=heroImg[2][1];
            y=y-3;
			if(y%2==0)
			{
				currentImg=heroImg[2][2];
			}else{
				currentImg=heroImg[2][0];
			}
			
		
		}

          

			if(action==DOWN){          //下
			/*
			实现转向代码
			*/
			
			
			 y=y+3;
			if(y%2==0)
			{
				currentImg=heroImg[3][2];
			}else{
				currentImg=heroImg[3][0];
			}
			
		
		}
             repaint();
	}
}