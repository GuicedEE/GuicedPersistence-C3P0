package com.guicedee.guicedpersistence.c3p0.test.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Entity2
{
	@Id
	@Column
	private int idColumn;

	public int getIdColumn()
	{
		return idColumn;
	}

	public Entity2 setIdColumn(int idColumn)
	{
		this.idColumn = idColumn;
		return this;
	}
}
