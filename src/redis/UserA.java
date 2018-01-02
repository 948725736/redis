package redis;

import java.util.Scanner;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

public class UserA {

	public final static String CHANNEL_A="chan_a";
	static Jedis jedis=new Jedis();
	public static void main(String[] args) {
		new ThreadA().start();
		Scanner scanner=new Scanner(System.in);
		while(true){
			System.out.print("请输入发送消息:");
			String text=scanner.nextLine();
			jedis.publish(CHANNEL_A, text);
		}
		
	}
}
class ThreadA extends Thread{
	public final static String CHANNEL_B="chan_b";
	static Jedis jedis=new Jedis();
	@Override
	public void run() {
		jedis.subscribe(new JedisPubSub(){
			@Override
			public void onMessage(String channel, String message) {
				System.out.println("获取的消息："+message);
			}
		}, CHANNEL_B);
		
	}

}
