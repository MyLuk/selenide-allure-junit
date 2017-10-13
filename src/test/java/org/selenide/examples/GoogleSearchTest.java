package org.selenide.examples;

import com.codeborne.selenide.Screenshots;
import com.google.common.io.Files;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;
import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Attachment;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class GoogleSearchTest extends Base {
  @Test
  public void userCanSearchAnyKeyword1() {

    open("http://google.com");
    $(".main").shouldBe(visible);
  }

  @Test
  public void userCanSearchAnyKeyword2() {
    open("http://google.com");
  }

  @Test
  public void userCanSearchAnyKeyword3() {

    open("http://yandex.ru");
    $(".main2").shouldBe(visible);
  }

  @After
  public void tearDown() throws IOException {
    File screenshot = Screenshots.getLastScreenshot();
    if (screenshot!=null && !myList.contains(screenshot.toString())) {
      screenshot(screenshot);
      myList.add(screenshot.toString());
      sleep(1);
    }

  }

  @Attachment(type = "image/png")
  public byte[] screenshot(File screenshot) throws IOException {
    return Files.toByteArray(screenshot);
  }

}
