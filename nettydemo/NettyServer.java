package com.netty.server;

import javax.xml.bind.helpers.ValidationEventImpl;

import com.netty.server.handler.DecodeHandler;
import com.netty.server.handler.EncodeHandler;
import com.netty.server.handler.ResolveHandler;

import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

public class NettyServer {

	
	public void start(int port){
		EventLoopGroup group=new NioEventLoopGroup();
		ServerBootstrap bootstrap=new ServerBootstrap();
		bootstrap.group(group)
		.channel(NioServerSocketChannel.class)
		.childHandler(new ChannelInitializer<SocketChannel>() {

			@Override
			protected void initChannel(SocketChannel sc) throws Exception {
				sc.pipeline()
				.addLast(new EncodeHandler()) //编码
				.addLast(new DecodeHandler()) //解码
				.addLast(new ResolveHandler()) //输入流 处理
				;  
				
			}
		}).option(ChannelOption.SO_BACKLOG, 128)   //用于临时存放已经完成三次握手的请求队列的最大长度
        .childOption(ChannelOption.SO_KEEPALIVE, true); //启用心跳保活机制
		
		try {
			//绑定端口地址
			ChannelFuture cf=bootstrap.bind(port).sync();
			cf.channel().closeFuture().sync();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		group.shutdownGracefully();
		
		
	}
	public static void main(String[] args) {
		NettyServer server=new NettyServer();
		server.start(20000);
		
	}
	
	
}
