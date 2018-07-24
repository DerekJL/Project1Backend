package com.revature.models;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity					// tells java that this will be mapped to a table in the database
@Table(name="User")		// specifies the table it will be mapped to
/* 
 * @SequenceGenerator(name="user_seq", sequenceName="user_seq", allocationSize=1) 
 * we can just set the auto-increment constraint on our PK in mySQL
 */
public class User {

}
