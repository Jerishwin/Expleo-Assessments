import selenium
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

driver = webdriver.Chrome()
driver.get("https://automationexercise.com/")
Wait = WebDriverWait(driver, 10)

signup_button = Wait.until(EC.element_to_be_clickable((By.XPATH, "/html/body/header/div/div/div/div[2]/div/ul/li[4]/a")))

if signup_button.is_displayed():
    print("Home page is visible successfully")

signup_button.click()

name_input = Wait.until(EC.visibility_of_element_located((By.XPATH, "//div[3]/div/form/input[2]")))
email_input = driver.find_element(By.XPATH, "//div[3]/div/form/input[3]")
signup_submit_button = driver.find_element(By.XPATH, "//div[3]/div/form/button")
name_input.send_keys("John Doe")
email_input.send_keys("johnn12@gmail.com")
signup_submit_button.click()

password_input = Wait.until(EC.visibility_of_element_located((By.ID, "password")))
password_input.send_keys("12345")

fname = driver.find_element(By.ID, "first_name")
lname = driver.find_element(By.ID, "last_name")
fname.send_keys("John")
lname.send_keys("Doe")

address = driver.find_element(By.ID, "address1")
address.send_keys("123 Main St")

state = driver.find_element(By.ID, "state")
state.send_keys("Tamil Nadu")

city = driver.find_element(By.ID, "city")
city.send_keys("Salem")

zipcode = driver.find_element(By.ID, "zipcode")
zipcode.send_keys("636005")

mobile_number = driver.find_element(By.ID, "mobile_number")
mobile_number.send_keys("1234567890")

create_account_button = Wait.until(EC.element_to_be_clickable((By.XPATH, "//section/div/div/div/div/form/child::button")))
create_account_button.click()

assert Wait.until(EC.visibility_of_element_located((By.XPATH, "//h2/b"))).is_displayed()

continue_button = driver.find_element(By.XPATH, "//section/div/div/div/div/child::a")
continue_button.click()

username_displayed = Wait.until(EC.visibility_of_element_located((By.XPATH, "//div[@class='header-middle']/div/div/child::*[2]/div/child::*/child::li[10]")))

assert username_displayed.is_displayed()

item = driver.find_element(By.XPATH, "//div[@class='features_items']/div[2]/div/div/div/a")
item.click()

cart_link = Wait.until(EC.element_to_be_clickable((By.XPATH, "//div[@class='modal-dialog modal-confirm']/div/div[2]/p/a")))
cart_link.click()

cart_table = Wait.until(EC.visibility_of_element_located((By.ID, "cart_info_table")))

assert cart_table.is_displayed()

driver.find_element(By.XPATH, "//div[@class='col-sm-6']/a").click()

delivery_address = Wait.until(EC.visibility_of_element_located((By.XPATH, "//ul[@id='address_delivery']/li[7]")))
billing_address = driver.find_element(By.XPATH, "//ul[@id='address_invoice']/li[7]")
assert delivery_address.text.__eq__(billing_address.text)

delete_account= Wait.until(EC.visibility_of_element_located((By.XPATH, "//div[@class='header-middle']/div/div/child::*[2]/div/child::*/child::li[5]")))
delete_account.click()

delete_account_confirm = Wait.until(EC.element_to_be_clickable((By.XPATH, "//h2/b")))

assert delete_account_confirm.text.isdisplayed()

driver.quit()
