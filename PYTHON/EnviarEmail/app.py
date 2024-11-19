import os
import smtplib
from email.message import EmailMessage
from segredo import senha



EMAIL_ADDRESS = 'maopdtec@gmail.com'
EMAIL_PASSWORD= senha

msg=EmailMessage()

msg['Subject']= 'Enviando email pelo vscode'
msg['From']='maopdtec@gmail.com'
msg['To']='mzbavaresco@ucs.br'
msg.set_content('Teste email')


with smtplib.SMTP_SSL('smtp.gmail.com',465) as smtp:
    smtp.login(EMAIL_ADDRESS,EMAIL_PASSWORD)
    smtp.send_message(msg)
print('Mensagem enviada com sucesso!')