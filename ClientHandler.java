package com.netty.client;

import org.springframework.util.SerializationUtils;

import com.netty.bean.RpcRequest;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.SimpleChannelInboundHandler;

public class ClientHandler extends ChannelInboundHandlerAdapter {
		
		//发送数据
		@Override
		public void channelActive(ChannelHandlerContext ctx) throws Exception {
			
			RpcRequest request=new RpcRequest();
			
			request.setInterfaceName("service");
			request.setRequestId("uuid13212");
			byte [] out=SerializationUtils.serialize(request); //序列化
			ByteBuf outbuf=ctx.alloc().buffer(out.length*4);
			outbuf.writeBytes(out); //写入到buf中
			ctx.writeAndFlush(outbuf);
			
		}
		//接受来自server的数据
		@Override
		public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
			System.out.println("客户端接收数据");
			ByteBuf buf=(ByteBuf)msg;
			byte [] bytes=new byte[buf.readableBytes()];
			buf.readBytes(bytes); //读出到bytes字节数组中
			
			Object object=SerializationUtils.deserialize(bytes);
			
			System.out.println("客户端获取的响应:"+object);
			
		}
		
		
		
		
}
