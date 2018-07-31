CREATE TABLE `User`(
	user_id			int				NOT NULL,
    username		varchar(25)		NOT NULL,
    `password`		varchar(25)		NOT NULL,
    firstName		varchar(25),
    lastName		varchar(25),
    email			varchar(250),
    phone			varchar(25),
    
    CONSTRAINT UC_User 	UNIQUE(user_id, username, email, phone),
    CONSTRAINT PK_User 	Primary Key(user_id)
);

CREATE TABLE Visibility(
	visibility_id	int		NOT NULL,
    visibility		varchar(10),
    
    CONSTRAINT PK_Visibility PRIMARY KEY (visibility_id));

CREATE TABLE `Type`(
	type_id			int,
    type_name		varchar(25),
    
    CONSTRAINT PK_Type	PRIMARY KEY (type_id)
);

-- drop all tables, then re run with AUTO_INCREMENT on each primary key
DROP TABLE Workout;
DROP TABLE Exercise;
DROP TABLE `Type`;
DROP TABLE Visibility;
DROP TABLE User;
DROP TABLE ExerciseWorkout;
CREATE TABLE Workout(
	workout_id			int,
    user_id				int,
    type_id				int,
    workout_name		varchar(25),
    workout_description varchar(25),
    queued_workout		varchar(1),
    
    CONSTRAINT PK_Workout	PRIMARY KEY (workout_id),
    CONSTRAINT FK_Workout_User	FOREIGN KEY (user_id)
		REFERENCES User (user_id)
        ON DELETE SET NULL
        ON UPDATE CASCADE,
	CONSTRAINT FK_Workout_Type	FOREIGN KEY (type_id)
		REFERENCES `Type` (type_id)
        ON UPDATE CASCADE
);

CREATE TABLE Exercise(
	exercise_id				int,
    user_id					int,
    type_id					int,
    exercise_name			varchar(25),
    exercise_description	varchar(25),
    exercise_sets			int,
    exercise_reps			int,
    exercise_duration		int,
    
    CONSTRAINT PK_Exercise	PRIMARY KEY (Exercise_id),
    CONSTRAINT FK_Exercise_User	FOREIGN KEY (user_id)
		REFERENCES User (user_id)
        ON DELETE RESTRICT
        ON UPDATE CASCADE,
	CONSTRAINT FK_Exercise_Type	FOREIGN KEY (type_id)
		REFERENCES `Type` (type_id)
        ON DELETE SET NULL
        ON UPDATE CASCADE
);

CREATE TABLE ExerciseWorkout(
	exercise_id		int,
    workout_id		int,
    
    CONSTRAINT PK_ExerciseWorkout_ExerciseWorkout PRIMARY KEY (exercise_id, workout_id)
);





