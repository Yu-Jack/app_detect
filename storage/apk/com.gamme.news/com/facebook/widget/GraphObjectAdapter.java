// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook.widget;

import android.widget.TextView$BufferType;
import android.widget.TextView;
import java.net.URISyntaxException;
import org.json.JSONObject;
import android.view.ViewGroup$LayoutParams;
import java.util.Locale;
import java.util.HashSet;
import android.widget.CheckBox;
import android.view.ViewStub;
import java.util.Collections;
import java.util.Comparator;
import android.graphics.Bitmap;
import android.widget.ProgressBar;
import com.facebook.android.R;
import android.view.ViewGroup;
import android.view.View;
import com.facebook.internal.ImageDownloader;
import java.net.URI;
import java.util.Iterator;
import com.facebook.FacebookException;
import android.widget.ImageView;
import java.text.Collator;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import com.facebook.internal.ImageResponse;
import com.facebook.internal.ImageRequest;
import android.view.LayoutInflater;
import java.util.ArrayList;
import java.util.Map;
import android.content.Context;
import android.widget.SectionIndexer;
import android.widget.BaseAdapter;
import com.facebook.model.GraphObject;

class GraphObjectAdapter<T extends GraphObject> extends BaseAdapter implements SectionIndexer
{
    private static final int ACTIVITY_CIRCLE_VIEW_TYPE = 2;
    private static final int DISPLAY_SECTIONS_THRESHOLD = 1;
    private static final int GRAPH_OBJECT_VIEW_TYPE = 1;
    private static final int HEADER_VIEW_TYPE = 0;
    private static final String ID = "id";
    private static final int MAX_PREFETCHED_PICTURES = 20;
    private static final String NAME = "name";
    private static final String PICTURE = "picture";
    private Context context;
    private GraphObjectCursor<T> cursor;
    private DataNeededListener dataNeededListener;
    private boolean displaySections;
    private Filter<T> filter;
    private Map<String, T> graphObjectsById;
    private Map<String, ArrayList<T>> graphObjectsBySection;
    private String groupByField;
    private final LayoutInflater inflater;
    private OnErrorListener onErrorListener;
    private final Map<String, ImageRequest> pendingRequests;
    private Map<String, ImageResponse> prefetchedPictureCache;
    private ArrayList<String> prefetchedProfilePictureIds;
    private List<String> sectionKeys;
    private boolean showCheckbox;
    private boolean showPicture;
    private List<String> sortFields;
    
    static /* synthetic */ int[] $SWITCH_TABLE$com$facebook$widget$GraphObjectAdapter$SectionAndItem$Type() {
        final int[] $switch_TABLE$com$facebook$widget$GraphObjectAdapter$SectionAndItem$Type = GraphObjectAdapter.$SWITCH_TABLE$com$facebook$widget$GraphObjectAdapter$SectionAndItem$Type;
        if ($switch_TABLE$com$facebook$widget$GraphObjectAdapter$SectionAndItem$Type != null) {
            return $switch_TABLE$com$facebook$widget$GraphObjectAdapter$SectionAndItem$Type;
        }
        final int[] $switch_TABLE$com$facebook$widget$GraphObjectAdapter$SectionAndItem$Type2 = new int[Type.values().length];
        while (true) {
            try {
                $switch_TABLE$com$facebook$widget$GraphObjectAdapter$SectionAndItem$Type2[Type.ACTIVITY_CIRCLE.ordinal()] = 3;
                try {
                    $switch_TABLE$com$facebook$widget$GraphObjectAdapter$SectionAndItem$Type2[Type.GRAPH_OBJECT.ordinal()] = 1;
                    try {
                        $switch_TABLE$com$facebook$widget$GraphObjectAdapter$SectionAndItem$Type2[Type.SECTION_HEADER.ordinal()] = 2;
                        return GraphObjectAdapter.$SWITCH_TABLE$com$facebook$widget$GraphObjectAdapter$SectionAndItem$Type = $switch_TABLE$com$facebook$widget$GraphObjectAdapter$SectionAndItem$Type2;
                    }
                    catch (NoSuchFieldError noSuchFieldError) {}
                }
                catch (NoSuchFieldError noSuchFieldError2) {}
            }
            catch (NoSuchFieldError noSuchFieldError3) {
                continue;
            }
            break;
        }
    }
    
