import backend.Database;
import backend.repositories.ExerciseRepo;
import backend.repositories.WorkoutRepo;
import backend.services.WorkoutService;
import ui.Gui;
import ui.UIController;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

/*
Initializes everything
UI
    GUI (Window management wrapper) -> UIController (Navigation) -> Windows (What we see)
Backend
    Service (used in UIController) -> Repositories (Queries the db) -> DB (Handles the DB connection)
 */
public class App {
    public static void run() throws SQLException {
        String url = "jdbc:sqlite:db";
        try (
                Database db = new Database(url);
        ) {
            // database
            db.connect();
            Connection conn = db.getConnection();

            // Repositories
            WorkoutRepo workoutRepo = new WorkoutRepo(conn);
            ExerciseRepo exerciseRepo = new ExerciseRepo(conn);

            // Services
            WorkoutService workoutService = new WorkoutService(workoutRepo, exerciseRepo);

            // GUI
            Gui gui = new Gui();
            gui.start();
            UIController ui = new UIController(gui, workoutService);
            ui.showMainMenu();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
