package org.longbox.unit.businesslogic.comparators;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.longbox.businesslogic.comparators.ComicBookDateAddedComparator;
import org.longbox.domainobjects.dto.ComicBookDto;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComicBookDateAddedComparatorTest {
    ComicBookDto comicBook1;
    ComicBookDto comicBook2;
    ComicBookDto comicBook3;
    ComicBookDto comicBook4;
    ComicBookDateAddedComparator comparator;

    @BeforeEach
    public void setup() {
        comparator = new ComicBookDateAddedComparator();

        comicBook1 = new ComicBookDto(
                "Batman",
                "Frank Miller",
                "David Mazzucchelli",
                new String[]{"Action", "Crime"},
                "A classic Batman story",
                4,
                "DC Comics",
                1987
        );

        comicBook2 = new ComicBookDto(
                "Spider-Man",
                "Stan Lee",
                "Steve Ditko",
                new String[]{"Action", "Adventure"},
                "The first appearance of Spider-Man",
                1,
                "Marvel Comics",
                1962
        );

        comicBook3 = new ComicBookDto(
                "X-Men",
                "Chris Claremont",
                "Jim Lee",
                new String[]{"Action", "Sci-Fi"},
                "The iconic '90s X-Men series",
                30,
                "Marvel Comics",
                1991
        );

        comicBook4 = new ComicBookDto(
                "Wonder Woman",
                "George Perez",
                "George Perez",
                new String[]{"Action", "Fantasy"},
                "Revitalizing Wonder Woman in the '80s",
                6,
                "DC Comics",
                1987
        );
    }

    @Test
    void test_equals_1(){
        int expected = 0;
        int actual = comparator.compare(comicBook1, comicBook2);
        assertEquals(expected, actual);
    }

    @Test
    void test_equals_2(){
        int expected = 0;
        int actual = comparator.compare(comicBook1, comicBook4);
        assertEquals(expected, actual);
    }

    @Test
    void test_equals_3(){
        int expected = 0;
        int actual = comparator.compare(comicBook3, comicBook4);
        assertEquals(expected, actual);
    }

    @Test
    void test_equals_4(){
        int expected = 0;
        int actual = comparator.compare(comicBook2, comicBook3);
        assertEquals(expected, actual);
    }

    @Test
    void test_equals_5(){
        int expected = 0;
        int actual = comparator.compare(comicBook3, comicBook1);
        assertEquals(expected, actual);
    }

    @Test
    void test_equals_6(){
        int expected = 0;
        int actual = comparator.compare(comicBook3, comicBook2);
        assertEquals(expected, actual);
    }

}
