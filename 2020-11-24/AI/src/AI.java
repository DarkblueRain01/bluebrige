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
			x=x-3;
            changePicAndDirectionX(0);
			
		}
		  


			if(action==RIGHT){              //��
			/*
			ʵ��ת�����
			*/
             
			x=x+3;
			changePicAndDirectionX(1);

			
		
		}
            

		 
			if(action==UP){                //��
			/*
			ʵ��ת�����
			*/
            y=y-3;
            changePicAndDirectionY(2);
		
		}

          

			if(action==DOWN){          //��
			/*
			ʵ��ת�����
			*/
			
			 y=y+3;
			changePicAndDirectionY(3);
		
		}
             repaint();
	}



	public void changePicAndDirectionX(int direction)
	{
          currentImg=heroImg[direction][1];
          if(x%2==0)
			{
				currentImg=heroImg[direction][2];
			}else{
				currentImg=heroImg[direction][0];
			}
	}
    

	public void changePicAndDirectionY(int direction)
	{
          currentImg=heroImg[direction][1];
          if(y%2==0)
			{
				currentImg=heroImg[direction][2];
			}else{
				currentImg=heroImg[direction][0];
			}
	}

}






			
			