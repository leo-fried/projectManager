package com.leofriedman.projectmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.leofriedman.projectmanager.model.*;

public interface LiftRepository extends JpaRepository<Lift, Long>{}
