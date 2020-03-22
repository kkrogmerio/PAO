public class BookStoreCheck {
    static boolean dubluEx(String a1,String a2, String b1,String b2) {
        return a1==a2 && b1==b2;
    }
    static String grosime(int prim,int doi){
        String msg=prim>doi?"Primul e mai mare":"Al doilea e mai mare";
        return msg;
    }

}
