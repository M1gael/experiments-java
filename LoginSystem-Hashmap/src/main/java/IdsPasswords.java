import java.util.HashMap;

public class IdsPasswords {
    //Hashmap
    private HashMap<String,String> loginInfo = new HashMap<String,String>();

    IdsPasswords(){
        loginInfo.put("a","b");
        loginInfo.put("John","biltong");
        loginInfo.put("Peter","Pizza123");
        loginInfo.put("Mike","Smit");
    }

    protected HashMap<String,String> getLoginInfo(){
        return loginInfo;
    }
}
