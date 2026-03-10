package com.makliftsan.visibility.repository;

import com.makliftsan.visibility.entity.MachineOrder;
import com.makliftsan.visibility.entity.VisibilityType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MachineOrderRepository extends JpaRepository<MachineOrder, Long> {
    List<MachineOrder> findByVisibilityType(VisibilityType visibilityType);
}