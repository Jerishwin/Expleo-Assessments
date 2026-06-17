import pytest
from selenium.webdriver.common.by import By

from action.product_action import ProductAction


@pytest.mark.regression
def test_add_to_cart(driver):

    driver.find_element(
        By.LINK_TEXT,
        "MacBook"
    ).click()

    product = ProductAction(driver)

    product.add_to_cart()

    assert "1 item(s)" in product.get_cart_text()