package com.naver.jpa.enrollment.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import com.naver.jpa.enrollment.domain.Locker;
import com.naver.jpa.enrollment.dto.LockerResponse;
import com.naver.jpa.enrollment.dto.LockerSearchRequest;
import com.naver.jpa.enrollment.repository.LockerRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Slf4j
@Service
public class LockerService {

    private final LockerRepository lockerRepository;

    public Page<LockerResponse> getAll(LockerSearchRequest lockerSearchRequest, @PageableDefault Pageable pageable) {
        lockerRepository.findAll(lockerSearchRequest, pageable);
        return null;
    }

}
