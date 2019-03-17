hadoop fs -copyFromLocal movie_metadata.csv labs/hadoop/pig/input/movie_metadata.csv
pig -f IMDB_Score.pig
pig -f IMDB_Likes.pig
pig -f IMDB_Genres.pig