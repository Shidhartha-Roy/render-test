package com.sid.itcodeapi.repository;

import com.sid.itcodeapi.entity.ItcodeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItcodeRepository extends JpaRepository<ItcodeEntity, String> {
}
