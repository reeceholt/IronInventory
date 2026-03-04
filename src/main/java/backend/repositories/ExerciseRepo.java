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

    public Exercise getExercise(long exerciseId) {
        String query = "SELECT id, name, muscles FROM Exercises WHERE id = ?";

        try (PreparedStatement sql = conn.prepareStatement(query)) {

            sql.setLong(1, exerciseId);

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

    public long addExercise(Exercise exercise) {
        try (PreparedStatement sql = conn.prepareStatement("""
                INSERT INTO exercises (name, muscles)
                	VALUES (?, ?);
                """)) {
            sql.setString(1, exercise.name());
            sql.setString(2, exercise.muscles());
            int affectedRows = sql.executeUpdate();
            if (affectedRows > 0) {
                try (ResultSet rs = sql.getGeneratedKeys()) {
                    if (rs.next()) {
                        return rs.getLong(1);
                    }
                }
            }
            return -1L;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
