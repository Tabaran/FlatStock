package com.flatstock.model.impl;

import com.flatstock.model.IFunctionalGroup;

/**
 * Created by Valentin on 22.08.2015.
 */
public class FunctionalGroup implements IFunctionalGroup {

    int id;
    String name;
    String description;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }
}
