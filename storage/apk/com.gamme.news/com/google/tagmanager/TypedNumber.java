// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager;

class TypedNumber extends Number implements Comparable<TypedNumber>
{
    private double mDouble;
    private long mInt64;
    private boolean mIsInt64;
    
    private TypedNumber(final double mDouble) {
        this.mDouble = mDouble;
        this.mIsInt64 = false;
    }
    
    private TypedNumber(final long mInt64) {
        this.mInt64 = mInt64;
        this.mIsInt64 = true;
    }
    
    public static TypedNumber numberWithDouble(final Double n) {
        return new TypedNumber(n);
    }
    
    public static TypedNumber numberWithInt64(final long n) {
        return new TypedNumber(n);
    }
    
    public static TypedNumber numberWithString(final String str) throws NumberFormatException {
        try {
            return new TypedNumber(Long.parseLong(str));
        }
        catch (NumberFormatException ex) {
            try {
                return new TypedNumber(Double.parseDouble(str));
            }
            catch (NumberFormatException ex2) {
                throw new NumberFormatException(str + " is not a valid TypedNumber");
            }
        }
    }
    
    @Override
    public byte byteValue() {
        return (byte)this.longValue();
    }
    
    @Override
    public int compareTo(final TypedNumber typedNumber) {
        if (this.isInt64() && typedNumber.isInt64()) {
            return new Long(this.mInt64).compareTo(Long.valueOf(typedNumber.mInt64));
        }
        return Double.compare(this.doubleValue(), typedNumber.doubleValue());
    }
    
    @Override
    public double doubleValue() {
        if (this.isInt64()) {
            return this.mInt64;
        }
        return this.mDouble;
    }
    
    @Override
    public boolean equals(final Object o) {
        return o instanceof TypedNumber && this.compareTo((TypedNumber)o) == 0;
    }
    
    @Override
    public float floatValue() {
        return (float)this.doubleValue();
    }
    
    @Override
    public int hashCode() {
        return new Long(this.longValue()).hashCode();
    }
    
    public short int16Value() {
        return (short)this.longValue();
    }
    
    public int int32Value() {
        return (int)this.longValue();
    }
    
    public long int64Value() {
        if (this.isInt64()) {
            return this.mInt64;
        }
        return (long)this.mDouble;
    }
    
    @Override
    public int intValue() {
        return this.int32Value();
    }
    
    public boolean isDouble() {
        return !this.isInt64();
    }
    
    public boolean isInt64() {
        return this.mIsInt64;
    }
    
    @Override
    public long longValue() {
        return this.int64Value();
    }
    
    @Override
    public short shortValue() {
        return this.int16Value();
    }
    
    @Override
    public String toString() {
        if (this.isInt64()) {
            return Long.toString(this.mInt64);
        }
        return Double.toString(this.mDouble);
    }
}
