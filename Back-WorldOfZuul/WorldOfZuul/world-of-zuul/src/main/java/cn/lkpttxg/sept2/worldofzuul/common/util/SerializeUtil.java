package cn.lkpttxg.sept2.worldofzuul.common.util;

import cn.lkpttxg.sept2.worldofzuul.common.consts.RoomDirection;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 对象序列化以及反序列化工具类，用于将对象进行序列化转为字节数组以及将字节数组还原为对象
 *
 * @author PpxiA
 * @version 1.0
 */
public class SerializeUtil {

  /**
   * 序列化函数
   *
   * @param object 需要进行序列化的对象
   * @return 字符数组
   */
  public byte[] serizlize(Object object){
    ObjectOutputStream oos = null;
    ByteArrayOutputStream baos = null;
    try {
      baos = new ByteArrayOutputStream();
      oos = new ObjectOutputStream(baos);
      oos.writeObject(object);
      byte[] bytes = baos.toByteArray();
      return bytes;
    } catch (Exception e) {
      e.printStackTrace();
    }finally {
      try {
        if(baos != null){
          baos.close();
        }
        if (oos != null) {
          oos.close();
        }
      } catch (Exception e2) {
        e2.printStackTrace();
      }
    }
    return null;
  }

  /**
   * 反序列化函数
   *
   * @param bytes 需要反序列化为对象的字节数组
   * @return 反序列化出的对象
   */
  public Object deserialize(byte[] bytes){
    ByteArrayInputStream bais = null;
    ObjectInputStream ois = null;
    try{
      bais = new ByteArrayInputStream(bytes);
      ois = new ObjectInputStream(bais);
      return ois.readObject();
    }catch(Exception e){
      e.printStackTrace();
    }finally {
      try {

      } catch (Exception e2) {
        e2.printStackTrace();
      }
    }
    return null;
  }

  public static void main(String[] args) {

  }
}
