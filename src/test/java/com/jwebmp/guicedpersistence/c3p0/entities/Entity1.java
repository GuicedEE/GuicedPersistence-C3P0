package com.jwebmp.guicedpersistence.c3p0.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

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
