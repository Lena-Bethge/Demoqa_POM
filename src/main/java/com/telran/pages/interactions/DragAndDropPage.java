package com.telran.pages.interactions;

import com.telran.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import javax.swing.*;

public class DragAndDropPage extends BasePage {

    public DragAndDropPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "draggable")
    WebElement dragMe;

    @FindBy(id = "droppable")
    WebElement dropHere;

    public DragAndDropPage actionDragMe() {
       // hideAd();  если не отрабатывает тест, нужно скрыть рекламу
        //hideFooter();

        Actions actions = new Actions(driver);
        pause(500);
        actions.dragAndDrop(dragMe,dropHere).perform();

        String textTo = dropHere.getText();

        if (textTo.equals("Dropped!")) {
            System.out.println("PASS: Sourse is dropped to target as expected");
        }else{
            System.out.println("FAIL: Sourse couldn't be dropped to target as expected");
        }
        return this;
    }

    public DragAndDropPage dragAndDropBy() {
        Actions actions = new Actions(driver);
        int xOffset = dragMe.getLocation().getX();
        int yOffset = dragMe.getLocation().getY();
        System.out.println("xOffset --> " + xOffset + "yOffset --> " + yOffset);

        //to

        int xOffsetTo = dropHere.getLocation().getX();
        int yOffsetTo = dropHere.getLocation().getY();
        System.out.println("xOffsetTo --> " + xOffsetTo + "yOffsetTo --> " + yOffsetTo);

        xOffsetTo = (xOffsetTo - xOffset) + 50;
        yOffsetTo = (yOffsetTo - yOffset) + 100;

        actions.dragAndDropBy(dragMe,xOffsetTo,yOffsetTo).perform();

        String textTo = dropHere.getText();

        if (textTo.equals("Dropped!")) {
            System.out.println("PASS: Sourse is dropped to target as expected");
        }else{
            System.out.println("FAIL: Sourse couldn't be dropped to target as expected");
        }

        return this;
    }
}
