package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.Playerbean;

public class PlayerDAO {

    public boolean addPlayer(Playerbean player) {

        boolean status = false;

        try {

            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO player(player_name, role, team_id) VALUES(?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, player.getPlayerName());
            ps.setString(2, player.getRole());
            ps.setInt(3, player.getTeamId());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                status = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    public ArrayList<Playerbean> getAllPlayers() {

        ArrayList<Playerbean> list = new ArrayList<>();

        try {

            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM player";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Playerbean player = new Playerbean();

                player.setPlayerId(rs.getInt("player_id"));
                player.setPlayerName(rs.getString("player_name"));
                player.setRole(rs.getString("role"));
                player.setTeamId(rs.getInt("team_id"));

                list.add(player);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public Playerbean getPlayerById(int playerId) {

        Playerbean player = new Playerbean();

        try {

            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM player WHERE player_id=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, playerId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                player.setPlayerId(rs.getInt("player_id"));
                player.setPlayerName(rs.getString("player_name"));
                player.setRole(rs.getString("role"));
                player.setTeamId(rs.getInt("team_id"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return player;
    }

    public boolean updatePlayer(Playerbean player) {

        boolean status = false;

        try {

            Connection con = DBConnection.getConnection();

            String sql = "UPDATE player SET player_name=?, role=?, team_id=? WHERE player_id=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, player.getPlayerName());
            ps.setString(2, player.getRole());
            ps.setInt(3, player.getTeamId());
            ps.setInt(4, player.getPlayerId());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                status = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    public boolean deletePlayer(int playerId) {

        boolean status = false;

        try {

            Connection con = DBConnection.getConnection();

            String sql = "DELETE FROM player WHERE player_id=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, playerId);

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