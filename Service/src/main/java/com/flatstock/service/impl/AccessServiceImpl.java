package com.flatstock.service.impl;

import com.flatstock.dao.AccessDao;
import com.flatstock.dao.GroupsDao;
import com.flatstock.dao.UrlDao;
import com.flatstock.dao.impl.AccessDaoImpl;
import com.flatstock.dao.impl.GroupsDaoImpl;
import com.flatstock.dao.impl.UrlDaoImpl;
import com.flatstock.model.IFunctionalGroup;
import com.flatstock.model.Role;
import com.flatstock.service.AccessService;

import java.util.*;

/**
 * Created by Valentin on 15.08.2015.
 */
public class AccessServiceImpl implements AccessService {

    private static Map<Integer, Set<Role>> accessMap = null;
    private static Map<Integer, IFunctionalGroup> groups;

    AccessDao accessDao;
    UrlDao urlDao;
    GroupsDao groupsDao;

    public AccessServiceImpl(){
        accessDao = new AccessDaoImpl();
        urlDao = new UrlDaoImpl();
        groupsDao = new GroupsDaoImpl();
        groups = new HashMap<>();
        for (IFunctionalGroup group: groupsDao.getAllGroups()){
            groups.put(group.getId(), group);
        }
    }


    @Override
    public Map<Integer, Set<Role>> getAccessMap() {
        if(accessMap == null){
            accessMap = new HashMap<>();
            for (IFunctionalGroup group: groups.values()){
                Set<Role> roles = accessDao.getRolesForGroup(group.getId());
                accessMap.put(group.getId(), roles);
            }
        }
        return accessMap;
    }

    @Override
    public Map<Integer, IFunctionalGroup> getGroups() {
        return groups;
    }

    @Override
    public void updateAccess(Integer groupId, Set<Role> newRoles) {
        Set<Role> oldRoles = accessDao.getRolesForGroup(groupId);
        for(Role role: Role.values()){
            if(oldRoles.contains(role) && !newRoles.contains(role)) {
                accessDao.removeAccess(groupId, role);
            }
            if(!oldRoles.contains(role) && newRoles.contains(role)) {
                accessDao.addAccess(groupId, role);
            }
        }
        getAccessMap().put(groupId, newRoles);
    }

    @Override
    public boolean checkAccess(String url, Role role) {
        Map<String, Integer> urlMap = urlDao.getAllUrls();
        IFunctionalGroup group = groups.get(urlMap.get(url));
        if(group == null) return false;
        Set<Role> roles = getAccessMap().get(group.getId());
        if(roles == null) return false;
        return roles.contains(role);
    }
}
