package com.guicedee.guicedpersistence.c3p0.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Entity1
{
	@Id
	@Column
	private int idColumn;

	public int getIdColumn()
	{
		return idColumn;
	}

	public Entity1 setIdColumn(int idColumn)
	{
		this.idColumn = idColumn;
		return this;
	}
}
