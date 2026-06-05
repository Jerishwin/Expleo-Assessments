data = {"25MCA001":77, "25MCA009":60,
"25MCA025":99, "25MCA007":84,
"25MCA012":45, "25MCA021":86,
"25MCA032":83, "25MCA018":40,
"25MCA014":67}

distinction={}
merit={}
passed={}
fail={}

min=100
max=0
maxUSD=minUSD=None

for d in data:
    if data[d]>max:
        max = data[d]
        maxUSD = d
    if data[d]<min:
        min = data[d]
        minUSD = d

    if data[d]>85:
        distinction[d]=data[d]
    elif data[d]>75:
        merit[d]=data[d]
    elif data[d]>59:
        passed[d]=data[d]
    else:
        fail[d]=data[d]

print("Maximum: ",data[maxUSD],"-",maxUSD)
print("Minimum: ",data[minUSD],"-",minUSD)
print("Distinction: ",len(distinction))
for d in distinction:
    print(distinction[d],"-",d)

print("Merit: ",len(merit))
for d in merit:
    print(merit[d],"-",d)

print("Pass: ",len(passed))
for d in passed:
    print(passed[d],"-",d)

print("Fail: ",len(fail))
for d in fail:
    print(fail[d],"-",d)




