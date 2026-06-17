from action.base_action import BaseAction
from page.product_page import ProductPage


class ProductAction(BaseAction):

    def __init__(self, driver):
        super().__init__(driver)

    def add_to_cart(self):

        self.click(ProductPage.ADD_TO_CART)

    def get_cart_total(self):

        return self.get_text(
            ProductPage.CART_TOTAL
        )