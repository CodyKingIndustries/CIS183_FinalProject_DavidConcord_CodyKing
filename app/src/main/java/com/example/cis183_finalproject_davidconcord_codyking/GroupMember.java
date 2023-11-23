package com.example.cis183_finalproject_davidconcord_codyking;

public class GroupMember
{
    String username;
    String gid;
    public GroupMember()
    {

    }
    public GroupMember(String u, String i)
    {
        username = u;
        gid = i;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
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
