package Sprint3.util;

public class BrowserUtil {

    public static void Wait(int seconds) {
        try{
            Thread.sleep(seconds*1000);
        }catch (InterruptedException e){
        }
    }
}