    public GraphObjectAdapter(final Context context) {
        this.pendingRequests = new HashMap<String, ImageRequest>();
        this.sectionKeys = new ArrayList<String>();
        this.graphObjectsBySection = new HashMap<String, ArrayList<T>>();
        this.graphObjectsById = new HashMap<String, T>();
        this.prefetchedPictureCache = new HashMap<String, ImageResponse>();
        this.prefetchedProfilePictureIds = new ArrayList<String>();
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }
    
    private void callOnErrorListener(Exception ex) {
        if (this.onErrorListener != null) {
            if (!(ex instanceof FacebookException)) {
                ex = new FacebookException(ex);
            }
            this.onErrorListener.onError(this, (FacebookException)ex);
        }
    }
    
    private static int compareGraphObjects(final GraphObject graphObject, final GraphObject graphObject2, final Collection<String> collection, final Collator collator) {
        for (final String s : collection) {
            final String s2 = (String)graphObject.getProperty(s);
            final String s3 = (String)graphObject2.getProperty(s);
            if (s2 != null && s3 != null) {
                final int compare = collator.compare(s2, s3);
                if (compare != 0) {
                    return compare;
                }
                continue;
            }
            else {
                if (s2 != null || s3 != null) {
                    int n;
                    if (s2 == null) {
                        n = -1;
                    }
                    else {
                        n = 1;
                    }
                    return n;
                }
                continue;
            }
        }
        return 0;
    }
    
    private void downloadProfilePicture(final String tag, final URI uri, final ImageView imageView) {
        if (uri != null) {
            boolean b;
            if (imageView == null) {
                b = true;
            }
            else {
                b = false;
            }
            if (b || !uri.equals(imageView.getTag())) {
                if (!b) {
                    imageView.setTag((Object)tag);
                    imageView.setImageResource(this.getDefaultPicture());
                }
                final ImageRequest build = new ImageRequest.Builder(this.context.getApplicationContext(), uri).setCallerTag(this).setCallback(new ImageRequest.Callback() {
                    @Override
                    public void onCompleted(final ImageResponse imageResponse) {
                        GraphObjectAdapter.this.processImageResponse(imageResponse, tag, imageView);
                    }
                }).build();
                this.pendingRequests.put(tag, build);
                ImageDownloader.downloadAsync(build);
            }
        }
    }
    
    private View getActivityCircleView(final View view, final ViewGroup viewGroup) {
        View inflate = view;
        if (inflate == null) {
            inflate = this.inflater.inflate(R.layout.com_facebook_picker_activity_circle_row, (ViewGroup)null);
        }
        ((ProgressBar)inflate.findViewById(R.id.com_facebook_picker_row_activity_circle)).setVisibility(0);
        return inflate;
    }
    
    private void processImageResponse(final ImageResponse imageResponse, final String s, final ImageView imageView) {
        this.pendingRequests.remove(s);
        if (imageResponse.getError() != null) {
            this.callOnErrorListener(imageResponse.getError());
        }
        if (imageView == null) {
            if (imageResponse.getBitmap() != null) {
                if (this.prefetchedPictureCache.size() >= 20) {
                    this.prefetchedPictureCache.remove(this.prefetchedProfilePictureIds.remove(0));
                }
                this.prefetchedPictureCache.put(s, imageResponse);
            }
        }
        else if (s.equals(imageView.getTag())) {
            final Exception error = imageResponse.getError();
            final Bitmap bitmap = imageResponse.getBitmap();
            if (error == null && bitmap != null) {
                imageView.setImageBitmap(bitmap);
                imageView.setTag((Object)imageResponse.getRequest().getImageUri());
            }
        }
    }
    
