package Autofox.objects.objectApi;

import Autofox.objects.objectSystem.users.AdminUsersPojo;
import Autofox.objects.objectSystem.users.AdminUsersPojo.*;
import Autofox.data.user.StaticSuperAdmin;
import Automation.utils.loggers.BusinessLogger;
import io.restassured.response.Response;

import java.io.IOException;
import java.util.List;

public class AdminUserDeserializer{


    public static AdminUsers DeserializeAdminUser(Response AdminResponse) {
        BusinessLogger.BusinessInfo("Mapping Apis response of {user} node into POJO class");

        AdminUsers adminUser = null;

        try {
            AdminUsersPojo adminUserPojo = AdminResponse.body().as(AdminUsersPojo.class);
            adminUser = adminUserPojo.getData().getAdminUsers();
        } catch (Exception E) {
            BusinessLogger.BusinessExceptionError("Failed Mapping Apis response of {user} node into POJO class", E);
            throw new NullPointerException();
        }
        return adminUser;
    }

    public static List<AdminErrors> DeserializeAdminErrors(Response AdminResponse) {
        BusinessLogger.BusinessInfo("Mapping Apis response of {errors} node  into POJO class");

        List<AdminErrors> adminErrors ;

        try {
            AdminUsersPojo adminUserPojo = AdminResponse.body().as(AdminUsersPojo.class);
            adminErrors = adminUserPojo.getAdminErrors();
        } catch (Exception E) {
            BusinessLogger.BusinessExceptionError("Failed Mapping Apis response of {errors} node  into POJO class", E);
            throw new NullPointerException();
        }
        return adminErrors;
    }


    public static AdminErrors DeserializeAdminErrorFetch(Response AdminResponse , String ErrorKeyword) {
        BusinessLogger.BusinessInfo("Picking a specific error that contains : " + ErrorKeyword+ " ,from list of errors");

        List<AdminErrors> adminErrors ;

        try {
            adminErrors = DeserializeAdminErrors(AdminResponse);
            for (AdminErrors error : adminErrors){
                if (error.getErrorMessage().contains(ErrorKeyword)){
                return error ;
            }else {
                    BusinessLogger.BusinessError("All errors in the response does not contain : " + ErrorKeyword+ " ,in the list of errors");
                    throw new NullPointerException();
                }
            }
        } catch (Exception E) {
            BusinessLogger.BusinessExceptionError("Failed Picking a specific error that contains : " + ErrorKeyword+ " ,from list of errors", E);
            throw new NullPointerException();
        }
        return null;
    }




    public static void main(String[] args) throws IOException {
        AdminUsers Admin = StaticSuperAdmin.GenerateInvalidStaticSuperAdmin();
        Response response = AdminLoginApiRequest.LoginApis(Admin);
        List<AdminErrors> admins = DeserializeAdminErrors(response);

        for (AdminErrors admin : admins) {
            System.out.println(admin.getErrorMessage());
        }
    }

}
