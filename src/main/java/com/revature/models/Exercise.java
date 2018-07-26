package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity						// tells java that this will be mapped to a table in the database
@Table(name="Exercise")		// specifies the table it will be mapped to
@Component
public class Exercise {

	@Id
	@Column
	private int exercise_id;	
	@Column
	private int type_id;
	@Column
	private int user_id;
	@Column
	private String exercise_name;
	@Column
	private String exercise_description;
	@Column
	private String exercise_sets;
	@Column
	private String exercise_reps;
	@Column
	private String exercise_duration;
	
	public Exercise() {}

	public Exercise(int exercise_id, int type_id, int user_id, String exercise_name, String exercise_description,
			String exercise_sets, String exercise_reps, String exercise_duration) {
		super();
		this.exercise_id = exercise_id;
		this.type_id = type_id;
		this.user_id = user_id;
		this.exercise_name = exercise_name;
		this.exercise_description = exercise_description;
		this.exercise_sets = exercise_sets;
		this.exercise_reps = exercise_reps;
		this.exercise_duration = exercise_duration;
	}

	public Exercise(int exercise_id, int type_id, int user_id, String exercise_name, String exercise_sets,
			String exercise_reps, String exercise_duration) {
		super();
		this.exercise_id = exercise_id;
		this.type_id = type_id;
		this.user_id = user_id;
		this.exercise_name = exercise_name;
		this.exercise_sets = exercise_sets;
		this.exercise_reps = exercise_reps;
		this.exercise_duration = exercise_duration;
	}

	public int getExercise_id() {
		return exercise_id;
	}

	public void setExercise_id(int exercise_id) {
		this.exercise_id = exercise_id;
	}

	public int getType_id() {
		return type_id;
	}

	public void setType_id(int type_id) {
		this.type_id = type_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getExercise_name() {
		return exercise_name;
	}

	public void setExercise_name(String exercise_name) {
		this.exercise_name = exercise_name;
	}

	public String getExercise_description() {
		return exercise_description;
	}

	public void setExercise_description(String exercise_description) {
		this.exercise_description = exercise_description;
	}

	public String getExercise_sets() {
		return exercise_sets;
	}

	public void setExercise_sets(String exercise_sets) {
		this.exercise_sets = exercise_sets;
	}

	public String getExercise_reps() {
		return exercise_reps;
	}

	public void setExercise_reps(String exercise_reps) {
		this.exercise_reps = exercise_reps;
	}

	public String getExercise_duration() {
		return exercise_duration;
	}

	public void setExercise_duration(String exercise_duration) {
		this.exercise_duration = exercise_duration;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((exercise_description == null) ? 0 : exercise_description.hashCode());
		result = prime * result + ((exercise_duration == null) ? 0 : exercise_duration.hashCode());
		result = prime * result + exercise_id;
		result = prime * result + ((exercise_name == null) ? 0 : exercise_name.hashCode());
		result = prime * result + ((exercise_reps == null) ? 0 : exercise_reps.hashCode());
		result = prime * result + ((exercise_sets == null) ? 0 : exercise_sets.hashCode());
		result = prime * result + type_id;
		result = prime * result + user_id;
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
		Exercise other = (Exercise) obj;
		if (exercise_description == null) {
			if (other.exercise_description != null)
				return false;
		} else if (!exercise_description.equals(other.exercise_description))
			return false;
		if (exercise_duration == null) {
			if (other.exercise_duration != null)
				return false;
		} else if (!exercise_duration.equals(other.exercise_duration))
			return false;
		if (exercise_id != other.exercise_id)
			return false;
		if (exercise_name == null) {
			if (other.exercise_name != null)
				return false;
		} else if (!exercise_name.equals(other.exercise_name))
			return false;
		if (exercise_reps == null) {
			if (other.exercise_reps != null)
				return false;
		} else if (!exercise_reps.equals(other.exercise_reps))
			return false;
		if (exercise_sets == null) {
			if (other.exercise_sets != null)
				return false;
		} else if (!exercise_sets.equals(other.exercise_sets))
			return false;
		if (type_id != other.type_id)
			return false;
		if (user_id != other.user_id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Exercise [exercise_id=" + exercise_id + ", type_id=" + type_id + ", user_id=" + user_id
				+ ", exercise_name=" + exercise_name + ", exercise_description=" + exercise_description
				+ ", exercise_sets=" + exercise_sets + ", exercise_reps=" + exercise_reps + ", exercise_duration="
				+ exercise_duration + "]";
	}
	
	
	
	
}
