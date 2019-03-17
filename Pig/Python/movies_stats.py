import csv

ACTOR_1_NAME = 10
ACTOR_1_LIKES = 7

ACTOR_2_NAME = 6
ACTOR_2_LIKES = 24

ACTOR_3_NAME = 14
ACTOR_3_LIKES = 5

MOVIE_SCORE = 25
GENRES = 9

with open('movie_metadata.csv', encoding="UTF-8") as f:
    file_reader = csv.reader(f, delimiter=',')

    actors_dict = {}
    genres_dict = {}

    headers = file_reader.__next__()
    for row in file_reader:
        actors_movie = [(row[ACTOR_1_NAME], row[ACTOR_1_LIKES]),
                        (row[ACTOR_2_NAME], row[ACTOR_2_LIKES]),
                        (row[ACTOR_3_NAME], row[ACTOR_3_LIKES])]

        movie_score = float(row[MOVIE_SCORE])
        genres = row[GENRES].split('|')

        for genre in genres:
            genre_value = genres_dict.get(genre, (0, 0))
            genres_dict[genre] = (genre_value[0] + movie_score, genre_value[1] + 1)

        for actor in actors_movie:
            if actor[1] != '':
                actor_value = actors_dict.get(actor[0], (0.0, 0, 0))
                actors_dict[actor[0]] = (actor_value[0]+movie_score, actor_value[1]+1, actor_value[2] + int(actor[1]))

    genres_dict = {key: value[0] / value[1] for key, value in genres_dict.items()}
    genres_avg_score = sorted(genres_dict.items(), key=lambda kv: kv[1], reverse=True)
    print(genres_avg_score[:10])

    actors_avg = {key: value[0] / value[1] for key, value in actors_dict.items()}
    actors_avg_score = sorted(actors_avg.items(), key=lambda kv: kv[1], reverse=True)
    print(actors_avg_score[:10])

    actors_likes = {key: value[2] for key, value in actors_dict.items()}
    actors_by_likes = sorted(actors_likes.items(), key=lambda kv: kv[1], reverse=True)
    print(actors_by_likes[:10])
