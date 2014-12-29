package com.example.teclalabs.myapplication.dao;

import java.io.Serializable;
import com.j256.ormlite.table.DatabaseTable;
import com.j256.ormlite.field.DatabaseField;
/**
 * Created by teclalabs on 29/12/14.
 */

@DatabaseTable(tableName = "contacto")
public class Contacto implements Serializable {

	@DatabaseField(generatedId = true)
	private int id;

	@DatabaseField(index = true, canBeNull = false)
	private String nombre;
	@DatabaseField
	private String telefono;
	@DatabaseField
	private String email;

	@DatabaseField
	private String direccion;


	public Contacto(String nombre, String telefono,String email,String direccion){
		this.nombre = nombre;
		this.telefono = telefono;
		this.email = email;
		this.direccion = direccion;
	}

}


