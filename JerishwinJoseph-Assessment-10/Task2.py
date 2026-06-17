import selenium
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.common.action_chains import ActionChains

driver = webdriver.Chrome()
driver.get("https://automationexercise.com/")
Wait = WebDriverWait(driver, 10)

actions = ActionChains(driver)

subscribe = driver.find_element(By.XPATH, "//div[@class='col-sm-3 col-sm-offset-1']/div/h2")
actions.scroll_to_element(subscribe).perform()
assert subscribe.is_displayed()

up_arrow = driver.find_element(By.ID, "scrollUp")
up_arrow.click()

text = Wait.until(EC.visibility_of_element_located((By.XPATH, "//div[@class='item active']/div/h2"))).text

print(text)

driver.quit()