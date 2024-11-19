import  gtts
from gtts.tokenizer.pre_processors import end_of_line
from playsound import playsound
with open('fala.txt','r') as arquivo:
    for linha in arquivo:
        frase=gtts.gTTS(linha,lang='pt-br')
        frase.save('frase.mp3')
        playsound('frase.mp3')
print('Ola mundo!')
      