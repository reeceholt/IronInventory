package backend.repositories;

import models.Exercise;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExerciseRepo {

    private final Connection conn;

    public ExerciseRepo(Connection conn) {
        this.conn = conn;
    }


    public List<Exercise> getExercises() {
        List<Exercise> exercises = new ArrayList<>();
        try (PreparedStatement sql = conn.prepareStatement("Select id, name, muscles FROM Exercises Order by muscles ")) {
            try (ResultSet rs = sql.executeQuery()) {
                while (rs.next()) {
                    exercises.add(new Exercise(rs.getInt("id"), rs.getString("name"), rs.getString("muscles")));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return exercises;
    }

    public Exercise getExercise(int exerciseId) {
        String query = "SELECT id, name, muscles FROM Exercises WHERE id = ?";

        try (PreparedStatement sql = conn.prepareStatement(query)) {

            sql.setInt(1, exerciseId);

            try (ResultSet rs = sql.executeQuery()) {
                if (rs.next()) {
                    return new Exercise(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("muscles")
                    );
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

}
