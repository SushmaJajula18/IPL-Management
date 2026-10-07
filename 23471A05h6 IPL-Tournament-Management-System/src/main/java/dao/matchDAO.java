package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.Matchbean;

public class matchDAO {

    public boolean addMatch(Matchbean match) {

        boolean status = false;

        try {

            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO match_table(team1,team2,winner,match_date,venue) VALUES(?,?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, match.getTeam1());
            ps.setString(2, match.getTeam2());
            ps.setString(3, match.getWinner());
            ps.setString(4, match.getMatchDate());
            ps.setString(5, match.getVenue());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                status = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    public ArrayList<Matchbean> getAllMatches() {

        ArrayList<Matchbean> list = new ArrayList<>();

        try {

            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM match_table";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Matchbean match = new Matchbean();

                match.setMatchId(rs.getInt("match_id"));
                match.setTeam1(rs.getString("team1"));
                match.setTeam2(rs.getString("team2"));
                match.setWinner(rs.getString("winner"));
                match.setMatchDate(rs.getString("match_date"));
                match.setVenue(rs.getString("venue"));

                list.add(match);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public boolean deleteMatch(int matchId) {

        boolean status = false;

        try {

            Connection con = DBConnection.getConnection();

            String sql = "DELETE FROM match_table WHERE match_id=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, matchId);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                status = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

}