package com.boot;

import com.boot.controller.HomeController;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Created by Prabhas_Harlapur on 8/31/2017.
 */
public class AppTest {

    @Test
    public void testApp() {

        HomeController homeController = new HomeController();
        String results = homeController.home();
        assertEquals(results,"Das Boot, reporting for Duty !");

    }

}
