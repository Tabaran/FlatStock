package com.flatstock.controller.users;

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
import static com.flatstock.controller.users.ShowUsersController.*;
import static com.flatstock.controller.users.AddUserController.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import org.apache.log4j.Logger;


/**
 * Created by Valentin on 09.06.2015.
 */

@WebServlet(ADD_USER_PATH)
public class AddUserController extends HttpServlet {

    public static final String ADD_USER_PATH = "/add_user";
    public static final String FILE_UPLOAD_PATH = "file-upload";
    public static final String PHOTO_PREFIX = "user_photo_";
    private static final long DB_PHOTO_SIZE = 100 * 1024;
    private String filePath;

    public void init() {
        filePath = getServletContext().getInitParameter(FILE_UPLOAD_PATH);
        File dir = new File(filePath);
        if(!dir.exists()) dir.mkdir();
        LOG.info(dir.getAbsolutePath());
    }

    static Logger LOG = Logger.getLogger(AddUserController.class.getName());
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserService service = new UserServiceImpl();
        IUser user = new User();
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        InputStream photoStream = null;
        long size = 0;
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
                    if(item.getSize() > DB_PHOTO_SIZE) {
                        String extension = "";
                        if(item.getName().contains(".")) extension = "." + item.getName().split(".")[1];
                        user.setPhotoUrl((new File(filePath)).getAbsolutePath() + "\\" + PHOTO_PREFIX + user.getId() + extension);
                        item.write(new File(filePath + PHOTO_PREFIX + user.getId() + extension));
                    }
                    else {
                        user.setPhotoUrl("DB");
                        photoStream = item.getInputStream();
                        size = item.getSize();
                    }
                }
            }
        }catch(Exception ex) {
            LOG.error(ex.getMessage());
        }
        LOG.info("Adding user");
        if(photoStream != null) {
            service.uploadPhotoToDB(service.addUser(user), photoStream, Long.valueOf(size).intValue());
        } else {
            service.addUser(user);
        }
        response.sendRedirect(USERS_PATH);
    }
}
