package com.util.fileUtil;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

/**
 * 
 * @ClassName: StringToPicture
 * @Description: ͼƬ��������
 * @author Mr.Wu
 * @date 2020��1��13������10:00:47
 *
 */
public class PictureProcessing {
	/**
	 * 
	 * @Title: createImage
	 * @author Mr.Wu
	 * @Description: ����ָ����strȥ����ͼƬ
	 * @param @param str
	 * @param @param ret
	 * @param @return
	 * @param @throws Exception ����
	 * @return byte[] ��������
	 * @throws
	 */
     public static  byte[] createImage(String str,HttpServletRequest ret) throws Exception{
       Font font=new Font("����",Font.BOLD,18);
     //��ȡfont����ʽӦ����str�ϵ���������
       Rectangle2D r=font.getStringBounds(str, new FontRenderContext(AffineTransform.getScaleInstance(1, 1),false,false));
     //��ȡ�����ַ��ĸ߶�
       int unitHeight=(int)Math.floor(r.getHeight());
     //��ȡ����str����font��ʽ�Ŀ�����������������+1��֤��Ⱦ�������������ַ�����ΪͼƬ�Ŀ��
       int width=(int)Math.round(r.getWidth())+1;
     //�ѵ����ַ��ĸ߶�+3��֤�߶Ⱦ����������ַ�����ΪͼƬ�ĸ߶�
       int height=unitHeight+3;
     //����ͼƬ
       BufferedImage image=new BufferedImage(width,height,BufferedImage.TYPE_INT_BGR);
       Graphics g=image.getGraphics();
       g.setColor(Color.WHITE);
     //���ð�ɫ�������ͼƬ,Ҳ���Ǳ���
       g.fillRect(0, 0, width, height);
     //�ڻ��ɺ�ɫ
       g.setColor(Color.black);
     //���û�������
       g.setFont(font);
     //�����ַ���
       g.drawString(str, 0, font.getSize());
       g.dispose();
   	   String realPath = ret.getServletContext().getRealPath("/");
       if (realPath!=null) {
    	   realPath=realPath.replace("\\","/");
    	   OutputStream ops = new FileOutputStream(new File(realPath+"/uploadFiles/"+new Date().getTime()+".jpg"));
           //���pngͼƬ��ָ��Ŀ¼
           ImageIO.write(image, "png", ops);
       }
       //����������
       ByteArrayOutputStream out = new ByteArrayOutputStream();
       boolean flag = ImageIO.write(image, "png", out);  
       byte[] b = out.toByteArray();
       return b; 
     }
}
