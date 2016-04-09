package com.nafaa.model;

import java.util.ArrayList;
import java.util.List;

public class World {
	
	private static List<Integer>players = new ArrayList<Integer>();

	public static List<Integer> getPlayers() {
		return players;
	}

	public static int getPlayersSize() {
		return players.size();
	}



}
