# LongBox ITR03 Build

Your digital solution for archiving and preserving comic books. Developed by passionate fans, this open-source desktop app offers concise documentation for out-of-print, independent, and mainstream comics. Addressing the decline in sales, LongBox provides a user-friendly platform for organizing and archiving collections. With web application plans, it aims to be a central hub for enthusiasts. Users can create profiles, submit comics, and enjoy a recommendation system. Built from scratch, LongBox prioritizes simplicity without relying on existing projects.

## System 

This project uses a 3-layer software architecture. The system is built around the Java Swing framework and behaves as a model view controller application in conformance to the oracle documentation for Swing applications. A sketch of it is:

![SystemDiagram](design_documents/diagrams/architecture_diagram_dark_mode.png)

### Documentation

There are three major documentation types for this project.
1. Several design & planning documents. These have several iterations/revisions and can be found in the [planning directory](design_documents/planning)
2. A [code review document](design_documents/code_review/EECS2311-Z-Team3-TakeHomeAssignment.pdf) that provides peer review done by the team on each other's user stories/features. It provides problem reports, code smells and end-2-end tests for the project.
3. A [refactoring document](design_documents/code_review/Refactoring_Document.pdf) that highlights major design changes in response to code review and problem reports above.

## Getting Started

### Prerequisites

- The project is built on Java 19.
- The project uses Gradle as the build system.
- The project uses [PostgreSQL 16](https://www.postgresql.org/) as the database.

### Installing

1. Clone the [GitHub Repository](https://github.com/Hashir-Jamil/LongBox) delivery-2 branch or download the source for Delivery 2 release.
2. If using eclipse, once the project has been cloned, gradle nature needs to be added to the project. [How to configure gradle in eclipse](https://www.vogella.com/tutorials/EclipseGradle/article.html#add-gradle-support-to-existing-eclipse-project).
3. To use the database, we need [PostgreSQL](https://www.postgresql.org). Run PostgreSQL via command line and create a new database called **longbox_db**.
>  createdb longbox_db; 
4. After creating the database, open the database using 
>  psql -p 5432 -d longbox_db;
5. Once the database view open (you should see longbox_db=# on the left side). Run the following command to load the database (Database script: [create_longbox_db](database_scripts/create_longbox_db.sql)):
>  \i < *path of create_longbox_db.sql* >;
6. To ensure the database server communicates with the project, go to the file [hibernate.cfg.xml](src/main/resources/hibernate.cfg.xml) configuration file and ensure the connection.url property matches the one for your personal machine's PostgreSQL installation and the database made above.

### Build

To build the project run the command:
> gradle clean build

To run the application run the command:
> gradle run 

### Testing

The project uses JUnit and gradle integration for unit testing and integration testing of system code. E2E testing is described in the [Code Review Document](design_documents/code_review/EECS2311-Z-Team3-TakeHomeAssignment.pdf) and organized by feature within the document. 

To execute the full JUnit test suite run the command:
> gradle test

To view the coverage of the tests navigate to the [JaCoCo coverage report](build/jacoco-reports/index.html). This must be done after running the test suite.

If using Eclipse, they can all be run as follows: 
> right click on src/test/java > RunAs > JUnit Test.

## Launching in Eclipse IDE

To launch the project:
>Run **Main.java** in *src/main/java*.

### Build System

[Gradle](https://kotlinlang.org/docs/gradle.html) - Dependency Management

## Features

### Login

This is the first page that the user of the app sees.

![Login](https://github.com/Hashir-Jamil/LongBox/assets/90640849/f301d4e4-9725-477c-82cd-8dc03ea25d7d)

### Registration

New users can sign up and use our app.

![Sign Up](https://github.com/Hashir-Jamil/LongBox/assets/90640849/29155eea-7b16-47bc-97b3-60d623c3d12a)

### Home

This is the first page that the user lands on after logging in the system. The current user's username is displayed near the logout button.
The default view is Comic Repository page where the user can view all the comic books in the app's collection.

![Comic Repo Page](https://github.com/Hashir-Jamil/LongBox/assets/90640849/f939fdd5-1ed5-4527-8234-1fcff95d23ab)

### Advanced Search

Users can use the advanced search and search the comics based on Title, Artist, Author, Genre, Publisher and Year Published. The search results are viewed in a different window.

![Search Results](https://github.com/Hashir-Jamil/LongBox/assets/90640849/a2aaeb1a-05c1-422f-b358-5b685564afe7)

### View Detailed information and Add Comments

After selecting a comic book, users can view detailed information about the comic book. In this window user also has an option to add a new comment, view existing comments in order of newest to oldest, 
favourite and unfavourite a book, add and remove a book from a reading and finished list. Comics added to reading and finished list can be viewed in the profile page.

![Comic Info](https://github.com/Hashir-Jamil/LongBox/assets/90640849/4b78f565-6018-4b12-aadb-3af7b6e3723e)

### Add Comic

Using this page, a user can add a comic book to the system. A user can favourite a comic while adding to the system.

![Add Comic](https://github.com/Hashir-Jamil/LongBox/assets/90640849/f9afc51d-567c-424d-92df-bd0f889a1208)

### Favourite a comic

All the comics favourited are visible in this page, a user can remove a comic from favourites.

![Favourites Page](https://github.com/Hashir-Jamil/LongBox/assets/90640849/4953cd07-9ed9-41ae-bac3-83f0dd2ed367)

Confirmation to remove from favourites:

![Unfavourite](https://github.com/Hashir-Jamil/LongBox/assets/90640849/f0523c0a-70de-45d1-b8af-58c217cf10a8)

### View Profile

Users can view their details on the profile page, including comics read and finished. Users also have an option to edit their about me.
This page will show all user profile information except for the password.

![Profile Page](https://github.com/Hashir-Jamil/LongBox/assets/90640849/52dfa3ec-768f-443d-82fa-fdac6d95a62f)

### Reading & Finished Lists

Users can add and remove books from their personal reading and finished lists of comic books. Add and remove is accomplished when viewing a comic book in its individual page. The lists can be viewed in the profile view and from here the comic books can be selected again to edit their list membership.

![Editing Lists](https://github.com/Hashir-Jamil/LongBox/assets/77168895/07c4fc74-c3f4-4d67-98d8-732a8036e7af)

![Viewing Lists](https://github.com/Hashir-Jamil/LongBox/assets/77168895/f7d02b3f-8d3e-4340-b6c5-ee6f36be5b49)

### Recommendations

Upon login users land on a page of recommendations that are tailored to for them. The entries in this list can be opened to explore more about them.

![Recommendations](https://github.com/Hashir-Jamil/LongBox/assets/77168895/6e7aefda-cefb-4668-9aae-e80d0c90942d)

### Trending

### About Me

### Star Ratings

### Leaderboards

### User Lookup

### Logout

After using the system, the user can log out and will be redirected to the login page.

![Logout](https://github.com/Hashir-Jamil/LongBox/assets/90640849/7bb2e520-4505-487d-8f5c-9fbaade7d7f6)

## Authors
    Hashir Jamil
    Ahan Bhargava
    Mher Eric Gyuluman
    Ali Sina
    Oscar Ye
