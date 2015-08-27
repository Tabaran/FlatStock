package com.flatstock.controller.users;

/**
 * Created by Valentin on 17.06.2015.
 */

import com.flatstock.model.Role;
import com.flatstock.service.UserService;
import com.flatstock.service.impl.UserServiceImpl;
import com.flatstock.model.Gender;
import com.flatstock.model.IUser;
import com.flatstock.model.impl.User;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import static com.flatstock.model.impl.User.*;
import static com.flatstock.controller.users.UpdateUserController.*;
import static com.flatstock.controller.users.ShowUsersController.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;


@WebServlet(UPDATE_USER_PATH)
public class UpdateUserController extends HttpServlet {

    public static final String UPDATE_USER_PATH = "/update_user";
    public static final String FILE_UPLOAD_PATH = "file-upload";
    private String filePath;

    public void init() {
        filePath = getServletContext().getInitParameter(FILE_UPLOAD_PATH);
        File dir = new File(filePath);
        if(!dir.exists()) dir.mkdir();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserService service = new UserServiceImpl();
        IUser user = new User();
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        try{
            List items = upload.parseRequest(request);
            Iterator itemsIterator = items.iterator();
            while (itemsIterator.hasNext()){
                FileItem item = (FileItem)itemsIterator.next();
                if(item.isFormField()){
                    switch (item.getFieldName()){
                        case FIRST_NAME: user.setFirstName(item.getString());
                            break;
                        case LAST_NAME: user.setLastName(item.getString());
                            break;
                        case LOGIN: user.setLogin(item.getString());
                            break;
                        case EMAIL: user.setEmail(item.getString());
                            break;
                        case PASSWORD: user.setPassword(item.getString());
                            break;
                        case GENDER: user.setGender(Gender.fromString(item.getString()));
                            break;
                        case ROLE: user.setRole(Role.fromString(item.getString()));
                            break;
                        default:
                            LOG.warn("Unknown field name");
                    }
                }
                else {
                    user.setPhotoUrl(item.getName());
                    item.write(new File(filePath + item.getName()));
                }
            }
        }catch(Exception ex) {
            LOG.error(ex.getMessage());
        }
        LOG.info("Adding user");
        service.updateUser(user);
        response.sendRedirect(USERS_PATH);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserService service = new UserServiceImpl();
        IUser user = service.getUser(Integer.parseInt(request.getParameter(ID)));
        request.setAttribute(USER, user);
        RequestDispatcher view = request.getRequestDispatcher("updateUser.jsp");
        view.forward(request, response);
    }


}
