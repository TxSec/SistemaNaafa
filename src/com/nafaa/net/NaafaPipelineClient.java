package com.nafaa.net;

import org.jboss.netty.channel.ChannelPipeline;

import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.handler.codec.string.StringDecoder;
import org.jboss.netty.handler.codec.string.StringEncoder;


public class NaafaPipelineClient implements ChannelPipelineFactory {

	@Override
	public ChannelPipeline getPipeline() throws Exception {
		ChannelPipeline pipeline = Channels.pipeline();
		//pipeline.addLast("counter", new ThroughputCounter());
		pipeline.addLast("protocolDecoder", new StringDecoder());
		pipeline.addLast("protocolEncoder", new StringEncoder());
		pipeline.addLast("handler", new ConnectionHandlerClient());
		return pipeline;
	}

}
