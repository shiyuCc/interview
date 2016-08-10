/**
 * Created by shiyu on 16/7/12.
 */
public final class Singleton{
    private static Singleton instance = null;

    public static synchronized Singleton getInstance(){
        if(instance == null){
            instance = new Singleton();
        }
        return instance;
    }
}