package offer;

/**
 * Created by zsc on 2017/2/27.
 * 单例模式静态实现
 */
public class Singleton {
    private Singleton() {}

    private static class Holder {
        private static Singleton singleton = new Singleton();
    }

    public static Singleton getInstance() {
        return Holder.singleton;
    }

}
