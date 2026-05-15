public class Main {
    public static void main(String[] args) throws Exception {
        BigStar gge = new BigStar("Gge");
        Star proxy = ProxyUtil.createProxy(gge);
        String result = proxy.sing(gge.name);
        System.out.println(result);
        proxy.dance();
    }
}
