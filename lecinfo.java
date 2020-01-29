package application;

public class lecinfo {
    private String lecname;
    private String Department;
    private String lecid;
    private String leclname;

public lecinfo(){
    this.lecname="";
    this.leclname = "";
    this.Department="";
    this.lecid = "";
    
}

public lecinfo(String lecname,String Department,String leclname)
{
    this.lecname=lecname;
    this.leclname = leclname;
    this.Department=Department;
    
}
public String getLecname(){
    return lecname;
}


public void setlecname(String lecname)
{
    this.lecname=lecname;
}
public String getLeclname(){
    return leclname;
}


public void setleclname(String leclname)
{
    this.leclname=leclname;
}

public String getLecid(){
    return lecid;
}

public void setlecid(String lecid)
{
    this.lecid = lecid;
}

public String getDepartment()
{
    return Department;
}

public void setDepartment(String Department) {
    this.Department=Department;
}

}
