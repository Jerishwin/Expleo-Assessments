obj =open("server_log.txt","r")
obj2 = open("log_report.txt","w")
lines=obj.readlines()
for i in lines:
    obj2.write(str(i)+"\n")

