// 
// Decompiled by Procyon v0.5.29
// 

package bolts;

public interface Continuation<TTaskResult, TContinuationResult>
{
    TContinuationResult then(Task<TTaskResult> p0) throws Exception;
}
