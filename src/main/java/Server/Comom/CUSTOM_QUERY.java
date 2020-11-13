package Server.Comom;

public class CUSTOM_QUERY {

    //CLIENT
    public static String getListByFullname(String fullname){
        return "select * from Client where fullname = N'"+fullname+"' or username ='"+fullname+"'";
    }
    public static String getClientBySecretKey(String fullname){
        return "select * from Client where privatekey = N'"+fullname+"'";
    }
    public static String loginClient(String username,String password){
        return "select * from Client where username = N'"+username+"' and password=N'"+password+"'";
    }
}
