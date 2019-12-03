package com.qf.Service.impl;

import com.qf.Service.UsertwoService;
import com.qf.UsertwoResponse.UsertwoResponse;
import com.qf.domain.Usertwo;
import com.qf.repository.UsertwoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by HP        PC on 2019/11/27.
 */
@Service
public class UsertwoServiceimpl  implements UsertwoService {


    @Autowired
    private UsertwoRepository usertwoRepository;

    @Override
    public UsertwoResponse findAll(Integer size, Integer page) {
        if (page < 0) {
            page = 0;
        } else {
            page = page - 1;
        }
        Pageable pages = PageRequest.of(page, size);
        Page<Usertwo> all = usertwoRepository.findAll(pages);
        List<Usertwo> content = all.getContent();
        UsertwoResponse us = new UsertwoResponse();
        us.setList(content);
        us.setPage(all.getTotalPages());
        us.setTotal(all.getTotalElements());
        return us;
    }

    @Override
    public Usertwo findbyid(Integer id) {
        Optional<Usertwo> byId = usertwoRepository.findById(id);
        Usertwo usertwo = null;
        if (byId.isPresent()) {
            usertwo = byId.get();
        }
        return usertwo;

    }

    @Override
    public Usertwo saveAndFlush(Usertwo usertwo) {
        return usertwoRepository.saveAndFlush(usertwo);

    }

    @Override
    public String delbyid(Usertwo usertwo) {
        Integer id = usertwo.getId();
        try {
            usertwoRepository.deleteById(id);
            return "okokokok";
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "fail";

    }

    @Override
    public Usertwo findByName(String name) {
        return  usertwoRepository.findByName(name);
    }
}
