package redis;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import redis.clients.jedis.Jedis;

public class Order {
	
    static Jedis jedis=new Jedis();
    final static String ORDER_KEY="orderList";
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws Exception {
		byte[] srcByte=jedis.lpop(ORDER_KEY.getBytes());
		Map map=(Map)ObjectUtils.byteToObject(srcByte);
		System.out.println(map.get("cid"));
		System.out.println(map.get("count"));
		System.out.println(map.get("price"));
		//写入数据库 或者文件 csv写入文件
		     FileOutputStream fos=new FileOutputStream("C:\\ProgramData\\MySQL\\MySQL Server 5.5\\data\\work\\users.csv");
		     BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(fos));
		       
		     String str=" ";
		     Set<String> keys=map.keySet();
		     Iterator<String> iter=keys.iterator();
		     while(iter.hasNext()){
		    	 String key=iter.next();
		    	str = map.get(key).toString()+","+str; 
		     }
		     str+="\r\n";
		     bw.write(str);
		     bw.close();
	}
}