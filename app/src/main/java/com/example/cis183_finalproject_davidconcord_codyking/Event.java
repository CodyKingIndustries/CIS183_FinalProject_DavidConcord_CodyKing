package com.example.cis183_finalproject_davidconcord_codyking;
import java.io.Serializable;
public class Event implements Serializable
{
    String ename;
    String etime;
    String edate;
    String egid;

    public Event()
    {

    }

    public Event(String n, String t, String d, String i)
    {
        ename = n;
        etime = t;
        edate = d;
        egid = i;
    }

    public String getEname()
    {
        return ename;
    }

    public void setEname(String ename)
    {
        this.ename = ename;
    }

    public String getEtime()
    {
        return etime;
    }

    public void setEtime(String etime)
    {
        this.etime = etime;
    }

    public String getEdate()
    {
        return edate;
    }

    public void setEdate(String edate)
    {
        this.edate = edate;
    }

    public String getEgid()
    {
        return egid;
    }

    public void setEgid(String egid)
    {
        this.egid = egid;
    }
}
