package com.pay.component.socket;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ClientSocket {

	private static final String HOST = "127.0.0.1";
	private static final int BUFFER_SIZE = 1024;
	private static final int PORT = 20001;

	public static String send(String requestData) throws Exception {
		Socket client = new Socket(HOST, PORT);
		String outMessage = "";
		BufferedReader in = null;
		String line = "";
		InputStream inputStream = new ByteArrayInputStream(requestData.getBytes());
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		PrintWriter out = new PrintWriter(client.getOutputStream());
		log.info("SOCKET 发送开始");
		while ((line = bufferedReader.readLine()) != null) {
			log.debug(line);
			out.println(line);
			out.flush();
		}
		log.info("SOCKET 发送结束");
		in = new BufferedReader(new InputStreamReader(client.getInputStream()));
		outMessage = in.readLine();
		log.info("读取返回信息结束");
		out.close();
		in.close();
		client.close();
		log.info("SOCKET关闭连接");
		return outMessage;
	}

}
