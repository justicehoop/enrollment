package com.naver.jpa.enrollment.repository.custom;

import com.naver.jpa.enrollment.domain.Locker;
import com.naver.jpa.enrollment.dto.LockerSearchRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class LockerRepositoryImpl extends QuerydslRepositorySupport implements LockerRepositoryCustom {

    public LockerRepositoryImpl() {
        super(Locker.class);
    }

    @Override
    public Page<Locker> findAll(LockerSearchRequest lockerSearchRequest, Pageable pageable) {
        return null;
    }
}
