import re

class InvalidFieldError(Exception):
    pass

def validate_email(email):
    pattern = r'[A-Za-z0-9._-]+@[A-Za-z0-9._-]+\.[A-Za-z]{2,3}'
    res = re.match(pattern, email)
    if not res:
        raise InvalidFieldError("Not a Valid Email")
    print("Valid Email")

def validate_phone(phone):
    pattern = r'[69]\d{9}'
    res = re.match(pattern, str(phone))
    if not res:
        raise InvalidFieldError("Not a Valid Phone Number")
    print("Valid Phone Number")

def validate_usn(usn):
    pattern = r'25MCA\d{3}'
    res = re.match(pattern, usn)
    if not res:
        raise InvalidFieldError("Not a Valid USN")
    print("Valid USN")
