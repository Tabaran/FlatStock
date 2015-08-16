package com.flatstock.dao;

import java.util.Map;

/**
 * Created by Valentin on 16.08.2015.
 */
public interface UrlDao {
    Map<Integer, String> getAllUrls();
    int getUrlId(String url);
    void addUrl(String url);
    void removeUrl(String url);
}
