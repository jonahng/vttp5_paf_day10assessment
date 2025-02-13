package vttp.batch5.paf.movies.repositories;

public class SQLQueries {
    public static final String SQLInsert = """
            insert into imdb(imdb_id,vote_average,vote_count,release_date,revenue,budget,runtime) values (?,?,?,?,?,?,?);
            """;
}
