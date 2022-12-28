package Day_09_JSEScroll_Cookies_Files_Elly;

import org.junit.Test;
import utilities.BaseTest;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C7_FileExist extends BaseTest {

    public static void main(String[] args) {
        System.out.println(System.getProperty("user.dir"));//projemizin rootunun yolunu verir.
        String projectRoot = System.getProperty("user.dir");
        // Bulmak istedigimiz file proje icerisinde oldugundan proje yolunu aldik

        String filePath = "/src/test/java/resources/fileExist.jpg";
        // Bulmak istedigimiz dosyanin proje klasorunden sonraki yolunu aldik (Copy path from content root)

        filePath = projectRoot + filePath;
        //Almis oldugumuz 2 yolu birlestirip absolute path imizi elde ettik


        System.out.println(Files.exists(Paths.get(filePath)));// Bu path de bir dosya olup olmadigini dogruladik

        if (Files.exists(Paths.get(filePath))){
            System.out.println("dosya var");
        }
        else {
            System.out.println("dosya yok");
        }


    }





    }

