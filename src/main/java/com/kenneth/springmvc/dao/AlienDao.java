package com.kenneth.springmvc.dao;

import java.util.List;

import com.kenneth.springmvc.model.Alien;

public interface AlienDao {

	public List<Alien> getAliens();

	public void add(Alien alien);

	public Alien getAlien(int aid);

}
