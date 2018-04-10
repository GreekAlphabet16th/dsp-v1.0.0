package com.cetiti.dsp.web;

import com.cetiti.core.annotation.LogInject;
import com.cetiti.core.annotation.MapperInject;
import com.cetiti.core.controller.ControllerSupport;
import com.cetiti.core.model.PageModel;
import com.cetiti.dsp.dao.GoodsDao;
import com.cetiti.dsp.entity.Goods;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequestMapping("/goods")
public class GoodsController extends ControllerSupport{

    @LogInject
    private Logger log;

    @Autowired
    private GoodsDao goodsDao;

/*    @MapperInject(GoodsDao.class)
    private GoodsDao goodsDao;*/

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public PageModel<Goods> list(){
        this.offsetPage(0, 10);
        List<Goods> list = goodsDao.queryAll();
        return this.resultPage(list);
    }

}
