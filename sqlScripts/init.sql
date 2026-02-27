CREATE TABLE users (
	id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	password TEXT NOT NULL
);
CREATE TABLE workouts (
	id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	user_id INTEGER NOT NULL,
	date TEXT NOT NULL,
	workout_name TEXT NOT NULL,
	notes TEXT,
	CONSTRAINT workouts_user_FK FOREIGN KEY (user_id) REFERENCES users(id)
);
CREATE TABLE exercises (
	id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	name TEXT NOT NULL,
	muscles TEXT NOT NULL
);
CREATE TABLE workout_exercises (
	id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	workout_id INTEGER NOT NULL,
	exercise_id INTEGER NOT NULL,
	CONSTRAINT workout_exercises_workout_FK FOREIGN KEY (workout_id) REFERENCES workouts(id),
	CONSTRAINT workout_exercises_exercises_FK FOREIGN KEY (exercise_id) REFERENCES exercises(id)
);
CREATE TABLE sets (
	id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	workout_exercises_id INTEGER NOT NULL,
	weight INTEGER,
	reps INTEGER,
	CONSTRAINT sets_workout_exercise_FK FOREIGN KEY (workout_exercises_id) REFERENCES workout_exercises(id)
);




