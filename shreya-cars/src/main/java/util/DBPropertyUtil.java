/*package util;

import java.util.Properties;

public class DBPropertyUtil {

    public static String getConnectionString() {
        Properties properties = new Properties();
        properties.setProperty("db.url", "jdbc:mysql://localhost:3306/crimereportingsystem?useSSL=false&user=root&password=anshu@6377&allowPublicKeyRetrieval=true");

        String url = properties.getProperty("db.url", "");

        return url;
    }
}*/
package util;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
public class DBPropertyUtil
{
	public static String getConnectionString(String propFileName)
	{
		String connString=null;
		Properties propsObject=new Properties();
		//i have created a stream connected to properties file
		try(FileInputStream fis=new FileInputStream(propFileName))  //try with resources
		{
				propsObject.load(fis);//loading the properties existed in file into propsObject
				//creating connection string
				connString=propsObject.getProperty("db.url")+"?user="+propsObject.getProperty("db.username")+"&password="+propsObject.getProperty("db.password");
		}catch (IOException fnf) {
			fnf.printStackTrace();
			System.out.println("Error:  Not able to Properties from File");
		}
		//returning connection string
		return connString;
	}
	
	public static void main(String[] args) 
	{
		System.out.println(getConnectionString("db.Properties"));
	}
	
}
