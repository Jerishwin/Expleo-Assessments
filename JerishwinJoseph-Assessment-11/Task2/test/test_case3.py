import pytest

from action.home_action import HomeAction
from action.search_action import SearchAction


@pytest.mark.smoke
def test_search(driver):

    HomeAction(driver).search_product("MacBook")

    products = SearchAction(driver).get_products()

    assert any(
        "MacBook" in product
        for product in products
    )