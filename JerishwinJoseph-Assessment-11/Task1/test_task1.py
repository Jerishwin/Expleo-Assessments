import pytest
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import Select


URL = "https://practice.automationtesting.in/shop/"

@pytest.mark.smoke
def test_case1(driver):

    driver.get(URL)

    price = driver.find_element(By.XPATH,"//ul/child::li[3]/a/h3/following-sibling::*/span").text
    assert price == "₹280.00"
    print("The price of the “HTML5 Forms” book is displayed as ",price)


@pytest.mark.smoke
def test_case2(driver):

    driver.get(URL)

    driver.find_element(By.XPATH,"//ul/child::li[5]/a/h3").click()
    title = driver.find_element(By.TAG_NAME, "h1").text
    assert title == "JS Data Structures and Algorithm"
    print("Title of the page: ",title)


@pytest.mark.regression
def test_case3(driver):

    driver.get(URL)

    driver.find_element(By.XPATH,"//div[@id='woocommerce_product_categories-2']/ul/li[2]/a").click()
    books = driver.find_elements(By.XPATH,"//div[@id='content']/ul/li")
    print(books)
    assert len(books) == 3


@pytest.mark.regression
def test_case4(driver):

    driver.get(URL)

    sort_dropdown = Select(driver.find_element(By.XPATH, "//select[@class='orderby']"))
    sort_dropdown.select_by_value("price")
    prices = driver.find_elements(By.XPATH,"//ul/child::li/a/h3/following-sibling::*/span")
    actual_price=[]
    for price in prices:
        actual_price.append(price.text)

    sorted_prices = sorted(actual_price)
    assert actual_price == sorted_prices


def test_case5(driver):

    driver.get(URL)

    driver.execute_script("window.scrollTo(0, document.body.scrollHeight);")

    subscribe_btn = driver.find_element(By.XPATH,"//input[@value='Subscribe']")

    assert subscribe_btn.is_displayed()