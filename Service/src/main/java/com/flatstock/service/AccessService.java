package com.flatstock.service;

import com.flatstock.model.IFunctionalGroup;
import com.flatstock.model.Role;

import java.util.Map;
import java.util.Set;

/**
 * Created by Valentin on 15.08.2015.
 */
public interface AccessService {
    Map<Integer, Set<Role>> getAccessMap();
    Map<Integer, IFunctionalGroup> getGroups();
    boolean updateAccess(Integer groupId, Set<Role> roles);
    boolean checkAccess(String url, Role role);
}
