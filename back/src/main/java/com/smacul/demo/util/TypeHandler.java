package com.smacul.demo.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TypeHandler {

    private static final String[] ch = {"综合", "社会", "娱乐", "科技", "军事", "体育", "汽车", "财经", "国际", "时尚", "旅游", "探索",
            "育儿", "养生", "故事", "美文", "游戏", "历史", "美食"};
    private static final String[] en = {"news_global", "news_society", "news_entertainment", "news_tech", "news_military", "news_sports",
            "news_car", "news_finance", "news_world", "news_fashion", "news_travel",
            "news_discovery", "news_baby", "news_regimen", "news_story", "news_essay",
            "news_game", "news_history", "news_food"};

    //public static List<String> sortTypeEn(List<Integer> nums) {
    //    Map<String, Integer> dictionary = new HashMap<>();
    //    for (int i = 0; i < nums.size(); i++) {
    //        dictionary.put(en[i+1], nums.get(i));
    //    }
    //
    //}

    //public static List<String> sortTypeCh(List<Integer> nums) {
    //
    //}

    public static List<String> typeTransAllEnToCh(List<String> enTypes) {
        for (int i = 0; i < enTypes.size(); i++) {
            for (int j = 0; j < en.length; j++) {
                if (enTypes.get(i).equals(en[j])) {
                    enTypes.set(i, ch[j]);
                }
            }
        }
        enTypes.add(0, "综合");
        return enTypes;
    }

    /**
     * 不出意外的话, 这个方法应该用不到.
     *
     * @param chTypes
     * @return
     */
    public static List<String> typeTransAllChToEn(List<String> chTypes) {
        for (int i = 0; i < chTypes.size(); i++) {
            for (int j = 0; j < ch.length; j++) {
                if (chTypes.get(i).equals(ch[j])) {
                    chTypes.set(i, en[j]);
                }
            }
        }
        chTypes.add(0, "news_global");
        return chTypes;
    }
    
    public static String typeTransSingleEnToCh(String enType) {
        for (int i = 0; i < en.length; i++) {
            if (enType.equals(en[i])) {
                return ch[i];
            }
        }
        return null;
    }
    
    public static String typeTransSingleChToEn(String chType) {
        for (int i = 0; i < ch.length; i++) {
            if (chType.equals(ch[i])) {
                return en[i];
            }
        }
        return null;
    }
    
}
