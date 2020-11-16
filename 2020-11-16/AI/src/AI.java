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
	����������
	�﷨���������� �������ƣ���ʶ����;
	*/
	int x,y;
	Image downImg,downWalkImg1,downWalkImg2,leftImg,leftWalkImg1, leftWalkImg2,rightImg,rightWalkImg1,rightWalkImg2,upImg,upWalkImg1,upWalkImg2,currentImg;
	public MainCanvas(){
		try
		{
			/*
			��������ֵ
			�﷨����������=value;
			*/
			x=110;
			y=125;
			downImg=Image.createImage("/sayo10.png");
            downWalkImg1=Image.createImage("/sayo20.png");
			downWalkImg2=Image.createImage("/sayo00.png");
			leftImg=Image.createImage("/sayo12.png");
			leftWalkImg1=Image.createImage("/sayo22.png");
            leftWalkImg2=Image.createImage("/sayo02.png");
            rightImg=Image.createImage("/sayo16.png");
			rightWalkImg1=Image.createImage("/sayo26.png");
			rightWalkImg2=Image.createImage("/sayo06.png");
			upImg=Image.createImage("/sayo14.png");
			upWalkImg1=Image.createImage("/sayo04.png");
		    upWalkImg2=Image.createImage("/sayo24.png");
			currentImg=downImg;
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	public void paint(Graphics g){
		g.setColor(66,204,255);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,x,y,0);//120��X���ꡢ100��Y����
	}
	public void keyPressed(int keyCode){
		int action=getGameAction(keyCode);
		/*
		action��ֵ��UP��DOWN��LEFT��RIGHT
		*/
		if(action==LEFT){                   //��
			/*
			ʵ��ת�����
			*/
			currentImg=leftImg;
			x=x-3;
			if(x%2==0)
			{
				currentImg=leftWalkImg1;
			}else{
				currentImg=leftWalkImg2;
			}
			
		}
		  


			if(action==RIGHT){              //��
			/*
			ʵ��ת�����
			*/
             currentImg=rightImg;
			x=x+3;
			if(x%2==0)
			{
				currentImg=rightWalkImg1;
			}else{
				currentImg=rightWalkImg2;
			}

			
		
		}
            

		 
			if(action==UP){                //��
			/*
			ʵ��ת�����
			*/
			
			currentImg=upImg;
            y=y-3;
			if(y%2==0)
			{
				currentImg=upWalkImg1;
			}else{
				currentImg=upWalkImg2;
			}
			
		
		}

          

			if(action==DOWN){          //��
			/*
			ʵ��ת�����
			*/
			
			
			 y=y+3;
			if(y%2==0)
			{
				currentImg=downWalkImg1;
			}else{
				currentImg=downWalkImg2;
			}
			
		
		}
             repaint();
	}
}