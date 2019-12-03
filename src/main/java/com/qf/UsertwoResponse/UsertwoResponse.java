package com.qf.UsertwoResponse;

import com.qf.domain.Usertwo;
import lombok.Data;

import java.util.List;

/**
 * Created by HP        PC on 2019/11/27.
 */
@Data
public class UsertwoResponse {
    private List<Usertwo> list;
    private Integer page;
    private Long total;
}
