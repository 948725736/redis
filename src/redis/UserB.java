package redis;
import java.util.Scanner;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;
public class UserB {
	public final static String CHANNEL_B="chan_b";
	static Jedis jedis=new Jedis();
	public static void main(String[] args) {
		new ThreadB().start();
		Scanner scanner=new Scanner(System.in);
		while(true){
			System.out.print("�����뷢����Ϣ:");
			String text=scanner.nextLine();
			jedis.publish(CHANNEL_B, text);
		}
	}
}
class ThreadB extends Thread{
	public final static String CHANNEL_A="chan_a";
	static Jedis jedis=new Jedis();
	@Override
	public void run() {
		jedis.subscribe(new JedisPubSub(){
			@Override
			public void onMessage(String channel, String message) {
				System.out.println("��ȡ����Ϣ��"+message);
			}
		}, CHANNEL_A);
	}
}
