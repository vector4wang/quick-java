package com.feature.learn.headless;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 *
 * @author wangxc
 * @date: 2019-10-27 09:38
 *
 */
public class TestCHSGraphic {
	public static void main(String[] args) throws Exception {
		//设置Headless模式
//		System.setProperty("java.awt.headless", "true");
		BufferedImage bi = new BufferedImage(200, 100, BufferedImage.TYPE_INT_RGB);
		Graphics g = bi.getGraphics();
		String s = "Headless模式测试";
		g.drawString(new String(s.getBytes(), "GB2312"), 50, 50);
		ImageIO.write(bi, "jpeg", new File("test.jpg"));
	}
}
