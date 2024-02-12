package ru.my.tests.base;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import ru.my.framework.managers.DriverManager;
import ru.my.framework.managers.InitManager;
import ru.my.framework.managers.PageManager;
import ru.my.framework.managers.TestPropManager;
import ru.my.framework.utils.ConstansProp;

public class BaseTest {
    private final TestPropManager testPropManager = TestPropManager.getTestPropManager();
    protected final PageManager pageManager = PageManager.getPageManager();

    @BeforeAll
    public static void before() {
        InitManager.initFramework();
    }

    @BeforeEach
    public void beforeEach(){
        DriverManager.getDriverManager().getDriver()
                .get(testPropManager.getProperty(ConstansProp.BASE_URL));
    }

    @AfterAll
    public static void after() {
        InitManager.quitFramework();
    }

}
