package com.guicedee.guicedpersistence.c3p0.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

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
