// 
// Decompiled by Procyon v0.5.29
// 

public final class tg extends adi
{
    public static tf a(final xj xj) {
        return new tf(xj.d("id"), (tw)xj.a("expires", tw.d), (byte[])xj.a("secret", adb.b));
    }
    
    public static void a(final tf tf, final xj xj) {
        xj.a("id", tf.b);
        xj.a("expires", tf.d, tw.d);
        xj.a("secret", tf.b(), adb.b);
    }
}
