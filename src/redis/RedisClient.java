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
			//  set ��         ֵ
			command=command.replaceAll(" +", " ").trim();
			if(command.startsWith("set ")){
				String[] c=command.split(" ");
				String key=c[1];
				String value=c[2];
				jedis.set(key, value);
			}
			// get ��
			if(command.startsWith("get ")){
				String[] c=command.split(" ");
				String key=c[1];
				String value=jedis.get(key);
				System.out.println(value);
			}
			//append  ׷���ַ���
			if(command.startsWith("append ")){
				String[] c=command.split(" ");
				String key=c[1];
				Long value=jedis.append(key, c[2]);
				System.out.println(value);
			}
			//incr	������+1��
			if(command.startsWith("incr ")){
				String[] c=command.split(" ");
				String key=c[1];
				Long value=jedis.incr(key);
				System.out.println(value);
			}
			//decr	�Լ���-1��
			if(command.startsWith("decr ")){
				String[] c=command.split(" ");
				String key=c[1];
				Long value=jedis.decr(key);
				System.out.println(value);
			}
			//strlen	����key��ֵ�ĳ���
			if(command.startsWith("strlen ")){
				String[] c=command.split(" ");
				String key=c[1];
				Long value=jedis.strlen(key);
				System.out.println(value);
			}
			//hexists	�ж�key���Ƿ����filed
			if(command.startsWith("hexists ")){
				String[] c=command.split(" ");
				String key=c[1];
				Boolean value=jedis.hexists(key, c[2]);
				System.out.println(value);
			}
			//hlen	��ȡkey��filed������
			if(command.startsWith("hlen ")){
			String[] c=command.split(" ");
			String key=c[1];
			Long value=jedis.hlen(key);
			System.out.println(value);
		}
		//hdel	ɾ��key�е�filed�ֶ�
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
		//lpush	��listͷ�����ֵ
		if(command.startsWith("lpush ")){
			String[] c=command.split(" ");
			String key=c[1];
			Long value=jedis.lpush(key, c[2]);
			System.out.println(value);
		}
		//rpush	��listβ�����ֵ
		if(command.startsWith("rpush")){
			String[] c=command.split(" ");
			String key=c[1];
			Long value=jedis.rpush(key, c[2]);
			System.out.println(value);
		}
		//lrange	��ȡָ��λ�õ�����
		if(command.startsWith("lrange ")){
		String[] c=command.split(" ");
		String key=c[1];
		System.out.println(jedis.lrange(key, Integer.parseInt(c[2]), Integer.parseInt(c[3])));
	}
		//lpop	��ͷ������key��ֵ��ɾ����
		if(command.startsWith("lpop	 ")){
			String[] c=command.split(" ");
			String key=c[1];
			String value=jedis.lpop(c[1]);
			System.out.println(value);
		}
		//rpop	��β������key��ֵ��ɾ����
		if(command.startsWith("rpop	 ")){
			String[] c=command.split(" ");
			String key=c[1];
			String value=jedis.rpop(c[1]);
			System.out.println(value);
		}
		//sadd	���ֵ
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
		//smembers	��������
		if(command.startsWith("smembers ")){
			String[] c=command.split(" ");
			String key=c[1];
			Set<String> value=jedis.smembers(key);
			System.out.println(value);
		}
		//	scard	��ȡkey�ĳ�Ա����
		if(command.startsWith("scard ")){
		String[] c=command.split(" ");
		String key=c[1];
		Long value=jedis.scard(key);
		System.out.println(value);
	}
		//srem	ɾ��ָ����Ա
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
		//sismember	�жϳ�Ա�Ƿ����
		if(command.startsWith("sismember ")){
		String[] c=command.split(" ");
		String key=c[1];
		Boolean value=jedis.sismember(key, c[1]);
		System.out.println(value);
	}
		//spop	�������һ��ֵ��ɾ����
		if(command.startsWith("spop	 ")){
			String[] c=command.split(" ");
			String key=c[1];
			String value=jedis.spop(key);
			System.out.println(value);
		}
		//zadd	��ӳ�Ա
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
		//zcard	��ȡ��Ա����
		if(command.startsWith("zcard ")){
			String[] c=command.split(" ");
			String key=c[1];
			Long value=jedis.zcard(key);
			System.out.println(value);
		}
		//zcount	��ȡָ������֮��ĳ�Ա����
		if(command.startsWith("zcount	 ")){
			String[] c=command.split(" ");
			String key=c[1];
			Long value=jedis.zcount(key, c[1], c[2]);
			System.out.println(value);
		}
		//zrange	����ָ���±�֮��ĳ�Ա[������](������С�������У�
		if(command.startsWith("zrange	 ")){
			String[] c=command.split(" ");
			String key=c[1];
			String start=c[2];
			String end=c[3];
			Set<String> value=jedis.zrange(key,Long.valueOf(start),Long.valueOf(end));
			System.out.println(value);
		}
		//zrevrange	����ָ����Ա[������]�������Ӵ�С���У�
		if(command.startsWith("zrevrange	 ")){
			String[] c=command.split(" ");
			String key=c[1];
			String start=c[2];
			String end=c[3];
			Set<String> value=jedis.zrange(key,Long.valueOf(start),Long.valueOf(end));
			System.out.println(value);
		}
		//select ѡ�����ݿ�
		if(command.startsWith("rpop	 ")){
			String[] c=command.split(" ");
			String key=c[1];
			String value=jedis.select(Integer.valueOf(key));
			System.out.println(value);
		}
		//hmset	ͬʱ���ö��field��value
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
		//ping ��������Ƿ��� 
		if(command.startsWith("ping	 ")){
			System.out.println("pong");
		}
		//echo �������д�ӡ����
		if(command.startsWith("echo	 ")){
			String[] c=command.split(" ");
			String key=c[1];
			String value=jedis.echo(key);
			System.out.println(value);
		}
		//quit �˳��ͻ���
		if(command.startsWith("quit	 ")){
			System.out.println("quit");
		}
		//dbsize ���ص�ǰ���ݿ���key����Ŀ
		if(command.startsWith("dbsize	 ")){
			String[] c=command.split(" ");
			String key=c[1];
			Long value=jedis.dbSize();
			System.out.println(value);
		}
		//flushdb ɾ����ǰ���ݿ��е�����key
		if(command.startsWith("flushdb ")){
			String[] c=command.split(" ");  
			String key=c[1];
			String value=jedis.flushDB();
			System.out.println(value);
		}
		//flushall ɾ���������ݿ��е�����key
		if(command.startsWith("flushall	 ")){
			String[] c=command.split(" ");
			String key=c[1];
			String value=jedis.flushAll();
			System.out.println(value);
		}
		//hgetall ��ȡkey�����е�field��value
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
