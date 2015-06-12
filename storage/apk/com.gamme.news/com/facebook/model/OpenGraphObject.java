// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook.model;

import java.util.Arrays;
import java.util.List;
import java.util.Date;

public interface OpenGraphObject extends GraphObject
{
    GraphObject getApplication();
    
    GraphObjectList<GraphObject> getAudio();
    
    @PropertyName("fbsdk:create_object")
    boolean getCreateObject();
    
    Date getCreatedTime();
    
    GraphObject getData();
    
    String getDescription();
    
    String getDeterminer();
    
    String getId();
    
    GraphObjectList<GraphObject> getImage();
    
    boolean getIsScraped();
    
    String getPostActionId();
    
    List<String> getSeeAlso();
    
    String getSiteName();
    
    String getTitle();
    
    String getType();
    
    Date getUpdatedTime();
    
    String getUrl();
    
    GraphObjectList<GraphObject> getVideo();
    
    void setApplication(GraphObject p0);
    
    void setAudio(GraphObjectList<GraphObject> p0);
    
    @PropertyName("fbsdk:create_object")
    void setCreateObject(boolean p0);
    
    void setCreatedTime(Date p0);
    
    void setData(GraphObject p0);
    
    void setDescription(String p0);
    
    void setDeterminer(String p0);
    
    void setId(String p0);
    
    void setImage(GraphObjectList<GraphObject> p0);
    
    @CreateGraphObject("url")
    @PropertyName("image")
    void setImageUrls(List<String> p0);
    
    void setIsScraped(boolean p0);
    
    void setPostActionId(String p0);
    
    void setSeeAlso(List<String> p0);
    
    void setSiteName(String p0);
    
    void setTitle(String p0);
    
    void setType(String p0);
    
    void setUpdatedTime(Date p0);
    
    void setUrl(String p0);
    
    void setVideo(GraphObjectList<GraphObject> p0);
    
    public static final class Factory
    {
        public static <T extends OpenGraphObject> T createForPost(Class<T> clazz, String s) {
            return createForPost(clazz, s, null, null, null, null);
        }
        
        public static <T extends OpenGraphObject> T createForPost(Class<T> clazz, String type, String title, String s, String url, String description) {
            OpenGraphObject openGraphObject;
            openGraphObject = GraphObject.Factory.create(clazz);
            if (type != null) {
                openGraphObject.setType(type);
            }
            if (title != null) {
                openGraphObject.setTitle(title);
            }
            if (s != null) {
                openGraphObject.setImageUrls(Arrays.asList(s));
            }
            if (url != null) {
                openGraphObject.setUrl(url);
            }
            if (description != null) {
                openGraphObject.setDescription(description);
            }
            openGraphObject.setCreateObject(true);
            openGraphObject.setData(GraphObject.Factory.create());
            return (T)openGraphObject;
        }
        
        public static OpenGraphObject createForPost(String s) {
            return createForPost(OpenGraphObject.class, s);
        }
    }
}
