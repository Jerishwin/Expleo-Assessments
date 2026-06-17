import selenium
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

driver = webdriver.Chrome()
driver.get("https://parabank.parasoft.com/parabank/index.htm?ConnType=JDBC")
Wait = WebDriverWait(driver, 10)

username_input = Wait.until(EC.visibility_of_element_located((By.XPATH, "//div[@class='login']/input[@type='text']")))
password_input = driver.find_element(By.XPATH, "//div[@class='login']/input[@type='password']")
login_button = driver.find_element(By.XPATH, "//div[@class='login']/input[@type='submit']")

username_input.send_keys("Jerish")
password_input.send_keys("JeriJose.1")
login_button.click()

pay_bills_link = Wait.until(EC.element_to_be_clickable((By.XPATH, "//div[@id='leftPanel']/ul/li[4]/a")))
pay_bills_link.click()

payee_name = Wait.until(EC.visibility_of_element_located((By.XPATH, "//tbody/tr[1]/td/input")))
address = driver.find_element(By.XPATH, "//tbody/tr[2]/td/input")
city = driver.find_element(By.XPATH, "//tbody/tr[3]/td/input")
state = driver.find_element(By.XPATH, "//tbody/tr[4]/td/input")
zip_code = driver.find_element(By.XPATH, "//tbody/tr[5]/td/input")
phone = driver.find_element(By.XPATH, "//tbody/tr[6]/td/input")
account = driver.find_element(By.XPATH, "//tbody/tr[8]/td/select")
verify_account = driver.find_element(By.XPATH, "//tbody/tr[9]/td/select")
amount = driver.find_element(By.XPATH, "//tbody/tr[11]/td/input")

send_payment_button = driver.find_element(By.XPATH, "//tbody/tr[14]/td/input")

payee_name.send_keys("Jerish")
address.send_keys("salem")
city.send_keys("Salem")
state.send_keys("TamilNadu")
zip_code.send_keys("636005")
phone.send_keys("1234567890")
account.send_keys("Saving")
verify_account.send_keys("Saving")
amount.send_keys("100")
send_payment_button.click()

payment_sucessfull = Wait.until(EC.visibility_of_element_located(By.ID,"billpayResult"))
assert payment_sucessfull.is_displayed()

account_overview_link = driver.find_element(By.XPATH,"//div[@id='leftPanel']/ul/li[2]/a")
account_overview_link.click()

table = Wait.until(EC.visibility_of_element_located(By.ID,"accountTable"))
assert table.is_displayed()

