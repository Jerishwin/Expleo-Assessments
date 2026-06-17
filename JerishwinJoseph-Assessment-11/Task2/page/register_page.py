from selenium.webdriver.common.by import By

class register_page():
    first_name = (By.XPATH,"//fieldset[@id='account']/div[2]/div/input")
    last_name = (By.XPATH,"//fieldset[@id='account']/div[3]/div/input")
    email = (By.XPATH,"//fieldset[@id='account']/div[4]/div/input")
    phone = (By.XPATH,"//fieldset[@id='account']/div[5]/div/input")

    password = (By.XPATH,"//fieldset/div[@class='form-group required']/div/input[@id='input-password']")
    confirm_pass = (By.XPATH,"//fieldset/div[@class='form-group required']/div/input[@id='input-confirm']")

    check_box = (By.XPATH,"//input[@name='agree']")
    continue_button = (By.XPATH,"//input[@value='Continue']")

    confirm_msg = (By.XPATH,"//div[@id='content']/h1")