package com.netty.server.handler;

import org.springframework.util.SerializationUtils;

import com.netty.bean.RpcRequest;
import com.netty.bean.RpcResponse;
import com.util.CommUtil;
import com.util.ProtostuffUtils;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class EncodeHandler extends MessageToByteEncoder{

	@Override
	protected void encode(ChannelHandlerContext ctx, Object obj, ByteBuf msg) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("服务端编码 ");
		System.out.println(" object:"+obj);
		
//		byte [] bytes=SerializationUtils.serialize((RpcRequest)obj);
		byte [] bytes=ProtostuffUtils.serializer(obj);
		
		msg.writeInt(bytes.length);
		msg.writeBytes(bytes);
	}

}
