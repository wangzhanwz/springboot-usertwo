package com.qf.Service;

import com.qf.UsertwoResponse.UsertwoResponse;
import com.qf.domain.Usertwo;

/**
 * Created by HP        PC on 2019/11/27.
 */
public interface UsertwoService {
    UsertwoResponse findAll(Integer size, Integer page);

    Usertwo findbyid(Integer id);

    Usertwo saveAndFlush(Usertwo usertwo);

    String delbyid(Usertwo usertwo);

    Usertwo findByName(String name);
}
