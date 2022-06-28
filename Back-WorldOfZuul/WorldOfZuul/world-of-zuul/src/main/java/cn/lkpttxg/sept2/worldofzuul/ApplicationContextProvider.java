package cn.lkpttxg.sept2.worldofzuul;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author TXG
 * @date 2022/6/27$
 */
@Component
public class ApplicationContextProvider implements ApplicationContextAware {
    private static ApplicationContext context;
    public static ApplicationContext getApplicationContext() {
        return context;
    }
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }
    /**
     * 根据类型获取
     * @param tClass
     * @param <T>
     * @return
     */
    public static <T> T getBean(Class<T> tClass) {
        return context.getBean(tClass);
    }

    /**
     * 如果同类型有多个实例，根据名字+类型获取
     * @param name
     * @param tClass
     * @param <T>
     * @return
     */
    public static <T> T getBean(String name, Class<T> tClass) {
        return context.getBean(name, tClass);
    }

}
