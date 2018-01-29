package com.netty.client.handler;

import java.util.List;

import com.netty.bean.RpcRequest;
import com.netty.bean.RpcResponse;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class ClientResolveHandler extends SimpleChannelInboundHandler{

	
	protected void channelRead0(ChannelHandlerContext ctx, Object obj) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("客户端处理...");
		System.out.println("显示客户端接受响应数据:"+obj);
		RpcResponse request=(RpcResponse)obj;
		
		
	}

}
