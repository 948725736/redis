package redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

/**
 * ����Ĳ���
 * save 900 1
   save 300 10
   save 60 10000
   
   �������ݵ�Ƶ������������Ĳ���
    save 60 10000  60��֮�� �����10000�ε����ݸı� д�����
    save 300 10    300��� �������10�ε����ݸı�д�����
    save 900 1     900�� �������1�����ݸı�д�����
 
 ���� ��̨redis ͬʱ���ڻ�������ʱ  ��ôȷ�� set�ļ�ֵ�� д����һ̨������
   1
   2
   3
  set("1","{name:'',price:''}")   
  set("99","{name:'',price:''}")      
  set("86","{name:'',price:''}") 
  set("101","{name:'',price:''}") 
  hashȡ�෨
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
