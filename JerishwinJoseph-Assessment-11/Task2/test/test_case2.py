import pytest

from action.home_action import HomeAction
from action.login_action import LoginAction


@pytest.mark.regression
@pytest.mark.parametrize(
    "email,password,result",
    [
        ("valid@gmail.com", "valid123", "valid"),
        ("abc", "123", "invalid"),
        ("valid@gmail.com", "wrong123", "invalid")
    ]
)
def test_login(driver, email, password, result):

    HomeAction(driver).open_login()

    login = LoginAction(driver)

    login.login(email, password)

    if result == "valid":
        assert "account" in driver.current_url
    else:
        assert "Warning" in login.get_warning()