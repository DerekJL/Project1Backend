package com.revature.beans;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity						// tells java that this will be mapped to a table in the database
@Table(name="Workout")		// specifies the table it will be mapped to
@Component
@SequenceGenerator(name="workoutSeq", sequenceName="WORKOUT_SEQ", allocationSize=1)
public class Workout {
	
	@Id
	@Column(name="workout_id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="workoutSeq")
	private int workout_id;
	
	@Column(name="user_id")
	private int User_id;
	
	@Column(name="type_id")
	private int type_id;
	
	@Column(name="workout_name")
	private String workout_name;
	
	@Column(name="workout_description")
	private String workout_description;
	
	@Column(name="workout_visibility")
	private int workout_visibility;
	
	@Column(name="queued_workout")
	private String queued_workout;
	
	@JsonIgnore
	@ManyToMany(fetch=FetchType.EAGER, cascade= {
			CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.DETACH, CascadeType.REFRESH
	})
	@JoinTable(
			name="ExerciseWorkout",
			joinColumns=@JoinColumn(name="workout_id"),
			inverseJoinColumns=@JoinColumn(name="exercise_id")
			)
	
	private List<Exercise> exercises;
	
	
	public Workout() {}
	
	
	public Workout(int workout_id, int user_id, int type_id, String workout_name, String workout_description,
			int workout_visibility, String queued_workout) {
		super();
		this.workout_id = workout_id;
		User_id = user_id;
		this.type_id = type_id;
		this.workout_name = workout_name;
		this.workout_description = workout_description;
		this.workout_visibility = workout_visibility;
		this.queued_workout = queued_workout;
	}
	
	public Workout(int user_id, int type_id, String workout_name, int workout_visibility, String queued_workout) {
		super();
		User_id = user_id;
		this.type_id = type_id;
		this.workout_name = workout_name;
		this.workout_visibility = workout_visibility;
		this.queued_workout = queued_workout;
	}


	public int getWorkout_id() {
		return workout_id;
	}
	public void setWorkout_id(int workout_id) {
		this.workout_id = workout_id;
	}
	public int getUser_id() {
		return User_id;
	}
	public void setUser_id(int user_id) {
		User_id = user_id;
	}
	public int getType_id() {
		return type_id;
	}
	public void setType_id(int type_id) {
		this.type_id = type_id;
	}
	public String getWorkout_name() {
		return workout_name;
	}
	public void setWorkout_name(String workout_name) {
		this.workout_name = workout_name;
	}
	public String getWorkout_description() {
		return workout_description;
	}
	public void setWorkout_description(String workout_description) {
		this.workout_description = workout_description;
	}
	
	public int getWorkout_visibility() {
		return workout_visibility;
	}

	public void setWorkout_visibility(int workout_visibility) {
		this.workout_visibility = workout_visibility;
	}

	public String getQueued_workout() {
		return queued_workout;
	}
	public void setQueued_workout(String string) {
		this.queued_workout = string;
	}
	
	
	public List<Exercise> getExercises() {
		return exercises;
	}


	public void setExercises(List<Exercise> exercises) {
		this.exercises = exercises;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + User_id;
		result = prime * result + type_id;
		result = prime * result + ((workout_description == null) ? 0 : workout_description.hashCode());
		result = prime * result + workout_id;
		result = prime * result + ((workout_name == null) ? 0 : workout_name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Workout other = (Workout) obj;
		if (User_id != other.User_id)
			return false;
		if (queued_workout != other.queued_workout)
			return false;
		if (type_id != other.type_id)
			return false;
		if (workout_description == null) {
			if (other.workout_description != null)
				return false;
		} else if (!workout_description.equals(other.workout_description))
			return false;
		if (workout_id != other.workout_id)
			return false;
		if (workout_name == null) {
			if (other.workout_name != null)
				return false;
		} else if (!workout_name.equals(other.workout_name))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Workout [workout_id=" + workout_id + ", User_id=" + User_id + ", type_id=" + type_id + ", workout_name="
				+ workout_name + ", workout_description=" + workout_description + ", queued_workout=" + queued_workout
				+ "]";
	}
	
	
	
	

}
