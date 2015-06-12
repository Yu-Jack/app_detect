// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager.protobuf.nano;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public class Extension<T>
{
    public final int fieldNumber;
    public Class<T> fieldType;
    public boolean isRepeatedField;
    public Class<T> listType;
    
    private Extension(final int fieldNumber, final TypeLiteral<T> typeLiteral) {
        this.fieldNumber = fieldNumber;
        this.isRepeatedField = ((TypeLiteral<Object>)typeLiteral).isList();
        this.fieldType = (Class<T>)((TypeLiteral<Object>)typeLiteral).getTargetClass();
        Class<T> access$200;
        if (this.isRepeatedField) {
            access$200 = (Class<T>)((TypeLiteral<Object>)typeLiteral).getListType();
        }
        else {
            access$200 = null;
        }
        this.listType = access$200;
    }
    
    public static <T> Extension<T> create(final int n, final TypeLiteral<T> typeLiteral) {
        return new Extension<T>(n, typeLiteral);
    }
    
    public static <T> Extension<List<T>> createRepeated(final int n, final TypeLiteral<List<T>> typeLiteral) {
        return new Extension<List<T>>(n, typeLiteral);
    }
    
    public abstract static class TypeLiteral<T>
    {
        private final Type type;
        
        protected TypeLiteral() {
            final Type genericSuperclass = this.getClass().getGenericSuperclass();
            if (genericSuperclass instanceof Class) {
                throw new RuntimeException("Missing type parameter");
            }
            this.type = ((ParameterizedType)genericSuperclass).getActualTypeArguments()[0];
        }
        
        private Class<T> getListType() {
            return (Class<T>)((ParameterizedType)this.type).getRawType();
        }
        
        private Class<T> getTargetClass() {
            if (this.isList()) {
                return (Class<T>)((ParameterizedType)this.type).getActualTypeArguments()[0];
            }
            return (Class<T>)this.type;
        }
        
        private boolean isList() {
            return this.type instanceof ParameterizedType;
        }
    }
}
