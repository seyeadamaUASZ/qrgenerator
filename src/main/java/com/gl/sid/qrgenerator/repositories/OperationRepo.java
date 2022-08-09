package com.gl.sid.qrgenerator.repositories;

import com.gl.sid.qrgenerator.models.Operation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationRepo extends JpaRepository<Operation,Long> {
}
