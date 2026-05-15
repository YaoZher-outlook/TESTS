import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.util.Properties;
import java.lang.reflect.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("src\\prop.properties");
        prop.load(fis);
        fis.close();

        String classname = (String)prop.get("classname");
        String methodname = (String)prop.get("method");
    
        Class cls = Class.forName(classname);
        Constructor con = cls.getConstructor();
        Object obj = con.newInstance();

        Method method = cls.getDeclaredMethod(methodname);
        method.invoke(obj);
    }
}
