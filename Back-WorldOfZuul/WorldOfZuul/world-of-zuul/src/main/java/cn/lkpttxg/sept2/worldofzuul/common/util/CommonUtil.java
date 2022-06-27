package cn.lkpttxg.sept2.worldofzuul.common.util;

import cn.lkpttxg.sept2.worldofzuul.common.enums.Item.FoodTypes;
import io.swagger.models.auth.In;
import springfox.documentation.schema.Entry;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;

/**
 * @author TXG
 * @date 2022/6/27$
 */
public class CommonUtil {

    public static Integer getRandomLocation(){
       Integer location = (int)(Math.random()*25);
       if(location==2||location==10||location==12||location==14||location==22){
           return getRandomLocation();
       }
       return location;
    }

    public static Integer getRandomLocation(int[] values){
        Integer location = (int)(Math.random()*25);
        if(location==2||location==10||location==12||location==14||location==22|| contains(location,values)){
            return getRandomLocation();
        }
        return location;
    }

    private static boolean contains(Integer location, int[] values) {
        for(int i=0;i<values.length;i++){
            if(location == values[i]){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(getRandomLocation(new int[]{0,1,2,3,4}));
    }
}
