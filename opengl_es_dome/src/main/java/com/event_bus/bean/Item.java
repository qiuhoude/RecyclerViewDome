package com.event_bus.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/8/18.
 */
public class Item {
    private String id;
    private String content;

    public static List<Item> ITEMS = new ArrayList<Item>();

    static {
        addItem(new Item("1", "item1"));
        addItem(new Item("2", "item2"));
        addItem(new Item("3", "item3"));
        addItem(new Item("4", "item4"));
        addItem(new Item("5", "item5"));
        addItem(new Item("6", "item6"));
    }

    private static void addItem(Item item) {
        ITEMS.add(item);
    }


    @Override
    public String toString() {
        return "Item{" +
                "content='" + content + '\'' +
                '}';
    }

    public Item(String id, String content) {
        this.id = id;
        this.content = content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public String getId() {
        return id;
    }
}
