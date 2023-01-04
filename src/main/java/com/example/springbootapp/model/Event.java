package com.example.springbootapp.model;

/**
 * Created by maksym_govorischev.
 */
public interface Event {
    /**
     * Event id. UNIQUE.
     * @return Event Id
     */
    long getId();
    void setId(long id);
    String getTitle();
    void setTitle(String title);
    java.sql.Date getDate();
    void setDate(java.sql.Date date);
}
