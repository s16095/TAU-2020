import span as span
from selenium import webdriver
import logging
import time
from selenium.webdriver.common.keys import Keys

from selenium.common.exceptions import NoSuchElementException

logger = logging.getLogger('simple_example')
logger.setLevel(logging.INFO)
ch = logging.StreamHandler()
ch.setLevel(logging.DEBUG)
formatter = logging.Formatter('%(asctime)s - %(name)s - %(levelname)s - %(message)s')
ch.setFormatter(formatter)
logger.addHandler(ch)

driver = webdriver.Chrome(executable_path='C:\chromedriver.exe')

# H&M test

driver.get('https://www2.hm.com/pl_pl/index.html')
temp = driver.find_element_by_xpath('/html/body/header/nav/ul[1]/li[1]/div/a[1]')
temp.click()
time.sleep(5)
logger.info('Dodajemy konto')
temp = driver.find_element_by_xpath('/html/body/div[9]/div/div/button')
temp.click()
time.sleep(4)
logger.warning('Wpisujemy nieprawdziwe dane')
email_field = driver.find_element_by_xpath('//*[@id="modal-signin-email"]')
email_field.send_keys("niematekiegomaila@jakastampoczta.pl")
pass_field = driver.find_element_by_xpath('//*[@id="modal-signin-password"]')
pass_field.send_keys("Haslonie111prawidlowe")
day_field = driver.find_element_by_xpath('//*[@id="modal-signin-day"]')
day_field.send_keys("11")
month_field = driver.find_element_by_xpath('//*[@id="modal-signin-month"]')
month_field.send_keys("11")
year_field = driver.find_element_by_xpath('//*[@id="modal-signin-year"]')
year_field.send_keys("1999")
time.sleep(1)
request = driver.find_element_by_xpath('/html/body/div[10]/div/div/div/form/button')
request.click()
time.sleep(3)
try:
    checker = driver.find_element_by_xpath("//*[contains(text(), 'Wygląda na to, że masz już konto.')]")
    logger.error('Konto istnieje')
except NoSuchElementException:
    logger.info('Konto nie istnieje')


# Automatyczne zakupy - sklep akwarystyczny

driver.get('https://www.akwarystyczny24.pl/')
time.sleep(2)
logger.warning('Wyszukujemy produkt')
findone = driver.find_element_by_xpath('/html/body/div[12]/div/nav/ul/li[2]/a')
findone.click()
time.sleep(1)
selecting = driver.find_element_by_xpath('/html/body/div[12]/div/div[1]/div[2]/main/ul[2]/li[1]/div')
selecting.click()
addtocart = driver.find_element_by_xpath('//*[@id="product-view-order"]/div[1]/span')
addtocart.click()
time.sleep(2)
cart = driver.find_element_by_xpath('//*[@id="mobile-basket-count"]')

try:
    cart = driver.find_element_by_xpath("//*[contains(text(), '1')]")
    logger.info('Dodano do koszyka')
except NoSuchElementException:
    logger.error('Nie dodano do koszyka')

driver.quit()