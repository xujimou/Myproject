package com.netty.server.handler;

import java.util.List;

import com.netty.bean.RpcRequest;
import com.netty.bean.RpcResponse;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class ResolveHandler extends SimpleChannelInboundHandler{

	
	protected void channelRead0(ChannelHandlerContext ctx, Object obj) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("服务端处理...");
		System.out.println("服务端接受的数据:"+obj);
		RpcResponse response=new RpcResponse();
		RpcRequest request=(RpcRequest)obj;
		
		response.setResult(request.getInterfaceName());
		response.setRequestId(request.getRequestId());
		
		ctx.writeAndFlush(response);
	}

}
