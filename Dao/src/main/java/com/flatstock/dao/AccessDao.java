package com.flatstock.dao;

import com.flatstock.model.Id;
import com.flatstock.model.Role;

import java.util.Set;

/**
 * Created by Valentin on 15.08.2015.
 */
public interface AccessDao {
    Set<Role> getRolesForGroup(int groupId);
    void addAccess(int urlId, Role role);
    void removeAccess(int groupId, Role role);
}
