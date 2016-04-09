package com.nafaa.net;

import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelHandler;

import com.nafaa.model.World;

public class ConnectionHandlerClient extends  SimpleChannelHandler {
	
	
	@Override
	public void messageReceived(ChannelHandlerContext ctx, MessageEvent e)
			throws Exception {
		//Packet packet = (Packet) e.getMessage();
		//engine.pushTask(new ChannelMessageTask(e.getChannel(), packet));
	}

}
