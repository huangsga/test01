package com.infotools.system.Utils;

import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class FileUtil {
    public static void uploadFile(byte[] file,String filePath, String fileName) throws Exception{
    File targetFile=new File(filePath);
    if(!targetFile.exists()){
        targetFile.mkdir();
    }
        FileOutputStream out=new FileOutputStream(targetFile.getAbsolutePath()+"/"+fileName);
    out.write(file);
    out.flush();
    out.close();
    }
    public static String getUpLoadFilePath()
    {
        File path=null;
        try {
            path=new File(ResourceUtils.getURL("classpath:").getPath());
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if(!path.exists()) path=new File("");
        File filePath=new File(path.getAbsolutePath(),"static/images/");
        return filePath.getAbsolutePath();
    }
}




