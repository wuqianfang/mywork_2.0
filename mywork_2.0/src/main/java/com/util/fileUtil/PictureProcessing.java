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
 * @Description: 图片处理工具类
 * @author Mr.Wu
 * @date 2020年1月13日上午10:00:47
 *
 */
public class PictureProcessing {
	/**
	 * 
	 * @Title: createImage
	 * @author Mr.Wu
	 * @Description: 根据指定的str去生成图片
	 * @param @param str
	 * @param @param ret
	 * @param @return
	 * @param @throws Exception 参数
	 * @return byte[] 返回类型
	 * @throws
	 */
     public static  byte[] createImage(String str,HttpServletRequest ret) throws Exception{
       Font font=new Font("黑体",Font.BOLD,18);
     //获取font的样式应用在str上的整个矩形
       Rectangle2D r=font.getStringBounds(str, new FontRenderContext(AffineTransform.getScaleInstance(1, 1),false,false));
     //获取单个字符的高度
       int unitHeight=(int)Math.floor(r.getHeight());
     //获取整个str用了font样式的宽度这里用四舍五入后+1保证宽度绝对能容纳这个字符串作为图片的宽度
       int width=(int)Math.round(r.getWidth())+1;
     //把单个字符的高度+3保证高度绝对能容纳字符串作为图片的高度
       int height=unitHeight+3;
     //创建图片
       BufferedImage image=new BufferedImage(width,height,BufferedImage.TYPE_INT_BGR);
       Graphics g=image.getGraphics();
       g.setColor(Color.WHITE);
     //先用白色填充整张图片,也就是背景
       g.fillRect(0, 0, width, height);
     //在换成黑色
       g.setColor(Color.black);
     //设置画笔字体
       g.setFont(font);
     //画出字符串
       g.drawString(str, 0, font.getSize());
       g.dispose();
   	   String realPath = ret.getServletContext().getRealPath("/");
       if (realPath!=null) {
    	   realPath=realPath.replace("\\","/");
    	   OutputStream ops = new FileOutputStream(new File(realPath+"/uploadFiles/"+new Date().getTime()+".jpg"));
           //输出png图片到指定目录
           ImageIO.write(image, "png", ops);
       }
       //返回数据流
       ByteArrayOutputStream out = new ByteArrayOutputStream();
       boolean flag = ImageIO.write(image, "png", out);  
       byte[] b = out.toByteArray();
       return b; 
     }
}
