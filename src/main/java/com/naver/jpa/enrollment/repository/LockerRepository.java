package com.naver.jpa.enrollment.repository;

import com.naver.jpa.enrollment.repository.custom.LockerRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.naver.jpa.enrollment.domain.Locker;

@Repository
public interface LockerRepository extends JpaRepository<Locker, Long>, LockerRepositoryCustom {

}
