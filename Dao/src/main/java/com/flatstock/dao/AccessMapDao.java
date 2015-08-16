package com.flatstock.dao;

import com.flatstock.model.Id;
import com.flatstock.model.Role;

import java.util.Set;

/**
 * Created by Valentin on 15.08.2015.
 */
public interface AccessMapDao {
    Set<Role> getRolesForUrl(int urlId);
    void addAccess(int urlId, Role role);
    void removeAccess(int urlId, Role role);
    void removeAccess(int urlId);
}
