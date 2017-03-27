package SwordForOffer;

/**
 * Created by zsc on 2017/3/20.
 * 单例模式静态实现
 */
public class b02_单例模式 {}

class Singleton {
    private Singleton() {}

    private static class Holder {
        private static Singleton singleton = new Singleton();
    }

    public static Singleton getInstance() {
        return Holder.singleton;
    }

}