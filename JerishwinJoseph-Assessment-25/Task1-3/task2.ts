function reverseNumber(num: number): number {
    let reverse = 0

    while (num > 0) {
        let temp = num % 10
        reverse = reverse * 10 + temp
        num = Math.floor(num / 10)
    }

    return reverse
}

let num = 12345

if (num >= 10000 && num <= 99999) {
    let result = reverseNumber(num)
    console.log("Reversed Number:", result)
} else {
    console.log("This is Not a Valid Number")
}