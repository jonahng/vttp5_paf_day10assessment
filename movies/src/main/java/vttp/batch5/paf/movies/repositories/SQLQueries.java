package vttp.batch5.paf.movies.repositories;

public class SQLQueries {
    public static final String SQLInsert = """
            insert into imdb(imdb_id,vote_average,vote_count,release_date,revenue,budget,runtime) values (?,?,?,?,?,?,?);
            """;

    public static final String SQLGetSpecificMovieDetails = """
            select * from imdb WHERE imdb_id LIKE ?;
            """;
}
