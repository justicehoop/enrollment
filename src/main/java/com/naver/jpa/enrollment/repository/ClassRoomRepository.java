package com.naver.jpa.enrollment.repository;

import com.naver.jpa.enrollment.domain.ClassRoom;
import com.naver.jpa.enrollment.repository.custom.ClassRoomRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassRoomRepository extends JpaRepository<ClassRoom, Long>, ClassRoomRepositoryCustom {
}
