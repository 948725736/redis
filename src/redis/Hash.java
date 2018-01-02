package redis;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import redis.clients.jedis.Jedis;

public class Hash {
	 static final Jedis jedis=new Jedis();
	//hmset����ͬʱ���ö��field��value

	public static void main(String[] args) {
		Map map=new HashMap();
		map.put("name", "Ф����");
		map.put("sex","Ů");
		map.put("age", "19");
		jedis.hmset("user:1", map);
		jedis.close();
	}
	//hset	��key�е�filed�ֶθ�ֵ
	@Test
public void test(){
	Map map=new HashMap();
	map.put("name", "Ф����");
	map.put("sex","Ů");
	map.put("age", "19");
	jedis.hset("user:1", "id", "1");
	jedis.close();
}
	//hget 	��ȡ������filed�ֶε�ֵ
	@Test
public void test1(){
	Map map=new HashMap();
	map.put("name", "Ф����");
	map.put("sex","Ů");
	map.put("age", "19");
	jedis.hget("user:1", "id");
	jedis.close();
}
	//hexists	�ж�key���Ƿ����filed
	@Test
	public void test2(){
		Map map=new HashMap();
		map.put("name", "Ф����");
		map.put("sex","Ů");
		map.put("age", "19");
		jedis.hexists("user:1", "id");
		jedis.close();
	}
	//hlen	��ȡkey��filed������
	@Test
	public void test3(){
		Map map=new HashMap();
		map.put("name", "Ф����");
		map.put("sex","Ů");
		map.put("age", "19");
		jedis.hlen("user:1");
		jedis.close();
	}
	//hdel	ɾ��key�е�filed�ֶ�
	@Test
	public void test4(){
		Map map=new HashMap();
		map.put("name", "Ф����");
		map.put("sex","Ů");
		map.put("age", "19");
		jedis.hdel("user:1", "name");
		jedis.close();
	}
	//hgetall	��ȡkey�����е�field��value
	@Test
	public void test5(){
		Map map=new HashMap();
		map.put("name", "Ф����");
		map.put("sex","Ů");
		map.put("age", "19");
		jedis.hgetAll("user:1");
		jedis.close();
	}
	//hmget	ͬʱ��ȡ���field��ֵ
	@Test
	public void test6(){
		Map map=new HashMap();
		map.put("name", "Ф����");
		map.put("sex","Ů");
		map.put("age", "19");
		jedis.hmget("user:1", "sex");
		jedis.close();
	}
	//hsetnx	���field�����ڸ�ֵ�����򲻲���
	@Test
	public void test7(){
		Map map=new HashMap();
		map.put("name", "Ф����");
		map.put("sex","Ů");
		map.put("age", "19");
		jedis.hsetnx("user:1", "name", "����");
		jedis.close();
	}
	//hkeys	��ȡ���е�key
	@Test
	public void test8(){
		Map map=new HashMap();
		map.put("name", "Ф����");
		map.put("sex","Ů");
		map.put("age", "19");
		jedis.hkeys("user:1");
		jedis.close();
	}
	
}
