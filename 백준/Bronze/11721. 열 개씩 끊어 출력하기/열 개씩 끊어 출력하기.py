word_inp = input()
lines = len(word_inp)//10
for i in range(0,lines+1):
    print(word_inp[i*10:(i+1)*10])