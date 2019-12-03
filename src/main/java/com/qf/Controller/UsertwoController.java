package com.qf.Controller;

import com.qf.Service.UsertwoService;
import com.qf.UsertwoResponse.UsertwoResponse;
import com.qf.domain.Usertwo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by HP        PC on 2019/11/27.
 */
@RestController
public class UsertwoController {
    @Autowired
    private UsertwoService usertwoService;

    @RequiresPermissions(value = {"user_find"})
    @RequestMapping("/findAll/{size}/{page}")
    public UsertwoResponse findAll(@PathVariable("size")Integer size, @PathVariable("page")Integer page){
        UsertwoResponse aa= usertwoService.findAll(size,page);
        return  aa;
    }
    @RequiresPermissions(value = {"user_update"})
    @RequestMapping("/findOne")
    public Usertwo findone(@RequestBody Usertwo usertwo){
        Integer id = usertwo.getId();
        return  usertwoService.findbyid(id);
    }
    @RequiresPermissions(value = {"user_add"})
    @RequestMapping("/updateone")
    public Usertwo updateuser(@RequestBody Usertwo usertwo){

        return   usertwoService.saveAndFlush(usertwo);
}
    @RequiresPermissions(value = {"user_del"})
    @RequestMapping( value = "/delbyid",method = RequestMethod.POST)
    public String delbyid(@RequestBody  Usertwo usertwo){

        return   usertwoService.delbyid(usertwo);
    }



    @RequestMapping(value = "/loginone", method = RequestMethod.POST)
    public String selectone(@RequestBody Usertwo usertwo){
       /* List<Usertwo> list= usertwoService.findByNameAndPass(name,pass);
     if(list!=null){
         return "redirect:/selectAll";
     }else{
         return"login";
     }*/
        try {
            String name=usertwo.getName();
            String pass=usertwo.getPass();
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(name, pass);
            subject.login(token);
            if (subject.isAuthenticated()){
                return "success";
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return "nonono";

    }
}
