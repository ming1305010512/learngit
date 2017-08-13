package com.lm.servlet;

import com.lm.dao.UserDao;
import com.lm.daoImpl.UserDaoImpl;
import com.lm.entity.User;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by 龙鸣 on 2017/8/11.
 */
public class UserServlet extends HttpServlet {

    private UserDao userDao=new UserDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String type=req.getParameter("type");
        System.out.println("UserServlet的type值为："+type);
        req.setCharacterEncoding("utf-8");

        //获得所有用户，保存在userList集合中，转发到userInfoShow页面
        if("all".equals(type)) {

            //用来保存所有的用户
            List<User> userList = new ArrayList<User>();
            userList = userDao.getAllUser();
            req.setAttribute("userList", userList);

            req.getRequestDispatcher("/WEB-INF/content/userInfoShow.jsp").forward(req, resp);
        }
        //更新用户
        if("update".equals(type)){

//            String userId=req.getParameter("userId");
//            String userName=req.getParameter("userName");
//            String password=req.getParameter("password");
//            String nickname=req.getParameter("nickname");
//            String headPicture=req.getParameter("headPicture");
//            userName=new String(userName.getBytes("iso-8859-1"),"UTF-8");
//            nickname=new String(nickname.getBytes("iso-8859-1"),"UTF-8");
//            System.out.println("用户名："+userName);
//            int id=Integer.parseInt(userId);
//            userDao.update(id, userName,password,nickname,headPicture);
//            req.getRequestDispatcher("userServlet?type=all").forward(req,resp);





            String userName="";
            String password="";
            String nickname="";
            Date birthday=null;
            boolean isMultipart= ServletFileUpload.isMultipartContent(req);
            System.out.println("是否为文件上传类型"+isMultipart);
            //创建文件上传处理工厂
            FileItemFactory factory=new DiskFileItemFactory();
            //创建文件上传处理器
            ServletFileUpload upload=new ServletFileUpload(factory);
            //请求信息
            List<FileItem> items=null;
            try {
                items=upload.parseRequest(req);
            } catch (FileUploadException e) {
                e.printStackTrace();
            }
            Iterator iterator=items.iterator();
            String fileName="";
            while (iterator.hasNext()){
                System.out.println("进入到集合种");
                FileItem item= (FileItem) iterator.next();
                //普通表单数据
                if (item.isFormField()){
                    String fieldName=item.getFieldName();
                    String value=item.getString();
                    if("userName".equals(fieldName)){
                        userName=value;
                    }
                    if ("password".equals(fieldName)){
                        password=value;
                    }
                    if ("nickname".equals(fieldName)){
                        nickname=value;
                    }
                    if ("birthday".equals(fieldName)){
                        birthday=StringToDate(value);
                    }
                }
                //文件数据
                else{
                    //文件的绝对路径
                    fileName=item.getName();
                    System.out.println("文件地址："+fileName);
                    int index=fileName.lastIndexOf("\\");
                    //获取文件名
                    fileName=fileName.substring(index+1);
                    System.out.println("文件名："+fileName);
                    String basePath=req.getRealPath("/uploadFile");
//                    String basePath=req.getRequestURI();
//                    String basePath=req.getContextPath()+"/uploadFile";
                    System.out.println("basePath:"+basePath);


//                    String path = req.getContextPath();
//                    System.out.println("上下文路径："+path);
//                    System.out.println("req.getScheme():"+req.getScheme());
//                    System.out.println("req.getServerName():"+req.getServerName());
//                    System.out.println("req.getServerPort():"+req.getServerPort());
                    File uploadPath=new File(basePath);
                    if(!uploadPath.exists()){
                        uploadPath.mkdirs();
                    }
                    File file=new File(uploadPath,fileName);
                    try {
                        //将数据写入文件
                        item.write(file);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }


                }

            }

            userName=new String(userName.getBytes("iso-8859-1"),"UTF-8");
            nickname=new String(nickname.getBytes("iso-8859-1"),"UTF-8");
            String userId=req.getParameter("userId");
            int id=Integer.parseInt(userId);
            userDao.update(id, userName,password,nickname,fileName,birthday);
            req.getRequestDispatcher("userServlet?type=all").forward(req,resp);

        }

