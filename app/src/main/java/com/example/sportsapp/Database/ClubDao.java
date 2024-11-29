package com.example.sportsapp.Database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import com.example.sportsapp.Database.Club;
import java.util.List;

@Dao
public interface ClubDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertClub(Club club);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertClubs(List<Club> clubs);

    @Query("SELECT * FROM clubs")
    List<Club> getAllClubs();

    @Query("DELETE FROM clubs")
    void deleteAllClubs();

    // Example query to get clubs by league
    @Query("SELECT * FROM clubs WHERE league = :leagueName")
    List<Club> getClubsByLeague(String leagueName);


    @Query("SELECT * FROM clubs WHERE name LIKE '%' || :query || '%' OR league LIKE '%' || :query || '%'")
    List<Club> searchClubs(String query);

}
