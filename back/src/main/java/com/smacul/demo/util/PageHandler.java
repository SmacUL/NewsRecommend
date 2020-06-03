package com.smacul.demo.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PageHandler {

    public static Integer calcuStartNO(Integer page, Integer pageSize) {
        return page * pageSize;
    }

    public static Map<String, Integer> initPageList() {
        Map<String, Integer> pages = new HashMap<>();
        pages.put("news_global", 0);
        pages.put("news_hot", 0);

        pages.put("news_society", 0);
        pages.put("news_entertainment", 0);
        pages.put("news_tech", 0);
        pages.put("news_military", 0);
        pages.put("news_sports", 0);
        pages.put("news_car", 0);

        pages.put("news_finance", 0);
        pages.put("news_world", 0);
        pages.put("news_fashion", 0);
        pages.put("news_travel", 0);
        pages.put("news_discovery", 0);
        pages.put("news_baby", 0);

        pages.put("news_regimen", 0);
        pages.put("news_story", 0);
        pages.put("news_essay", 0);
        pages.put("news_game", 0);
        pages.put("news_history", 0);
        pages.put("news_food", 0);

        return pages;
    }

    //public static void hotArtPageCheck(Map<String, Integer> pages) {
    //    if (pages.get("hot") > 4) {
    //        pages.replace("hot", 0);
    //    }
    //}
    //
    //public static void pageChange(Map<String, Integer> pages, String category, Integer num) {
    //    pages.replace(category, num);
    //}
}
