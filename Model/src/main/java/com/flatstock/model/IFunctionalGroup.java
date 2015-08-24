package com.flatstock.model;

/**
 * Created by Valentin on 22.08.2015.
 */
public interface IFunctionalGroup extends Id<Integer> {
    String getName();
    void setName(String name);
    String getDescription();
    void setDescription(String description);
}
