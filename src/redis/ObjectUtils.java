package redis;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
/**
 * ���󹤾���
 * @author Administrator
 *
 */
public class ObjectUtils {
	/**
	 * ������ת��Ϊ�ֽ�����
	 * @param obj
	 * @return
	 * @throws IOException 
	 */
	public static byte[] objectToByte(Object obj) throws IOException{
		ByteArrayOutputStream boas=new ByteArrayOutputStream();
		ObjectOutputStream oops=new ObjectOutputStream(boas);
		oops.writeObject(obj);
		oops.close();
		return boas.toByteArray();
	}
	
	/**
	 * ���ֽ�����ת��Ϊ����
	 * @param obj
	 * @return
	 * @throws IOException 
	 */
	public static Object byteToObject(byte[] src) throws Exception{
		ByteArrayInputStream boas=new ByteArrayInputStream(src);
		ObjectInputStream ois=new ObjectInputStream(boas);
		return ois.readObject();
	}
}
