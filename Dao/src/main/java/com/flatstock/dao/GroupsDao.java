package com.flatstock.dao;

import com.flatstock.model.IFunctionalGroup;

import java.util.Set;

/**
 * Created by Valentin on 22.08.2015.
 */
public interface GroupsDao {
    Set<IFunctionalGroup> getAllGroups();
}
