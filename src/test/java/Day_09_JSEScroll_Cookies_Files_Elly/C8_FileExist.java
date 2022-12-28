package Day_09_JSEScroll_Cookies_Files_Elly;

import org.junit.Assert;
import org.junit.Test;
import utilities.BaseTest;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C8_FileExist  {

    @Test
    public void test() {
//   /Users/faruk/Desktop/deneme/fileExist.png

        System.out.println(System.getProperty("user.home"));
        String homePath = System.getProperty("user.home");
        String filePath = "/Desktop/deneme/fileExist.png";
        String fullPath= homePath + filePath;
        File img = new File(fullPath);// Path imizi file a cevirdik

        Assert.assertTrue(img.exists());// exists metoduyla varolup olmadigini kontrol ettik




    }
}


