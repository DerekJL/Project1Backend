CREATE TABLE `User`(
	user_id			int				NOT NULL		AUTO_INCREMENT,
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
	visibility_id	int		NOT NULL		AUTO_INCREMENT,
    visibility		varchar(10),
    
    CONSTRAINT PK_Visibility PRIMARY KEY (visibility_id));

CREATE TABLE `Type`(
	type_id			int			AUTO_INCREMENT,
    type_name		varchar(25),
    
    CONSTRAINT PK_Type	PRIMARY KEY (type_id)
);

-- drop all tables, then re run with AUTO_INCREMENT on each primary key
/*
DROP TABLE Workout;
DROP TABLE Exercise;
DROP TABLE `Type`;
DROP TABLE Visibility;
DROP TABLE User;
DROP TABLE ExerciseWorkout;
*/

/*
ALTER TABLE Workout 
	ADD COLUMN workout_visibility iUserUsernt AFTER workout_description;
*/

/*
ALTER TABLE Exercise
DROP COLUMN workout_id;
*/

/*
ALTER TABLE Workout
	ADD Exercise_id		int	AFTER workout_id;
*/

CREATE TABLE Workout(
	workout_id			int		AUTO_INCREMENT,
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

-- ALTER TABLE Exercise
-- ADD workout_id		int	AFTER exercise_id;


CREATE TABLE Exercise(
	exercise_id				int				AUTO_INCREMENT,
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

INSERT INTO `Type` VALUES (1, 'Upper Body');
INSERT INTO `Type` VALUES (2, 'Lower Body');
INSERT INTO `Type` VALUES (3, 'Full Body');
INSERT INTO `Type` VALUES (4, 'Chest');
INSERT INTO `Type` VALUES (5, 'Back');
INSERT INTO `Type` VALUES (6, 'Biceps');
INSERT INTO `Type` VALUES (7, 'Triceps');
INSERT INTO `Type` VALUES (8, 'Shoulders');
INSERT INTO `Type` VALUES (9, 'Abs');
INSERT INTO `Type` VALUES (10, 'Glutes');
INSERT INTO `Type` VALUES (11, 'Hamstrings');
INSERT INTO `Type` VALUES (12, 'Quads');
INSERT INTO `Type` VALUES (13, 'Calves');
INSERT INTO `Type` VALUES (14, 'Cardio');


INSERT INTO Workout VALUES (1, 1, 1, 1, 'Upper Strength', 'Heavy upper body day', 1, 1);

Commit;




