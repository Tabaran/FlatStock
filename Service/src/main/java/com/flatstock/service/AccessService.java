package com.flatstock.service;

import com.flatstock.model.Role;

import java.util.Map;
import java.util.Set;

/**
 * Created by Valentin on 15.08.2015.
 */
public interface AccessService {
    Map<Integer, Set<Role>> getAccessMap();
    Map<Integer, IFunctionalGroup> getGroups();
    void updateAccess(Map<Integer, Set<Role>> newMap);
    boolean checkAccess(String url, Role role);

    boolean isSaved();
}
