package com.engine.entity;

import com.engine.utils.NameGenerator;

public abstract class Entity {

	private String name;
	private String familyName;
	
	private NameGenerator nameGenerator;
	
	public Entity() {
		nameGenerator = new NameGenerator();
		name = nameGenerator.generateName().trim();
		familyName = nameGenerator.generateFamilyName().trim();
	}
	
	public String getName() {
		return name;
	}
	
	public String getFamilyName() {
		return familyName;
	}
	
	public String getFullName() {
		return familyName + " " + name;
	}
	
}
