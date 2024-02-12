package ru.my.framework.managers;

import java.time.Duration;

/**
 * Класс для инициализации фреймворка
 */
public class InitManager {

    /**
     * Менеджер properties
     *
     * @see TestPropManager#getTestPropManager()
     */
    private static final TestPropManager props = TestPropManager.getTestPropManager();

    /**
     * Driver manager
     *
     * @see DriverManager#getDriverManager()
     */
    private static final DriverManager driverManager = DriverManager.getDriverManager();

    /**
     * Инициализация фреймворка и запуск браузера со строницей приложения
     *
     * @see DriverManager#getDriver()
     * @see TestPropManager#getProperty(String)
     * @see ru.my.framework.utils.ConstansProp
     */
    public static void initFramework(){
        driverManager.getDriver().manage().window().maximize();
        driverManager.getDriver().manage()
                .timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driverManager.getDriver().manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(10));
    }

    /**
     * Завершение работы фреймворка. Гасит драйвер и закрывает браузер
     *
     * @see DriverManager#quitDriver()
     */

    public static void quitFramework(){
        driverManager.quitDriver();
    }

}
