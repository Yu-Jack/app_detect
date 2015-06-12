// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.commons;

abstract class s<SUCCESS_T> extends d<Object, Object, Object>
{
    private u<SUCCESS_T> a;
    private u<Exception> b;
    
    public s(final u<SUCCESS_T> a, final u<Exception> b) {
        this.a = a;
        this.b = b;
    }
    
    private void a() {
        this.a = null;
        this.b = null;
    }
    
    protected abstract Object a(final Object... p0);
    
    protected Object doInBackground(final Object... array) {
        try {
            return this.a(array);
        }
        catch (Exception ex) {
            n.c(ex);
            return ex;
        }
    }
    
    @Override
    protected void onCancelled() {
        super.onCancelled();
        this.a();
    }
    
    @Override
    protected void onPostExecute(final Object o) {
        super.onPostExecute(o);
        if (o instanceof Exception) {
            if (this.b != null) {
                this.b.a((Exception)o);
            }
        }
        else if (this.a != null) {
            this.a.a((SUCCESS_T)o);
        }
        this.a();
    }
}
