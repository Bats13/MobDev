package timbr.mymovies.model;

import java.io.Serializable;

/**
 * Created by timbr on 15-10-2017.
 */

public class Film implements Serializable {

    private int id;
    private String title;
    private String type;
    private String dateAdded; // String, since you cannot save date/time values in SQLite
    private String filmStatus;
    private String notes;

    public Film(int id, String title, String type, String dateAdded, String filmStatus, String notes) {

        this.id = id;
        this.title = title;
        this.type = type;
        this.dateAdded = dateAdded;
        this.filmStatus = filmStatus;
        this.notes = notes;

    }

    public Film() {

    }

    public long getId() {
        return (long) id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
    }

    public String getFilmStatus() {
        return filmStatus;
    }

    public void setFilmStatus(String filmStatus) {
        this.filmStatus = filmStatus;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

}
