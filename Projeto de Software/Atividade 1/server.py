#!/usr/bin/env python
import socket
import threading

ip = '127.0.0.1'
port = 5013
tcp = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
server = (ip,port)


def escutaConexoes(conexoes,tcp):	
	while True:
		conexao,cliente = tcp.accept()
		conexoes.append((conexao,cliente))
		print("\nNova conexao realizada")
		t = threading.Thread(target=recebeMensagens,args=(conexao,))
		t.start()

def recebeMensagens(conexao):
	while True:
		mensagem = conexao.recv(1024)
		if not mensagem:
			break
		tcp.send(str(mensagem).encode())
		print(mensagem.decode())


print("digite s para ser servidor - ou c para ser cliente")
ehServer = raw_input() == "s"
conexoes = []

if ehServer:
	tcp.bind(server)
	tcp.listen(1)
	print("Aguardando conexao...")
	escutaConexoes(conexoes,tcp)
	print("\n Conexao realizada")
else:
	tcp.connect(server)
	print("Conversem! - Digite bye para sair.")
	mensagem = raw_input()
	while mensagem != "bye":
		tcp.send(str(mensagem).encode())
		mensagem = raw_input();



tcp.close();