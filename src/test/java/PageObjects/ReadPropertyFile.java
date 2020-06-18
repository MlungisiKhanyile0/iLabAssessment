package PageObjects;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadPropertyFile {


    private final String propertyFilePath = "C://Users//Mlungisi Khanyile//IdeaProjects//iLabAssessment//src//test//java//Utility//config.properties";

    public void readPrpFile() throws IOException
    {
        Properties properties =new  Properties();
        InputStream is = new FileInputStream(propertyFilePath);
        properties.load(is);
        is.close();

    }
}
