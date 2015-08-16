package com.flatstock.service;

import com.flatstock.model.Role;

import java.util.Map;
import java.util.Set;

/**
 * Created by Valentin on 15.08.2015.
 */
public interface AccessService {
    Map<String, Set<Role>> getAccessMap();
    void addUrl(String url);
    void updateAccess(String url, Set<Role> roles);
    void removeUrl(String url);
    void removeAccess(String url, Role role);
    void addAccess(String url, Role role);
}