    private void rebuildSections() {
        int displaySections = 1;
        this.sectionKeys = new ArrayList<String>();
        this.graphObjectsBySection = new HashMap<String, ArrayList<T>>();
        this.graphObjectsById = new HashMap<String, T>();
        this.displaySections = false;
        if (this.cursor == null || this.cursor.getCount() == 0) {
            return;
        }
        int n = 0;
        this.cursor.moveToFirst();
        do {
            final GraphObject graphObject = this.cursor.getGraphObject();
            if (this.filterIncludesItem((T)graphObject)) {
                ++n;
                final String sectionKeyOfGraphObject = this.getSectionKeyOfGraphObject((T)graphObject);
                if (!this.graphObjectsBySection.containsKey(sectionKeyOfGraphObject)) {
                    this.sectionKeys.add(sectionKeyOfGraphObject);
                    this.graphObjectsBySection.put(sectionKeyOfGraphObject, new ArrayList<T>());
                }
                this.graphObjectsBySection.get(sectionKeyOfGraphObject).add((T)graphObject);
                this.graphObjectsById.put(this.getIdOfGraphObject((T)graphObject), (T)graphObject);
            }
        } while (this.cursor.moveToNext());
        if (this.sortFields != null) {
            final Collator instance = Collator.getInstance();
            final Iterator<ArrayList<T>> iterator = this.graphObjectsBySection.values().iterator();
            while (iterator.hasNext()) {
                Collections.sort(iterator.next(), new Comparator<GraphObject>() {
                    @Override
                    public int compare(final GraphObject graphObject, final GraphObject graphObject2) {
                        return compareGraphObjects(graphObject, graphObject2, GraphObjectAdapter.this.sortFields, instance);
                    }
                });
            }
        }
        Collections.sort(this.sectionKeys, Collator.getInstance());
        if (this.sectionKeys.size() <= displaySections || n <= displaySections) {
            displaySections = 0;
        }
        this.displaySections = (displaySections != 0);
    }
    
    private boolean shouldShowActivityCircleCell() {
        return this.cursor != null && this.cursor.areMoreObjectsAvailable() && this.dataNeededListener != null && !this.isEmpty();
    }
    
    public boolean areAllItemsEnabled() {
        return this.displaySections;
    }
    
    public boolean changeCursor(final GraphObjectCursor<T> cursor) {
        if (this.cursor == cursor) {
            return false;
        }
        if (this.cursor != null) {
            this.cursor.close();
        }
        this.cursor = cursor;
        this.rebuildAndNotify();
        return true;
    }
    
    protected View createGraphObjectView(final T t) {
        final View inflate = this.inflater.inflate(this.getGraphObjectRowLayoutId(t), (ViewGroup)null);
        final ViewStub viewStub = (ViewStub)inflate.findViewById(R.id.com_facebook_picker_checkbox_stub);
        if (viewStub != null) {
            if (!this.getShowCheckbox()) {
                viewStub.setVisibility(8);
            }
            else {
                this.updateCheckboxState((CheckBox)viewStub.inflate(), false);
            }
        }
        final ViewStub viewStub2 = (ViewStub)inflate.findViewById(R.id.com_facebook_picker_profile_pic_stub);
        if (!this.getShowPicture()) {
            viewStub2.setVisibility(8);
            return inflate;
        }
        ((ImageView)viewStub2.inflate()).setVisibility(0);
        return inflate;
    }
    
    boolean filterIncludesItem(final T t) {
        return this.filter == null || this.filter.includeItem(t);
    }
    
    public int getCount() {
        final int size = this.sectionKeys.size();
        int size2 = 0;
        if (size != 0) {
            final boolean displaySections = this.displaySections;
            size2 = 0;
            if (displaySections) {
                size2 = this.sectionKeys.size();
            }
            final Iterator<ArrayList<T>> iterator = this.graphObjectsBySection.values().iterator();
            while (iterator.hasNext()) {
                size2 += iterator.next().size();
            }
            if (this.shouldShowActivityCircleCell()) {
                return size2 + 1;
            }
        }
        return size2;
    }
    
    public GraphObjectCursor<T> getCursor() {
        return this.cursor;
    }
    
    public DataNeededListener getDataNeededListener() {
        return this.dataNeededListener;
    }
    
    protected int getDefaultPicture() {
        return R.drawable.com_facebook_profile_default_icon;
    }
    
