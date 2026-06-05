import re
rec=()
def record(usn,name,email,phone):
    rec+=(usn,name,email,phone)

Username=()
domain=()
def extract():
    split=()
    for r in rec:
        split=re.split("@",r[2])
        domain+=split[1]
        Username+=split[0]
    