import java.io.File;
import java.util.jar.JarFile;
import java.util.jar.JarEntry;
import java.net.URLClassLoader;
import java.net.URL;
import java.util.Enumeration;
import java.lang.ClassLoader;
import java.lang.reflect.Method;
public class Plugin {
public static void main(String[] args) throws Exception {
         
        File file = new File(System.getProperty("user.home") + "/HelloWorld.jar");
         
        URLClassLoader clazzLoader = URLClassLoader.newInstance(new URL[]{file.toURI().toURL()});
        String className = null ;
        JarFile jarFile = new JarFile(file);
        Enumeration<JarEntry> entries = jarFile.entries();
         
        while (entries.hasMoreElements()) {
            JarEntry element = entries.nextElement();
            if (element.getName().endsWith(".class")) {
                try {
                    Class c = clazzLoader.loadClass(element.getName().replaceAll(".class", "").replaceAll("/", "."));
                    //c.newInstance(); // this proves that class is loaded
                    className = c.getName();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        
        //Check if class was loaded 
        
        //check 1 : throws  ClassNotFoundException exception if class not found 
        try {
            Class cls = Class.forName(className, false, clazzLoader);
            System.out.println("Class " + cls.getName() +" found in check 1");
        }
        catch (ClassNotFoundException e) {
        	System.out.println("Class not found");
        }
        
        // check 2 : use reflection
        Method m = ClassLoader.class.getDeclaredMethod("findLoadedClass",  new Class[]{String.class});
        m.setAccessible(true);
        Class<?> clazz = (Class<?>) m.invoke( clazzLoader , new Object[]{className});
        if ( clazz == null ){
        	System.out.println("There is no such class ");
        }
        else {
        	System.out.println("Class " + clazz.getName() + " found in check 2");
        }
    }

    
}
