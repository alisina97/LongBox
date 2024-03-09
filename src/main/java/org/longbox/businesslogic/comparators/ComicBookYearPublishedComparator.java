package org.longbox.businesslogic.comparators;

import org.longbox.domainobjects.dto.ComicBookDto;

import java.util.Comparator;

public class ComicBookYearPublishedComparator implements Comparator<ComicBookDto> {
    @Override
    public int compare(ComicBookDto comicBook1, ComicBookDto comicBook2) {

        if (comicBook1.getYearPublished() > comicBook2.getYearPublished()) {
            return 1;
        }
        if (comicBook1.getYearPublished() < comicBook2.getYearPublished()) {
            return -1;
        }
        else {
            return 0;
        }
    }
}
