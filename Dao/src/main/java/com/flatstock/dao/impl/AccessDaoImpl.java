package com.flatstock.dao.impl;

import com.flatstock.dao.AccessDao;
import com.flatstock.model.Role;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Valentin on 16.08.2015.
 */
public class AccessDaoImpl implements AccessDao {
    private static final String TABLE_NAME = "access_table";
    private static final String ROLE = "role";
    private static final String GROUP_ID = "group_id";

    private static final String SELECT_ROLES_QUERY = "SELECT " + ROLE + " FROM " + TABLE_NAME +
            " WHERE " + GROUP_ID + "=?;";
    private static final String ADD_ACCESS_QUERY = "INSERT INTO " + TABLE_NAME +
            "(" + GROUP_ID + ", " + ROLE + ") VALUES (?, ?::role);";
    private static final String REMOVE_ACCESS_QUERY = "DELETE FROM " + TABLE_NAME +
            " WHERE " + GROUP_ID + "=? AND " + ROLE + "=?::role;";


    public Set<Role> getRolesForGroup(final int groupId) {
        Dao<Set<Role>> dao = new Dao<Set<Role>>() {
            @Override
            public void prepare(PreparedStatement statement) throws SQLException {
                statement.setInt(1, groupId);
            }

            @Override
            public Set<Role> execute(ResultSet result) throws SQLException {
                Set<Role> roles = new HashSet<>();
                while (result.next()){
                    roles.add(Role.fromString(result.getString(ROLE)));
                }
                return roles;
            }
        };
        return dao.executeQuery(SELECT_ROLES_QUERY);
    }

    public void addAccess(final int groupId, final Role role) {
        Dao dao = new Dao() {
            @Override
            public void prepare(PreparedStatement statement) throws SQLException {
                statement.setInt(1, groupId);
                statement.setString(2, role.toString());
            }

            @Override
            public Object execute(ResultSet result) throws SQLException {
                return null;
            }
        };
        dao.executeQuery(ADD_ACCESS_QUERY);
    }

    public void removeAccess(final int groupId, final Role role) {
        Dao dao = new Dao() {
            @Override
            public void prepare(PreparedStatement statement) throws SQLException {
                statement.setInt(1, groupId);
                statement.setString(2, role.toString());
            }

            @Override
            public Object execute(ResultSet result) throws SQLException {
                return null;
            }
        };
        dao.executeQuery(REMOVE_ACCESS_QUERY);
    }


}
