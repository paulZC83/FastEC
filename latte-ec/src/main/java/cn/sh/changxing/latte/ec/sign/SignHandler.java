package cn.sh.changxing.latte.ec.sign;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import cn.sh.changxing.latte.ec.database.DatabaseManager;
import cn.sh.changxing.latte.ec.database.UserProfile;


/**
 * Created by ZengChao on 2018/2/1.
 */

public class SignHandler {

    public static void onSignUp(String response){
        final JSONObject profileJson = JSON.parseObject(response).getJSONObject("data");
        final long userId = profileJson.getLong("userId");
        final String name = profileJson.getString("name");
        final String avatar = profileJson.getString("avatar");
        final String gender = profileJson.getString("gender");
        final String address = profileJson.getString("address");

        UserProfile userProfile = new UserProfile(userId, name, avatar, gender, address);
        DatabaseManager.getInstance().getDao().insert(userProfile);
    }
}
