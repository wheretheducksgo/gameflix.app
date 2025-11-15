package com.jphuey.gameflix.model;

import jakarta.persistence.*;

@Entity
@Table(name = "games")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(length = 1000)
    private String description;

    @Column
    private String genre;

    @Column
    private String developer;

    @Column
    private int releaseYear;

    public Game() {}

    public Game(String title, String description, String genre, String developer, int releaseYear) {
        this.title = title;
        this.description = description;
        this.genre = genre;
        this.developer = developer;
        this.releaseYear = releaseYear;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }
    public String getDeveloper() { return developer; }
    public void setDeveloper(String developer) { this.developer = developer; }
    public int getReleaseYear() { return releaseYear; }
    public void setReleaseYear(int releaseYear) { this.releaseYear = releaseYear; }
}