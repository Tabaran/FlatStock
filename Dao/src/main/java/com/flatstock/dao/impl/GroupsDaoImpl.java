package com.flatstock.dao.impl;

import com.flatstock.dao.GroupsDao;
import com.flatstock.model.IFunctionalGroup;
import com.flatstock.model.impl.FunctionalGroup;

import static com.flatstock.model.Id.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Valentin on 22.08.2015.
 */
public class GroupsDaoImpl implements GroupsDao {
    private static final String TABLE_NAME = "FUNCTIONAL_GROUPS";
    public static final String NAME = "group_name";
    public static final String DESCRIPTION = "description";

    private static final String SELECT_ALL_GROUPS = "SELECT * FROM " + TABLE_NAME;

    @Override
    public Set<IFunctionalGroup> getAllGroups() {
        Dao<Set<IFunctionalGroup>> dao = new Dao<Set<IFunctionalGroup>>() {
            @Override
            public void prepare(PreparedStatement statement) throws SQLException {

            }

            @Override
            public Set<IFunctionalGroup> execute(ResultSet result) throws SQLException {
                Set<IFunctionalGroup> groups = new HashSet<>();
                while (result.next()){
                    IFunctionalGroup group = new FunctionalGroup();
                    group.setId(result.getInt(ID));
                    group.setName(result.getString(NAME));
                    group.setDescription(result.getString(DESCRIPTION));
                    groups.add(group);
                }
                return groups;
            }
        };
        return dao.executeQuery(SELECT_ALL_GROUPS);
    }
}
