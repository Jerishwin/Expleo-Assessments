import pytest
from action.register_action import register_action
from conftest import driver

URL = "https://tutorialsninja.com/demo"

class TestRegister(driver):

    @pytest.mark.smoke
    def test_register(self):
        self.register_action = register_action()
        self.register_action.click_myAccount()
        self.register_action.register("John", "Doe", "john.doe@example.com", "1234567890", "password123")
        assert self.register_action.get_text(self.register_action.register_page.confirm_msg) == "Your Account Has Been Created!"



    