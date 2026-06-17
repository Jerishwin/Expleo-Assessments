from action.base_action import BaseAction
from page.search_page import SearchPage


class SearchAction(BaseAction):

    def __init__(self, driver):
        super().__init__(driver)

    def get_product_names(self):

        products = self.driver.find_elements(
            *SearchPage.PRODUCTS
        )

        return [product.text for product in products]