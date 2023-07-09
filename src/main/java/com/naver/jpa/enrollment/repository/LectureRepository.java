package com.naver.jpa.enrollment.repository;

import com.naver.jpa.enrollment.repository.custom.LectureRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.naver.jpa.enrollment.domain.Lecture;

@Repository
public interface LectureRepository extends JpaRepository<Lecture, Long>, LectureRepositoryCustom {
}
