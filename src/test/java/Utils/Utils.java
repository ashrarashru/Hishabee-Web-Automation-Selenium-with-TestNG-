package Utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class Utils {


    public static void scroll(WebDriver driver, int dy){
        ((JavascriptExecutor)driver).executeScript(
                "const dy=arguments[0];" +
                        "const panel=document.querySelector('div.overflow-y-scroll.scroll_hidden');" +
                        "if(panel){ panel.scrollTop += dy; }" +
                        "else { document.scrollingElement.scrollBy(0, dy); }", dy);
    }

}
