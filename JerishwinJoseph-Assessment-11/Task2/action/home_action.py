from action.base_action import BaseAction
from page.home_page import HomePage


class HomeAction(BaseAction):

    def __init__(self, driver):
        super().__init__(driver)

    def open_register(self):

        self.click(HomePage.MY_ACCOUNT)
        self.click(HomePage.REGISTER)

    def open_login(self):

        self.click(HomePage.MY_ACCOUNT)
        self.click(HomePage.LOGIN)

    def search_product(self, product):

        self.enter_text(HomePage.SEARCH_BOX, product)
        self.click(HomePage.SEARCH_BUTTON)