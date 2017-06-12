CREATE TABLE film_actor(
film_id INTEGER REFERENCES films(id),
actor_id INTEGER REFERENCES actors(id)
)