package com.example.baseadapter;

/**
 * Created by Vic on 2016/7/14.
 */
public class Item {
    public int ItemImageId;
    public String ItemTitle;
    public String ItemContent;

    public Item(int itemImageId, String itemContent, String itemTitle) {
        ItemImageId = itemImageId;
        ItemContent = itemContent;
        ItemTitle = itemTitle;
    }
}
