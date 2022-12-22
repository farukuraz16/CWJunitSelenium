package Day_06_Dropdown_SeleniumWait;

import com.github.javafaker.Faker;
import org.junit.Test;

public class C01_Faker {
    //Faker değerler üretmek için Faker Classından objeler üretip var olan methodları kullanırız.

    @Test
    public void fakerExample(){
         Faker faker = new Faker();
        System.out.println(faker.name().firstName());//random bir isim verir. her çalıştırıldığında farklı bir isim çıkar
        System.out.println("faker.name().lastName() = " + faker.name().lastName());
        System.out.println("faker.address() = " + faker.address());

    }

}
