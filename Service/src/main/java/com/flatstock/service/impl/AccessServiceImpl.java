package com.flatstock.service.impl;

import com.flatstock.dao.AccessMapDao;
import com.flatstock.dao.UrlDao;
import com.flatstock.dao.impl.AccessMapDaoImpl;
import com.flatstock.dao.impl.UrlDaoImpl;
import com.flatstock.model.Role;
import com.flatstock.service.AccessService;

import java.util.*;

/**
 * Created by Valentin on 15.08.2015.
 */
public class AccessServiceImpl implements AccessService {

    private static Map<String, Set<Role>> accessMap = null;

    AccessMapDao accessMapDao;
    UrlDao urlDao;

    public AccessServiceImpl(){
        accessMapDao = new AccessMapDaoImpl();
        urlDao = new UrlDaoImpl();
    }

    public Map<String, Set<Role>> getAccessMap() {
        if(accessMap == null) {
            accessMap = new HashMap<String, Set<Role>>();
            Map<Integer,String> urls = urlDao.getAllUrls();
            if(urls != null){
                for(int urlId: urls.keySet()){
                    accessMap.put(urls.get(urlId), accessMapDao.getRolesForUrl(urlId));
                }
            }
        }
        return accessMap;
    }

    public void addUrl(String url) {
        urlDao.addUrl(url);
        accessMap = null;
    }

    public void updateAccess(String url, Set<Role> newRoles) {
        int urlId = urlDao.getUrlId(url);
        Set<Role> oldRoles = accessMapDao.getRolesForUrl(urlId);
        for(Role role: Role.values()){
            if(oldRoles.contains(role) && !newRoles.contains(role)) {
                accessMapDao.removeAccess(urlId, role);
            }
            if(!oldRoles.contains(role) && newRoles.contains(role)) {
                accessMapDao.addAccess(urlId, role);
            }
        }
        getAccessMap().put(url, newRoles);
    }

    public void removeUrl(String url) {
        Integer urlId = urlDao.getUrlId(url);
        if(urlId != null) {
            accessMapDao.removeAccess(urlId);
            urlDao.removeUrl(url);
            accessMap = null;
        }
    }

    public void removeAccess(String url, Role role) {
        Integer urlId = urlDao.getUrlId(url);
        if(urlId != null) {
            accessMapDao.removeAccess(urlId, role);
            accessMap = null;
        }
    }

    public void addAccess(String url, Role role) {
        Integer urlId = urlDao.getUrlId(url);
        if(urlId != null) {
            accessMapDao.addAccess(urlId, role);
            accessMap = null;
        }
    }
}
