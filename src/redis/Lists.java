package redis;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import java.util.List;

public class Lists {
static final	Jedis jedis=new Jedis();
	//lpush	��listͷ�����ֵ
	//rpush	��listβ�����ֵ
public static void main(String[] args) {
		jedis.lpush("1611", new String[]{"zs"});
		jedis.lpush("1611", new String[]{"ww"});
		jedis.rpush("1611", new String[]{"zl"});
		jedis.close();
}
//lrange	��ȡָ��λ�õ�����
@Test
public void test(){
	List<String> str=jedis.lrange("1611", 0, 100);
	System.out.println(str);
	jedis.close();
}
//lpop	��ͷ������key��ֵ��ɾ����
//rpop	��β������key��ֵ��ɾ����
@Test
public void test1(){
	jedis.lpop("1611");
	jedis.rpop("1611");
	jedis.close();
}

//llen	����key�ĳ���
@Test
public void test2(){
	jedis.llen("1611");
	jedis.close();
}
//lrem	ɾ��ǰ�漸��ֵΪvalue��Ԫ��
@Test
public void test3(){
	jedis.lrem("1611", 1, "ls");
	jedis.close();
}
//lset	���±긳ֵ
@Test
public void test4(){
	jedis.lset("1611", 1, "sg");
	jedis.close();
}
//rpoplpush	��һ��list��β���������뵽��һ��list��ͷ��
@Test
public void test5(){
	jedis.rpoplpush("1611", "1607");
	jedis.close();
}

}
