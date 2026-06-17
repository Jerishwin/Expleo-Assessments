from selenium.webdriver.common.by import By

class HomePage():
    myAccount = (By.XPATH,"//div[@id='top-links']/ul/li[2]")
    register = (By.XPATH,"//div[@id='top-links']/ul/li[2]/ul/li[1]")
    login = (By.XPATH,"//div[@id='top-links']/ul/li[2]/ul/li[2]")