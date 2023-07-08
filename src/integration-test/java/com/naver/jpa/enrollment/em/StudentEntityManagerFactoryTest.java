package com.naver.jpa.enrollment.em;

import com.naver.jpa.enrollment.IntegrationTestSupport;
import com.naver.jpa.enrollment.domain.Student;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

@Slf4j
public class StudentEntityManagerFactoryTest extends IntegrationTestSupport{

    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;


    @Test
    public void testPersistWithTransaction() {

        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Student student = Student.builder()
                    .userId("userId")
                    .name("name")
                    .email("email@naver.com")
                    .password("password")
                    .dayOfBirth("20170501")
                    .identificationNumber("identificationNumber")
                    .build();
            em.persist(student);
//            em.flush();
            log.info("after flush");
        } catch (Exception e) {
            tx.rollback();
        } finally {
            tx.rollback();
            em.clear();
            em.close();
        }

    }

    @Test
    public void testPersistWithoutTransaction() {

        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
//            tx.begin();
            Student student = Student.builder()
                    .userId("userId")
                    .name("name")
                    .email("email@naver.com")
                    .password("password")
                    .dayOfBirth("20170501")
                    .identificationNumber("identificationNumber")
                    .build();
            em.persist(student);
            em.flush();
            log.info("after flush");
        } catch (Exception e) {
            tx.rollback();
        } finally {
            tx.rollback();
            em.clear();
            em.close();
        }

    }
}
