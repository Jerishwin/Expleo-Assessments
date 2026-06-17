from page.home_page import HomePage
from page.register_page import register_page
from action.base_action import base_action

class register_action(base_action):
    def __init__(self, driver):
        super().__init__(driver)
        self.home_page = HomePage()
        self.register_page = register_page()

    def click_myAccount(self):
        self.click(self.home_page.myAccount)
        self.click(self.home_page.register)

    def register(self, first_name, last_name, email, phone, password):
        self.enter_text(self.register_page.first_name, first_name)
        self.enter_text(self.register_page.last_name, last_name)
        self.enter_text(self.register_page.email, email)
        self.enter_text(self.register_page.phone, phone)
        self.enter_text(self.register_page.password, password)
        self.enter_text(self.register_page.confirm_pass, password)
        self.click(self.register_page.check_box)
        self.click(self.register_page.continue_button)
        