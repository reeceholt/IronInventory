package backend.repositories;

import models.Exercise;
import models.Workout;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WorkoutRepo {

    private final Connection conn;

    public WorkoutRepo(Connection conn) {
        this.conn = conn;
    }

    public List<Workout> getWorkouts() {
        List<Workout> workouts = new ArrayList<>();
        try (PreparedStatement sql = conn.prepareStatement("Select id, workout_name, notes FROM workouts")) {
            try (ResultSet rs = sql.executeQuery()) {
                while (rs.next()) {
                    workouts.add(new Workout(rs.getInt("id"), rs.getString("workout_name"), rs.getString("notes")));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return workouts;
    }

    public Workout getWorkout(int workoutId) {
        String query = "SELECT id, workout_name, notes FROM workouts WHERE id = ?";

        try (PreparedStatement sql = conn.prepareStatement(query)) {

            sql.setInt(1, workoutId);

            try (ResultSet rs = sql.executeQuery()) {
                if (rs.next()) {
                    return new Workout(
                            rs.getInt("id"),
                            rs.getString("workout_name"),
                            rs.getString("notes")
                    );
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

}
