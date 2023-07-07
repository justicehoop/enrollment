package com.naver.jpa.enrollment.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.naver.jpa.enrollment.domain.Locker;
import com.naver.jpa.enrollment.dto.LockerSearchRequest;

public interface LockerRepositoryCustom {
  Page<Locker> findAll(LockerSearchRequest lockerSearchRequest, Pageable pageable);
}