    Filter<T> getFilter() {
        return this.filter;
    }
    
    protected int getGraphObjectRowLayoutId(final T t) {
        return R.layout.com_facebook_picker_list_row;
    }
    
    protected View getGraphObjectView(final T t, final View view, final ViewGroup viewGroup) {
        View graphObjectView = view;
        if (graphObjectView == null) {
            graphObjectView = this.createGraphObjectView(t);
        }
        this.populateGraphObjectView(graphObjectView, t);
        return graphObjectView;
    }
    
    public List<T> getGraphObjectsById(final Collection<String> collection) {
        final HashSet<String> set = new HashSet<String>();
        set.addAll((Collection<?>)collection);
        final ArrayList list = new ArrayList<T>(set.size());
        final Iterator<Object> iterator = set.iterator();
        while (iterator.hasNext()) {
            final GraphObject e = this.graphObjectsById.get(iterator.next());
            if (e != null) {
                list.add((T)e);
            }
        }
        return (List<T>)list;
    }
    
    public String getGroupByField() {
        return this.groupByField;
    }
    
    String getIdOfGraphObject(final T t) {
        if (t.asMap().containsKey("id")) {
            final Object property = t.getProperty("id");
            if (property instanceof String) {
                return (String)property;
            }
        }
        throw new FacebookException("Received an object without an ID.");
    }
    
    public Object getItem(final int n) {
        final SectionAndItem<T> sectionAndItem = this.getSectionAndItem(n);
        if (sectionAndItem.getType() == Type.GRAPH_OBJECT) {
            return sectionAndItem.graphObject;
        }
        return null;
    }
    
    public long getItemId(final int n) {
        final SectionAndItem<T> sectionAndItem = this.getSectionAndItem(n);
        if (sectionAndItem != null && sectionAndItem.graphObject != null) {
            final String idOfGraphObject = this.getIdOfGraphObject((T)sectionAndItem.graphObject);
            if (idOfGraphObject != null) {
                return Long.parseLong(idOfGraphObject);
            }
        }
        return 0L;
    }
    
    public int getItemViewType(final int n) {
        switch ($SWITCH_TABLE$com$facebook$widget$GraphObjectAdapter$SectionAndItem$Type()[this.getSectionAndItem(n).getType().ordinal()]) {
            default: {
                throw new FacebookException("Unexpected type of section and item.");
            }
            case 2: {
                return 0;
            }
            case 1: {
                return 1;
            }
            case 3: {
                return 2;
            }
        }
    }
    
    public OnErrorListener getOnErrorListener() {
        return this.onErrorListener;
    }
    
    String getPictureFieldSpecifier() {
        final ImageView imageView = (ImageView)this.createGraphObjectView(null).findViewById(R.id.com_facebook_picker_image);
        if (imageView == null) {
            return null;
        }
        final ViewGroup$LayoutParams layoutParams = imageView.getLayoutParams();
        return String.format(Locale.US, "picture.height(%d).width(%d)", layoutParams.height, layoutParams.width);
    }
    
    protected URI getPictureUriOfGraphObject(final T t) {
        final Object property = t.getProperty("picture");
        Label_0041: {
            if (!(property instanceof String)) {
                break Label_0041;
            }
            String url = (String)property;
        Block_4_Outer:
            while (true) {
                if (url == null) {
                    return null;
                }
                try {
                    return new URI(url);
                    while (true) {
                        final ItemPictureData data = GraphObject.Factory.create((JSONObject)property).cast(ItemPicture.class).getData();
                        url = null;
                        url = data.getUrl();
                        continue Block_4_Outer;
                        final boolean b = property instanceof JSONObject;
                        url = null;
                        continue;
                    }
                }
                // iftrue(Label_0022:, data == null)
                // iftrue(Label_0022:, !b)
                catch (URISyntaxException ex) {}
                break;
            }
        }
        return null;
    }
    
