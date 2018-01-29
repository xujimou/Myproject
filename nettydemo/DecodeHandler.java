package com.netty.server.handler;

import java.rmi.activation.ActivationGroupDesc.CommandEnvironment;
import java.util.List;

import org.springframework.util.SerializationUtils;

import com.netty.bean.RpcRequest;
import com.netty.bean.RpcResponse;
import com.util.CommUtil;
import com.util.ProtostuffUtils;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

public class DecodeHandler extends ByteToMessageDecoder{

	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf msg, List<Object> list) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("服务端解码..");
		
		ByteBuf buf=(ByteBuf)msg;
		byte [] bytes=new byte[buf.readableBytes()];
		buf.readBytes(bytes);
		
		RpcRequest request=ProtostuffUtils.deserializer(bytes, RpcRequest.class);
		
//		Object request=SerializationUtils.deserialize(bytes);
		
		System.out.println("msg反序列化后的数据:"+request);
		
		
		list.add(request);
		
	}

}
