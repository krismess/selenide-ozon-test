package utils;

import com.codeborne.selenide.Screenshots;
import com.google.common.io.Files;
import io.qameta.allure.Attachment;

import java.io.File;
import java.io.IOException;

import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Selenide.$;

public class Attachments {

    @Attachment(value = "{0}",type = "image/png")
    public static byte[] screenshot(String name)  {
        byte[] result = null;
        $(".five-dots").should(disappear); //one of the ozon loaders
        File screenshot = Screenshots.takeScreenShotAsFile();
        try {
            result = Files.toByteArray(screenshot);

        } catch (IOException e) {
            System.out.println("Could not take screenshot");
            System.out.println(e.getMessage());
        }

        return result;
    }
}
