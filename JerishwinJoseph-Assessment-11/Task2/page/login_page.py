from selenium.webdriver.common.by import By

class LoginPage():
    email = (By.ID, "input-email")
    password = (By.ID, "input-password")
    login_button = (By.XPATH, "//input[@value='Login']")
    error_msg = (By.CSS_SELECTOR, ".alert-danger")