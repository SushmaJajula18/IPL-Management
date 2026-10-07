package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.Teambean;

public class TeamDAO {

    public boolean addTeam(Teambean team) {

        boolean status = false;

        try {

            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO team(team_name,captain,home_city) VALUES(?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, team.getTeamName());
            ps.setString(2, team.getCaptain());
            ps.setString(3, team.getHomeCity());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                status = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    public ArrayList<Teambean> getAllTeams() {

        ArrayList<Teambean> list = new ArrayList<>();

        try {

            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM team";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Teambean team = new Teambean();

                team.setTeamId(rs.getInt("team_id"));
                team.setTeamName(rs.getString("team_name"));
                team.setCaptain(rs.getString("captain"));
                team.setHomeCity(rs.getString("home_city"));

                list.add(team);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public Teambean getTeamById(int teamId) {

        Teambean team = new Teambean();

        try {

            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM team WHERE team_id=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, teamId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                team.setTeamId(rs.getInt("team_id"));
                team.setTeamName(rs.getString("team_name"));
                team.setCaptain(rs.getString("captain"));
                team.setHomeCity(rs.getString("home_city"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return team;
    }

    public boolean updateTeam(Teambean team) {

        boolean status = false;

        try {

            Connection con = DBConnection.getConnection();

            String sql = "UPDATE team SET team_name=?, captain=?, home_city=? WHERE team_id=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, team.getTeamName());
            ps.setString(2, team.getCaptain());
            ps.setString(3, team.getHomeCity());
            ps.setInt(4, team.getTeamId());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                status = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    public boolean deleteTeam(int teamId) {

        boolean status = false;

        try {

            Connection con = DBConnection.getConnection();

            String sql1 = "DELETE FROM player WHERE team_id=?";
            PreparedStatement ps1 = con.prepareStatement(sql1);
            ps1.setInt(1, teamId);
            ps1.executeUpdate();

            String sql2 = "DELETE FROM team WHERE team_id=?";
            PreparedStatement ps2 = con.prepareStatement(sql2);
            ps2.setInt(1, teamId);

            int rows = ps2.executeUpdate();

            if (rows > 0) {
                status = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }
}