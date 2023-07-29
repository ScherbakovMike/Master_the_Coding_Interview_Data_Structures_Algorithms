import re


def longest_word(sen):
    arr = re.findall("\\w+\\b", sen)
    arr.sort()
    return arr.pop()


# keep this function call here
print(longest_word(input()))
