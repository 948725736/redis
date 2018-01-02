package redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

/**
 * 事务的操作
 * save 900 1
   save 300 10
   save 60 10000
   
   根据数据的频率来决定保存的策略
    save 60 10000  60秒之内 如果有10000次的数据改变 写入磁盘
    save 300 10    300秒后 如果存在10次的数据改变写入磁盘
    save 900 1     900秒 如果存在1次数据改变写入磁盘
 
 比如 多台redis 同时用于缓存数据时  怎么确定 set的键值对 写入哪一台服务器
   1
   2
   3
  set("1","{name:'',price:''}")   
  set("99","{name:'',price:''}")      
  set("86","{name:'',price:''}") 
  set("101","{name:'',price:''}") 
  hash取余法
  1%3=1
  99%3=0
  86%3=2
  101%3=2
 * 
 * 
 * @author Administrator
 *
 */
public class Trans {
	static Jedis redis=new Jedis();
	public static void main(String[] args) {
		redis.auth("123456");
		Transaction trans=redis.multi();
		trans.set("a", "1");
		trans.zadd("etop1611", 100, "clx");
		trans.zadd("etop1611", 20, "wj");
		trans.exec();
//		Strings str=null;
//		str.toString();
	}
}
