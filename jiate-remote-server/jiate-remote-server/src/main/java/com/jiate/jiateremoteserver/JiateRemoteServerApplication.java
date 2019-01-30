package com.jiate.jiateremoteserver;

import com.jiate.jiateremoteserver.service.SocketServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class JiateRemoteServerApplication {
		public static final Logger log = LoggerFactory.getLogger(JiateRemoteServerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(JiateRemoteServerApplication.class, args);
		SocketServer server = new SocketServer();
		try {
			server.startSocketServer(8088);
		} catch (IOException e) {
			log.error("服务器异常",e);
		}

	}

}

