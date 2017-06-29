package com.zw.cf.model;

/**
 * Created by zhaowei on 2017/6/24.
 */
public class User {
    private String id;
    private String userName;
    private String passWord;

    public String getId(){
        return this.id;
    }

    public void setId(String id){
        this.id=id;
    }

    public String getUserName(){
        return  this.userName;
    }

    public void setUserName(String userName){
        this.userName=userName;
    }

    public String getPassWord(){
        return  this.passWord;
    }

    public void setPassWord(String passWord){
        this.passWord=passWord;
    }

    public User(){

    }
    public User(String id,String userName,String passWord){
        super();
        this.id=id;
        this.userName=userName;
        this.passWord=passWord;
    }
    @Override
    public String toString(){
        return  "User[id="+id+", userName="+userName+"]";
    }
}
