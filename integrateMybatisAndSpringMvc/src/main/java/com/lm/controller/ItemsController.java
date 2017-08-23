package com.lm.controller;

import com.lm.controller.validate.ValidateGroupOne;
import com.lm.exception.CustomException;
import com.lm.po.ItemCustom;
import com.lm.po.QueryItemsVo;
import com.lm.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by 龙鸣 on 2017/8/19.
 * Description:
 *
 * @author:龙鸣
 * @version:1.0
 */
@Controller
@RequestMapping(value = "/items")
public class ItemsController {

    @Autowired
    private ItemsService itemsService;

    @RequestMapping(value = "/queryItems")
    public String queryItems(Model model, HttpServletRequest request, QueryItemsVo queryItemsVo){


//        System.out.println("dkskjdksjdksjdksj");

        //测试url和uri
        String uri=request.getRequestURI();
        StringBuffer url=request.getRequestURL();
        System.out.println("uri:"+uri);
        System.out.println("url:"+url);

        if(queryItemsVo!=null) {
            if(queryItemsVo.getItemCustom()!=null) {

                System.out.println("queryItemsVo的名字：" + queryItemsVo.getItemCustom().getItemName());
            }
        }

        ModelAndView modelAndView;
        try {
            List<ItemCustom> list=itemsService.getItemsList(queryItemsVo);
//            modelAndView=new ModelAndView();
//            modelAndView.addObject("itemsList",list);
//            modelAndView.setViewName("items/itemsDetail");
            model.addAttribute("itemsList",list);
            return "items/itemsDetail";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //商品信息修改页面显示
    @RequestMapping(value = "/editItems",method = {RequestMethod.POST,RequestMethod.GET})
    //@RequestParam指定request传入参数名称和形参进行绑定
    //required通过required属性指定参数是否必须传入
    //defaultValue可以设置默认值，如果id没有传入，将默认值和形参绑定
    public ModelAndView editItems(@RequestParam(value = "id",required = true,defaultValue = "") Integer items_id) throws Exception {
        //获取商品信息
        ItemCustom itemCustom=itemsService.findItemsById(items_id);

//        //测试全局异常处理器
//        if(itemCustom!=null){
//            throw new CustomException("修改的商品信息不存在！");
//        }

        ModelAndView modelAndView=new ModelAndView();
        //将商品信息放到model中
        modelAndView.addObject("item",itemCustom);
        //商品修改页面
        modelAndView.setViewName("items/editItems");
        return modelAndView;
    }

    //商品信息修改提交
    @RequestMapping(value = "/editItemsSubmit",method = {RequestMethod.POST,RequestMethod.GET})
    //itemCustom值会从页面中的input的name与itemCustom中的属性名一样的进行值的填充
    //在需要校验的pojo前边添加@Validated注解，在pojo后边添加BindingResult接收校验错误信息
    //注意：@Validated和BindingResult是配对出现的，且顺序也是固定的
    public String editItemsSubmit(Model model, Integer id,
                                  @Validated(value = {ValidateGroupOne.class}) ItemCustom itemCustom,
                                  BindingResult bindingResult,HttpServletRequest request,
                                  MultipartFile items_pic) throws Exception {

        //获取校验错误信息
        if(bindingResult.hasErrors()){
            List<ObjectError> allErrors=bindingResult.getAllErrors();
            for (ObjectError objectError:allErrors){
                System.out.println(objectError.getDefaultMessage());
            }
            model.addAttribute("allErrors",allErrors);
            //可以直接使用Model进行回显
            model.addAttribute("item",itemCustom);
            return "items/editItems";
        }

        //上传文件
        if(items_pic!=null){

            //图片原始的名称
            String originalFileName=items_pic.getOriginalFilename();

            //图片新的名称
//            String newFileName= UUID.randomUUID()+originalFileName.substring(originalFileName.lastIndexOf("."));

            //获取存储图片位置的绝对路径
            String basePath=request.getRealPath("/uploadFile");
            //创建文件夹
            File uploadPath=new File(basePath);
            if(!uploadPath.exists()){
                uploadPath.mkdirs();
            }

            //创建新图片
            File newFile=new File(uploadPath,originalFileName);

            //将内存中的数据存储到磁盘中
            items_pic.transferTo(newFile);

            //上传成功之后，将图片存入数据库
            itemCustom.setPicture(originalFileName);
        }

        String name=itemCustom.getItemName();
//        Date createTime=itemCustom.getCreateTime();
        System.out.println("name值："+name);
//        System.out.println(createTime);,

        //调用service的更新商品信息方法，需要将商品信息传到此方法
        itemsService.updateItems(id,itemCustom);

        //重定向到产品查询列表
//        return "redirect:queryItems";
        //转发
        return "forward:queryItems";
    }

    //批量删除
    @RequestMapping(value = "/delete")
    public String itemsDelete(Integer[] item_id){

        //这里调用service的方法进行删除

        return "items/success";
    }

    //查询商品列表信息，在页面可编辑商品信息
    @RequestMapping(value = "editItemsQuery")
    public ModelAndView editItemsQuery(QueryItemsVo queryItemsVo){

        //调用service查找数据库，查询商品列表
        ModelAndView modelAndView;
        try {
            List<ItemCustom> list=itemsService.getItemsList(queryItemsVo);
            modelAndView=new ModelAndView();
            modelAndView.addObject("itemsList",list);
            modelAndView.setViewName("items/editItemsQuery");
            return modelAndView;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //批量修改商品提交
//    @RequestMapping(value = "editeAllItemsSubmit")
//    public String editeAllItemsSubmit(QueryItemsVo queryItemsVo){
//
//
//        return "success";
//    }

    //批量修改商品提交 使用Map
    @RequestMapping(value = "editeAllItemsSubmit",method = {RequestMethod.POST,RequestMethod.GET})
    public String editeAllItemsSubmit(QueryItemsVo queryItemsVo){

        return "items/success";
    }
}
