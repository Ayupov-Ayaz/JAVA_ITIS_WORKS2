CREATE TABLE film_genre(
film_id INTEGER REFERENCES films(id),
genre_id INTEGER REFERENCES genres(id)
)