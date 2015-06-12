// 
// Decompiled by Procyon v0.5.29
// 

package com.flurry.sdk;

import java.io.DataOutput;
import java.io.DataInput;

public class aq
{
    String a;
    ay b;
    long c;
    long d;
    ar e;
    long f;
    long g;
    
    public aq(final DataInput dataInput) {
        this.a = dataInput.readUTF();
        this.b = ay.a(dataInput.readInt());
        this.c = dataInput.readLong();
        this.d = dataInput.readLong();
        this.e = ar.a(dataInput.readInt());
        this.f = dataInput.readLong();
        this.g = dataInput.readLong();
    }
    
    public aq(final String a, final ay b, final long f) {
        this.a = a;
        this.b = b;
        this.c = System.currentTimeMillis();
        this.d = System.currentTimeMillis();
        this.e = ar.a;
        this.f = f;
        this.g = -1L;
    }
    
    public String a() {
        return this.a;
    }
    
    public void a(final long g) {
        synchronized (this) {
            this.g = g;
        }
    }
    
    public void a(final ar e) {
        synchronized (this) {
            this.e = e;
        }
    }
    
    public void a(final DataOutput dataOutput) {
        dataOutput.writeUTF(this.a);
        dataOutput.writeInt(this.b.a());
        dataOutput.writeLong(this.c);
        dataOutput.writeLong(this.d);
        dataOutput.writeInt(this.e.a());
        dataOutput.writeLong(this.f);
        dataOutput.writeLong(this.g);
    }
    
    public ar b() {
        synchronized (this) {
            return this.e;
        }
    }
    
    public long c() {
        return this.f;
    }
    
    public boolean d() {
        return this.f > 0L && System.currentTimeMillis() > this.f;
    }
    
    public void e() {
        synchronized (this) {
            this.d = System.currentTimeMillis();
        }
    }
    
    public long f() {
        return this.c;
    }
    
    @Override
    public String toString() {
        return "url: " + this.a + ", type:" + this.b + ", creation:" + this.c + ", accessed:" + this.d + ", status: " + this.e + ", expiration: " + this.f + ", size: " + this.g;
    }
}
