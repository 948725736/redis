package redis;
import java.io.BufferedReader;
/**
 * ����1  ��ȡcsv�ļ� 
 * ����2  ���ݴ���name������ȡ��Ӧ�� ��ʾ
 * ����3  Ӧ��redis ���ٶ�ȡ ����һ�� ��ȡ�ļ�  ����redis ��
 * @author Administrator
 *
 */
import java.io.FileInputStream;
import java.io.InputStreamReader;
import redis.clients.jedis.Jedis;
public class Query {
	private static Jedis jedis=new Jedis();
public static void main(String[] args) throws Exception {
	String name="zs";
	System.out.println(query(name));
	}
public static String query(String name) throws Exception{
	FileInputStream fis=new FileInputStream("C:\\ProgramData\\MySQL\\MySQL Server 5.5\\data\\work\\users.csv");
	BufferedReader br=new BufferedReader(new InputStreamReader(fis,"utf-8"));
	String line =null;
	while((line=br.readLine())!=null){
		String[] str=line.split(","); 
		String value=str[0].replace("\"", "")+"-"+
				str[1].replace("\"", "")+
				str[2].replace("\"", "")+
				str[3].replace("\"", "");
		if(name.equals(str[1].replace("\"", ""))){
			jedis.set(name, value);
			return value;
		}
	}
	return null;
}
}
