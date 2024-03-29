package com.olawale.criteriasearch.repository;

import com.olawale.criteriasearch.entity.Resident;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ResidentCriteriaSearchRepo {

    private final EntityManager entityManager;

    public List<Resident> findAll(String firstName, String lastName, String email){

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Resident> query = builder.createQuery(Resident.class);
        Root<Resident> root = query.from(Resident.class);
        Predicate firstnamePredicate =  builder.like(root.get("firstName"), "%" + firstName +"%");
        Predicate lastnamePredicate = builder.like(root.get("lastName"), "%" + lastName + "%");
        Predicate emailPredicate = builder.like(root.get("email"), "%"+ email + "%");

        Predicate firstnameOrLastnamePredicate = builder.or(firstnamePredicate, lastnamePredicate);

        var andEmailPredicate = builder.and(firstnameOrLastnamePredicate, emailPredicate);

        query.where(andEmailPredicate);

        TypedQuery<Resident> residentTypedQuery = entityManager.createQuery(query);

        return residentTypedQuery.getResultList();
    }
}