        //根据用户id获取User对象
        if("getUserOne".equals(type)){

            String userId=req.getParameter("userId");
            int id=Integer.parseInt(userId);
            User user=userDao.getUser(id);
            req.setAttribute("user",user);
            System.out.println(user);
            req.getRequestDispatcher("/WEB-INF/content/updateUser.jsp").forward(req,resp);
        }
        //删除用户
        if("delete".equals(type)){
            String userId=req.getParameter("userId");
            HttpSession session=req.getSession();
//            String userName= (String) session.getAttribute("userName");
//            String password=(String) session.getAttribute("password");
            int id=Integer.parseInt(userId);
//            int currentUserId=userDao.getUserId(userName,password);

            userDao.delete(id);
            req.getRequestDispatcher("userServlet?type=all").forward(req,resp);
        }

        //增加用户
        if("insert".equals(type)){
            String userName="";
            String password="";
            String nickname="";
            Date birthday=null;
            boolean isMultipart= ServletFileUpload.isMultipartContent(req);
            System.out.println("是否为文件上传类型"+isMultipart);
            //创建文件上传处理工厂
            FileItemFactory factory=new DiskFileItemFactory();
            //创建文件上传处理器
            ServletFileUpload upload=new ServletFileUpload(factory);
            //请求信息
            List<FileItem> items=null;
            try {
                items=upload.parseRequest(req);
            } catch (FileUploadException e) {
                e.printStackTrace();
            }
            Iterator iterator=items.iterator();
            String fileName="";
            while (iterator.hasNext()){
                FileItem item= (FileItem) iterator.next();
                //普通表单数据
                if (item.isFormField()){
                    String fieldName=item.getFieldName();
                    String value=item.getString();
                    if("userName".equals(fieldName)){
                        userName=value;
                    }
                    if ("password".equals(fieldName)){
                        password=value;
                    }
                    if ("nickname".equals(fieldName)){
                        nickname=value;
                    }
                    if ("birthday".equals(fieldName)){
                        birthday=StringToDate(value);
                    }
                }
                //文件数据
                else{
                    //文件的绝对路径
                    fileName=item.getName();
                    System.out.println("文件地址："+fileName);
                    int index=fileName.lastIndexOf("\\");
                    //获取文件名
                    fileName=fileName.substring(index+1);
                    System.out.println("文件名："+fileName);
                    String basePath=req.getRealPath("/uploadFile");
//                    String basePath=req.getRequestURI();
//                    String basePath=req.getContextPath()+"/uploadFile";
                    System.out.println("basePath:"+basePath);


//                    String path = req.getContextPath();
//                    System.out.println("上下文路径："+path);
//                    System.out.println("req.getScheme():"+req.getScheme());
//                    System.out.println("req.getServerName():"+req.getServerName());
//                    System.out.println("req.getServerPort():"+req.getServerPort());
                    File uploadPath=new File(basePath);
                    if(!uploadPath.exists()){
                        uploadPath.mkdirs();
                    }
                    File file=new File(uploadPath,fileName);
                    try {
                        //将数据写入文件
                        item.write(file);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }


                }

            }

            /**
             * 将数据保存到数据库中
             * */

            userName=new String(userName.getBytes("iso-8859-1"),"UTF-8");
            nickname=new String(nickname.getBytes("iso-8859-1"),"UTF-8");

            //获取对应的属性值

            System.out.println("========================");
            System.out.println("用户名："+userName);
            System.out.println("密码："+password);
            System.out.println("生日："+birthday);

            userDao.insert(userName,password,nickname,fileName,birthday);
            req.getRequestDispatcher("/WEB-INF/content/login.jsp").forward(req,resp);
        }

    }

    public static Date StringToDate(String date){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        try {
           Date date1=simpleDateFormat.parse(date);
           return date1;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
