REGISTER /usr/hdp/current/pig-client/piggybank.jar;

movies = LOAD 'labs/hadoop/pig/input/movie_metadata.csv' USING org.apache.pig.piggybank.storage.CSVExcelStorage() as (
																														color:chararray,
																														director_name:chararray,
																														num_critic_for_reviews:int,
																														duration:int,
																														director_facebook_likes:int,
																														actor_3_facebook_likes:int,
																														actor_2_name:chararray,
																														actor_1_facebook_likes:int,
																														gross:int,
																														genres:chararray,
																														actor_1_name:chararray,
																														movie_title:chararray,
																														num_voted_users:int,
																														cast_total_facebook_likes:int,
																														actor_3_name:chararray,
																														facenumber_in_poster:int,
																														plot_keywords:chararray,
																														movie_imdb_link:chararray,
																														num_user_for_reviews:int,
																														language:chararray,
																														country:chararray,
																														content_rating:chararray,
																														budget:int,
																														title_year:int,
																														actor_2_facebook_likes:int,
																														imdb_score:double,
																														aspect_ratio:double,
																														movie_facebook_likes:int);


movies = RANK movies;
movies = FILTER movies BY $0>1;

actors = FOREACH movies GENERATE flatten(TOBAG((actor_1_name , actor_1_facebook_likes), (actor_2_name , actor_2_facebook_likes), (actor_3_name , actor_3_facebook_likes)));
actors = GROUP actors BY $0;

final_rank = FOREACH actors GENERATE $0, SUM($1.$1) as likes_sum;
final_rank = ORDER final_rank BY likes_sum DESC;
limit_data = LIMIT final_rank 10; 
DUMP limit_data;
