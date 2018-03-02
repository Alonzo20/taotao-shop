package com.taotao.controller;

import java.io.File;
import java.io.FileInputStream;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.junit.Test;

public class FTPTest {

	@Test
	public void testFtpClient() throws Exception {
		FTPClient ftpClient = new FTPClient();
		ftpClient.connect("192.168.1.115",21);
		
		ftpClient.login("ftpuser", "ftpuser");
		FileInputStream inputStream = new FileInputStream(new File(
				"D:\\2.jpg"));
		ftpClient.changeWorkingDirectory("/home/ftpuser/www/images");
		ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
		
		ftpClient.storeFile("123.jpg", inputStream);
		inputStream.close();
		ftpClient.logout();
	}
	
	
	 
}
