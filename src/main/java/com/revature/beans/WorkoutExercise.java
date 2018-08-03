package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

public class WorkoutExercise {

	@Entity						// tells java that this will be mapped to a table in the database
	@Table(name="WorkoutExercise")		// specifies the table it will be mapped to
	@Component
	@SequenceGenerator(name="workoutExerciseSeq", sequenceName="WORKOUTEXERCISE_SEQ", allocationSize=1)
	public class Exercise {

		@Id
		@Column(name="junction_id")
		@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="workoutExerciseSeq")
		private int junction_id;

		@Column(name="workout_id")
		private int workout_id;
		
		@Column(name="exercise_id")
		private int exercise_id;
		
		@Column(name="type_id")
		private int type_id;

		@Column(name="user_id")
		private int user_id;

		@Column(name="exercise_name")
		private String exercise_name;

		@Column(name="exercise_description")
		private String exercise_description;

		@Column(name="exercise_sets")
		private String exercise_sets;

		@Column(name="exercise_reps")
		private String exercise_reps;

		@Column(name="exercise_duration")
		private String exercise_duration;

		@Column(name="exercise_rest")
		private String exercise_rest;
	}
}
