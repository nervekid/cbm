package com.xw.cbm.repo;

import java.util.List;

import com.xw.cbm.entity.StrFoo;

public interface StrFooRepo {

	public List<StrFoo> findAll();

	public StrFoo findById(String id);

	public void save(StrFoo u);

    public StrFoo findUserByName(String name);

    public boolean strFooExit(String name);
}
