package com.kenneth.springmvc.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kenneth.springmvc.model.Alien;
import com.kenneth.springmvc.model.ReddyAlien;

@Repository("reddyADao")
public class ReddyAlienDao implements AlienDao {

	private final SessionFactory sessionFactory;

	@Autowired
	public ReddyAlienDao(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public List<Alien> getAliens() {

		List<ReddyAlien> aliens = new ArrayList<>();

		Session session = this.sessionFactory.getCurrentSession();

		CriteriaBuilder cb = session.getCriteriaBuilder();

		CriteriaQuery<ReddyAlien> cq = cb.createQuery(ReddyAlien.class);

		cq.from(ReddyAlien.class);

		aliens = session.createQuery(cq).list();

		List<Alien> finalAliens = new ArrayList<>();

		for (ReddyAlien r : aliens) {
			finalAliens.add(r);
		}

		return finalAliens;

	}

	@Override
	@Transactional
	public void add(Alien alien) {

		Session session = this.sessionFactory.getCurrentSession();

		// ReddyAlien rAlien = new ReddyAlien(alien.getAid(), alien.getAname());

		session.save(alien);

	}

	@Override
	@Transactional
	public Alien getAlien(int aid) {

		Session session = this.sessionFactory.getCurrentSession();

		Alien a = session.get(ReddyAlien.class, aid);

		return a;
	}

}