    int getPosition(final String anObject, final T t) {
        int n = 0;
        final Iterator<String> iterator = this.sectionKeys.iterator();
        while (true) {
            Block_3: {
                int n2;
                while (true) {
                    final boolean hasNext = iterator.hasNext();
                    n2 = 0;
                    if (!hasNext) {
                        break;
                    }
                    final String s = iterator.next();
                    if (this.displaySections) {
                        ++n;
                    }
                    if (s.equals(anObject)) {
                        break Block_3;
                    }
                    n += this.graphObjectsBySection.get(s).size();
                }
                if (n2 == 0) {
                    return -1;
                }
                if (t == null) {
                    int n3;
                    if (this.displaySections) {
                        n3 = 1;
                    }
                    else {
                        n3 = 0;
                    }
                    return n - n3;
                }
                final Iterator<T> iterator2 = this.graphObjectsBySection.get(anObject).iterator();
                while (iterator2.hasNext()) {
                    if (GraphObject.Factory.hasSameId(iterator2.next(), t)) {
                        return n;
                    }
                    ++n;
                }
                return -1;
            }
            int n2 = 1;
            continue;
        }
    }
    
    public int getPositionForSection(final int a) {
        final boolean displaySections = this.displaySections;
        int position = 0;
        if (displaySections) {
            final int max = Math.max(0, Math.min(a, -1 + this.sectionKeys.size()));
            final int size = this.sectionKeys.size();
            position = 0;
            if (max < size) {
                position = this.getPosition(this.sectionKeys.get(max), null);
            }
        }
        return position;
    }
    
    SectionAndItem<T> getSectionAndItem(int index) {
        if (this.sectionKeys.size() == 0) {
            return null;
        }
        String s = null;
        GraphObject graphObject = null;
        Label_0090: {
            if (!this.displaySections) {
                s = this.sectionKeys.get(0);
                final ArrayList<T> list = this.graphObjectsBySection.get(s);
                if (index >= 0 && index < list.size()) {
                    graphObject = this.graphObjectsBySection.get(s).get(index);
                }
                else {
                    assert this.dataNeededListener != null && this.cursor.areMoreObjectsAvailable();
                    return new SectionAndItem<T>(null, null);
                }
            }
            else {
                final Iterator<String> iterator = this.sectionKeys.iterator();
                String s2 = null;
                int n = 0;
                ArrayList<T> list2 = null;
                Block_10: {
                    while (true) {
                        final boolean hasNext = iterator.hasNext();
                        graphObject = null;
                        s = null;
                        if (!hasNext) {
                            break Label_0090;
                        }
                        s2 = iterator.next();
                        n = index - 1;
                        if (index == 0) {
                            break;
                        }
                        list2 = this.graphObjectsBySection.get(s2);
                        if (n < list2.size()) {
                            break Block_10;
                        }
                        index = n - list2.size();
                    }
                    s = s2;
                    graphObject = null;
                    break Label_0090;
                }
                s = s2;
                graphObject = (T)list2.get(n);
            }
        }
        if (s != null) {
            return new SectionAndItem<T>(s, graphObject);
        }
        throw new IndexOutOfBoundsException("position");
    }
    
    public int getSectionForPosition(final int n) {
        final SectionAndItem<T> sectionAndItem = this.getSectionAndItem(n);
        int max = 0;
        if (sectionAndItem != null) {
            final Type type = sectionAndItem.getType();
            final Type activity_CIRCLE = Type.ACTIVITY_CIRCLE;
            max = 0;
            if (type != activity_CIRCLE) {
                max = Math.max(0, Math.min(this.sectionKeys.indexOf(sectionAndItem.sectionKey), -1 + this.sectionKeys.size()));
            }
        }
        return max;
    }
    
    protected View getSectionHeaderView(final String text, final View view, final ViewGroup viewGroup) {
        TextView textView = (TextView)view;
        if (textView == null) {
            textView = (TextView)this.inflater.inflate(R.layout.com_facebook_picker_list_section_header, (ViewGroup)null);
        }
        textView.setText((CharSequence)text);
        return (View)textView;
    }
    
    protected String getSectionKeyOfGraphObject(final T t) {
        final String groupByField = this.groupByField;
        String upperCase = null;
        if (groupByField != null) {
            upperCase = (String)t.getProperty(this.groupByField);
            if (upperCase != null && upperCase.length() > 0) {
                upperCase = upperCase.substring(0, 1).toUpperCase();
            }
        }
        if (upperCase != null) {
            return upperCase;
        }
        return "";
    }
    
