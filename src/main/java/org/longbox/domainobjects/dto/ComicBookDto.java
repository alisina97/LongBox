package org.longbox.domainobjects.dto;

import org.longbox.businesslogic.utils.GenreUtils;
import org.longbox.domainobjects.entity.ComicBook;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;
@Getter
@Setter
@NoArgsConstructor
public class ComicBookDto {
    private long id;
    private String seriesTitle;
    private String author;
    private String artist;
    private String[] genres;
    private String description;
    private int numberOfIssues;
    private String publisher;
    private int yearPublished;
    private Date dateAdded;
    private int northAmericaFavoritesCount;
    private int southAmericaFavoritesCount;
    private int europeFavoritesCount;
    private int asiaFavoritesCount;
    private int africaFavoritesCount;
    private int oceaniaFavoritesCount;
    private int antarcticaFavoritesCount;    
    private int favoritesCount;

    public ComicBookDto(
        long id,
        String seriesTitle,
        String author,
        String artist,
        String[] genres,
        String description,
        int numberOfIssues,
        String publisher,
        int yearPublished
    ) {
        this.id = id;
        this.seriesTitle = seriesTitle;
        this.author = author;
        this.artist = artist;
        this.genres = genres;
        this.description = description;
        this.numberOfIssues = numberOfIssues;
        this.yearPublished = yearPublished;
        this.publisher = publisher;
        this.dateAdded = new Date();
        this.northAmericaFavoritesCount = 0;
        this.southAmericaFavoritesCount = 0;
        this.europeFavoritesCount = 0;
        this.asiaFavoritesCount = 0;
        this.africaFavoritesCount = 0;
        this.oceaniaFavoritesCount = 0;
        this.antarcticaFavoritesCount = 0;
        this.favoritesCount = 0;
    }

    public ComicBookDto(
        String seriesTitle,
        String author,
        String artist,
        String genres,
        String description,
        int numberOfIssues,
        String publisher,
        int yearPublished,
        Date date, 
        int northAmericaFavoritesCount,
        int southAmericaFavoritesCount,
        int europeFavoritesCount,
        int asiaFavoritesCount,
        int africaFavoritesCount,
        int oceaniaFavoritesCount,
        int antarcticaFavoritesCount,
        int favoritesCount
    ) {
        this.seriesTitle = seriesTitle;
        this.author = author;
        this.artist = artist;
        this.genres = GenreUtils.genreStringToList(genres);
        this.description = description;
        this.numberOfIssues = numberOfIssues;
        this.yearPublished = yearPublished;
        this.publisher = publisher;
        this.dateAdded = date;
        this.northAmericaFavoritesCount = northAmericaFavoritesCount;
        this.southAmericaFavoritesCount = southAmericaFavoritesCount;
        this.europeFavoritesCount = europeFavoritesCount;
        this.asiaFavoritesCount = asiaFavoritesCount;
        this.africaFavoritesCount = africaFavoritesCount;
        this.oceaniaFavoritesCount = oceaniaFavoritesCount;
        this.antarcticaFavoritesCount = antarcticaFavoritesCount;
        this.favoritesCount = favoritesCount;
    };

    public ComicBookDto(
        String seriesTitle,
        String author,
        String artist,
        String[] genres,
        String description,
        int numberOfIssues,
        String publisher,
        int yearPublished
    ) {
        this.seriesTitle = seriesTitle;
        this.author = author;
        this.artist = artist;
        this.genres = genres;
        this.description = description;
        this.numberOfIssues = numberOfIssues;
        this.yearPublished = yearPublished;
        this.publisher = publisher;
        this.dateAdded = new Date();
        this.northAmericaFavoritesCount = 0;
        this.southAmericaFavoritesCount = 0;
        this.europeFavoritesCount = 0;
        this.asiaFavoritesCount = 0;
        this.africaFavoritesCount = 0;
        this.oceaniaFavoritesCount = 0;
        this.antarcticaFavoritesCount = 0;
        this.favoritesCount = 0;
    }
  
    public ComicBookDto(ComicBook comicBookRecord) {
    	this(
            comicBookRecord.getSeriesTitle(),
            comicBookRecord.getAuthor(),
            comicBookRecord.getArtist(),
            comicBookRecord.getGenres(),
            comicBookRecord.getDescription(),
            comicBookRecord.getNumberOfIssues(),
            comicBookRecord.getPublisher(),
            comicBookRecord.getYearPublished(),
            comicBookRecord.getDateAdded(),
            comicBookRecord.getNorthAmericaFavoritesCount(),
            comicBookRecord.getSouthAmericaFavoritesCount(),
            comicBookRecord.getEuropeFavoritesCount(),
            comicBookRecord.getAsiaFavoritesCount(),
            comicBookRecord.getAfricaFavoritesCount(),
            comicBookRecord.getOceaniaFavoritesCount(),
            comicBookRecord.getAntarcticaFavoritesCount(),
            comicBookRecord.getFavoritesCount()
        );
        this.setId(comicBookRecord.getId());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComicBookDto that = (ComicBookDto) o;
        return getYearPublished() == that.getYearPublished() && Objects.equals(getSeriesTitle(), that.getSeriesTitle()) && Objects.equals(getAuthor(), that.getAuthor()) && Objects.equals(getArtist(), that.getArtist()) && Objects.equals(getPublisher(), that.getPublisher());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSeriesTitle(), getAuthor(), getArtist(), getPublisher(), getYearPublished());
    }

    @Override
    public String toString() {
        return "ComicBookDTO{" +
                "id=" + id +
                ", seriesTitle='" + seriesTitle + '\'' +
                ", author='" + author + '\'' +
                ", artist='" + artist + '\'' +
                ", genres=" + Arrays.toString(genres) +
                ", description='" + description + '\'' +
                ", numberOfIssues=" + numberOfIssues +
                ", publisher='" + publisher + '\'' +
                ", yearPublished=" + yearPublished +
                ", dateAdded=" + dateAdded +
                ", favoritesCount=" + favoritesCount +
                '}';
    }
}