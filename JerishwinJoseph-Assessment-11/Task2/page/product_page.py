from selenium.webdriver.common.by import By

class ProductPage:

    add_to_cart = (By.ID, "button-cart")

    cart_total = (By.ID, "cart-total")