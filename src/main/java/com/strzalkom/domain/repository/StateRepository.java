package com.strzalkom.domain.repository;

import com.strzalkom.domain.State;
import com.strzalkom.utils.Ids;

import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.*;
import javax.persistence.PersistenceContext;

@Repository
public class StateRepository {


   @PersistenceContext
    private EntityManager em;
    Random rand = new Random();


    @Transactional
    public void createState(String description) {

        State newState = new State(description);
        em.persist(newState);


    }

    public List<State> getAll() {
        return em.createQuery("from State", State.class).getResultList();
    }
    @Transactional
    public void deleteState(State state){
            em.remove(state);
    }

//    @Transactional
//    public void createState(String description) {
////        List<String> descriptions = new ArrayList<>();
////
////        descriptions.add("Wypożyczony");
////        descriptions.add("Dostępny");
////        descriptions.add("Dostępny");
////        descriptions.add("W przygotowaniu");
//
////        String description = descriptions.get(rand.nextInt(descriptions.size()));
//        createState(description);
//    }
    @Transactional
    public void update(State state) {
          em.merge(state);
    }

    public State getState(Integer id) {

        return em.find(State.class, id);
    }
}
