package com.qf.repository;

import com.qf.domain.Usertwo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by HP        PC on 2019/11/27.
 */
public interface UsertwoRepository  extends JpaRepository<Usertwo,Integer> {
    Usertwo findByName(String name);
}
