package com.guicedee.guicedpersistence.c3p0.implementations;

import com.guicedee.guicedinjection.interfaces.IGuiceScanModuleExclusions;

import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

public class C3P0ModuleExclusions
		implements  IGuiceScanModuleExclusions<C3P0ModuleExclusions>
{
	@Override
	public @NotNull Set<String> excludeModules()
	{
		Set<String> strings = new HashSet<>();
		strings.add("com.guicedee.guicedpersistence.c3p0");
		strings.add("c3p0");
		return strings;
	}
}
