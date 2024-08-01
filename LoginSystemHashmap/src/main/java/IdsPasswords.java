import java.util.HashMap;

public class IdsPasswords {
    //Hashmap
    HashMap<String,String> loginInfo = new HashMap<String,String>();

    IdsPasswords(){
        loginInfo("a","b");
        loginInfo("John","biltong");
        loginInfo("Peter","Pizza123");
        loginInfo("Mike","Smit");
    }

    protected HashMap getLoginInfo(){
        return loginInfo;
    }
}
