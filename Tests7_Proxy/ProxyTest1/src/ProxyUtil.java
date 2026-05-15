import java.lang.reflect.*;

public class ProxyUtil{
    public static Star createProxy(BigStar bigStar){
        Star star = (Star)Proxy.newProxyInstance(
            BigStar.class.getClassLoader(),
            new Class[]{Star.class},
            new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args)  throws Throwable{
                    if("sing".equals(method.getName())){
                        System.out.println("Ready to sing");
                    }else if("dance".equals(method.getName())){
                        System.out.println("Ready to dance");
                    }

                    return method.invoke(bigStar, args);
                }
            }
        );
        return star;
    }
}
