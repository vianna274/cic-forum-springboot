package com.org.cicforumspringboot.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "semesters")
public class Semester extends Audit {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @NotBlank
    private String title;

    @OneToMany(mappedBy = "semester",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Course> courses = new HashSet<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Semester{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", courses=" + courses +
                '}';
    }
}
