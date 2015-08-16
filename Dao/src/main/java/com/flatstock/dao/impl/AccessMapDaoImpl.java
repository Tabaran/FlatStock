package com.flatstock.dao.impl;

import com.flatstock.dao.AccessMapDao;
import com.flatstock.model.Role;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Valentin on 16.08.2015.
 */
public class AccessMapDaoImpl implements AccessMapDao {
    private static final String ACCESS_TABLE = "AccessMap";
    private static final String ROLE = "role";
    private static final String URL_ID = "url_id";

    private static final String SELECT_ROLES_QUERY = "SELECT " + ROLE + " FROM " + ACCESS_TABLE +
            " WHERE " + URL_ID + "=?;";
    private static final String ADD_ACCESS_QUERY = "INSERT INTO " + ACCESS_TABLE +
            "(" + URL_ID + ", " + ROLE + ") VALUES (?, ?::role);";
    private static final String REMOVE_ACCESS_QUERY = "DELETE FROM " + ACCESS_TABLE +
            " WHERE " + URL_ID + "=? AND " + ROLE + "=?::role;";
    private static final String REMOVE_URL_QUERY = "DELETE FROM " + ACCESS_TABLE +
            " WHERE " + URL_ID + "=?;";

    public Set<Role> getRolesForUrl(final int urlId) {
        Dao<Set<Role>> dao = new Dao<Set<Role>>() {
            @Override
            public void prepare(PreparedStatement statement) throws SQLException {
                statement.setInt(1, urlId);
            }

            @Override
            public Set<Role> execute(ResultSet result) throws SQLException {
                Set<Role> roles = new HashSet<Role>();
                while (result.next()){
                    roles.add(Role.fromString(result.getString(ROLE)));
                }
                return roles;
            }
        };
        return dao.executeQuery(SELECT_ROLES_QUERY);
    }

    public void addAccess(final int urlId, final Role role) {
        Dao dao = new Dao() {
            @Override
            public void prepare(PreparedStatement statement) throws SQLException {
                statement.setInt(1, urlId);
                statement.setString(2, role.toString());
            }

            @Override
            public Object execute(ResultSet result) throws SQLException {
                return null;
            }
        };
        dao.executeQuery(ADD_ACCESS_QUERY);
    }

    public void removeAccess(final int urlId, final Role role) {
        Dao dao = new Dao() {
            @Override
            public void prepare(PreparedStatement statement) throws SQLException {
                statement.setInt(1, urlId);
                statement.setString(2, role.toString());
            }

            @Override
            public Object execute(ResultSet result) throws SQLException {
                return null;
            }
        };
        dao.executeQuery(REMOVE_ACCESS_QUERY);
    }

    public void removeAccess(final int urlId) {
        Dao dao = new Dao() {
            @Override
            public void prepare(PreparedStatement statement) throws SQLException {
                statement.setInt(1, urlId);
            }

            @Override
            public Object execute(ResultSet result) throws SQLException {
                return null;
            }
        };
        dao.executeQuery(REMOVE_URL_QUERY);
    }
}
