package com.jiate.jiateremoteserver.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class SocketServer {

		private final static Logger log = LoggerFactory.getLogger(ServerSocket.class);


		public void startSocketServer(int port) throws IOException {
			ServerSocket server = new ServerSocket(port);
			log.info("============服务器开启============");
			//ExecutorService threaPool= Executors.newFixedThreadPool(2);
			while (true){
				//Runnable runnable=()->{
					try(	Socket socket =server.accept();
							InputStream inputStream =socket.getInputStream();){
						byte[] bytes=new byte[1024];
						int len;
						StringBuilder sb =new StringBuilder();
						while ((len = inputStream.read(bytes)) != -1) {
							// 注意指定编码格式，发送方和接收方一定要统一，建议使用UTF-8
							sb.append(new String(bytes, 0, len, "UTF-8"));
						}
						log.info("服务器接收到数据:{"+sb.toString()+"}");

					}catch (Exception e){
						log.error("服务器处理异常",e);

					}
				//};
				//threaPool.submit(runnable);
			}

		}

}
