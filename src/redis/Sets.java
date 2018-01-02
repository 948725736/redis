package redis;

import org.junit.Test;

import redis.clients.jedis.Jedis;

public class Sets {
static final Jedis jedis=new Jedis();
//sadd	添加值
public static void main(String[] args) {
	jedis.sadd("1611","女","肖慧婷");
	jedis.close();
}
//smembers	遍历集合
@Test
public void test(){
	jedis.smembers("1611");
	jedis.close();
}
//scard	获取key的成员数量
@Test
public void test1(){
	jedis.scard("1611");
	jedis.close();
}
//srem	删除指定成员
@Test
public void test2(){
	jedis.srem("1611", "肖慧婷");
	jedis.close();
}
//sismember	判断成员是否存在
@Test
public void test3(){
	jedis.sismember("1611", "肖慧婷");
	jedis.close();
}
//spop	随机弹出一个值（删除）
@Test
public void test4(){
	jedis.spop("1611");
	jedis.close();
}
//srandmember	随机弹出一个成员（不删除）
@Test
public void test5(){
	jedis.srandmember("1611");
	jedis.close();
}
//smove	移动一个集合的成员到另一个集合
@Test
public void test6(){
	jedis.smove("1611", "1611", "肖慧婷");
	jedis.close();
}
}
