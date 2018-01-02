package redis;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import redis.clients.jedis.Jedis;

public class Hash {
	 static final Jedis jedis=new Jedis();
	//hmset命令同时设置多个field和value

	public static void main(String[] args) {
		Map map=new HashMap();
		map.put("name", "肖慧婷");
		map.put("sex","女");
		map.put("age", "19");
		jedis.hmset("user:1", map);
		jedis.close();
	}
	//hset	给key中的filed字段赋值
	@Test
public void test(){
	Map map=new HashMap();
	map.put("name", "肖慧婷");
	map.put("sex","女");
	map.put("age", "19");
	jedis.hset("user:1", "id", "1");
	jedis.close();
}
	//hget 	获取可以中filed字段的值
	@Test
public void test1(){
	Map map=new HashMap();
	map.put("name", "肖慧婷");
	map.put("sex","女");
	map.put("age", "19");
	jedis.hget("user:1", "id");
	jedis.close();
}
	//hexists	判断key中是否存在filed
	@Test
	public void test2(){
		Map map=new HashMap();
		map.put("name", "肖慧婷");
		map.put("sex","女");
		map.put("age", "19");
		jedis.hexists("user:1", "id");
		jedis.close();
	}
	//hlen	获取key中filed的数量
	@Test
	public void test3(){
		Map map=new HashMap();
		map.put("name", "肖慧婷");
		map.put("sex","女");
		map.put("age", "19");
		jedis.hlen("user:1");
		jedis.close();
	}
	//hdel	删除key中的filed字段
	@Test
	public void test4(){
		Map map=new HashMap();
		map.put("name", "肖慧婷");
		map.put("sex","女");
		map.put("age", "19");
		jedis.hdel("user:1", "name");
		jedis.close();
	}
	//hgetall	获取key中所有的field和value
	@Test
	public void test5(){
		Map map=new HashMap();
		map.put("name", "肖慧婷");
		map.put("sex","女");
		map.put("age", "19");
		jedis.hgetAll("user:1");
		jedis.close();
	}
	//hmget	同时获取多个field的值
	@Test
	public void test6(){
		Map map=new HashMap();
		map.put("name", "肖慧婷");
		map.put("sex","女");
		map.put("age", "19");
		jedis.hmget("user:1", "sex");
		jedis.close();
	}
	//hsetnx	如果field不存在赋值，否则不操作
	@Test
	public void test7(){
		Map map=new HashMap();
		map.put("name", "肖慧婷");
		map.put("sex","女");
		map.put("age", "19");
		jedis.hsetnx("user:1", "name", "张三");
		jedis.close();
	}
	//hkeys	获取所有的key
	@Test
	public void test8(){
		Map map=new HashMap();
		map.put("name", "肖慧婷");
		map.put("sex","女");
		map.put("age", "19");
		jedis.hkeys("user:1");
		jedis.close();
	}
	
}
