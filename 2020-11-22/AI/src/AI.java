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
	Image  heroImg[][]=new Image[4][3];                 //����һ����άͼ������������ֱ�ֵ�ĸ����������ͼƬ��0������1���ҷ���2���Ϸ���3���·���
	Image currentImg;

		
	public MainCanvas(){
		try
		{
			/*
			��������ֵ
			�﷨����������=value;
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
			currentImg=heroImg[0][1];
			x=x-3;
			if(x%2==0)
			{
				currentImg=heroImg[0][2];
			}else{
				currentImg=heroImg[0][0];
			}
			
		}
		  


			if(action==RIGHT){              //��
			/*
			ʵ��ת�����
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
            

		 
			if(action==UP){                //��
			/*
			ʵ��ת�����
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

          

			if(action==DOWN){          //��
			/*
			ʵ��ת�����
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