    public Object[] getSections() {
        if (this.displaySections) {
            return this.sectionKeys.toArray();
        }
        return new Object[0];
    }
    
    public boolean getShowCheckbox() {
        return this.showCheckbox;
    }
    
    public boolean getShowPicture() {
        return this.showPicture;
    }
    
    public List<String> getSortFields() {
        return this.sortFields;
    }
    
    protected CharSequence getSubTitleOfGraphObject(final T t) {
        return null;
    }
    
    protected CharSequence getTitleOfGraphObject(final T t) {
        return (String)t.getProperty("name");
    }
    
    public View getView(final int n, final View view, final ViewGroup viewGroup) {
        final SectionAndItem<T> sectionAndItem = this.getSectionAndItem(n);
        switch ($SWITCH_TABLE$com$facebook$widget$GraphObjectAdapter$SectionAndItem$Type()[sectionAndItem.getType().ordinal()]) {
            default: {
                throw new FacebookException("Unexpected type of section and item.");
            }
            case 2: {
                return this.getSectionHeaderView(sectionAndItem.sectionKey, view, viewGroup);
            }
            case 1: {
                return this.getGraphObjectView((T)sectionAndItem.graphObject, view, viewGroup);
            }
            case 3: {
                assert this.cursor.areMoreObjectsAvailable() && this.dataNeededListener != null;
                this.dataNeededListener.onDataNeeded();
                return this.getActivityCircleView(view, viewGroup);
            }
        }
    }
    
    public int getViewTypeCount() {
        return 3;
    }
    
    public boolean hasStableIds() {
        return true;
    }
    
    public boolean isEmpty() {
        return this.sectionKeys.size() == 0;
    }
    
    public boolean isEnabled(final int n) {
        return this.getSectionAndItem(n).getType() == Type.GRAPH_OBJECT;
    }
    
    boolean isGraphObjectSelected(final String s) {
        return false;
    }
    
    protected void populateGraphObjectView(final View view, final T t) {
        final String idOfGraphObject = this.getIdOfGraphObject(t);
        view.setTag((Object)idOfGraphObject);
        final CharSequence titleOfGraphObject = this.getTitleOfGraphObject(t);
        final TextView textView = (TextView)view.findViewById(R.id.com_facebook_picker_title);
        if (textView != null) {
            textView.setText(titleOfGraphObject, TextView$BufferType.SPANNABLE);
        }
        final CharSequence subTitleOfGraphObject = this.getSubTitleOfGraphObject(t);
        final TextView textView2 = (TextView)view.findViewById(R.id.picker_subtitle);
        if (textView2 != null) {
            if (subTitleOfGraphObject != null) {
                textView2.setText(subTitleOfGraphObject, TextView$BufferType.SPANNABLE);
                textView2.setVisibility(0);
            }
            else {
                textView2.setVisibility(8);
            }
        }
        if (this.getShowCheckbox()) {
            this.updateCheckboxState((CheckBox)view.findViewById(R.id.com_facebook_picker_checkbox), this.isGraphObjectSelected(idOfGraphObject));
        }
        if (this.getShowPicture()) {
            final URI pictureUriOfGraphObject = this.getPictureUriOfGraphObject(t);
            if (pictureUriOfGraphObject != null) {
                final ImageView imageView = (ImageView)view.findViewById(R.id.com_facebook_picker_image);
                if (!this.prefetchedPictureCache.containsKey(idOfGraphObject)) {
                    this.downloadProfilePicture(idOfGraphObject, pictureUriOfGraphObject, imageView);
                    return;
                }
                final ImageResponse imageResponse = this.prefetchedPictureCache.get(idOfGraphObject);
                imageView.setImageBitmap(imageResponse.getBitmap());
                imageView.setTag((Object)imageResponse.getRequest().getImageUri());
            }
        }
    }
    
