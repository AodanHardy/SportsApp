package com.example.sportsapp.Database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import com.example.sportsapp.Database.Club;
import java.util.List;

/**
 * The DAO for the clubs table.
 */
@Dao
public interface ClubDao {

    /**
     * Insert club.
     *
     * @param club the club
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertClub(Club club);

    /**
     * Insert clubs.
     *
     * @param clubs the clubs
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertClubs(List<Club> clubs);

    /**
     * Gets all clubs.
     *
     * @return the all clubs
     */
    @Query("SELECT * FROM clubs")
    List<Club> getAllClubs();

    /**
     * Delete all clubs.
     */
    @Query("DELETE FROM clubs")
    void deleteAllClubs();

    /**
     * Gets clubs by league.
     *
     * @param leagueName the league name
     * @return the clubs by league
     */
// Example query to get clubs by league
    @Query("SELECT * FROM clubs WHERE league = :leagueName")
    List<Club> getClubsByLeague(String leagueName);


    /**
     * Search clubs list.
     *
     * @param searchText the search text
     * @return the list
     */
    @Query("SELECT * FROM clubs WHERE name LIKE '%' || :searchText || '%' or league LIKE '%' " +
            "|| :searchText || '%' or shortName LIKE '%' || :searchText " +
            "|| '%' or alternateName LIKE '%' || :searchText || '%'")
    List<Club> searchClubs(String searchText);

}
