package redis;

import org.junit.Test;

import redis.clients.jedis.Jedis;

public class Sets {
static final Jedis jedis=new Jedis();
//sadd	���ֵ
public static void main(String[] args) {
	jedis.sadd("1611","Ů","Ф����");
	jedis.close();
}
//smembers	��������
@Test
public void test(){
	jedis.smembers("1611");
	jedis.close();
}
//scard	��ȡkey�ĳ�Ա����
@Test
public void test1(){
	jedis.scard("1611");
	jedis.close();
}
//srem	ɾ��ָ����Ա
@Test
public void test2(){
	jedis.srem("1611", "Ф����");
	jedis.close();
}
//sismember	�жϳ�Ա�Ƿ����
@Test
public void test3(){
	jedis.sismember("1611", "Ф����");
	jedis.close();
}
//spop	�������һ��ֵ��ɾ����
@Test
public void test4(){
	jedis.spop("1611");
	jedis.close();
}
//srandmember	�������һ����Ա����ɾ����
@Test
public void test5(){
	jedis.srandmember("1611");
	jedis.close();
}
//smove	�ƶ�һ�����ϵĳ�Ա����һ������
@Test
public void test6(){
	jedis.smove("1611", "1611", "Ф����");
	jedis.close();
}
}
