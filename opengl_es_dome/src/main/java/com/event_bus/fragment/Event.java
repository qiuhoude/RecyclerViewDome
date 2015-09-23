package com.event_bus.fragment;

import com.event_bus.bean.Item;

import java.util.List;

/**
 * Created by Administrator on 2015/8/18.
 */
public class Event {
    /** 列表加载事件 */
    public static class ItemListEvent
    {
        private List<Item> items;

        public ItemListEvent(List<Item> items)
        {
            this.items = items;
        }

        public List<Item> getItems()
        {
            return items;
        }
    }
}
