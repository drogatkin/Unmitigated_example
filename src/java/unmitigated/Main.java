package unmitigated;
import java.nio.file.*;
// This is a minimal testing example for the stackoverflow question requested by Unmitigated
public class Main {
    public static void main(String...args) {
          Path p = Paths.get("/usr/local/bee/lib/bee.jar");
          System.out.printf("Path %s\n", p.getFileName());
          // same using reflection
          try {
             System.out.printf("Path(reflection) %s\n",  p.getClass().getMethod("getFileName").invoke(p));
          } catch(Exception e) {
              e.printStackTrace();
          }
        // It looks like a JDK 17 bug for me now, see:
        File f = new File("/usr/local/bee/lib/bee.jar");
          System.out.printf("Path %s\n", f.getName());
          // same using reflection
          try {
             System.out.printf("Path(reflection) %s\n",  f.getClass().getMethod("getName").invoke(f));
              // it works just fine, no an exception
          } catch(Exception e) {
              e.printStackTrace();
          }
    }
}
