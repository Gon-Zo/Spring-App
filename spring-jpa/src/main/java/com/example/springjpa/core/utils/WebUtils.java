package com.example.springjpa.core.utils;

import org.json.JSONObject;

/**
 * Create by park031517@gmail.com on 2020-08-3, 월
 * Blog : https://zzz-oficial.tistory.com
 * Github : https://github.com/Gon-Zo
 */
public class WebUtils {

    public static String getJsonData(String str, String title) {
        JSONObject jo = new JSONObject(str);
        return String.valueOf(jo.get(title));
    }

}
