package javainternal;

import java.util.Map;
import java.util.WeakHashMap;

public class WeakHashMapUse {
    private static Map map;
    public static void main (String args[]) {
        map = new WeakHashMap();

        map.put(new String("Maine"), "Augusta");
   /*
           String str = new String("Maine");
        map.put(str, "Augusta");

        str is a pointer holding to reference so it wont be gc
         */
        Runnable runner = new Runnable() {
            public void run() {
                while (map.containsKey("Maine")) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException ignored) {
                    }
                    System.out.println("Thread waiting");
                    System.gc();
                }
            }
        };
        Thread t = new Thread(runner);
        t.start();
        System.out.println("Main waiting");
        try {
            t.join();
        } catch (InterruptedException ignored) {
        }
    }
}
