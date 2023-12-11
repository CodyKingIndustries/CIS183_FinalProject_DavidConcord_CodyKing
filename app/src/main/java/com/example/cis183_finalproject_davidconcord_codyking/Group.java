package com.example.cis183_finalproject_davidconcord_codyking;
import java.io.Serializable;
public class Group implements Serializable
{
    String gname;
    String gowner;
    String gid;
    public Group()
    {

    }
    public Group(String n, String o, String i)
    {
        gname = n;
        gowner = o;
        gid = i;
    }
    public String getGname()
    {
        return gname;
    }

    public void setGname(String gname)
    {
        this.gname = gname;
    }

    public String getGowner()
    {
        return gowner;
    }

    public void setGowner(String gowner)
    {
        this.gowner = gowner;
    }

    public String getGid()
    {
        return gid;
    }

    public void setGid(String gid)
    {
        this.gid = gid;
    }
}