    public void prioritizeViewRange(final int n, final int n2, final int n3) {
        if (n2 >= n && this.sectionKeys.size() != 0) {
            for (int i = n2; i >= 0; --i) {
                final SectionAndItem<T> sectionAndItem = this.getSectionAndItem(i);
                if (sectionAndItem.graphObject != null) {
                    final ImageRequest imageRequest = this.pendingRequests.get(this.getIdOfGraphObject((T)sectionAndItem.graphObject));
                    if (imageRequest != null) {
                        ImageDownloader.prioritizeRequest(imageRequest);
                    }
                }
            }
            final int max = Math.max(0, n - n3);
            final int min = Math.min(n2 + n3, -1 + this.getCount());
            final ArrayList<GraphObject> list = (ArrayList<GraphObject>)new ArrayList<T>();
            for (int j = max; j < n; ++j) {
                final SectionAndItem<T> sectionAndItem2 = this.getSectionAndItem(j);
                if (sectionAndItem2.graphObject != null) {
                    list.add(sectionAndItem2.graphObject);
                }
            }
            for (int k = n2 + 1; k <= min; ++k) {
                final SectionAndItem<T> sectionAndItem3 = this.getSectionAndItem(k);
                if (sectionAndItem3.graphObject != null) {
                    list.add(sectionAndItem3.graphObject);
                }
            }
            for (final GraphObject graphObject : list) {
                final URI pictureUriOfGraphObject = this.getPictureUriOfGraphObject((T)graphObject);
                final String idOfGraphObject = this.getIdOfGraphObject((T)graphObject);
                final boolean remove = this.prefetchedProfilePictureIds.remove(idOfGraphObject);
                this.prefetchedProfilePictureIds.add(idOfGraphObject);
                if (!remove) {
                    this.downloadProfilePicture(idOfGraphObject, pictureUriOfGraphObject, null);
                }
            }
        }
    }
    
    public void rebuildAndNotify() {
        this.rebuildSections();
        this.notifyDataSetChanged();
    }
    
    public void setDataNeededListener(final DataNeededListener dataNeededListener) {
        this.dataNeededListener = dataNeededListener;
    }
    
    void setFilter(final Filter<T> filter) {
        this.filter = filter;
    }
    
    public void setGroupByField(final String groupByField) {
        this.groupByField = groupByField;
    }
    
    public void setOnErrorListener(final OnErrorListener onErrorListener) {
        this.onErrorListener = onErrorListener;
    }
    
    public void setShowCheckbox(final boolean showCheckbox) {
        this.showCheckbox = showCheckbox;
    }
    
    public void setShowPicture(final boolean showPicture) {
        this.showPicture = showPicture;
    }
    
    public void setSortFields(final List<String> sortFields) {
        this.sortFields = sortFields;
    }
    
    void updateCheckboxState(final CheckBox checkBox, final boolean b) {
    }
    
    public interface DataNeededListener
    {
        void onDataNeeded();
    }
    
    interface Filter<T>
    {
        boolean includeItem(T p0);
    }
    
    private interface ItemPicture extends GraphObject
    {
        ItemPictureData getData();
    }
    
    private interface ItemPictureData extends GraphObject
    {
        String getUrl();
    }
    
    public interface OnErrorListener
    {
        void onError(GraphObjectAdapter<?> p0, FacebookException p1);
    }
    
    public static class SectionAndItem<T extends GraphObject>
    {
        public T graphObject;
        public String sectionKey;
        
        public SectionAndItem(final String sectionKey, final T graphObject) {
            this.sectionKey = sectionKey;
            this.graphObject = graphObject;
        }
        
        public Type getType() {
            if (this.sectionKey == null) {
                return Type.ACTIVITY_CIRCLE;
            }
            if (this.graphObject == null) {
                return Type.SECTION_HEADER;
            }
            return Type.GRAPH_OBJECT;
        }
        
        public enum Type
        {
            ACTIVITY_CIRCLE("ACTIVITY_CIRCLE", 2), 
            GRAPH_OBJECT("GRAPH_OBJECT", 0), 
            SECTION_HEADER("SECTION_HEADER", 1);
            
            private Type(final String name, final int ordinal) {
            }
        }
    }
}
