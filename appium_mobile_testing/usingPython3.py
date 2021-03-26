from appium import webdriver
import sys
import os
# "b19c5982"
#sys.argv[1]
desired_capabilities = {
    # "deviceName":"OnePlus 7 Pro",
    "udid":"SERIAL",
    "mjpegServerPort": "MJPEGSERVERPORT",
    "platformName":"Android",
    "platformVersion":"10",
    "appPackage":"com.android.chrome",
    "appActivity":"com.google.android.apps.chrome.Main"
}
# http://localhost:4723/wd/hub
os.system("appium -p PORTNUMBER &")

driver = webdriver.Remote("http://localhost:PORTNUMBER/wd/hub", desired_capabilities)

# el1 = driver.find_element_by_id("com.android.chrome:id/send_report_checkbox")
# el1.click()
# el2 = driver.find_element_by_id("com.android.chrome:id/terms_accept")
# el2.click()
# el5 = driver.find_element_by_id("com.android.chrome:id/enable_data_saver_switch")
# el5.click()
# el6 = driver.find_element_by_id("com.android.chrome:id/next_button")
# el6.click()
# el1 = driver.find_element_by_id("com.android.chrome:id/negative_button")
# el1.click()