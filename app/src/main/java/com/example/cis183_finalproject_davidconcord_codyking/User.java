package com.example.cis183_finalproject_davidconcord_codyking;
import java.io.Serializable;
public class User implements Serializable
{
    String fname;
    String lname;
    String username;
    String password;
    String email;
    String age;
    public User()
    {

    }
    public User(String f, String l, String u, String p, String e, String a)
    {
        fname = f;
        lname = l;
        username = u;
        password = p;
        email = e;
        age = a;
    }
    public String getFname()
    {
        return fname;
    }

    public void setFname(String f)
    {
        fname = f;
    }

    public String getLname()
    {
        return lname;
    }

    public void setLname(String l)
    {
        lname = l;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String u)
    {
        username = u;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String p)
    {
        password = p;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String e)
    {
        email = e;
    }

    public String getAge()
    {
        return age;
    }

    public void setAge(String a)
    {
        age = a;
    }
}
