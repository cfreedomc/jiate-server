package com.jiate.jiateremoteserver.service;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class PortClient {


	public static void main(String[] args) {
		String host="47.98.135.28";
		//String host="127.0.0.1";
		int port =8088;
		try(Socket socket=new Socket(host,port);
				OutputStream outputStream=socket.getOutputStream()) {
			String message = "hello";
			socket.getOutputStream().write(message.getBytes("UTF-8"));

		}catch (Exception e){
			e.printStackTrace();
		}

	}
}
