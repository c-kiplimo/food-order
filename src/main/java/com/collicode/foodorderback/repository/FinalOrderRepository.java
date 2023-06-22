package com.collicode.foodorderback.repository;


import com.collicode.foodorderback.model.FinalOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FinalOrderRepository extends JpaRepository<FinalOrder, Long> {

}
