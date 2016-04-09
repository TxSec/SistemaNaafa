package com.nafaa.net;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

import org.jboss.netty.bootstrap.ClientBootstrap;
import org.jboss.netty.channel.socket.nio.NioClientSocketChannelFactory;

public class Client {
	
	private ClientBootstrap bootstrap;
	
	public Client(){
		bootstrap = new ClientBootstrap(new NioClientSocketChannelFactory
				(Executors.newCachedThreadPool(),Executors.newCachedThreadPool()));
		bootstrap.setPipelineFactory(new NaafaPipelineClient());
		bootstrap.connect(new InetSocketAddress("localhost",43594));
	}

}
