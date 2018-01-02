package redis;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import redis.clients.jedis.Jedis;

public class Client {
	/**
	 * 假设的用户的订单
	 */
	public static List<Map> list=new ArrayList<Map>();
	/**
	 * 模拟有多个用户 发送的订单请求  模拟2个 淘宝 
	 */
	static{
		Map map=new HashMap();
		map.put("cid", 1);
		map.put("count", 2);
		map.put("price", 200);
		list.add(map);
		Map map1=new HashMap();
		map1.put("cid", 2);
		map1.put("count", 1);
		map1.put("price", 10);
		list.add(map1);
	}
    static Jedis jedis=new Jedis();
    final static String ORDER_KEY="orderList";
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		for(int i=0;i<list.size();i++){
			final Map map=list.get(i); 
			jedis.rpush(ORDER_KEY.getBytes(),ObjectUtils.objectToByte(map));
		}
	}

}
