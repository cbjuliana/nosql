package redinsgo;

import redis.clients.jedis.Jedis;

public class Redis {

	private static Jedis instance;

	public static Jedis getInstance() {
		if (instance == null) {
			instance = new Jedis("localhost");
		}
		return instance;
	}

}
