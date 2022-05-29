package com.cookandroid.forthepuppy;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class SignupRequest extends StringRequest {

    //서버 URL 설정
    final static private String URL = "http://yenie.shop/users";
    private Map<String, String> map;

    public SignupRequest(int userID, String userName, String userEmail, String userPnum, String userPassword, Response.Listener<String>listener){
        super(Method.POST,URL,listener,null);

        map=new HashMap();
        map.put("userID",userID + "");
        map.put("userName",userName);
        map.put("userEmail",userEmail);
        map.put("userPnum",userPnum);
        map.put("userPassword",userPassword);
    }


    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }

}
