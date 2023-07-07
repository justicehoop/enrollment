package com.naver.jpa.enrollment.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.naver.jpa.enrollment.domain.Locker;
import com.naver.jpa.enrollment.dto.LockerSearchRequest;

@Repository
public interface LockerRepository extends JpaRepository<Locker, Long>, LockerRepositoryCustom {

}
