import socket

HOST = '127.0.0.1'  # The server's hostname or IP address
PORT = 3333

with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
    s.connect((HOST, PORT))
    while True:
        message = input("Enter your message: ")
        s.sendall(message.encode())
        if message == 'stop':
            break
        data = s.recv(1024).decode()
        print('Server says:', data)