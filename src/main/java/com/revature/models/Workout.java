package com.revature.models;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity						// tells java that this will be mapped to a table in the database
@Table(name="Workout")		// specifies the table it will be mapped to

public class Workout {

}
