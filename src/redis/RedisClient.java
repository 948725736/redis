package redis;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import redis.clients.jedis.Jedis;
/**
 * 
 * @author Administrator
 *
 */
public class RedisClient {

	public static Jedis jedis;
	/**
	 * 
	 * redis-cli -h localhost -p 6379
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		String host="localhost";
		String port="8900";
		for(int i=0;i<args.length;i++){
			if(args[i].equals("-h")){
				host=args[i+1];
			}
			if(args[i].equals("-p")){
				port=args[i+1];
			}
		}
		jedis=new Jedis(host,Integer.parseInt(port));
		Scanner s=new Scanner(System.in);
		while(true){
			System.out.print(host+":"+port+">");
			String command=s.nextLine();
			//  set 键         值
			command=command.replaceAll(" +", " ").trim();
			if(command.startsWith("set ")){
				String[] c=command.split(" ");
				String key=c[1];
				String value=c[2];
				jedis.set(key, value);
			}
			// get 键
			if(command.startsWith("get ")){
				String[] c=command.split(" ");
				String key=c[1];
				String value=jedis.get(key);
				System.out.println(value);
			}
			//append  追加字符串
			if(command.startsWith("append ")){
				String[] c=command.split(" ");
				String key=c[1];
				Long value=jedis.append(key, c[2]);
				System.out.println(value);
			}
			//incr	自增（+1）
			if(command.startsWith("incr ")){
				String[] c=command.split(" ");
				String key=c[1];
				Long value=jedis.incr(key);
				System.out.println(value);
			}
			//decr	自减（-1）
			if(command.startsWith("decr ")){
				String[] c=command.split(" ");
				String key=c[1];
				Long value=jedis.decr(key);
				System.out.println(value);
			}
			//strlen	返回key的值的长度
			if(command.startsWith("strlen ")){
				String[] c=command.split(" ");
				String key=c[1];
				Long value=jedis.strlen(key);
				System.out.println(value);
			}
			//hexists	判断key中是否存在filed
			if(command.startsWith("hexists ")){
				String[] c=command.split(" ");
				String key=c[1];
				Boolean value=jedis.hexists(key, c[2]);
				System.out.println(value);
			}
			//hlen	获取key中filed的数量
			if(command.startsWith("hlen ")){
			String[] c=command.split(" ");
			String key=c[1];
			Long value=jedis.hlen(key);
			System.out.println(value);
		}
		//hdel	删除key中的filed字段
		if(command.startsWith("hdel ")){
			String[] c=command.split(" ");
			String key=c[1];
			String[]fields=new String[c.length-2];
			int index=0;
			for(int i=2;i<c.length;i++){
				fields[index++]=c[i];
			}
			Long value=jedis.hdel(key, fields);
			System.out.println(value);
		}
		//lpush	在list头部添加值
		if(command.startsWith("lpush ")){
			String[] c=command.split(" ");
			String key=c[1];
			Long value=jedis.lpush(key, c[2]);
			System.out.println(value);
		}
		//rpush	在list尾部添加值
		if(command.startsWith("rpush")){
			String[] c=command.split(" ");
			String key=c[1];
			Long value=jedis.rpush(key, c[2]);
			System.out.println(value);
		}
		//lrange	获取指定位置的数据
		if(command.startsWith("lrange ")){
		String[] c=command.split(" ");
		String key=c[1];
		System.out.println(jedis.lrange(key, Integer.parseInt(c[2]), Integer.parseInt(c[3])));
	}
		//lpop	从头部弹出key的值（删除）
		if(command.startsWith("lpop	 ")){
			String[] c=command.split(" ");
			String key=c[1];
			String value=jedis.lpop(c[1]);
			System.out.println(value);
		}
		//rpop	从尾部弹出key的值（删除）
		if(command.startsWith("rpop	 ")){
			String[] c=command.split(" ");
			String key=c[1];
			String value=jedis.rpop(c[1]);
			System.out.println(value);
		}
		//sadd	添加值
		if(command.startsWith("sadd	 ")){
			String[] c=command.split(" ");
			String key=c[1];
			String[]members=new String[c.length-2];
			int index=0;
			for(int i=2;i<c.length;i++){
				members[index++]=c[i];
			}
			Long value=jedis.sadd(key,members);
			System.out.println(value);
		}
		//smembers	遍历集合
		if(command.startsWith("smembers ")){
			String[] c=command.split(" ");
			String key=c[1];
			Set<String> value=jedis.smembers(key);
			System.out.println(value);
		}
		//	scard	获取key的成员数量
		if(command.startsWith("scard ")){
		String[] c=command.split(" ");
		String key=c[1];
		Long value=jedis.scard(key);
		System.out.println(value);
	}
		//srem	删除指定成员
		if(command.startsWith("srem ")){
			String[] c=command.split(" ");
			String key=c[1];
			String[]members=new String[c.length-2];
			int index=0;
			for(int i=2;i<c.length;i++){
				members[index++]=c[i];
			}
			Long value=jedis.srem(key, members);
			System.out.println(value);
		}
		//sismember	判断成员是否存在
		if(command.startsWith("sismember ")){
		String[] c=command.split(" ");
		String key=c[1];
		Boolean value=jedis.sismember(key, c[1]);
		System.out.println(value);
	}
		//spop	随机弹出一个值（删除）
		if(command.startsWith("spop	 ")){
			String[] c=command.split(" ");
			String key=c[1];
			String value=jedis.spop(key);
			System.out.println(value);
		}
		//zadd	添加成员
		if(command.startsWith("zadd	 ")){
			String[] c=command.split(" ");
			String key=c[1];
			Map<String,Double> score=new HashMap<>();
			for(int i=2;i<c.length;i++){
				String value=c[i];
				String ke=c[++i];
				score.put(ke,Double.valueOf(value));
			}
			Long value=jedis.zadd(key,score);
			System.out.println(value);
		}
		//zcard	获取成员数量
		if(command.startsWith("zcard ")){
			String[] c=command.split(" ");
			String key=c[1];
			Long value=jedis.zcard(key);
			System.out.println(value);
		}
		//zcount	获取指定分数之间的成员数量
		if(command.startsWith("zcount	 ")){
			String[] c=command.split(" ");
			String key=c[1];
			Long value=jedis.zcount(key, c[1], c[2]);
			System.out.println(value);
		}
		//zrange	遍历指定下标之间的成员[及分数](分数从小到大排列）
		if(command.startsWith("zrange	 ")){
			String[] c=command.split(" ");
			String key=c[1];
			String start=c[2];
			String end=c[3];
			Set<String> value=jedis.zrange(key,Long.valueOf(start),Long.valueOf(end));
			System.out.println(value);
		}
		//zrevrange	遍历指定成员[及分数]（分数从大到小排列）
		if(command.startsWith("zrevrange	 ")){
			String[] c=command.split(" ");
			String key=c[1];
			String start=c[2];
			String end=c[3];
			Set<String> value=jedis.zrange(key,Long.valueOf(start),Long.valueOf(end));
			System.out.println(value);
		}
		//select 选择数据库
		if(command.startsWith("rpop	 ")){
			String[] c=command.split(" ");
			String key=c[1];
			String value=jedis.select(Integer.valueOf(key));
			System.out.println(value);
		}
		//hmset	同时设置多个field和value
		if(command.startsWith("hmset	 ")){
			String[] c=command.split(" ");
			String key=c[1];
			Map<String,String> hash=new HashMap<>();
			for(int i=2;i<c.length;i++){
				String ke=c[i];
				String value=c[++i];
				hash.put(ke, value);
			}
			String value=jedis.hmset(key,hash);
			System.out.println(value);
		}
		//ping 检查链接是否存活 
		if(command.startsWith("ping	 ")){
			System.out.println("pong");
		}
		//echo 在命令行打印内容
		if(command.startsWith("echo	 ")){
			String[] c=command.split(" ");
			String key=c[1];
			String value=jedis.echo(key);
			System.out.println(value);
		}
		//quit 退出客户端
		if(command.startsWith("quit	 ")){
			System.out.println("quit");
		}
		//dbsize 返回当前数据库中key的数目
		if(command.startsWith("dbsize	 ")){
			String[] c=command.split(" ");
			String key=c[1];
			Long value=jedis.dbSize();
			System.out.println(value);
		}
		//flushdb 删除当前数据库中的所有key
		if(command.startsWith("flushdb ")){
			String[] c=command.split(" ");  
			String key=c[1];
			String value=jedis.flushDB();
			System.out.println(value);
		}
		//flushall 删除所有数据库中的所有key
		if(command.startsWith("flushall	 ")){
			String[] c=command.split(" ");
			String key=c[1];
			String value=jedis.flushAll();
			System.out.println(value);
		}
		//hgetall 获取key中所有的field和value
		if(command.startsWith("hgetall	 ")){
			String[] c=command.split(" ");
			String key=c[1];
			Map<String, String> value=jedis.hgetAll(key);
			System.out.println(value);
		}
		//save
		if(command.startsWith("save	 ")){
			jedis.save();
		}
			}
		}
	}
