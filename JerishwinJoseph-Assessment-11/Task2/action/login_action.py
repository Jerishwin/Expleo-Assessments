from action.base_action import BaseAction
from page.login_page import LoginPage


class LoginAction(BaseAction):

    def __init__(self, driver):
        super().__init__(driver)

    def login(self, email, password):

        self.enter_text(LoginPage.EMAIL, email)
        self.enter_text(LoginPage.PASSWORD, password)

        self.click(LoginPage.LOGIN_BUTTON)

    def get_warning_message(self):

        return self.get_text(
            LoginPage.WARNING_MSG
        )