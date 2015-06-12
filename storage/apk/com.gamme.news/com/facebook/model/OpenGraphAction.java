// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook.model;

import java.util.List;
import java.util.Date;
import org.json.JSONObject;

public interface OpenGraphAction extends GraphObject
{
    GraphObject getApplication();
    
    JSONObject getComments();
    
    Date getCreatedTime();
    
    GraphObject getData();
    
    Date getEndTime();
    
    Date getExpiresTime();
    
    @PropertyName("fb:explicitly_shared")
    boolean getExplicitlyShared();
    
    GraphUser getFrom();
    
    String getId();
    
    List<JSONObject> getImage();
    
    JSONObject getLikes();
    
    String getMessage();
    
    GraphPlace getPlace();
    
    Date getPublishTime();
    
    String getRef();
    
    Date getStartTime();
    
    GraphObjectList<GraphObject> getTags();
    
    String getType();
    
    void setApplication(GraphObject p0);
    
    void setComments(JSONObject p0);
    
    void setCreatedTime(Date p0);
    
    void setData(GraphObject p0);
    
    void setEndTime(Date p0);
    
    void setExpiresTime(Date p0);
    
    @PropertyName("fb:explicitly_shared")
    void setExplicitlyShared(boolean p0);
    
    void setFrom(GraphUser p0);
    
    void setId(String p0);
    
    void setImage(List<JSONObject> p0);
    
    @CreateGraphObject("url")
    @PropertyName("image")
    void setImageUrls(List<String> p0);
    
    void setLikes(JSONObject p0);
    
    void setMessage(String p0);
    
    void setPlace(GraphPlace p0);
    
    void setPublishTime(Date p0);
    
    void setRef(String p0);
    
    void setStartTime(Date p0);
    
    void setTags(List<? extends GraphObject> p0);
    
    void setType(String p0);
    
    public static final class Factory
    {
        @Deprecated
        public static OpenGraphAction createForPost() {
            return createForPost(OpenGraphAction.class, null);
        }
        
        public static <T extends OpenGraphAction> T createForPost(Class<T> clazz, String type) {
            OpenGraphAction openGraphAction;
            openGraphAction = GraphObject.Factory.create(clazz);
            if (type != null) {
                openGraphAction.setType(type);
            }
            return (T)openGraphAction;
        }
        
        public static OpenGraphAction createForPost(String s) {
            return createForPost(OpenGraphAction.class, s);
        }
    }
}
