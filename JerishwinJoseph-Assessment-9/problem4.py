from moduler import data_validator as dv
from moduler import data_processor as dp

n = int(input("Enter Records: "))


for i in range(0,n):
    usn = input("USN: ")
    name = input("Name: ")
    email = input("Email: ")
    phone = int(input("Phone: "))
    dv.validate_email(email)
    dv.validate_phone(phone)
    dv.validate_usn(usn)
    dp.record(usn,name,email,phone)
    print("_"*10)

print("USN\t|Name\t|Username\t|Domain")
for r in dp.rec:
    print(r[0],r[1],dp.Username[1],dp.domain[1])


