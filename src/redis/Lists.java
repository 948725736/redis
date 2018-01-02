package redis;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import java.util.List;

public class Lists {
static final	Jedis jedis=new Jedis();
	//lpush	在list头部添加值
	//rpush	在list尾部添加值
public static void main(String[] args) {
		jedis.lpush("1611", new String[]{"zs"});
		jedis.lpush("1611", new String[]{"ww"});
		jedis.rpush("1611", new String[]{"zl"});
		jedis.close();
}
//lrange	获取指定位置的数据
@Test
public void test(){
	List<String> str=jedis.lrange("1611", 0, 100);
	System.out.println(str);
	jedis.close();
}
//lpop	从头部弹出key的值（删除）
//rpop	从尾部弹出key的值（删除）
@Test
public void test1(){
	jedis.lpop("1611");
	jedis.rpop("1611");
	jedis.close();
}

//llen	返回key的长度
@Test
public void test2(){
	jedis.llen("1611");
	jedis.close();
}
//lrem	删除前面几个值为value的元素
@Test
public void test3(){
	jedis.lrem("1611", 1, "ls");
	jedis.close();
}
//lset	按下标赋值
@Test
public void test4(){
	jedis.lset("1611", 1, "sg");
	jedis.close();
}
//rpoplpush	从一个list的尾部弹出插入到另一个list的头部
@Test
public void test5(){
	jedis.rpoplpush("1611", "1607");
	jedis.close();
}

}
