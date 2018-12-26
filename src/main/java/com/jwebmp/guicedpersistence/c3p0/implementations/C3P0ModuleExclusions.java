package com.jwebmp.guicedpersistence.c3p0.implementations;

import com.jwebmp.guicedinjection.interfaces.IGuiceScanJarExclusions;
import com.jwebmp.guicedinjection.interfaces.IGuiceScanModuleExclusions;

import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

public class C3P0ModuleExclusions
		implements IGuiceScanJarExclusions<C3P0ModuleExclusions>,
				           IGuiceScanModuleExclusions<C3P0ModuleExclusions>
{
	@Override
	public @NotNull Set<String> excludeJars()
	{
		Set<String> strings = new HashSet<>();
		strings.add("c3p0-*");
		strings.add("mchange-commons-*");
		strings.add("hibernate-c3p0-*");
		return strings;
	}

	@Override
	public @NotNull Set<String> excludeModules()
	{
		Set<String> strings = new HashSet<>();
		strings.add("com.jwebmp.guicedpersistence.c3p0");
		strings.add("c3p0");
		return strings;
	}
}
